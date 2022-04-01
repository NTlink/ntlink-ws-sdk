package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.TimbraCfdiSinSello;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                    "Request Error :CRP20104 - El valor del campo Moneda debe ser \"XXX\".",
                    e.getMessage());
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
                    "Request Error :CRP20111 - Solo debe existir un Concepto en el CFDI. ",
                    e.getMessage());
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
                    "Request Error :CRP20112 - Si no existe el nodo AcuentaTerceros, no se deben registrar apartados dentro de Conceptos. ",
                    e.getMessage());

            /**
             * TODO: REVISAR: El servicio de Richard si responde bien, pero el proxy responde Error Al abrir el comprobante. En el log dice lo siguiente:
             *  Los datos del nivel de raíz no son válidos. línea 1, posición 1.
             */
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
                    "Request Error :CRP20115 - El valor del campo Cantidad debe ser \"1\".",
                    e.getMessage());
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
             * TODO: Validar código de respuesta SAT:

             * el proxy regresa: cvc-complex-type.2.4.a: Invalid content was found starting with element 'cfdi:Impuestos'. One of '{"http://www.sat.gob.mx/cfd/4":Concepto}' is expected.
             *
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
                    "Request Error :CRP20214 - El campo TipoCambioP se debe registrar.",
                    e.getMessage());
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



}
