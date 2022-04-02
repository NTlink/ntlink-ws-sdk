package com.mx.ntlink.util;

import static com.mx.ntlink.util.CfdiConstants.NOMINA_NS;
import static com.mx.ntlink.util.CfdiConstants.NOMINA_PREFIX;
import static com.mx.ntlink.util.CfdiConstants.PAGOS_NS;
import static com.mx.ntlink.util.CfdiConstants.PAGO_PREFIX;
import static com.mx.ntlink.util.CfdiConstants.SAT_NS_40;
import static com.mx.ntlink.util.CfdiConstants.SAT_NS_4_PREFIX;
import static com.mx.ntlink.util.CfdiConstants.TFD_NS;
import static com.mx.ntlink.util.CfdiConstants.TFD_PREFIX;
import static com.mx.ntlink.util.CfdiConstants.W3_NS;
import static com.mx.ntlink.util.CfdiConstants.XSI_PREFIX;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class CfdiNamespaceMapper extends NamespacePrefixMapper {

  @Override
  public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
    if (SAT_NS_40.equals(namespaceUri)) {
      return SAT_NS_4_PREFIX;
    } else if (W3_NS.equals(namespaceUri)) {
      return XSI_PREFIX;
    } else if (PAGOS_NS.equals(namespaceUri)) {
      return PAGO_PREFIX;
    } else if (TFD_NS.equals(namespaceUri)) {
      return TFD_PREFIX;
    } else if (NOMINA_NS.equals(namespaceUri)) {
      return NOMINA_PREFIX;
    }
    return suggestion;
  }

  @Override
  public String[] getPreDeclaredNamespaceUris() {
    return new String[] {W3_NS};
  }
}
