package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/** @author Ralph */
public class NtLinkClientImpl extends AbstractSoapClient implements NtLinkClient {

  private static final String I_SERVICIO_TIMBRADO = "/IServicioTimbrado";

  private static final String NTLINK_NAMESAPCE = "https://ntlink.com.mx/IServicioTimbrado";

  private static final String NTLINK_BUSINESS_NAMESPACE =
      "https://ntlink.com.mx/IServicioTimbrado.Business";

  private static final String CERTIFICADOR_NAMESPACE =
      "http://schemas.datacontract.org/2004/07/CertificadorWs";
  private static final String CERTIFICADOR_BUSINESS_NAMESPACE =
      "http://schemas.datacontract.org/2004/07/CertificadorWs.Business";

  private static final String SERVICIO_LOCAL_CONTRACT_NAMESPACE =
      "http://schemas.datacontract.org/2004/07/ServicioLocalContract";

  private static final String MICROSOFT_ARRAYS_NAMESPACE =
      "http://schemas.microsoft.com/2003/10/Serialization/Arrays";

  public NtLinkClientImpl(URL wsEndpoint) {
    super(wsEndpoint, NTLINK_NAMESAPCE.concat(I_SERVICIO_TIMBRADO));
  }

  @Override
  public ProcesarRespuestaAceptacionRechazoResponse procesarRespuestaAceptacionRechazo(
      ProcesarRespuestaAceptacionRechazo request) throws SoapClientException {
    SOAPMessage response =
        replaceNamespaces(sendRequest(request, ProcesarRespuestaAceptacionRechazo.class));
    return parseResponse(response, ProcesarRespuestaAceptacionRechazoResponse.class);
  }

  @Override
  public ObtenerEmpresasResponse obtenerEmpresas(ObtenerEmpresas request)
      throws SoapClientException {
    SOAPMessage response = replaceNamespaces(sendRequest(request, ObtenerEmpresas.class));
    return parseResponse(response, ObtenerEmpresasResponse.class);
  }

  @Override
  public ObtenerDatosClienteResponse obtenerDatosCliente(ObtenerDatosCliente request)
      throws SoapClientException {
    SOAPMessage response = replaceNamespaces(sendRequest(request, ObtenerDatosCliente.class));
    return parseResponse(response, ObtenerDatosClienteResponse.class);
  }

  @Override
  public CancelaCfdiOtrosPACsResponse cancelaCfdiOtrosPACs(CancelaCfdiOtrosPACs request)
      throws SoapClientException {
    SOAPMessage response = sendRequest(request, CancelaCfdiOtrosPACs.class);
    return parseResponse(response, CancelaCfdiOtrosPACsResponse.class);
  }

  @Override
  public CancelaCfdiRequestResponse cancelaCfdiRequest(CancelaCfdiRequest request)
      throws SoapClientException {
    request.setRequestCancelacion("<![CDATA[" + request.getRequestCancelacion() + "]]>");
    SOAPMessage response = replaceNamespaces(sendRequest(request, CancelaCfdiRequest.class));
    return parseResponse(response, CancelaCfdiRequestResponse.class);
  }

  @Override
  public ConsultaAceptacionRechazoResponse consultaAceptacionRechazo(
      ConsultaAceptacionRechazo request) throws SoapClientException {
    SOAPMessage response = sendRequest(request, ConsultaAceptacionRechazo.class);
    return parseResponse(response, ConsultaAceptacionRechazoResponse.class);
  }

  @Override
  public ConsultaCFDIRelacionadosResponse consultaCfdiRelacionados(ConsultaCFDIRelacionados request)
      throws SoapClientException {
    SOAPMessage response = sendRequest(request, ConsultaCFDIRelacionados.class);
    return parseResponse(response, ConsultaCFDIRelacionadosResponse.class);
  }

  @Override
  public ObtenerStatusHashResponse obtenerStatusHash(ObtenerStatusHash request)
      throws SoapClientException {
    SOAPMessage response = replaceNamespaces(sendRequest(request, ObtenerStatusHash.class));
    return parseResponse(response, ObtenerStatusHashResponse.class);
  }

  @Override
  public ObtenerStatusUuidResponse obtenerStatusUuid(ObtenerStatusUuid request)
      throws SoapClientException {
    SOAPMessage response = replaceNamespaces(sendRequest(request, ObtenerStatusUuid.class));
    return parseResponse(response, ObtenerStatusUuidResponse.class);
  }

  @Override
  public ConsultaSaldoResponse consultaSaldo(ConsultaSaldo request) throws SoapClientException {
    SOAPMessage response = sendRequest(request, ConsultaSaldo.class);
    return parseResponse(response, ConsultaSaldoResponse.class);
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
    TimbraCfdiResponse result = parseResponse(response, TimbraCfdiResponse.class);
    if (result.getTimbraCfdiResult().contains("UUID")) {
      return result;
    } else {
      throw new SoapClientException(result.getTimbraCfdiResult());
    }
  }

