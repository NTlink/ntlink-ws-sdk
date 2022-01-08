/** */
package com.mx.ntlink.client;

import com.mx.ntlink.client.generated.*;
import com.mx.ntlink.error.SoapClientException;
import lombok.extern.slf4j.Slf4j;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/** @author Ralph */
@Slf4j
public class NtLinkClientImpl extends AbstractSoapClient implements NtLinkClient {

  private static  final String I_SERVICIO_TIMBRADO = "/IServicioTimbrado";

  private static final String NTLINK_NAMESAPCE =
          "https://ntlink.com.mx/IServicioTimbrado";

  private static final String CERTIFICADOR_NAMESPACE =
          "http://schemas.datacontract.org/2004/07/CertificadorWs";
  private static final String CERTIFICADOR_BUSINESS_NAMESPACE =
          "http://schemas.datacontract.org/2004/07/CertificadorWs.Business";

  public NtLinkClientImpl(String wsUrl) {
    super(wsUrl, NTLINK_NAMESAPCE.concat(I_SERVICIO_TIMBRADO));
  }

  @Override
  public CancelaCfdiResponse cancelarCfdi(CancelaCfdi request) throws SoapClientException {
    SOAPMessage response = sendRequest(request, CancelaCfdi.class);
    return parseResponse(response, CancelaCfdiResponse.class);
  }

  @Override
  public CancelaRetencionResponse cancelarRetencion(CancelaRetencion request)
      throws SoapClientException {
    SOAPMessage response = sendRequest(request, CancelaRetencion.class);
    return parseResponse(response, CancelaRetencionResponse.class);
  }

  @Override
  public TimbraCfdiResponse timbrarCfdi(TimbraCfdi request) throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = sendRequest(request, TimbraCfdi.class);
    return parseResponse(response, TimbraCfdiResponse.class);
  }

  @Override
  public TimbraCfdiQrResponse timbrarCfdiConQr(TimbraCfdiQr request) throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = replaceNamespaces(sendRequest(request, TimbraCfdiQr.class));
    return parseResponse(response, TimbraCfdiQrResponse.class);
  }

  @Override
  public TimbraCfdiSinSelloResponse timbrarSinSello(TimbraCfdiSinSello request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = sendRequest(request, TimbraCfdiSinSello.class);
    return parseResponse(response, TimbraCfdiSinSelloResponse.class);
  }

  @Override
  public TimbraCfdiQrSinSelloResponse timbrarSinSelloConQr(TimbraCfdiQrSinSello request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = replaceNamespaces(sendRequest(request, TimbraCfdiQrSinSello.class));
    return parseResponse(response, TimbraCfdiQrSinSelloResponse.class);
  }

  @Override
  public TimbraRetencionResponse timbraRetencion(TimbraRetencion request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = sendRequest(request, TimbraRetencion.class);
    return parseResponse(response, TimbraRetencionResponse.class);
  }

  @Override
  public TimbraRetencionQrResponse timbraRetenionConQr(TimbraRetencionQr request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = replaceNamespaces(sendRequest(request, TimbraRetencionQr.class));
    return parseResponse(response, TimbraRetencionQrResponse.class);
  }

  @Override
  public TimbraRetencionSinSelloResponse timbrarRetencionSinSello(TimbraRetencionSinSello request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = sendRequest(request, TimbraRetencionSinSello.class);
    return parseResponse(response, TimbraRetencionSinSelloResponse.class);
  }

  private SOAPMessage replaceNamespaces(SOAPMessage message) throws SoapClientException {
    try {
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      message.writeTo(bos);
      String stringResponse = bos.toString("UTF-8");
      stringResponse = stringResponse.replaceAll(CERTIFICADOR_NAMESPACE, NTLINK_NAMESAPCE);
      stringResponse = stringResponse.replaceAll(CERTIFICADOR_BUSINESS_NAMESPACE, NTLINK_NAMESAPCE);
      InputStream is = new ByteArrayInputStream(stringResponse.getBytes());
      log.info("Replaced response: {}", stringResponse);
      return MessageFactory.newInstance().createMessage(message.getMimeHeaders(), is);
    } catch (IOException | SOAPException e) {
      throw new SoapClientException("Error replacing namespaces" + e.getMessage());
    }
  }
}
