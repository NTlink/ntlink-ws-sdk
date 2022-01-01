package com.mx.ntlink.error;

public class SoapClientException extends Exception {

  public SoapClientException(String message) {
    super(message);
  }

  public SoapClientException(String message, Throwable error) {
    super(message, error);
  }
}