  @Override
  public TimbraCfdiQrResponse timbrarCfdiConQr(TimbraCfdiQr request) throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = replaceNamespaces(sendRequest(request, TimbraCfdiQr.class));
    TimbraCfdiQrResponse result = parseResponse(response, TimbraCfdiQrResponse.class);
    if (result.getTimbraCfdiQrResult().getDescripcionError().isEmpty()) {
      return result;
    } else {
      throw new SoapClientException(result.getTimbraCfdiQrResult().getDescripcionError());
    }
  }

  @Override
  public TimbraCfdiSinSelloResponse timbrarSinSello(TimbraCfdiSinSello request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = sendRequest(request, TimbraCfdiSinSello.class);
    TimbraCfdiSinSelloResponse result = parseResponse(response, TimbraCfdiSinSelloResponse.class);
    if (result.getTimbraCfdiSinSelloResult().contains("UUID")) {
      return result;
    } else {
      throw new SoapClientException(result.getTimbraCfdiSinSelloResult());
    }
  }

  @Override
  public TimbraCfdiQrSinSelloResponse timbrarSinSelloConQr(TimbraCfdiQrSinSello request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = replaceNamespaces(sendRequest(request, TimbraCfdiQrSinSello.class));
    TimbraCfdiQrSinSelloResponse result =
        parseResponse(response, TimbraCfdiQrSinSelloResponse.class);
    if (result.getTimbraCfdiQrSinSelloResult().getDescripcionError().isEmpty()) {
      return result;
    } else {
      throw new SoapClientException(result.getTimbraCfdiQrSinSelloResult().getDescripcionError());
    }
  }

  @Override
  public TimbraRetencionResponse timbraRetencion(TimbraRetencion request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = sendRequest(request, TimbraRetencion.class);
    TimbraRetencionResponse result = parseResponse(response, TimbraRetencionResponse.class);
    if (result.getTimbraRetencionResult().contains("UUID")) {
      return result;
    } else {
      throw new SoapClientException(result.getTimbraRetencionResult());
    }
  }

  @Override
  public TimbraRetencionQrResponse timbraRetenionConQr(TimbraRetencionQr request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = replaceNamespaces(sendRequest(request, TimbraRetencionQr.class));
    TimbraRetencionQrResponse result = parseResponse(response, TimbraRetencionQrResponse.class);
    if (result.getTimbraRetencionQrResult().getDescripcionError().isEmpty()) {
      return result;
    } else {
      throw new SoapClientException(result.getTimbraRetencionQrResult().getDescripcionError());
    }
  }

  @Override
  public TimbraRetencionSinSelloResponse timbrarRetencionSinSello(TimbraRetencionSinSello request)
      throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = sendRequest(request, TimbraRetencionSinSello.class);
    TimbraRetencionSinSelloResponse result =
        parseResponse(response, TimbraRetencionSinSelloResponse.class);
    if (result.getTimbraRetencionSinSelloResult().contains("UUID")) {
      return result;
    } else {
      throw new SoapClientException(result.getTimbraRetencionSinSelloResult());
    }
  }

  @Override
  public RegistraEmpresaResponse registraEmpresa(RegistraEmpresa registro)
      throws SoapClientException {
    SOAPMessage response = sendRequest(registro, RegistraEmpresa.class);
    return parseResponse(response, RegistraEmpresaResponse.class);
  }

  @Override
  public BajaEmpresaResponse bajaEmpresa(BajaEmpresa baja) throws SoapClientException {
    SOAPMessage response = sendRequest(baja, BajaEmpresa.class);
    return parseResponse(response, BajaEmpresaResponse.class);
  }

  @Override
  public ConsultaEstatusCFDIResponse estatusCfdi(ConsultaEstatusCFDI consulta)
      throws SoapClientException {
    SOAPMessage response = sendRequest(consulta, ConsultaEstatusCFDI.class);
    return parseResponse(response, ConsultaEstatusCFDIResponse.class);
  }

  @Override
  public ValidarResponse validarCfdi(Validar request) throws SoapClientException {
    request.setComprobante("<![CDATA[" + request.getComprobante() + "]]>");
    SOAPMessage response = replaceNamespaces(sendRequest(request, Validar.class));
    return parseResponse(response, ValidarResponse.class);
  }

  @Override
  public ConsultaListaNegraResponse consultaListaNegra(ConsultaListaNegra request)
      throws SoapClientException {
    SOAPMessage response = replaceNamespaces(sendRequest(request, ConsultaListaNegra.class));
    return parseResponse(response, ConsultaListaNegraResponse.class);
  }

  private SOAPMessage replaceNamespaces(SOAPMessage message) throws SoapClientException {
    try {
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      message.writeTo(bos);
      String stringResponse = bos.toString(StandardCharsets.UTF_8);
      stringResponse = stringResponse.replaceAll(CERTIFICADOR_NAMESPACE, NTLINK_NAMESAPCE);
      stringResponse = stringResponse.replaceAll(CERTIFICADOR_BUSINESS_NAMESPACE, NTLINK_NAMESAPCE);
      stringResponse =
          stringResponse.replaceAll(SERVICIO_LOCAL_CONTRACT_NAMESPACE, NTLINK_NAMESAPCE);
      stringResponse = stringResponse.replaceAll(MICROSOFT_ARRAYS_NAMESPACE, NTLINK_NAMESAPCE);
      stringResponse = stringResponse.replaceAll(NTLINK_BUSINESS_NAMESPACE, NTLINK_NAMESAPCE);

      InputStream is = new ByteArrayInputStream(stringResponse.getBytes());
      return MessageFactory.newInstance().createMessage(message.getMimeHeaders(), is);
    } catch (IOException | SOAPException e) {
      throw new SoapClientException("Error replacing namespaces" + e.getMessage());
    }
  }
}
