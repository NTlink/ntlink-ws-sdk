package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.BajaEmpresa;
import com.mx.ntlink.models.generated.BajaEmpresaResponse;
import com.mx.ntlink.models.generated.CancelaCfdi;
import com.mx.ntlink.models.generated.CancelaCfdiResponse;
import com.mx.ntlink.models.generated.CancelaRetencion;
import com.mx.ntlink.models.generated.CancelaRetencionResponse;
import com.mx.ntlink.models.generated.ConsultaEstatusCFDI;
import com.mx.ntlink.models.generated.ConsultaEstatusCFDIResponse;
import com.mx.ntlink.models.generated.RegistraEmpresa;
import com.mx.ntlink.models.generated.RegistraEmpresaResponse;
import com.mx.ntlink.models.generated.TimbraCfdi;
import com.mx.ntlink.models.generated.TimbraCfdiQr;
import com.mx.ntlink.models.generated.TimbraCfdiQrResponse;
import com.mx.ntlink.models.generated.TimbraCfdiQrSinSello;
import com.mx.ntlink.models.generated.TimbraCfdiQrSinSelloResponse;
import com.mx.ntlink.models.generated.TimbraCfdiResponse;
import com.mx.ntlink.models.generated.TimbraCfdiSinSello;
import com.mx.ntlink.models.generated.TimbraCfdiSinSelloResponse;
import com.mx.ntlink.models.generated.TimbraRetencion;
import com.mx.ntlink.models.generated.TimbraRetencionQr;
import com.mx.ntlink.models.generated.TimbraRetencionQrResponse;
import com.mx.ntlink.models.generated.TimbraRetencionResponse;
import com.mx.ntlink.models.generated.TimbraRetencionSinSello;
import com.mx.ntlink.models.generated.TimbraRetencionSinSelloResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/** @author Ralph */
public class NtLinkClientImpl extends AbstractSoapClient implements NtLinkClient {

  private static final String I_SERVICIO_TIMBRADO = "/IServicioTimbrado";

  private static final String NTLINK_NAMESAPCE = "https://ntlink.com.mx/IServicioTimbrado";

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

  private SOAPMessage replaceNamespaces(SOAPMessage message) throws SoapClientException {
    try {
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      message.writeTo(bos);
      String stringResponse = bos.toString("UTF-8");
      stringResponse = stringResponse.replaceAll(CERTIFICADOR_NAMESPACE, NTLINK_NAMESAPCE);
      stringResponse = stringResponse.replaceAll(CERTIFICADOR_BUSINESS_NAMESPACE, NTLINK_NAMESAPCE);
      InputStream is = new ByteArrayInputStream(stringResponse.getBytes());
      return MessageFactory.newInstance().createMessage(message.getMimeHeaders(), is);
    } catch (IOException | SOAPException e) {
      throw new SoapClientException("Error replacing namespaces" + e.getMessage());
    }
  }
}
