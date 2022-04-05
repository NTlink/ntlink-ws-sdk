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






    }





















































