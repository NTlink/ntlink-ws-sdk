package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.TimbraCfdiSinSello;
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

public class NtLinkClientNominaTest {

  private static final Logger log = LoggerFactory.getLogger(NtLinkClientNominaTest.class);
  private static final NtLinkClient client =
      new NtLinkClientImpl("http://dev-cfdi4.ntlink.com.mx/cfdi40/servicio-timbrado");
  private static final String TEST_USER = "EKU9003173C9@ntlink.com.mx";
  private static final String TEST_PASS = "Factura.2021*";
  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
  private static final String DATE_REPLACEMENT = "%fecha-timbrado%";

  @Test
  public void timbra_nomina_error1() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM1.xml")));

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
          "Request Error :NOM1 - El atributo Comprobante.Moneda no tiene el valor =  \"MXN\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error2() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM2.xml")));

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
          "Request Error :NOM2 - El atributo Comprobante.TipoDeComprobante no tiene el valor =  \"N\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error3() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM3.xml")));

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
          "Request Error :NOM3 - El atributo Comprobante.Exportacion no tiene el valor =  \"01\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error4() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM4.xml")));

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
          "Request Error :NOM4 - El nodo Comprobante.InformacionGlobal, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error5() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM5.xml")));

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
          "Request Error :NOM05 - El atributo Nomina12:Emisor:Curp, no aplica para persona moral.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error6() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM6.xml")));

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
          "Request Error :NOM06 - El atributo Nomina12:Emisor:Curp, aplica para persona física.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error7() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM7.xml")));

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
          "Request Error :NOM7 - El atributo Comprobante.Emisor.FacAtrAdquirente, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error8() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM8.xml")));

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
          "Request Error :NOM8 - El atributo Comprobante.Receptor.Rfc, debe ser de longitud 13.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error9() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM9.xml")));

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
          "Request Error :NOM9 - El atributo Comprobante.Receptor.Rfc, no está en la lista de RFC inscritos no cancelados en el SAT (l_RFC).",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error10() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM10.xml")));

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
          "Request Error :NOM010 - El atributo Comprobante.Receptor.Rfc registra el RFC genérico XAXX010101000, por lo que en el atributo Nomina12:Receptor:Curp, debe registrar la CURP del receptor fallecido.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error11() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM11.xml")));

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
          "Request Error :NOM11 - En el atributo Comprobante.Receptor.RegimenFiscalReceptor, se debe registrar la clave \"605\", aún y cuando el atributo Comprobante.Receptor.Rfc tenga registrado el RFC genérico XAXX010101000.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error12() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM12.xml")));

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
          "Request Error :NOM12 - El atributo Comprobante.Receptor.UsoCFDI no tiene el valor =  \"CN01\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error13() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM13.xml")));

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
          "Request Error :NOM13 - El nodo Comprobante.Conceptos.Concepto, solo puede registrar un nodo concepto, sin elementos hijo.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error14() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM14.xml")));

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
          "Request Error :NOM14 - El atributo Comprobante.Conceptos.Concepto.ClaveProdServ no tiene el valor =  \"84111505\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error15() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM15.xml")));

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
          "Request Error :NOM15 - El atributo Comprobante.Conceptos.Concepto.NoIdentificacion, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error16() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM16.xml")));

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
          "Request Error :NOM16 - El atributo Comprobante.Conceptos.Concepto.Cantidad no tiene el valor =  \"1\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error17() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM17.xml")));

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
          "Request Error :NOM17 - El atributo Comprobante.Conceptos.Concepto.ClaveUnidad no tiene el valor =  “ACT”.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error18() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM18.xml")));

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
          "Request Error :NOM18 - El atributo Comprobante.Conceptos.Concepto.Unidad, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error19() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM19.xml")));

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
          "Request Error :NOM19 - El atributo Comprobante.Conceptos.Concepto.Descripcion no tiene el valor =  “Pago de nómina”.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error20() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM20.xml")));

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
          "Request Error :NOM20 -El valor del atributo Comprobante.Conceptos.Concepto.ValorUnitario no coincide con la suma TotalPercepciones más TotalOtrosPagos.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error21() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM21.xml")));

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
          "Request Error :NOM21 - El valor del atributo Comprobante.Conceptos.Concepto.Importe no coincide con la suma TotalPercepciones más TotalOtrosPagos.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error22() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM22.xml")));

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
          "Request Error :NOM22 - El valor del atributo Comprobante.Conceptos.Concepto.Descuento no es igual a el valor del campo Nomina12:TotalDeducciones.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error23() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM23.xml")));

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
          "Request Error :NOM23 - El atributo Comprobante.Conceptos.Concepto.ObjetoImp no tiene el valor =  “01”.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error24() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM24.xml")));

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
          "Request Error :NOM24 - El nodo Comprobante.Conceptos.Concepto.Impuestos, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error25() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM25.xml")));

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
          "Request Error :NOM25 - El nodo Comprobante.Conceptos.Concepto.ACuentaTerceros, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error26() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM26.xml")));

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
          "Request Error :NOM26 - El nodo Comprobante.Conceptos.Concepto.InformacionAduanera, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error27() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM27.xml")));

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
          "Request Error :NOM27 - El nodo Comprobante.Conceptos.Concepto.CuentaPredial, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error28() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM28.xml")));

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
          "Request Error :NOM28 - El nodo Comprobante.Conceptos.Concepto.ComplementoConcepto, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error29() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM29.xml")));

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
          "Request Error :NOM29 - El nodo Comprobante.Conceptos.Concepto.Parte, no debe existir.",
          e.getMessage());
    }
  }



  @Test
  public void timbra_nomina_error30() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM30.xml")));

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
              "Request Error :NOM30 - El nodo Nomina no se puede utilizar dentro del elemento ComplementoConcepto.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error31() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM31.xml")));

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
              "Request Error :NOM31 - El nodo Nomina no tiene valores en TotalPercepciones y/o TotalOtrosPagos.",
              e.getMessage());
    }
  }



  @Test
  public void timbra_nomina_error32() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM32.xml")));

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
              "Request Error :NOM32 - El valor del atributo Nomina.TipoNomina no cumple con un valor del catálogo c_TipoNomina.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error33() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM33.xml")));

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
              "Request Error :NOM33 - El valor del atributo tipo de periodicidad es \"99\".",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error34() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM34.xml")));

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
              "Request Error :NOM34 - El valor del atributo tipo de periodicidad no tiene el valor \"99\".",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error35() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM35.xml")));

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
              "Request Error :NOM35 - El valor del atributo Nomina.FechaInicialPago no es menor o igual al valor del atributo FechaFinalPago.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error36() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM36.xml")));

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
              "Request Error :NOM36 - El atributo Nomina.TotalPercepciones, no debe existir.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error37() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM37.xml")));

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
              "Request Error :NOM37 - El valor del atributo Nomina.TotalPercepciones no coincide con la suma de los atributos TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro del  nodo Percepciones.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error38() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM38.xml")));

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
              "Request Error :NOM38 - El atributo Nomina.TotalDeducciones, no debe existir.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error39() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM39.xml")));

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
              "Request Error :NOM39 - El valor del atributo Nomina.TotalDeducciones no coincide con la suma de los atributos TotalOtrasDeducciones más TotalImpuestosRetenidos del elemento Deducciones.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error40() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM40.xml")));

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
              "Request Error :NOM40 - El valor del atributo Nomina.TotalOtrosPagos no está registrado o  no coincide con la suma de los atributos Importe de los nodos nomina12:OtrosPagos:OtroPago.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error41() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM41.xml")));

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
              "Request Error :NOM41 - El atributo Nomina.Emisor.RfcPatronOrigen no está inscrito o bien, inscrito y sí cancelado en el SAT (l_RFC).",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error42() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM42.xml")));

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
              "Request Error :NOM42 - El atributo Nomina.Emisor.RegistroPatronal se debe registrar.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error43() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM43.xml")));

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
              "Request Error :NOM43 - El atributo Nomina.Emisor.RegistroPatronal  no se debe registrar.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error44() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM44.xml")));

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
              "Request Error :NOM44 - Los atributos NumSeguridadSocial, FechaInicioRelLaboral, Antigüedad,RiesgoPuesto,SalarioDiarioIntegrado deben existir.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error45() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM45.xml")));

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
              "Request Error :NOM45 - El elemento Nomina.Emisor.EntidadSNCF debe existir.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error46() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM46.xml")));

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
              "Request Error :NOM46 - El elemento Nomina.Emisor.EntidadSNCF no debe existir.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error47() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM47.xml")));

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
              "Request Error :NOM47 - El valor del atributo Nomina.Emisor.EntidadSNCF.OrigenRecurso no cumple con un valor del catálogo c_OrigenRecurso.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error48() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM48.xml")));

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
              "Request Error :NOM48 - El atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio debe existir.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error49() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM49.xml")));

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
              "Request Error :NOM49 - El atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio no debe existir.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error50() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM50.xml")));

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
              "Request Error :NOM50 - El valor del atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio no es menor a la suma de los valores de los atributos TotalPercepciones y TotalOtrosPagos. .",
              e.getMessage());
    }
  }
  @Test
  public void timbra_nomina_error51() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM51.xml")));

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
              "Request Error :NOM51 - El valor del atributo Nomina.Receptor.TipoContrato no cumple con un valor del catálogo c_TipoContrato.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error52() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM52.xml")));

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
              "Request Error :NOM52 - El valor del atributo Nomina.Receptor.TipoJornada no cumple con un valor del catálogo c_TipoJornada.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error53() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM53.xml")));

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
              "Request Error :NOM53 - El valor del atributo Nomina.Receptor.FechaInicioRelLaboral no es menor o igual al atributo a FechaFinalPago.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error54() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM54.xml")));

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
              "Request Error :NOM54 - El valor numérico del atributo Nomina.Receptor.Antigüedad no es menor o igual al cociente de (la suma del número de días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago más uno) dividido entre siete.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error55() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM55.xml")));

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
              "Request Error :NOM55 - El valor del atributo Nomina.Receptor.Antigüedad. no cumple con el número de años, meses y días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error56() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM56.xml")));

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
              "Request Error :NOM56 - El valor del atributo Nomina.Receptor.TipoRegimen no cumple con un valor del catálogo c_TipoRegimen.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error57() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM57.xml")));

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
              "Request Error :NOM57 - El valor del atributo Nomina.Receptor.TipoRegimen no es \"02\", \"03\" o \"04\".",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error58() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM58.xml")));

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
              "Request Error :NOM58 - El valor del atributo Nomina.Receptor.TipoRegimen no está entre \"05\" a \"99\".",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error59() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM59.xml")));

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
              "Request Error :NOM59 - El valor del atributo Nomina.Receptor.RiesgoPuesto no cumple con un valor del catálogo c_RiesgoPuesto.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error60() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM60.xml")));

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
              "Request Error :NOM60 - El valor del atributo Nomina.Receptor.PeriodicidadPago no cumple con un valor del catálogo c_PeriodicidadPago.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error61() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM61.xml")));

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
              "Request Error :NOM61 - El valor del atributo Nomina.Receptor.Banco no cumple con un valor del catálogo c_Banco.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error62() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM62.xml")));

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
              "Request Error :NOM62 - El atributo Nomina.Receptor.CuentaBancaria no cumple con la longitud de 10, 11, 16 o 18 posiciones.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error63() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM63.xml")));

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
              "Request Error :NOM63 - El atributo Banco no debe existir.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error64() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM64.xml")));

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
              "Request Error :NOM64 - El dígito de control del atributo CLABE no es correcto.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error65() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM65.xml")));

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
              "Request Error :NOM65 - El atributo Banco debe existir.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error66() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM66.xml")));

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
              "Request Error :NOM66 - El valor del atributo Nomina.Receptor.ClaveEntFed no cumple con un valor del catálogo c_Estado.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error67() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM67.xml")));

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
              "Request Error :NOM67 - El valor del atributo Nomina.Receptor.SubContratacion.RfcLabora no está en la lista de RFC (l_RFC).",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error68() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM68.xml")));

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
              "Request Error :NOM68 - La suma de los valores registrados en el atributo Nomina.Receptor.SubContratacion.PorcentajeTiempo no es igual a 100.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error69() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM69.xml")));

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
              "Request Error :NOM69 - La suma de los valores de los atributos TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro no es igual a la suma de los valores de los atributos TotalGravado más TotalExento.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error70() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM70.xml")));

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
              "Request Error :NOM70 - El valor del atributo Nomina.Percepciones.TotalSueldos, no es igual a la suma de los atributos ImporteGravado e ImporteExento donde la clave expresada en el atributo TipoPercepcion es distinta de \"022\", \"023\",\"025\", \"039\" y \"044\".",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error71() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM71.xml")));

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
              "Request Error :NOM71 - El valor del atributo Nomina.Percepciones.TotalSeparacionIndemnizacion, no es igual a la suma de los atributos ImporteGravado e ImporteExento donde la clave en el atributo TipoPercepcion es igual a \"022\", \"023\" o \"025\".",
              e.getMessage());
    }
  }




  @Test
  public void timbra_nomina_error72() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM72.xml")));

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
              "Request Error :NOM72 - El valor del atributo Nomina.Percepciones.TotalJubilacionPensionRetiro, no es igual a la suma de los atributos ImporteGravado e importeExento donde la clave expresada en el atributo TipoPercepcion es igual a \"039\" o \"044\".",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error73() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM73.xml")));

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
              "Request Error :NOM73 - El valor del atributo Nomina.Percepciones.TotalGravado, no es igual a la suma de los atributos ImporteGravado de los nodos Percepcion.",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error74() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM74.xml")));

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
              "Request Error :NOM74 - El valor del atributo Nomina.Percepciones.TotalExento, no es igual a la suma de los atributos ImporteExento de los nodos Percepcion.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error75() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM75.xml")));

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
              "Request Error :NOM75 - La suma de los importes de los atributos ImporteGravado e ImporteExento no es mayor que cero.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error76() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM76.xml")));

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
              "Request Error :NOM76 - El valor del atributo Nomina.Percepciones.Percepcion.TipoPercepcion no cumple con un valor del catálogo c_TipoPercepcion.",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error77() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM77.xml")));

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
              "Request Error :NOM77 - El atributo TotalSueldos, debe existir, ya que la clave expresada en Nomina.Percepciones.Percepcion.TipoPercepcion es distinta de \"022\", \"023\", \"025\", \"039\" y \"044\".",
              e.getMessage());
    }
  }



  @Test
  public void timbra_nomina_error78() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM78.xml")));

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
              "Request Error :NOM78 - El atributo TotalSeparacionIndemnizacion y el elemento SeparacionIndemnizacion, deben existir, ya que la clave expresada en Nomina.Percepciones.Percepcion.TipoPercepcion es \"022\" o \"023\" o \"025\".",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error79() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM79.xml")));

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
              "Request Error :NOM79 - El atributo TotalJubilacionPensionRetiro y el elemento JubilacionPensionRetiro deben existir,  ya que la clave expresada en el atributo Nomina.Percepciones.Percepcion.TipoPercepcion es \"039\" o \"044\".",
              e.getMessage());
    }
  }


  @Test
  public void timbra_nomina_error80() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM80.xml")));

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
              "Request Error :NOM80 - El atributo TotalUnaExhibicion debe existir y no deben existir TotalParcialidad, MontoDiario, ya que la clave expresada en el atributo Nomina.Percepciones.Percepcion.TipoPercepcion es \"039\".",
              e.getMessage());
    }
  }

  @Test
  public void timbra_nomina_error81() throws IOException, SoapClientException {

    String comprobante =
            new String(Files.readAllBytes(Paths.get("./src/test/resources/nomina-error/NOM81.xml")));

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
              "Request Error :NOM81 - El atributo TotalUnaExhibicion no debe existir y deben existir TotalParcialidad, MontoDiario, ya que la clave expresada en el atributo Nomina.Percepciones.Percepcion.TipoPercepcion es \"044\".",
              e.getMessage());
    }
  }


}
