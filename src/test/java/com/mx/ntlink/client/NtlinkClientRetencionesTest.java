package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.TimbraRetencionSinSello;
import com.mx.ntlink.models.generated.TimbraRetencionSinSelloResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NtlinkClientRetencionesTest {

  private static final Logger log = LoggerFactory.getLogger(NtLinkClientNominaTest.class);
  private static final NtLinkClient client =
      new NtLinkClientImpl("http://dev-cfdi4.ntlink.com.mx/cfdi40/servicio-timbrado");
  private static final String TEST_USER = "EKU9003173C9@ntlink.com.mx";
  private static final String TEST_PASS = "Factura.2021*";

  private static final String TEST_USER2 = "CACX7605101P8@ntlink.com.mx";
  private static final String TEST_PASS2 = "Ntlink.2021";

  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
  private static final String DATE_REPLACEMENT = "%fecha-timbrado%";

  @Test
  public void timbra_retencion1_test() throws IOException, SoapClientException {

    String retencion =
        new String(
            Files.readAllBytes(Paths.get("./src/test/resources/retencion-samples/retencion1.xml")));

    retencion =
        retencion.replace(DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello retencionSinSello = new TimbraRetencionSinSello();
    retencionSinSello.setPassword(TEST_PASS);
    retencionSinSello.setUserName(TEST_USER);
    retencionSinSello.setComprobante(retencion);
    TimbraRetencionSinSelloResponse response = client.timbrarRetencionSinSello(retencionSinSello);

    log.info(response.getTimbraRetencionSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraRetencionSinSelloResult());
    Assert.assertTrue(
        "Contains UUID", response.getTimbraRetencionSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_retencion_relacionados_test() throws IOException, SoapClientException {

    String retencion =
        new String(
            Files.readAllBytes(
                Paths.get(
                    "./src/test/resources/retencion-samples/timbra_retencion_relacionados.xml")));

    retencion =
        retencion.replace(DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello retencionSinSello = new TimbraRetencionSinSello();
    retencionSinSello.setPassword(TEST_PASS);
    retencionSinSello.setUserName(TEST_USER);
    retencionSinSello.setComprobante(retencion);
    TimbraRetencionSinSelloResponse response = client.timbrarRetencionSinSello(retencionSinSello);

    log.info(response.getTimbraRetencionSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraRetencionSinSelloResult());
    Assert.assertTrue(
        "Contains UUID", response.getTimbraRetencionSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_retencion_dividendos_test() throws IOException, SoapClientException {

    String retencion =
        new String(
            Files.readAllBytes(
                Paths.get("./src/test/resources/retencion-samples/retencion_dividendos.xml")));

    retencion =
        retencion.replace(DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello retencionSinSello = new TimbraRetencionSinSello();
    retencionSinSello.setPassword(TEST_PASS);
    retencionSinSello.setUserName(TEST_USER);
    retencionSinSello.setComprobante(retencion);
    TimbraRetencionSinSelloResponse response = client.timbrarRetencionSinSello(retencionSinSello);

    log.info(response.getTimbraRetencionSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraRetencionSinSelloResult());
    Assert.assertTrue(
        "Contains UUID", response.getTimbraRetencionSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_retencion_enajenacion_test() throws IOException, SoapClientException {

    String retencion =
        new String(
            Files.readAllBytes(
                Paths.get("./src/test/resources/retencion-samples/retencion_enajenacion.xml")));

    retencion =
        retencion.replace(DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello retencionSinSello = new TimbraRetencionSinSello();
    retencionSinSello.setPassword(TEST_PASS);
    retencionSinSello.setUserName(TEST_USER);
    retencionSinSello.setComprobante(retencion);
    TimbraRetencionSinSelloResponse response = client.timbrarRetencionSinSello(retencionSinSello);

    log.info(response.getTimbraRetencionSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraRetencionSinSelloResult());
    Assert.assertTrue(
        "Contains UUID", response.getTimbraRetencionSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_retencion_intereses_test() throws IOException, SoapClientException {

    String retencion =
        new String(
            Files.readAllBytes(
                Paths.get("./src/test/resources/retencion-samples/retencion_intereses.xml")));

    retencion =
        retencion.replace(DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello retencionSinSello = new TimbraRetencionSinSello();
    retencionSinSello.setPassword(TEST_PASS);
    retencionSinSello.setUserName(TEST_USER);
    retencionSinSello.setComprobante(retencion);
    TimbraRetencionSinSelloResponse response = client.timbrarRetencionSinSello(retencionSinSello);

    log.info(response.getTimbraRetencionSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraRetencionSinSelloResult());
    Assert.assertTrue(
        "Contains UUID", response.getTimbraRetencionSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_retencion_test() throws IOException, SoapClientException {

    String retencion =
        new String(
            Files.readAllBytes(Paths.get("./src/test/resources/retencion-samples/retencion.xml")));

    retencion =
        retencion.replace(DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello retencionSinSello = new TimbraRetencionSinSello();
    retencionSinSello.setPassword(TEST_PASS);
    retencionSinSello.setUserName(TEST_USER);
    retencionSinSello.setComprobante(retencion);
    TimbraRetencionSinSelloResponse response = client.timbrarRetencionSinSello(retencionSinSello);

    log.info(response.getTimbraRetencionSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraRetencionSinSelloResult());
    Assert.assertTrue(
        "Contains UUID", response.getTimbraRetencionSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_retencion_test_extranejero() throws IOException, SoapClientException {

    String retencion =
        new String(
            Files.readAllBytes(
                Paths.get("./src/test/resources/retencion-samples/retencion_extranjero.xml")));

    retencion =
        retencion.replace(DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello retencionSinSello = new TimbraRetencionSinSello();
    retencionSinSello.setPassword(TEST_PASS);
    retencionSinSello.setUserName(TEST_USER);
    retencionSinSello.setComprobante(retencion);
    TimbraRetencionSinSelloResponse response = client.timbrarRetencionSinSello(retencionSinSello);

    log.info(response.getTimbraRetencionSinSelloResult());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTimbraRetencionSinSelloResult());
    Assert.assertTrue(
        "Contains UUID", response.getTimbraRetencionSinSelloResult().contains("UUID"));
  }

  @Test
  public void timbra_retencion_errorRETEN20101() throws IOException, SoapClientException {

    String comprobante =
        new String(
            Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20101.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS2);
    timbraRetencionSinSello.setUserName(TEST_USER2);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :Reten20101 - El resultado de la digestión debe ser igual al resultado de la desencripción del sello.",
          e.getMessage());
    }
  }
}
