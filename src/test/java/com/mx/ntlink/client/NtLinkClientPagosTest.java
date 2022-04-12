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

public class NtLinkClientPagosTest {

  private static final Logger log = LoggerFactory.getLogger(NtLinkClientPagosTest.class);
  private static final NtLinkClient client =
      new NtLinkClientImpl("http://dev-cfdi4.ntlink.com.mx/cfdi40/servicio-timbrado");
  private static final String TEST_USER = "EKU9003173C9@ntlink.com.mx";
  private static final String TEST_PASS = "Factura.2021*";
  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
  private static final String DATE_REPLACEMENT = "%fecha-timbrado%";

  @Test
  public void timbra_pagos_error20101() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20101.xml")));

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
          "Request Error :CRP20101 - El valor del campo TipoDeComprobante debe ser \"P\"",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20102() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20102.xml")));

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
          "Request Error :CRP20102 - El valor del campo Exportacion debe ser \"01\"",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20103() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20103.xml")));

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
          "Request Error :CRP20103 - El valor del campo SubTotal debe ser cero \"0\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20104() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20104.xml")));

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
          "Request Error :CRP20104 - El valor del campo Moneda debe ser \"XXX\".", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20105() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20105.xml")));

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
          "Request Error :CRP20105 - El campo FormaPago no se debe registrar en el CFDI.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20106() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20106.xml")));

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
          "Request Error :CRP20106 - El campo MetodoPago no se debe registrar en el CFDI.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20107() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20107.xml")));

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
          "Request Error :CRP20107 - El campo CondicionesDePago no se debe registrar en el CFDI.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20108() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20108.xml")));

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
          "Request Error :CRP20108 - El campo Descuento no se debe registrar en el CFDI.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20109() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20109.xml")));

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
          "Request Error :CRP20109 - El campo TipoCambio no se debe registrar en el CFDI.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20110() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20110.xml")));

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
          "Request Error :CRP20110 - El valor del campo Total debe ser cero \"0\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20111() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20111.xml")));

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
          "Request Error :CRP20111 - Solo debe existir un Concepto en el CFDI. ", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20112() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20112.xml")));

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
          "Request Error :CRP20112 - Si no existe el nodo AcuentaTerceros, no se deben registrar apartados dentro de Conceptos.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20113() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20113.xml")));

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
          "Request Error :CRP20113 - El valor del campo ClaveProdServ debe ser \"84111506\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20114() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20114.xml")));

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
          "Request Error :CRP20114 - El campo NoIdentificacion no se debe registrar en el CFDI.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20115() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20115.xml")));

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
          "Request Error :CRP20115 - El valor del campo Cantidad debe ser \"1\".", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20116() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20116.xml")));

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
          "Request Error :CRP20116 - El valor del campo ClaveUnidad debe ser \"ACT\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20117() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20117.xml")));

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
          "Request Error :CRP20117 - El campo Unidad no se debe registrar en el CFDI.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20118() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20118.xml")));

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
          "Request Error :CRP20118 - El valor del campo Descripcion debe ser \"Pago\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20119() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20119.xml")));

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
          "Request Error :CRP20119 - El valor del campo ValorUnitario debe ser cero \"0\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20120() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20120.xml")));

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
          "Request Error :CRP20120 - El valor del campo Importe debe ser cero \"0\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20121() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20121.xml")));

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
          "Request Error :CRP20121 - El campo Descuento no se debe registrar en el CFDI.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20122() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20122.xml")));

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
          "Request Error :CRP20122 - El valor del campo ObjetoImp debe ser \"01\".",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_pagos_error20123() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20123.xml")));

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
          "Request Error :CRP20123 - No se debe registrar el apartado de Impuestos en el CFDI.",
          e.getMessage());
      /**
       * TODO: Validar código de respuesta SAT: el proxy regresa: cvc-complex-type.2.4.a: Invalid
       * content was found starting with element 'cfdi:Impuestos'. One of
       * '{"http://www.sat.gob.mx/cfd/4":Concepto}' is expected.
       */
    }
  }

  @Test
  public void timbra_pagos_error20201() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20201.xml")));

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
          "Request Error :CRP20201 - El valor del campo TotalRetencionesIVA no es igual al redondeo de la suma del resultado de multiplicar cada uno de los importes de los atributos ImporteP de los impuestos retenidos registrados en el elemento RetencionP donde el atributo ImpuestoP contenga el valor IVA por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20202() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20202.xml")));

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
          "Request Error :CRP20202 - El valor del campo TotalRetencionesISR no es igual al redondeo de la suma del resultado  de multiplicar cada uno de los importes de los atributos ImporteP de los impuestos retenidos registrados en el elemento RetencionP donde el atributo ImpuestoP contenga el valor ISR por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20203() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20203.xml")));

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
          "Request Error :CRP20203 - El valor del campo TotalRetencionesIEPS no es igual al redondeo de la suma del resultado de multiplicar cada uno de los importes de los atributos ImporteP de los impuestos retenidos registrados en el elemento RetencionP donde el atributo ImpuestoP contenga el valor IEPS por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20204() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20204.xml")));

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
          "Request Error :CRP20204 - El valor del campo TotalTrasladosBaseIVA16 no es igual al redondeo de la suma del resultado de multiplicar cada uno de los importes de los atributos BaseP de los impuestos trasladados registrados en el elemento TrasladoP donde los atributos contengan en ImpuestoP el valor IVA, en TipoFactorP el valor Tasa y en TasaOCuotaP el valor 0.160000, por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20205() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20205.xml")));

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
          "Request Error :CRP20205 - El valor del campo TotalTrasladosImpuestoIVA16 no es  igual al redondeo de la suma del resultado de multiplicar cada uno de los importes de los atributos ImporteP de los impuestos trasladados registrados en el elemento TrasladoP donde los atributos contengan en ImpuestoP el valor IVA, en TipoFactorP el valor Tasa y en TasaOCuotaP el valor 0.160000, por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20206() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20206.xml")));

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
          "Request Error :CRP20206 - El valor del campo TotalTrasladosBaseIVA8 no es igual al redondeo de la suma del resultado de multiplicar cada uno de los importes de los atributos BaseP de los impuestos trasladados registrados en el elemento TrasladoP donde los atributos contengan en ImpuestoP el valor IVA, en TipoFactorP el valor Tasa y en TasaOCuotaP el valor 0.080000, por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20207() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20207.xml")));

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
          "Request Error :CRP20207 - El valor del campo TotalTrasladosImpuestoIVA8 no es igual al redondeo de la suma del resultado de multiplicar  cada uno de los importes de los atributos ImporteP de los impuestos trasladados registrados en el elemento TrasladoP donde los atributos contengan en ImpuestoP el valor IVA, en TipoFactorP el valor Tasa y TasaOCuotaP el valor 0.080000, por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20208() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20208.xml")));

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
          "Request Error :CRP20208 - El valor del campo TotalTrasladosBaseIVA0 no es igual al redondeo de la suma del resultado de multiplicar cada uno de los importes de los atributos BaseP de los impuestos trasladados registrados en el elemento TrasladoP donde los atributos contengan en ImpuestoP el valor IVA, en TipoFactorP el valor Tasa y en TasaOCuotaP el valor 0.000000, por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20209() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20209.xml")));

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
          "Request Error :CRP20209 - El valor del campo TotalTrasladosImpuestoIVA0 no es  igual al redondeo de la suma del resultado de multiplicar cada uno de los importes de los atributos ImporteP de los impuestos trasladados registrados en el elemento TrasladoP donde los atributos contengan en ImpuestoP el valor IVA, en TipoFactorP el valor Tasa y en TasaOCuotaP el valor 0.000000, por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20210() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20210.xml")));

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
          "Request Error :CRP20210 - El valor del campo TotalTrasladosBaseExento no es igual al redondeo de la suma del resultado de multiplicar cada uno de los importes de los atributos BaseP de los impuestos trasladados registrados en el elemento TrasladoP donde los atributos contengan en ImpuestoP el valor IVA y en TipoFactorP el valor Exento, por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20211() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20211.xml")));

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
          "Request Error :CRP20211 - El valor del campo MontoTotalPagos no es igual al redondeo de la suma del resultado de multiplicar cada uno de los atributos Monto por el valor registrado en el atributo TipoCambioP de cada nodo Pago.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20212() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20212.xml")));

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
          "Request Error :CRP20212 - El valor del campo FormaDePagoP debe ser distinto de \"99\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20213() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20213.xml")));

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
          "Request Error :CRP20213 - El campo MonedaP debe ser distinto de \"XXX\"",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20214() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20214.xml")));

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
          "Request Error :CRP20214 - El campo TipoCambioP se debe registrar.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20215() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20215.xml")));

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
          "Request Error :CRP20215 - El campo TipoCambioP debe contener el valor \"1\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20216() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20216.xml")));

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
          "Request Error :CRP20216 - Cuando el valor del campo TipoCambioP se encuentre fuera de los límites establecidos, debe existir el campo Confirmacion.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20217() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20217.xml")));

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
          "Request Error :CRP20217 - La suma de los valores registrados en el campo ImpPagado de los apartados DoctoRelacionado no es menor o igual que el valor del campo Monto.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20218() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20218.xml")));

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
          "Request Error :CRP20218 - El valor del campo Monto no es mayor que cero \"0\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20219() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20219.xml")));

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
          "Request Error :CRP20219 - El valor del campo Monto debe tener hasta la cantidad de decimales que soporte la moneda registrada en el campo MonedaP.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_pagos_error20220() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20220.xml")));

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
          "Request Error :CRP20220 - Cuando el valor del campo Monto se encuentre fuera de los límites establecidos, debe existir el campo Confirmacion",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20222() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20222.xml")));

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
          "Request Error :CRP20222 - El RFC del campo RfcEmisorCtaOrd no se encuentra en la lista de RFC.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20223() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20223.xml")));

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
          "Request Error :CRP20223 - El campo NomBancoOrdExt se debe registrar.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20224() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20224.xml")));

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
          "Request Error :CRP20224 - El campo CtaOrdenante no se debe registrar.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20225() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20225.xml")));

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
          "Request Error :CRP20225 - El campo CtaOrdenante no cumple con el patrón requerido.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20226() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20226.xml")));

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
          "Request Error :CRP20226 - El campo CtaBeneficiario no cumple con el patrón requerido.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20227() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20227.xml")));

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
          "Request Error :CRP20227 - El campo RfcEmisorCtaBen no se debe registrar.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20229() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20229.xml")));

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
          "Request Error :CRP20229 - El campo TipoCadPago no se debe registrar. ", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20230() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20230.xml")));

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
          "Request Error :CRP20230 - El campo CertPago se debe registrar.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20231() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20231.xml")));

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
          "Request Error :CRP20231 - El campo CertPago no se debe registrar.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20232() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20232.xml")));

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
          "Request Error :CRP20232 - El campo CadPago se debe registrar.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20233() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20233.xml")));

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
          "Request Error :CRP20233 - El campo CadPago no se debe registrar.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20234() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20234.xml")));

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
          "Request Error :CRP20234 - El campo SelloPago se debe registrar. ", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20235() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20235.xml")));

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
          "Request Error :CRP20235 - El campo SelloPago no se debe registrar.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20236() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20236.xml")));

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
          "Request Error :CRP20236 - El valor del campo MonedaDR debe ser distinto de \"XXX\"",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20237() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20237.xml")));

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
          "Request Error :CRP20237 - El campo EquivalenciaDR se debe registrar.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20238() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20238.xml")));

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
          "Request Error :CRP20238 - El campo EquivalenciaDR debe contener el valor \"1\".",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20239() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20239.xml")));

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
          "Request Error :CRP20239 - El campo ImpSaldoAnt debe mayor a cero.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20240() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20240.xml")));

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
          "Request Error :CRP20240 - El valor del campo ImpSaldoAnt debe tener hasta la cantidad de decimales que soporte la moneda registrada en el campo MonedaDR.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20241() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20241.xml")));

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
          "Request Error :CRP20241 - El campo ImpPagado debe mayor a cero.", e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20242() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20242.xml")));

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
          "Request Error :CRP20242 - El valor del campo ImpPagado debe tener hasta la cantidad de decimales que soporte la moneda registrada en el campo MonedaDR.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20243() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20243.xml")));

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
          "Request Error :CRP20243 - El valor del campo ImpSaldoInsoluto debe tener hasta la cantidad de decimales que soporte la moneda registrada en el campo MonedaDR.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20244() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20244.xml")));

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
          "Request Error :CRP20244 - El campo ImpSaldoInsoluto debe ser mayor o igual a cero y calcularse con la suma de los campos ImSaldoAnt menos el ImpPagado",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20245() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20245.xml")));

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
          "Request Error :CRP20245 - El campo ObjetoImpDR, debe tener un valor del catálogo c_ObjetoImp.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20246() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20246.xml")));

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
          "Request Error :CRP20246 - El nodo hijo ImpuestosDR del nodo DoctoRelacionado debe existir.",
          e.getMessage());
    }
  }


  @Ignore
  @Test
  public void timbra_pagos_error20247() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20247.xml")));

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
          "Request Error :CRP20247 - El nodo hijo Impuestos del nodo concepto, no debe existir.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20248() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20248.xml")));

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
          "Request Error :CRP20248 - En caso de utilizar el nodo Impuestos en un documento relacionado, se deben incluir impuestos  de traslados y/o retenciones.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20249() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20249.xml")));

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
          "Request Error :CRP20249 - El valor del campo BaseDR que corresponde a Retención debe ser mayor que cero.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20250() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20250.xml")));

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
          "Request Error :CRP20250 - El valor del campo ImpuestoDR que corresponde a Retención no contiene un valor del catálogo c_Impuesto.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20251() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20251.xml")));

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
          "Request Error :CRP20251 - El valor del campo TipoFactorDR que corresponde a Retención no contiene un valor del catálogo c_TipoFactor.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20252() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20252.xml")));

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
          "Request Error :CRP20252 - El valor registrado en el campo TipoFactorDR que corresponde a Retención debe ser distinto de Exento.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20253() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20253.xml")));

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
          "Request Error :CRP20253 - El valor del campo TasaOCuotaDR que corresponde a Retención, no contiene un valor del catálogo c_TasaOcuota o se encuentra fuera de rango.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20254() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20254.xml")));

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
          "Request Error :CRP20254 - El valor del campo ImporteDR que corresponde a Retención no se encuentra entre el limite inferior y superior permitido.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20255() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20255.xml")));

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
          "Request Error :CRP20255 - El valor del campo BaseDR que corresponde a Traslado debe ser mayor que cero.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20256() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20256.xml")));

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
          "Request Error :CRP20256 - El valor del campo ImpuestoDR que corresponde a Traslado no contiene un valor del catálogo c_Impuesto.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20257() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20257.xml")));

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
          "Request Error :CRP20257 - El valor del campo TipoFactorDR que corresponde a Traslado no contiene un valor del catálogo c_TipoFactor.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20258() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20258.xml")));

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
          "Request Error :CRP20258 - Si el valor registrado es Exento no se deben registrar los atributos TasaOCuotaDR ni ImporteDR.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_pagos_error20259() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20259.xml")));

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
          "Request Error :CRP20259 - El valor del campo TasaOCuotaDR que corresponde a Traslado no contiene un valor del catálogo c_TasaOcuota o se encuentra fuera de rango.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20260() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20260.xml")));

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
          "Request Error :CRP20260 - El valor del campo TasaOCuotaDR que corresponde a Traslado no contiene un valor del catálogo c_TasaOcuota o se encuentra fuera de rango.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20261() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20261.xml")));

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
          "Request Error :CRP20261 - El valor del campo ImporteDR o que corresponde a Traslado no se encuentra entre el limite inferior y superior permitido.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_pagos_error20262() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20262.xml")));

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
          "Request Error :CRP20262 - El campo ImpuestoP no contiene un valor del catálogo c_Impuesto.",
          e.getMessage());
    }

    /* ESTA VALIDACION ESTA "AMARRADA" A LA VALIDACION 256 */
  }

  @Ignore
  @Test
  public void timbra_pagos_error20263() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20263.xml")));

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
          "Request Error :CRP20263 - Debe haber sólo un registro por cada tipo de impuesto retenido.",
          e.getMessage());

      /* ESTA VALIDACION ESTA "AMARRADA" A LA VALIDACION 202 */

    }
  }

  @Test
  public void timbra_pagos_error20264() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20264.xml")));

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
          "Request Error :CRP20264 - Debe existir al menos uno de los campos TotalRetencionesIVA, TotalRetencionesISR, TotalRetencionesIEPS.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20265() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20265.xml")));

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
          "Request Error :CRP20265 - El campo ImporteP  que corresponde a Retención, no es igual a la suma de los importes de los impuestos retenidos registrados en el documento relacionado donde el impuesto sea igual al campo ImpuestoP de este elemento.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20266() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20266.xml")));

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
          "Request Error :CRP20266 - Deben exitir los campos BaseP, ImpuestoP y TipoFactorP",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20267() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20267.xml")));

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
          "Request Error :CRP20267 - Debe existir al menos uno de los campos TotalTrasladosBaseIVA16 y/o y/o TotalTrasladosBaseIVA8 y/o TotalTrasladosBaseIVA0 y/o TotalTrasladosBaseIVAExento.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20268() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20268.xml")));

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
          "Request Error :CRP20268 - El campo BaseP que corresponde a Traslado, no es igual a la suma de los importes de las bases registrados en los documentos relacionados donde el impuesto del documento relacionado sea igual al campo ImpuestoP de este elemento y la TasaOCuotaDR del documento relacionado sea igual al campo TasaOCuotaP de este elemento.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20269() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20269.xml")));

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
          "Request Error :CRP20269 - El importe del campo BaseP que corresponde a Traslado, no es igual a la suma de los importes de las bases registrados en los documentos relacionados.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_pagos_error20270() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20270.xml")));

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
          "Request Error :CRP20270 - El campo ImpuestoP que corresponde a Traslado no contiene un valor del catálogo c_Impuesto.",
          e.getMessage());
    }

    /* Esta validación se relaciona con la 268 ya que se comparan las bases y el tipo de impuesto */
  }

  @Ignore
  @Test
  public void timbra_pagos_error20271() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20271.xml")));

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
          "Request Error :CRP20271 - Debe haber sólo un registro con la misma combinación de impuesto, factor y tasa por cada traslado.",
          e.getMessage());
    }
  }

  @Ignore
  @Test
  public void timbra_pagos_error20272() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20272.xml")));

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
          "Request Error :CRP20272 - El valor seleccionado debe corresponder a un valor del catálogo Tasa O Cuota donde la columna impuesto corresponda con el campo ImpuestoP y la columna factor corresponda con el campo TipoFactorP.",
          e.getMessage());
    }

    /*Esta valdiacion se relaciona directamente con la 260 */
  }

  @Test
  public void timbra_pagos_error20273() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20273.xml")));

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
          "Request Error :CRP20273 - Deben existir al menos uno de los campos TotalTrasladosImpuestoIVA16, TotalTrasladosImpuestoIVA8, TotalTrasladosImpuestoIVA0 cuando existan conceptos con un TipoFactor distinto a Exento.",
          e.getMessage());
    }
  }

  @Test
  public void timbra_pagos_error20274() throws IOException, SoapClientException {

    String comprobante =
        new String(Files.readAllBytes(Paths.get("./src/test/resources/pagos-error/CRP20274.xml")));

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
          "Request Error :CRP20274 - El campo ImporteP que corresponde a Traslado, no es igual a la suma de los importes de los impuestos registrados en el documento relacionado donde el impuesto del documento relacionado sea igual al campo ImpuestoP de este elemento y la TasaOCuotaP del documento relacionado sea igual al campo TasaOCuotaP de este elemento.",
          e.getMessage());
    }
  }
}
