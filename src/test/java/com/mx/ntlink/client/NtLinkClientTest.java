package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.TimbraCfdiQr;
import com.mx.ntlink.models.generated.TimbraCfdiQrResponse;
import com.mx.ntlink.models.generated.TimbraCfdiSinSello;
import com.mx.ntlink.models.generated.TimbraCfdiSinSelloResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NtLinkClientTest {

  private static final Logger log = LoggerFactory.getLogger(NtLinkClientTest.class);

  private static final NtLinkClient client =
      new NtLinkClientImpl("http://dev-cfdi4.ntlink.com.mx/cfdi40/servicio-timbrado");

  private static final String TEST_USER = "EKU9003173C9@ntlink.com.mx";
  private static final String TEST_PASS = "Factura.2021*";

  @Test
  public void testTimbraCfdiSinSello() throws IOException, SoapClientException {

    String comprobante =
        new String(
            Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/vehiculo-usado.xml")));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    TimbraCfdiSinSelloResponse response = client.timbrarSinSello(cfdiSinSello);

    log.info(response.getTimbraCfdiSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiSinSelloResult());
  }

  @Test
  public void testTimbraConQr() throws IOException, SoapClientException {
    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/pue-cfdi.xml")));

    TimbraCfdiQr request = new TimbraCfdiQr();
    request.setPassword(TEST_PASS);
    request.setUserName(TEST_USER);
    request.setComprobante(comprobante);

    TimbraCfdiQrResponse response = client.timbrarCfdiConQr(request);
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiQrResult());
    Assert.assertNotNull(response.getTimbraCfdiQrResult().getDescripcionError());
  }
}
