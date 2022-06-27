package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.BajaEmpresa;
import com.mx.ntlink.models.generated.BajaEmpresaResponse;
import com.mx.ntlink.models.generated.CancelaCfdi;
import com.mx.ntlink.models.generated.CancelaCfdiOtrosPACs;
import com.mx.ntlink.models.generated.CancelaCfdiOtrosPACsResponse;
import com.mx.ntlink.models.generated.CancelaCfdiRequest;
import com.mx.ntlink.models.generated.CancelaCfdiRequestResponse;
import com.mx.ntlink.models.generated.CancelaCfdiResponse;
import com.mx.ntlink.models.generated.CancelaRetencion;
import com.mx.ntlink.models.generated.CancelaRetencionResponse;
import com.mx.ntlink.models.generated.ConsultaAceptacionRechazo;
import com.mx.ntlink.models.generated.ConsultaAceptacionRechazoResponse;
import com.mx.ntlink.models.generated.ConsultaCFDIRelacionados;
import com.mx.ntlink.models.generated.ConsultaCFDIRelacionadosResponse;
import com.mx.ntlink.models.generated.ConsultaEstatusCFDI;
import com.mx.ntlink.models.generated.ConsultaEstatusCFDIResponse;
import com.mx.ntlink.models.generated.ConsultaSaldo;
import com.mx.ntlink.models.generated.ConsultaSaldoResponse;
import com.mx.ntlink.models.generated.ObtenerDatosCliente;
import com.mx.ntlink.models.generated.ObtenerDatosClienteResponse;
import com.mx.ntlink.models.generated.ObtenerEmpresas;
import com.mx.ntlink.models.generated.ObtenerEmpresasResponse;
import com.mx.ntlink.models.generated.ObtenerStatusHash;
import com.mx.ntlink.models.generated.ObtenerStatusHashResponse;
import com.mx.ntlink.models.generated.ObtenerStatusUuid;
import com.mx.ntlink.models.generated.ObtenerStatusUuidResponse;
import com.mx.ntlink.models.generated.ProcesarRespuestaAceptacionRechazo;
import com.mx.ntlink.models.generated.ProcesarRespuestaAceptacionRechazoResponse;
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

/** @author Ralph */
public interface NtLinkClient {
  ProcesarRespuestaAceptacionRechazoResponse procesarRespuestaAceptacionRechazo(
      ProcesarRespuestaAceptacionRechazo request) throws SoapClientException;

  ObtenerEmpresasResponse obtenerEmpresas(ObtenerEmpresas request) throws SoapClientException;

  ObtenerDatosClienteResponse obtenerDatosCliente(ObtenerDatosCliente request)
      throws SoapClientException;

  CancelaCfdiOtrosPACsResponse cancelaCfdiOtrosPACs(CancelaCfdiOtrosPACs request)
      throws SoapClientException;

  CancelaCfdiRequestResponse cancelaCfdiRequest(CancelaCfdiRequest request)
      throws SoapClientException;

  ConsultaAceptacionRechazoResponse consultaAceptacionRechazo(ConsultaAceptacionRechazo request)
      throws SoapClientException;

  ConsultaCFDIRelacionadosResponse consultaCfdiRelacionados(ConsultaCFDIRelacionados request)
      throws SoapClientException;

  ObtenerStatusHashResponse obtenerStatusHash(ObtenerStatusHash request) throws SoapClientException;

  ObtenerStatusUuidResponse obtenerStatusUuid(ObtenerStatusUuid request) throws SoapClientException;

  ConsultaSaldoResponse consultaSaldo(ConsultaSaldo request) throws SoapClientException;

  CancelaCfdiResponse cancelarCfdi(CancelaCfdi cancellation) throws SoapClientException;

  CancelaRetencionResponse cancelarRetencion(CancelaRetencion cancellation)
      throws SoapClientException;

  TimbraCfdiResponse timbrarCfdi(TimbraCfdi cfdi) throws SoapClientException;

  TimbraCfdiQrResponse timbrarCfdiConQr(TimbraCfdiQr cfdi) throws SoapClientException;

  TimbraCfdiSinSelloResponse timbrarSinSello(TimbraCfdiSinSello cfdiSinSello)
      throws SoapClientException;

  TimbraCfdiQrSinSelloResponse timbrarSinSelloConQr(TimbraCfdiQrSinSello cfdiQrSinSello)
      throws SoapClientException;

  TimbraRetencionResponse timbraRetencion(TimbraRetencion retencion) throws SoapClientException;

  TimbraRetencionQrResponse timbraRetenionConQr(TimbraRetencionQr retencion)
      throws SoapClientException;

  TimbraRetencionSinSelloResponse timbrarRetencionSinSello(
      TimbraRetencionSinSello retencionSinSello) throws SoapClientException;

  RegistraEmpresaResponse registraEmpresa(RegistraEmpresa registro) throws SoapClientException;

  BajaEmpresaResponse bajaEmpresa(BajaEmpresa baja) throws SoapClientException;

  ConsultaEstatusCFDIResponse estatusCfdi(ConsultaEstatusCFDI consulta) throws SoapClientException;
}
