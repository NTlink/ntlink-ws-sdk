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
import org.junit.Ignore;
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

  private static final String TEST_USER3 = "XIA190128J61@ntlink.com.mx";
  private static final String TEST_PASS3 = "Ntlink.2022";

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


  @Test
  public void timbra_retencion_errorRETEN20102() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20102.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS3);
    timbraRetencionSinSello.setUserName(TEST_USER3);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20102 - EL certificado no cumple con alguno de los valores permitidos.(CSDRevocado)",
              e.getMessage());
    }
  }


  @Test
  public void timbra_retencion_errorRETEN20103() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20103.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20103 - El campo FechaExp no cumple con el patrón requerido.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20104() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20104.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20104 - El campo LugarExpRetenc, no contiene un valor del catálogo c_CodigoPostal.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_retencion_errorRETEN20105() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20105.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20105 - El campo CveRetenc no contiene un valor del catálogo c_CveRetenc.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20106() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20106.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20106 - El campo DescRetenc debe existir.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_retencion_errorRETEN20108() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20108.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20108 - Los campos MontoTotGrav y MontoTotExento contienen un valor diferente de cero.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_retencion_errorRETEN20109() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20109.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20109 - El campo TipoRelacion, no contiene un valor del catálogo c_TipoRelacion.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20110() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20110.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20110 - El campo NomDenRazSocE del emisor, no corresponde con el nombre del titular del certificado de sello digital del Emisor.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20111() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20111.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20111 - El campo RegimenFiscalE, no contiene un valor del catálogo c_RegimenFiscalE.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20112() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20112.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20112 - La clave del campo RegimenFiscalE debe corresponder con el tipo de persona (física o moral).",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20113() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20113.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20113 - Este RFC del receptor no existe en la lista de RFC inscritos no cancelados del SAT.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20116() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20116.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20116 - El campo NomDenRazSocR del receptor, debe pertenecer al nombre asociado al RFC registrado en el campo RFCRecep del Receptor.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20117() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20117.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20117 - El campo RfcR no corresponde a persona física.",
              e.getMessage());
    }
  }



  @Test
  public void timbra_retencion_errorRETEN20120() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20120.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20120 -El campo DomicilioFiscalR, debe pertenecer al nombre asociado a la clave de RFC registrado en el campo RfcR.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20121() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20121.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20121 - El campo MesIni no contiene un valor del catálogo c_Periodo.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20122() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20122.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20122 - El campo MesIni no es menor o igual que el campo MesFin.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_retencion_errorRETEN20123() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20123.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20123 - El campo MesFin no contiene un valor del catálogo c_Periodo.",
              e.getMessage());
    }
  }

@Ignore
  @Test
  public void timbra_retencion_errorRETEN20124() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20124.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20124 - El campo MesFin no es mayor o igual que el campo MesIni.",
              e.getMessage());
    }
  }


  @Ignore
  @Test
  public void timbra_retencion_errorRETEN20125() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20125.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20125 - El campo Ejercicio no contiene un valor del catálogo c_Ejercicio.",
              e.getMessage());
    }
  }



  @Test
  public void timbra_retencion_errorRETEN20126() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20126.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20126 - El campo Año, no es igual al año en curso o al año inmediato anterior.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_retencion_errorRETEN20127() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20127.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20127 - El campo MontoTotOperacion no es igual a la suma de los atributos MontoTotGrav y MontoTotExent.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20128() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20128.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20128 - El valor del atributo MontoTotGrav es mayor al atributo MontoTotOperacion",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20129() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20129.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20129 - El valor del atributo MontoTotExent es mayor al atributo MontoTotOperacion",
              e.getMessage());
    }
  }


  @Test
  public void timbra_retencion_errorRETEN20130() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20130.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20130 - No existen los Impuestos Retenidos.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_retencion_errorRETEN20131() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20131.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20131 - El valor del campo MontoTotRet no es igual a la suma de los campos MontoRet.",
              e.getMessage());
    }
  }



  @Test
  public void timbra_retencion_errorRETEN20132() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20132.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20132 - El valor del campo UtilidadBimestral no es mayor que cero.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_retencion_errorRETEN20133() throws IOException, SoapClientException {

    String comprobante =
            new String(
                    Files.readAllBytes(Paths.get("./src/test/resources/retenciones-error/RETEN20133.xml")));

    comprobante =
            comprobante.replace(
                    DATE_REPLACEMENT, formatter.format(LocalDateTime.now().minusMinutes(10)));

    TimbraRetencionSinSello timbraRetencionSinSello = new TimbraRetencionSinSello();
    timbraRetencionSinSello.setPassword(TEST_PASS);
    timbraRetencionSinSello.setUserName(TEST_USER);
    timbraRetencionSinSello.setComprobante(comprobante);

    try {
      client.timbrarRetencionSinSello(timbraRetencionSinSello);
    } catch (SoapClientException e) {
      Assert.assertEquals(
              "Request Error :Reten20133 - El valor del campo ISRCorrespondiente no es mayor que cero.",
              e.getMessage());
    }
  }


}
