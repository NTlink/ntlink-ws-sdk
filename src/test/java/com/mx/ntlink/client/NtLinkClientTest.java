package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NtLinkClientTest {

  private static final Logger log = LoggerFactory.getLogger(NtLinkClientTest.class);

  private static final NtLinkClient client =
      new NtLinkClientImpl("http://dev-cfdi4.ntlink.com.mx/cfdi40/servicio-timbrado");

  private static final String TEST_USER = "EKU9003173C9@ntlink.com.mx";
  private static final String TEST_PASS = "Factura.2021*";

  private static final String TEST_USER2 = "CACX7605101P8@ntlink.com.mx";
  private static final String TEST_PASS2 = "Ntlink.2021";

  private static final String TEST_USER3 = "XIA190128J61@ntlink.com.mx";
  private static final String TEST_PASS3 = "Ntlink.2022";

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

  @Ignore
  @Test
  public void  testTimbraConQrWithError() throws IOException, SoapClientException {
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
  /*Para este metodo es necesario sellar el cfdi, es por eso que da error */


  @Test
  public void timbraPPD_test() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-ppd.xml")));

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
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-pue.xml")));

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
    Assert.assertTrue(
        "Contains UUID", response.getTimbraCfdiQrSinSelloResult().getCfdi().contains("UUID"));
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
            Files.readAllBytes(
                Paths.get("./src/test/resources/cfdi-samples/cfdi-relacionados.xml")));

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
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-ine.xml")));

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
  public void timbra_pagos_test() throws IOException, SoapClientException {

    String comprobante =
        new String(
            Files.readAllBytes(
                Paths.get("./src/test/resources/cfdi-samples/pagos-impuestos2.xml")));

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
  public void timbra_pagos_terceros_test() throws IOException, SoapClientException {

    String comprobante =
        new String(
            Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/pagos-terceros.xml")));

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
  public void timbra_cfdi_iedu() throws IOException, SoapClientException {

    String comprobante =
        new String(
            Files.readAllBytes(
                Paths.get("./src/test/resources/cfdi-samples/cfdi-complementos-iedu.xml")));

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
  public void timbra_cfdi_donataria() throws IOException, SoapClientException {

    String comprobante =
        new String(
            Files.readAllBytes(Paths.get("./src/test/resources/cfdi-samples/cfdi-donatarias.xml")));

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
  public void timbra_cfdi_error40101() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40101.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);
    try {
      TimbraCfdiSinSelloResponse response = client.timbrarSinSello(cfdiSinSello);

      log.info(response.getTimbraCfdiSinSelloResult());
    } catch (Exception e) {
      log.error("Error", e);
      /**
       * TODO: Regresar códigos de validación SAT, actualmente se hacen validaciones locales
       * ejemplo:
       *
       * <p>Request Error :cvc-pattern-valid: Value '16-03-2022T00:00:00' is not facet-valid with
       * respect to pattern
       * '(20[1-9][0-9])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])T(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9])'
       * for type 't_FechaH'.
       *
       * <p>Debe ser: - CFDI40101 - El campo Fecha no cumple con el patrón requerido.
       */
    }
  }

  @Test
  public void timbra_cfdi_error40102() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40102.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS2);
    cfdiSinSello.setUserName(TEST_USER2);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40102 - El resultado de la digestión debe ser igual al resultado de la desencripción del sello.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40103() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40103.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40103 - Si existe el tipo de comprobante T, N o P el campo FormaPago no debe existir.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40104() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40104.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40104 - El campo FormaPago no contiene un valor del catálogo c_FormaPago.",
          e.getMessage());

      /**
       * TODO: Regresar códigos de validación SAT, actualmente se hacen validaciones locales
       * ejemplo:
       *
       * <p>Request Error :cvc-enumeration-valid: Value 'EFECTIVO' is not facet-valid with respect
       * to enumeration '[01, 02, 03, 04, 05, 06, 08, 12, 13, 14, 15, 17, 23, 24, 25, 26, 27, 28,
       * 29, 30, 31, 99]'. It must be a value from the enumeration.
       *
       * <p>Debe regresar: - CFDI40104 - El campo FormaPago no contiene un valor del catálogo
       * c_FormaPago.
       */
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40105() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40105.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40105 - El campo FormaPago no contiene el valor \"99\". ",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40106() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40106.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS3);
    cfdiSinSello.setUserName(TEST_USER3);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40106 - EL certificado no cumple con alguno de los valores permitidos.(CSDRevocado)",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40107() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40107.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40107 - El valor de este campo SubTotal excede la cantidad de decimales que soporta la moneda.",
          e.getMessage());

      /**
       * TODO: Regresar códigos de validación SAT, actualmente se hacen validaciones locales
       * ejemplo:
       *
       * <p>Request Error :cvc-enumeration-valid: Value 'EFECTIVO' is not facet-valid with respect
       * to enumeration '[01, 02, 03, 04, 05, 06, 08, 12, 13, 14, 15, 17, 23, 24, 25, 26, 27, 28,
       * 29, 30, 31, 99]'. It must be a value from the enumeration.
       *
       * <p>Debe regresar: - CFDI40107 - El valor de este campo SubTotal excede la cantidad de
       * decimales que soporta la moneda.
       */
    }
  }

  @Test
  public void timbra_cfdi_error40108() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40108.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40108 - El TipoDeComprobante es I,E o N, el importe registrado en el campo no es igual al redondeo de la suma de los importes de los conceptos registrados.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40109() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40109.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40109 - El TipoDeComprobante es T o P y el importe no es igual a 0, o cero con decimales.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40110() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40110.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40110 - El valor registrado en el campo Descuento no es menor o igual que el campo Subtotal.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40111() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40111.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40111 - El TipoDeComprobante NO es I,E o N, y un concepto incluye el campo descuento.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40112() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40112.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40112 - El valor del campo Descuento excede la cantidad de decimales que soporta la moneda.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40113() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40113.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40113 - El campo Moneda no contiene un valor del catálogo c_Moneda.",
          e.getMessage());
      /**
       * TODO: Regresar códigos de validación SAT:
       *
       * <p>Request Error :Request Error :cvc-enumeration-valid: Value 'MEX' is not facet-valid with
       * respect to enumeration '[AED, AFN, ALL, AMD, ANG, AOA, ARS, AUD, AWG, AZN, BAM, BBD, BDT,
       * BGN, BHD, BIF, BMD, BND, BOB, BOV, BRL, BSD, BTN, BWP, BYR, BZD, CAD, CDF, CHE, CHF, C ...
       *
       * <p>Debe regresar: - CFDI40113 - El campo Moneda no contiene un valor del catálogo c_Moneda
       */
    }
  }

  @Test
  public void timbra_cfdi_error40114() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40114.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40114 - El campo TipoCambio no tiene el valor \"1\" y la moneda indicada es MXN.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40115() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40115.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40115 - El campo TipoCambio se debe registrar cuando el campo Moneda tiene un valor distinto de MXN y XXX.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40116() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40116.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40116 - El campo TipoCambio no se debe registrar cuando el campo Moneda tiene el valor XXX.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40117() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40117.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40117 - El campo TipoCambio no cumple con el patrón requerido.",
          e.getMessage());
      /**
       * TODO: Regresar códigos de validación SAT:
       *
       * <p>Request Error :cvc-fractionDigits-valid: Value '20.0000000000000001' has 16 fraction
       * digits, but the number of fraction digits has been limited to 6.
       *
       * <p>Debe regresar: - CFDI40117 - El campo TipoCambio no cumple con el patrón requerido.
       */
    }
  }

  @Test
  public void timbra_cfdi_error40118() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40118.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40118 - Cuando el valor del campo TipoCambio se encuentre fuera de los límites establecidos, debe existir el campo Confirmación.(Solicitar en el portal de facturación NT Link menú Reportes/Confirmaciones)",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40119() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40119.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40119 - El campo Total no corresponde con la suma del subtotal, menos los descuentos aplicables, más las contribuciones recibidas (impuestos trasladados - federales o locales, derechos, productos, aprovechamientos, aportaciones de seguridad social, contribuciones de mejoras) menos los impuestos retenidos y/o locales.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40120() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40120.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40120 - Cuando el valor del campo Total se encuentre fuera de los límites establecidos, debe existir el campo Confirmacion.",
          e.getMessage());

      /**
       * TODO: Regresar códigos de validación SAT:
       *
       * <p>Request Error :Request Error :cvc-pattern-valid: Value '1000000000000000000.00' is not
       * facet-valid with respect to pattern '[0-9]{1,18}(.[0-9]{1,6})?' for type 't_Importe'.
       *
       * <p>Debe regresar: - CFDI40120 - Cuando el valor del campo Total se encuentre fuera de los
       * límites establecidos, debe existir el campo Confirmacion.
       */
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40121() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40121.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40121 - El campo TipoDeComprobante, no contiene un valor del catálogo c_TipoDeComprobante.",
          e.getMessage());

      /**
       * TODO: Regresar códigos de validación SAT:
       *
       * <p>Request Error :Request Error :cvc-enumeration-valid: Value 'X' is not facet-valid with
       * respect to enumeration '[I, E, T, N, P]'.
       *
       * <p>Debe regresar: - CFDI40121 - El campo TipoDeComprobante, no contiene un valor del
       * catálogo c_TipoDeComprobante.
       */
    }
  }

  @Test
  public void timbra_cfdi_error40122() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40122.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40122 - El campo Exportacion contiene el valor \"02\", el CFDI debe contener el complemento para Comercio Exterior.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40123() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40123.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40123 - El campo Exportacion no contiene un valor del catálogo c_Exportacion.",
          e.getMessage());

      /**
       * TODO: Regresar códigos de validación SAT:
       *
       * <p>Request Error :Request Error :cvc-enumeration-valid: Value 'X' is not facet-valid with
       * respect to enumeration '[I, E, T, N, P]'.
       *
       * <p>Debe regresar: - CFDI40121 - El campo Exportacion no contiene un valor del catálogo
       * c_Exportacion.
       */
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40124() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40124.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40124 - El campo MetodoPago, no contiene un valor del catálogo c_MetodoPago.",
          e.getMessage());

      /**
       * TODO: Regresar códigos de validación SAT:
       *
       * <p>Request Error :cvc-enumeration-valid: Value 'AHORITA' is not facet-valid with respect to
       * enumeration '[PUE, PPD]'. It must be a value from the enumeration.
       *
       * <p>Debe regresar: - CFDI40124 - El campo MetodoPago, no contiene un valor del catálogo
       * c_MetodoPago..
       */
    }
  }

  @Test
  public void timbra_cfdi_error40125() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40125.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40125 - Se debe omitir el campo MetodoPago cuando el TipoDeComprobante es T o P.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40126() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40126.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40126 - El campo LugarExpedicion, no contiene un valor del catálogo c_CodigoPostal.",
          e.getMessage());

      /**
       * TODO: Regresar códigos de validación SAT:
       *
       * <p>Request Error :cvc-enumeration-valid: Value 'MEXICO' is not facet-valid with respect to
       * enumeration '[00000, 20000, 20001, 20002, 20003, 20004, 20005, 20006, 20007, 20008, 20009,
       * 20010, 20011, 20012, 20013, 20014, 20015, 20016, 20017, 20018, 20019, 2 ...
       *
       * <p>Debe regresar: - CFDI40126 - El campo LugarExpedicion, no contiene un valor del catálogo
       * c_CodigoPostal.
       */
    }
  }


  @Test
  public void timbra_cfdi_error40127() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40127.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40127 - El campo Confirmacion no debe existir cuando los atributos TipoCambio y/o Total están dentro del rango permitido.",
          e.getMessage());
      /**
       * TODO: Cambiar de la validación la palabra atributos por campos (Así viene en la matriz):
       */
    }
  }

  @Test
  public void timbra_cfdi_error40128() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40128.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40128 - Número de confirmación inválido.", e.getMessage());
    }
  }


  @Ignore
  @Test
  public void timbra_cfdi_error40129() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40129.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40129 - Número de confirmación utilizado previamente.",
          e.getMessage());
      /**
       * TODO: Agregar la I al codig´de valiacion actualemnte aparece como CFD40129 debe ser
       * CFDI40129
       */
    }
  }

  @Test
  public void timbra_cfdi_error40130() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40130.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40130 - El campo Rfc del nodo receptor debe contener valor \"XAXX010101000\" y el valor del campo Nombre del nodo Receptor debe contener el valor “PUBLICO EN GENERAL”.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40131() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40131.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40131 - El campo Periodicidad, no contiene un valor del catálogo c_Periodicidad.",
          e.getMessage());

      /**
       * TODO: Cambiar la validacion Request Error :cvc-enumeration-valid: Value 'NUNCA' is not
       * facet-valid with respect to enumeration '[01, 02, 03, 04, 05]'. It must be a value from the
       * enumeration. POR: CFDI40131 - El campo Periodicidad, no contiene un valor del catálogo
       * c_Periodicidad.
       */
    }
  }

  @Test
  public void timbra_cfdi_error40132() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40132.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40132 - El campo RegimenFiscal, no contiene el valor 621.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40133() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40133.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40133 - El campo Meses, no contiene un valor del catálogo c_Meses.",
          e.getMessage());
      /**
       * TODO: Cambiar la validacion Request Error :cvc-enumeration-valid: Value 'Enero' is not
       * facet-valid with respect to enumeration '[01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12,
       * 13, 14, 15, 16, 17, 18]'. It must be a value from the enumeration POR validacion sat:
       * CFDI40133 - El campo Meses, no contiene un valor del catálogo c_Meses.
       */
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40134() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40134.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40134 - El campo Meses, no contiene alguno de los valores “01”, “02”, “03”, “04”, “05”, “06”, “07”, “08”, “09”, “10”, “11” o \"12\".",
          e.getMessage());

      /**
       * TODO: Cambiar la validacion cvc-enumeration-valid: Value '00' is not facet-valid with
       * respect to enumeration '[01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12, 13, 14, 15, 16,
       * 17, 18]'. It must be a value from the enumeration. POR validacion sat: CFDI40134 - El campo
       * Meses, no contiene alguno de los valores “01”, “02”, “03”, “04”, “05”, “06”, “07”, “08”,
       * “09”, “10”, “11” o "12".
       */
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40135() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40135.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40135 - El campo Meses, no contiene alguno de los valores “13”, “14”, “15”, “16”, “17” o “18”.",
          e.getMessage());
      /**
       * TODO: Cambiar la validacion Request Error :cvc-enumeration-valid: Value '19' is not
       * facet-valid with respect to enumeration '[01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12,
       * 13, 14, 15, 16, 17, 18]'. It must be a value from the enumeration.
       *
       * <p>POR validacion sat: CFDI40135 - El campo Meses, no contiene alguno de los valores “13”,
       * “14”, “15”, “16”, “17” o “18”."
       */
    }
  }

  @Test
  public void timbra_cfdi_error40136() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40136.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40136 - El campo Año, no es igual al año en curso o al año inmediato anterior.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40137() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40137.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40137 - El campo TipoRelacion, no contiene un valor del catálogo c_TipoRelacion.",
          e.getMessage());

      /**
       * TODO: Cambiar la validacion Request Error :cvc-enumeration-valid: Value '19' is not
       * facet-valid with respect to enumeration '[01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12,
       * 13, 14, 15, 16, 17, 18]'. It must be a value from the enumeration.
       *
       * <p>POR validacion sat: CFDI40135 - El campo Meses, no contiene alguno de los valores “13”,
       * “14”, “15”, “16”, “17” o “18”."
       */
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40138() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40138.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40138 - El campo Nombre del emisor, debe encontrarse en la lista de RFC inscritos no cancelados en el SAT.",
          e.getMessage());
      /** TODO: Revisar Esta validacion se cumple con el error CFDI40139 */
    }
  }

  @Test
  public void timbra_cfdi_error40139() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40139.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40139 - El campo Nombre del emisor, debe pertenecer al nombre asociado al RFC registrado en el campo Rfc del Emisor.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40140() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40140.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40140 - El campo RegimenFiscal, no contiene un valor del catálogo c_RegimenFiscal.",
          e.getMessage());

      /**
       * TODO: Cambiar la validacion Request Error :cvc-enumeration-valid: Value '99' is not
       * facet-valid with respect to enumeration
       *
       * <p>POR validacion sat: :CFDI40140 - El campo RegimenFiscal, no contiene un valor del
       * catálogo c_RegimenFiscal.
       */
    }
  }

  @Test
  public void timbra_cfdi_error40141() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40141.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40141 - La clave del campo RegimenFiscal debe corresponder con el tipo de persona (fisica o moral).",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40142() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40142.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40142 - El campo FacAtrAdquirente, no contiene un número de operación valido.",
          e.getMessage());

      /**
       * TODO: Cambiar la validacion Request Error :cvc-pattern-valid: Value 'ABC' is not
       * facet-valid with respect to pattern '[0-9]{10}' for type
       * '#AnonType_FacAtrAdquirenteEmisorComprobante'
       *
       * <p>POR validacion sat: :CFDI40142 - El campo FacAtrAdquirente, no contiene un número de
       * operación valido.
       */
    }
  }

  @Test
  public void timbra_cfdi_error40143() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40143.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40143 - Este RFC del receptor no existe en la lista de RFC inscritos no cancelados del SAT.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_cfdi_error40144() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40144.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40144 - El campo Nombre del receptor, debe encontrarse en la lista de RFC inscritos no cancelados en el SAT.",
          e.getMessage());

      /** TODO: Revisar Esta validacion se cumple con el error CFDI40145 */
    }
  }

  @Test
  public void timbra_cfdi_error40145() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40145.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40145 - El campo Nombre del receptor, debe pertenecer al nombre asociado al RFC registrado en el campo Rfc del Receptor.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_cfdi_error40146() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/cfdi-error/CFDI40146.xml")));

    comprobante =
        comprobante.replace(
            DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraCfdiSinSello cfdiSinSello = new TimbraCfdiSinSello();
    cfdiSinSello.setPassword(TEST_PASS);
    cfdiSinSello.setUserName(TEST_USER);
    cfdiSinSello.setComprobante(comprobante);

    try {
      client.timbrarSinSello(cfdiSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
          "Request Error :CFDI40146 - El campo RFC del receptor debe contener el valor  \"XAXX010101000\".",
          e.getMessage());
    }
  }
}
