package com.mx.ntlink.util;

import static com.mx.ntlink.util.NamespaceConstants.CARTA_PORTE_NS;
import static com.mx.ntlink.util.NamespaceConstants.CARTA_PORTE_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.COMERCIO_EXT_NS;
import static com.mx.ntlink.util.NamespaceConstants.COMERCIO_EXT_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.NOMINA_NS;
import static com.mx.ntlink.util.NamespaceConstants.NOMINA_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.PAGOS_NS;
import static com.mx.ntlink.util.NamespaceConstants.PAGO_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.SAT_NS_40;
import static com.mx.ntlink.util.NamespaceConstants.SAT_NS_4_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.TFD_NS;
import static com.mx.ntlink.util.NamespaceConstants.TFD_PREFIX;
import static com.mx.ntlink.util.NamespaceConstants.W3_NS;
import static com.mx.ntlink.util.NamespaceConstants.XSI_PREFIX;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class CfdiNamespaceMapper extends NamespacePrefixMapper {

  @Override
  public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {

    switch (namespaceUri){
      case  SAT_NS_40:
        suggestion = SAT_NS_4_PREFIX;
        break;
      case  W3_NS:
        suggestion = XSI_PREFIX;
        break;
      case  PAGOS_NS:
        suggestion = PAGO_PREFIX;
        break;
      case  TFD_NS:
        suggestion = TFD_PREFIX;
        break;
      case  NOMINA_NS:
        suggestion = NOMINA_PREFIX;
        break;
      case  CARTA_PORTE_NS:
        suggestion = CARTA_PORTE_PREFIX;
        break;
      case  COMERCIO_EXT_NS:
        suggestion = COMERCIO_EXT_PREFIX;
        break;
    }

    return suggestion;

  }

  @Override
  public String[] getPreDeclaredNamespaceUris() {
    return new String[] {W3_NS};
  }
}
