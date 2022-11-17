package com.mx.ntlink.helper;

import com.mx.ntlink.models.generated.TimbreFiscalDigital;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TimbreFiscalDigitalTransformer {
  public static TimbreFiscalDigital xmlToCfdiModel(InputStream xmlStream) throws JAXBException {
    JAXBContext jc = JAXBContext.newInstance(TimbreFiscalDigital.class);
    Unmarshaller um = jc.createUnmarshaller();
    return (TimbreFiscalDigital) um.unmarshal(xmlStream);
  }

  public static TimbreFiscalDigital xmlToCfdiModel(String xml) throws JAXBException {
    return xmlToCfdiModel(new ByteArrayInputStream(xml.getBytes()));
  }
}
