package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.util.CustomCharacterEscapeHandler;
import com.sun.xml.bind.marshaller.DataWriter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@Slf4j
public abstract class AbstractSoapClient {

  private final String wsUrl;
  private final String principalNamespace;

  public AbstractSoapClient(String wsUrl, String principalNamespace) {
    this.wsUrl = wsUrl;
    this.principalNamespace = principalNamespace;
  }

  public <T> SOAPMessage sendRequest(T request, Class<T> entityType) throws SoapClientException {

    SOAPConnection soapConnection = null;
    SOAPMessage soapRequest = buildSoapMessage(request, entityType);
    try {
      SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
      soapConnection = soapConnectionFactory.createConnection();

      SOAPMessage soapResponse = soapConnection.call(soapRequest, wsUrl);
      if (soapResponse.getSOAPBody().hasFault()) {
        throw new SoapClientException(
            "Request Error :".concat(soapResponse.getSOAPBody().getFault().getFaultString()));
      }
      soapConnection.close();
      return soapResponse;
    } catch (SOAPException e) {
      log.error("SOAPException in SOAPClient", e);
      throw new SoapClientException(e.getMessage());
    }
  }

  public <R> R parseResponse(SOAPMessage response, Class<R> entityType) throws SoapClientException {
    JAXBContext jc = null;
    try {
      jc = JAXBContext.newInstance(entityType);
      Unmarshaller um = jc.createUnmarshaller();
      SOAPBody soapBody = response.getSOAPBody();
      SOAPElement element = (SOAPElement) soapBody.getChildElements().next();
      JAXBElement<R> root = um.unmarshal(element, entityType);
      return root.getValue();
    } catch (JAXBException | SOAPException e) {
      log.error("Error parsing response", e);
      throw new SoapClientException(e.getMessage());
    }
  }

  public <T> SOAPMessage buildSoapMessage(T request, Class<T> entityType)
      throws SoapClientException {
    try {
      String soapAction = String.format("%s/%s", principalNamespace, entityType.getSimpleName());
      MessageFactory messageFactory = MessageFactory.newInstance();
      SOAPMessage soapRequest = messageFactory.createMessage();
      SOAPPart soapPart = soapRequest.getSOAPPart();
      SOAPEnvelope envelope = soapPart.getEnvelope();
      SOAPBody soapBody = envelope.getBody();
      soapRequest.getMimeHeaders().addHeader("SOAPAction", soapAction);
      JAXBContext jaxbContext = JAXBContext.newInstance(entityType);

      Marshaller marshaller = jaxbContext.createMarshaller();

      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      DataWriter dataWriter =
          new DataWriter(printWriter, "UTF-8", new CustomCharacterEscapeHandler());

      marshaller.marshal(request, dataWriter);
      InputStream is =
          new ByteArrayInputStream(stringWriter.toString().getBytes(StandardCharsets.UTF_8));
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      dbf.setNamespaceAware(true);
      Document document = dbf.newDocumentBuilder().parse(is);

      soapBody.addDocument(document);

      try {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        soapRequest.writeTo(bos);
        bos.toString("UTF-8");
        log.info(bos.toString());
      } catch (IOException e) {
        e.printStackTrace();
      }

      return soapRequest;
    } catch (SOAPException
        | JAXBException
        | ParserConfigurationException
        | IOException
        | SAXException e) {
      log.error("Error generating request", e);
      throw new SoapClientException(e.getMessage());
    }
  }
}
