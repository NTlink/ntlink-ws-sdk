package com.mx.ntlink.util;

import static com.mx.ntlink.util.NamespaceConstants.DIVIDENDOS_NS;
import static com.mx.ntlink.util.NamespaceConstants.DIVIDENDOS_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.HIPOTECARIOS_NS;
import static com.mx.ntlink.util.NamespaceConstants.HIPOTECARIOS_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.INTERESES_NS;
import static com.mx.ntlink.util.NamespaceConstants.INTERESES_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.PLAN_RETIRO_NS;
import static com.mx.ntlink.util.NamespaceConstants.PLAN_RETIRO_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.PLATAFORMAS_TEC_NS;
import static com.mx.ntlink.util.NamespaceConstants.PLATAFORMAS_TEC_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.PREMIOS_NS;
import static com.mx.ntlink.util.NamespaceConstants.PREMIOS_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.RETENCIONES_NS;
import static com.mx.ntlink.util.NamespaceConstants.RETENCIONES_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.TFD_NS;
import static com.mx.ntlink.util.NamespaceConstants.TFD_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.W3_NS;
import static com.mx.ntlink.util.NamespaceConstants.XSI_PREFIX;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class RetencionesNamespaceMapper extends NamespacePrefixMapper {

  @Override
  public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {

    switch (namespaceUri) {
      case RETENCIONES_NS:
        suggestion = RETENCIONES_PREFIX;
        break;
      case W3_NS:
        suggestion = XSI_PREFIX;
        break;
      case TFD_NS:
        suggestion = TFD_PREFIX;
        break;
      case DIVIDENDOS_NS:
        suggestion = DIVIDENDOS_PREFIX;
        break;
      case PLAN_RETIRO_NS:
        suggestion = PLAN_RETIRO_PREFIX;
        break;
      case PLATAFORMAS_TEC_NS:
        suggestion = PLATAFORMAS_TEC_PREFIX;
        break;
      case HIPOTECARIOS_NS:
        suggestion = HIPOTECARIOS_PREFIX;
        break;
      case PREMIOS_NS:
        suggestion = PREMIOS_PREFIX;
        break;
      case INTERESES_NS:
        suggestion = INTERESES_PREFIX;
        break;
    }

    return suggestion;
  }

  @Override
  public String[] getPreDeclaredNamespaceUris() {
    return new String[] {W3_NS};
  }
}
