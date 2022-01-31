package com.mx.ntlink.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.mx.ntlink.models.generated.CMetodoPago;
import com.mx.ntlink.models.generated.CMoneda;
import com.mx.ntlink.models.generated.CTipoDeComprobante;
import com.mx.ntlink.models.generated.CTipoFactor;
import com.mx.ntlink.models.generated.CUsoCFDI;
import com.mx.ntlink.models.generated.Comprobante;
import com.mx.ntlink.models.generated.Pagos;
import com.mx.ntlink.models.generated.TimbreFiscalDigital;
import com.mx.ntlink.util.CfdiConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import javax.xml.bind.JAXBException;
import org.junit.Test;

public class CfdiTransformerTest {

  @Test
  public void xmlToCfdiModel_test() throws FileNotFoundException, JAXBException {

    InputStream is =
        new FileInputStream("./src/test/resources/cfdi-samples/complemento-con-sello.xml");

    Comprobante comprobante = CfdiTransformer.xmlToCfdiModel(is);

    assertNotNull(comprobante);

    assertEquals("VCO1612152V1", comprobante.getEmisor().getRfc());

    assertEquals("VSE8203172I2", comprobante.getReceptor().getRfc());

    assertEquals(BigDecimal.ZERO, comprobante.getTotal());

    assertEquals("84111506", comprobante.getConceptos().getConcepto().get(0).getClaveProdServ());

    Comprobante.Complemento complemento = comprobante.getComplemento();

    TimbreFiscalDigital tfd =
        (TimbreFiscalDigital)
            complemento.getAny().stream()
                .filter(c -> c instanceof TimbreFiscalDigital)
                .findAny()
                .get();

    assertNotNull(tfd);

    assertEquals("EB94379B-D031-4E14-BD33-AB4D8E630807", tfd.getUUID());

    assertEquals("00001000000504447535", tfd.getNoCertificadoSAT());

    Pagos pagos =
        (Pagos) complemento.getAny().stream().filter(c -> c instanceof Pagos).findAny().get();

    assertNotNull(pagos);

    assertEquals(new BigDecimal("116000.00"), pagos.getPago().get(0).getMonto());

    assertEquals(
        "4974BE6B-AE4A-4ED4-A44D-64F0980EE946",
        pagos.getPago().get(0).getDoctoRelacionado().getIdDocumento());

    assertEquals(1, pagos.getPago().get(0).getDoctoRelacionado().getNumParcialidad());
  }

  @Test
  public void test2() throws JAXBException {
    Comprobante comprobante = new Comprobante();

    comprobante.setVersion("4.0");
    comprobante.setExportacion("01");
    comprobante.setFecha("2022-01-25T13:13:14");
    comprobante.setDescuento(BigDecimal.ZERO);
    comprobante.setFolio("20225310101440551");
    comprobante.setFormaPago("99");
    comprobante.setLugarExpedicion("04700");
    comprobante.setMetodoPago(CMetodoPago.PUE);
    comprobante.setMoneda(CMoneda.MXN);
    comprobante.setSubTotal(BigDecimal.ONE);
    comprobante.setTipoCambio(BigDecimal.ONE);
    comprobante.setTipoDeComprobante(CTipoDeComprobante.I);
    comprobante.setTotal(new BigDecimal("1.16"));

    Comprobante.Emisor emisor = new Comprobante.Emisor();
    emisor.setNombre("UNIVERSIDAD ROBOTICA ESPAÑOLA SA DE CV");
    emisor.setRfc("URE180429TM6");
    emisor.setRegimenFiscal("601");
    comprobante.setEmisor(emisor);

    Comprobante.Receptor receptor = new Comprobante.Receptor();
    receptor.setNombre("EDGAR JOSEDUARDO RAMOS SILVEYRA");
    receptor.setDomicilioFiscalReceptor("04600");
    receptor.setRfc("RASE8810158B9");
    receptor.setUsoCFDI(CUsoCFDI.G_03);
    receptor.setRegimenFiscalReceptor("601");
    comprobante.setReceptor(receptor);

    Comprobante.Conceptos conceptos = new Comprobante.Conceptos();
    Comprobante.Conceptos.Concepto concepto = new Comprobante.Conceptos.Concepto();
    concepto.setCantidad(BigDecimal.ONE);
    concepto.setClaveProdServ("84111506");
    concepto.setClaveUnidad("H87");
    concepto.setDescripcion("timbres");
    concepto.setDescuento(BigDecimal.ZERO);
    concepto.setImporte(BigDecimal.ONE);
    concepto.setObjetoImp("02");
    concepto.setUnidad("Pieza");
    concepto.setValorUnitario(BigDecimal.ONE);

    Comprobante.Conceptos.Concepto.Impuestos impuestos =
        new Comprobante.Conceptos.Concepto.Impuestos();
    Comprobante.Conceptos.Concepto.Impuestos.Traslados traslado =
        new Comprobante.Conceptos.Concepto.Impuestos.Traslados();
    Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado iva =
        new Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado();
    iva.setImporte(new BigDecimal("0.16"));
    iva.setBase(BigDecimal.ONE);
    iva.setImpuesto("002");
    iva.setTasaOCuota(new BigDecimal("0.16"));
    iva.setTipoFactor(CTipoFactor.TASA);
    traslado.getTraslado().add(iva);
    impuestos.setTraslados(traslado);
    concepto.setImpuestos(impuestos);
    conceptos.getConcepto().add(concepto);
    comprobante.setConceptos(conceptos);

    Comprobante.Complemento complemento = new Comprobante.Complemento();
    Pagos pagos = new Pagos();
    Pagos.Pago pago = new Pagos.Pago();
    pago.setFechaPago("2022-01-24T00:00:00");
    pago.setFormaDePagoP("03");
    pago.setMonedaP(CMoneda.MXN);
    pago.setMonto(BigDecimal.ONE);
    Pagos.Pago.DoctoRelacionado relacionado = new Pagos.Pago.DoctoRelacionado();
    relacionado.setFolio("20219391201412705");
    relacionado.setIdDocumento("4974BE6B-AE4A-4ED4-A44D-64F0980EE946");
    relacionado.setImpPagado(new BigDecimal("0.5"));
    relacionado.setImpSaldoAnt(BigDecimal.ONE);
    relacionado.setNumParcialidad((short) 1);
    relacionado.setImpSaldoInsoluto(new BigDecimal("0.5"));
    relacionado.setMetodoDePagoDR(CMetodoPago.PPD);
    relacionado.setMonedaDR(CMoneda.MXN);
    relacionado.setSerie("PFP");
    pago.setDoctoRelacionado(relacionado);
    pagos.setVersion("1.0");
    pagos.getPago().add(pago);
    complemento.getAny().add(pagos);
    comprobante.setComplemento(complemento);

    String xml = CfdiTransformer.cfdiMoldelToString(comprobante);

    assertTrue(xml.contains(CfdiConstants.SAT_NS_4_PREFIX));
    assertTrue(xml.contains(CfdiConstants.PAGO_PREFIX));
    System.out.println(xml);
  }
}
