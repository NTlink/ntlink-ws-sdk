package com.mx.ntlink.helper;

import static com.mx.ntlink.util.CfdiConstants.PAGOS_NS;
import static com.mx.ntlink.util.CfdiConstants.SAT_NS_40;
import static com.mx.ntlink.util.CfdiConstants.SAT_XSD_40;
import static com.mx.ntlink.util.CfdiConstants.TFD_NS;
import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;
import static javax.xml.bind.Marshaller.JAXB_SCHEMA_LOCATION;

import com.mx.ntlink.models.generated.Comprobante;
import com.mx.ntlink.util.CfdiNamespaceMapper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class CfdiTransformer {

  public static String cfdiMoldelToString(Comprobante cfdi) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new CfdiNamespaceMapper());
    jaxbMarshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
    jaxbMarshaller.setProperty(
        JAXB_SCHEMA_LOCATION,
        String.format("%s %s %s %s", SAT_NS_40, SAT_XSD_40, PAGOS_NS, TFD_NS));
    StringWriter sw = new StringWriter();
    jaxbMarshaller.marshal(cfdi, sw);
    return sw.toString();
  }

  public static Comprobante xmlToCfdiModel(InputStream xmlStream) throws JAXBException {
    JAXBContext jc = JAXBContext.newInstance(Comprobante.class);
    Unmarshaller um = jc.createUnmarshaller();
    return (Comprobante) um.unmarshal(xmlStream);
  }

  public static Comprobante xmlToCfdiModel(String xml) throws JAXBException {
    return xmlToCfdiModel(new ByteArrayInputStream(xml.getBytes()));
  }
}
