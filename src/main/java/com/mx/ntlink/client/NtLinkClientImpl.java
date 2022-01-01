/** */
package com.mx.ntlink.client;

import com.mx.ntlink.client.generated.*;
import com.mx.ntlink.error.SoapClientException;
import javax.xml.soap.SOAPMessage;

/** @author Ralph */
public class NtLinkClientImpl extends AbstractSoapClient implements NtLinkClient {

  private static final String NTLINK_NAMESAPCE =
      "https://ntlink.com.mx/IServicioTimbrado/IServicioTimbrado";

  public NtLinkClientImpl(String wsUrl) {
    super(wsUrl, NTLINK_NAMESAPCE);
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
    SOAPMessage response = sendRequest(request, TimbraCfdiQr.class);
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
    SOAPMessage response = sendRequest(request, TimbraCfdiQrSinSello.class);
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
  public TimbraRetencionQr timbraRetenionConQr(TimbraRetencionQr request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = sendRequest(request, TimbraRetencionQr.class);
    return parseResponse(response, TimbraRetencionQr.class);
  }

  @Override
  public TimbraRetencionSinSelloResponse timbrarRetencionSinSello(TimbraRetencionSinSello request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = sendRequest(request, TimbraRetencionSinSello.class);
    return parseResponse(response, TimbraRetencionSinSelloResponse.class);
  }
}
