package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.TimbraCfdiQr;
import com.mx.ntlink.models.generated.TimbraCfdiQrResponse;
import com.mx.ntlink.models.generated.TimbraCfdiQrSinSello;
import com.mx.ntlink.models.generated.TimbraCfdiQrSinSelloResponse;
import com.mx.ntlink.models.generated.TimbraCfdiSinSello;
import com.mx.ntlink.models.generated.TimbraCfdiSinSelloResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.mx.ntlink.models.generated.TimbraRetencion;
import com.mx.ntlink.models.generated.TimbraRetencionSinSello;
import com.mx.ntlink.models.generated.TimbraRetencionSinSelloResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NtLinkClientTest {

  private static final Logger log = LoggerFactory.getLogger(NtLinkClientTest.class);

  private static final NtLinkClient client =
      new NtLinkClientImpl(
          "http://dev-cfdi4.ntlink.com.mx/cfdi40/servicio-timbrado");

  private static final String TEST_USER = "EKU9003173C9@ntlink.com.mx";
  private static final String TEST_PASS = "Factura.2021*";


  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
  private static final String DATE_REPLACEMENT = "%fecha-timbrado%";

  @Test
  public void timbraVehiculoUsado_test() throws IOException, SoapClientException {

    String comprobante =
        new String(
            Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/vehiculo-usado.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    TimbraCfdiSinSelloResponse response = client.timbrarSinSello(cfdiSinSello);

    log.info(response.getTimbraCfdiSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiSinSelloResult());
    Assert.assertTrue("Contains UUID", response.getTimbraCfdiSinSelloResult().contains("UUID"));
  }


  @Test
  public void testTimbraConQrWithError() throws IOException, SoapClientException {
    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/pue-cfdi.xml")));

    TimbraCfdiQr request = new TimbraCfdiQr();
    request.setPassword(TEST_PASS);
    request.setUserName(TEST_USER);
    request.setComprobante(comprobante);

    TimbraCfdiQrResponse response = client.timbrarCfdiConQr(request);
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiQrResult());
    Assert.assertFalse(response.getTimbraCfdiQrResult().getDescripcionError().isEmpty());
  }


  @Ignore
  @Test
  public void timbraPPD_test() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-ppd.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    TimbraCfdiSinSelloResponse response = client.timbrarSinSello(cfdiSinSello);

    log.info(response.getTimbraCfdiSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiSinSelloResult());
    Assert.assertTrue("Contains UUID", response.getTimbraCfdiSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbraPUE_test() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-pue.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiQrSinSello cfdiSinSello = new TimbraCfdiQrSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    TimbraCfdiQrSinSelloResponse response = client.timbrarSinSelloConQr(cfdiSinSello);

    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiQrSinSelloResult());
    Assert.assertTrue(response.getTimbraCfdiQrSinSelloResult().getDescripcionError().isEmpty());
    Assert.assertTrue("Contains UUID", response.getTimbraCfdiQrSinSelloResult().getCfdi().contains("UUID"));
  }


  @Test
  public void timbra_cfdi_global_test() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-global.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    TimbraCfdiSinSelloResponse response = client.timbrarSinSello(cfdiSinSello);

    log.info(response.getTimbraCfdiSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiSinSelloResult());
    Assert.assertTrue("Contains UUID", response.getTimbraCfdiSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_cfdi_relacionados_test() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-relacionados.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    TimbraCfdiSinSelloResponse response = client.timbrarSinSello(cfdiSinSello);

    log.info(response.getTimbraCfdiSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiSinSelloResult());
    Assert.assertTrue("Contains UUID", response.getTimbraCfdiSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_cfdi_terceros_test() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-terceros.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    TimbraCfdiSinSelloResponse response = client.timbrarSinSello(cfdiSinSello);

    log.info(response.getTimbraCfdiSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiSinSelloResult());
    Assert.assertTrue("Contains UUID", response.getTimbraCfdiSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_cfdi_ine_test() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-ine.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    TimbraCfdiSinSelloResponse response = client.timbrarSinSello(cfdiSinSello);

    log.info(response.getTimbraCfdiSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraCfdiSinSelloResult());
    Assert.assertTrue("Contains UUID", response.getTimbraCfdiSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_retencion_test() throws IOException, SoapClientException {

    String retencion =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retencion-samples/retencion.xml")));

    retencion =
            retencion.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello retencionSinSello = new TimbraRetencionSinSello();
    retencionSinSello.setPassword(TEST_PASS);
    retencionSinSello.setUserName(TEST_USER);
    retencionSinSello.setComprobante(retencion);
    TimbraRetencionSinSelloResponse response = client.timbrarRetencionSinSello(retencionSinSello);

    log.info(response.getTimbraRetencionSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraRetencionSinSelloResult());
    Assert.assertTrue("Contains UUID", response.getTimbraRetencionSinSelloResult().contains("UUID"));
  }


}
