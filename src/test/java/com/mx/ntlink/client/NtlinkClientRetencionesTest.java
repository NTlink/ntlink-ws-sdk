package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.TimbraCfdiSinSello;
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
    public void timbra_retencion_errorRETEN20101() throws IOException, SoapClientException {

        String comprobante =
                new String(Files.readAllBytes(Paths.get("./src/test/resources/retencion-samples/retencion.xml")));

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
                    "Request Error :Reten20101 - El resultado de la digestión debe ser igual al resultado de la desencripción del sello.",
                    e.getMessage());
        }
    }







}
