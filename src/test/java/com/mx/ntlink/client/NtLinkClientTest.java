package com.mx.ntlink.client;

import com.mx.ntlink.client.generated.TimbraCfdiSinSello;
import com.mx.ntlink.client.generated.TimbraCfdiSinSelloResponse;
import com.mx.ntlink.error.SoapClientException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class NtLinkClientTest {

  private static final NtLinkClient client =
      new NtLinkClientImpl("http://rds.dyndns.org:90/CertificadorWs40/ServicioTimbrado.svc");
  private static final String TEST_USER = "EKU9003173C9@ntlink.com.mx";
  private static final String TEST_PASS = "Factura.2021*";

  @Test
  public void testTimbraCfdiSinSello() throws IOException, SoapClientException {
    String comprobante =
        Files.readString(Path.of("src/test/resources/cfdi-samples/vehiculo-usado.xml"));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    TimbraCfdiSinSelloResponse response = client.timbrarSinSello(cfdiSinSello);

    log.info(response.getTimbraCfdiSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiSinSelloResult());
  }
}