package com.mx.ntlink.client;

import com.mx.ntlink.error.SoapClientException;
import com.mx.ntlink.models.generated.*;

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

  ValidarResponse validarCfdi(Validar request) throws SoapClientException;

  ConsultaListaNegraResponse consultaListaNegra(ConsultaListaNegra request)
      throws SoapClientException;
}
