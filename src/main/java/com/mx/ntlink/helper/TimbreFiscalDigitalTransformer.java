package com.mx.ntlink.helper;

import com.mx.ntlink.error.TimbreFiscalDigitalException;
import com.mx.ntlink.models.generated.TimbreFiscalDigital;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TimbreFiscalDigitalTransformer {
  public static TimbreFiscalDigital xmlToCfdiModel(InputStream xmlStream)
      throws TimbreFiscalDigitalException {
    try {
      JAXBContext jc = JAXBContext.newInstance(TimbreFiscalDigital.class);
      Unmarshaller um = jc.createUnmarshaller();
      return (TimbreFiscalDigital) um.unmarshal(xmlStream);
    } catch (JAXBException ex) {
      throw new TimbreFiscalDigitalException(ex.getMessage());
    }
  }

  public static TimbreFiscalDigital xmlToCfdiModel(String xml) throws TimbreFiscalDigitalException {
    return xmlToCfdiModel(new ByteArrayInputStream(xml.getBytes()));
  }
}
