/** */
package com.mx.ntlink.client;

import com.mx.ntlink.client.generated.*;
import com.mx.ntlink.error.SoapClientException;

/** @author Ralph */
public interface NtLinkClient {

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
}
