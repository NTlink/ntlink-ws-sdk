package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.error.StampException;
import com.mx.ntlink.helper.StampHelper;
import com.mx.ntlink.models.generated.TimbraCfdiQr;
import com.mx.ntlink.models.generated.TimbraCfdiQrResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class StampHelperTest {

  private static final NtLinkClient client =
      new NtLinkClientImpl("http://rds.dyndns.org:90/CertificadorWs40/ServicioTimbrado.svc");

  private static final String TEST_USER = "URE180429TM6@ntlink.com.mx";
  private static final String TEST_PASS = "NTPruebas.2021*?";
  private static final String DATE_REPLACEMENT = "%fecha-timbrado%";
  private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-d'T'HH:mm:ss");
  private static final StampHelper helper = new StampHelper();

  @Test
  public void testStamp() throws IOException, StampException, SoapClientException {
    String xml =
        new String(
            Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-sample.xml")));

    xml = xml.replace(DATE_REPLACEMENT, formatter.format(new Date()));

    final String PW_SAT = "12345678a";

    String privateKey =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/sample-certs/key.txt")));

    String xmlWithStamp = helper.stampCfdi(xml, PW_SAT, privateKey);

    log.info(xmlWithStamp);
    Assert.assertNotNull(xmlWithStamp);
    TimbraCfdiQr stampRequest = new TimbraCfdiQr();
    stampRequest.setComprobante(xmlWithStamp);
    stampRequest.setUserName(TEST_USER);
    stampRequest.setPassword(TEST_PASS);

    TimbraCfdiQrResponse response = client.timbrarCfdiConQr(stampRequest);
    Assert.assertNotNull(response.getTimbraCfdiQrResult());
    if (response.getTimbraCfdiQrResult().getDescripcionError().isEmpty()) {
      Assert.assertNotNull(response.getTimbraCfdiQrResult().getCadenaTimbre());
      Assert.assertNotNull(response.getTimbraCfdiQrResult().getCfdi());
      Assert.assertNotNull(response.getTimbraCfdiQrResult().getQrCodeBase64());
      log.info("XML timbrado : {}", response.getTimbraCfdiQrResult().getCfdi());
    } else {
      Assert.fail("Error timbrando XML: " + response.getTimbraCfdiQrResult().getDescripcionError());
    }
  }
}
