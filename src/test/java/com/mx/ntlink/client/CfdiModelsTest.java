package com.mx.ntlink.client;

import com.mx.ntlink.models.generated.Comprobante;
import com.mx.ntlink.models.generated.TimbreFiscalDigital;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.Assert;
import org.junit.Test;

public class CfdiModelsTest {

  @Test
  public void test_unmmarshall() throws IOException, JAXBException {

    InputStream is = new FileInputStream("./src/test/resources/cfdi-samples/cfdi-con-sello.xml");

    JAXBContext jc = JAXBContext.newInstance(Comprobante.class);
    Unmarshaller um = jc.createUnmarshaller();

    Comprobante comprobante = (Comprobante) um.unmarshal(is);

    Assert.assertNotNull(comprobante);

    Assert.assertEquals("VCO1612152V1", comprobante.getEmisor().getRfc());

    Assert.assertEquals("VSE8203172I2", comprobante.getReceptor().getRfc());

    Assert.assertEquals(
        new BigDecimal("69307.52"), comprobante.getImpuestos().getTotalImpuestosTrasladados());

    Comprobante.Complemento complemento = comprobante.getComplemento();

    TimbreFiscalDigital tfd = (TimbreFiscalDigital) complemento.getAny().get(0);

    Assert.assertNotNull(tfd);

    Assert.assertEquals("4974BE6B-AE4A-4ED4-A44D-64F0980EE946", tfd.getUUID());

    Assert.assertEquals("00001000000504447535", tfd.getNoCertificadoSAT());
  }
}
