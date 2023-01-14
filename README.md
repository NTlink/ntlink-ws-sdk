# ntlink-ws-sdk
Java web client
<div id="top"></div>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->




<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://ntlink.com.mx">
    <img src="logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">NT LINK WEB SERVICE CLIENT</h3>

  <p align="center">
    SDK Java client for NT link CFDI 4.0 web services
    <br />
    <br />
    <br />
    <a href="https://ntlink.com.mx">Documentation</a>
    ·
    <a href="https://github.com/NTlink/ntlink-ws-sdk/issues">Report Bug</a>
    ·
    <a href="https://github.com/NTlink/ntlink-ws-sdk/issues">Add feature</a>
  </p>
</div>


<!-- ABOUT THE PROJECT -->
## NT Link Web service client


Java SOAP client to consume NTLink SOAP web services

The client supports next operations:
* timbrarCfdi
* timbrarCfdiConQr
* timbrarSinSello
* timbrarSinSelloConQr
* timbraRetencion
* timbraRetenionConQr
* timbrarRetencionSinSello
* cancelarCfdi
* cancelarRetencion


<!-- GETTING STARTED -->
## Getting Started

Just clone this repository an then run 

```mvn clean install```

on the root folder

### Prerequisites

In order to compile this project you will need
* java 8 or higher
* maven 3.5 or higher  

<!-- USAGE EXAMPLES -->
## Usage

To use just make a simple maven import

```
<dependency>
	<groupId>com.mx.ntlink</groupId>
	<artifactId>ntlink-ws-sdk</artifactId>
	<version>3.0.0</version>
</dependency>
```



<!-- ROADMAP -->
## Roadmap

- [x] 1.0.0 First WS client version supporting main CFDI V4.0 ws features
- [x] 1.1.0 Adding Stamp Helper to generate stamp in XML before to send into CFDI 4.0 web service
- [x] 2.0.0 Adding CFDI models and refactor generated classes package
- [x] 2.0.1 Adding translator class with customizations
- [x] 2.0.2 Removing lombok dependency
- [x] 2.0.3 Adding error handling on stamp CFDI and retention methods
- [x] 2.0.4 Adding nomina12.xsd for class autogeneration via JaxB
- [x] 2.0.4 Format  Pom and fixing import
- [x] 2.0.5 Correction of type XMLGregorian to string of for nomina12.xsd
- [x] 2.0.6 Including nomina namespace
- [x] 2.0.7 Include company registration, deletion and status CFDI  method calls
- [x] 2.0.8 Pagos version 20
- [x] 2.0.9 Consulta saldo method
- [x] 2.0.10 Adding logback logger
- [x] 2.0.11 Add missing WS Client Methods (CancelaCfdiOtrosPACs, CancelaCfdiRequest, ConsultaAceptacionRechazo, ConsultaCFDIRelacionados, ObtenerDatosCliente, ObtenerEmpresas, ObtenerStatusHash, ObtenerStatusUuid, ProcesarRespuestaAceptacionRechazo)
- [x] 2.0.12 Adding TimbreFiscalTransformer
- [x] 2.0.13 Adding retenciones20.xsd generated for class autogeneration via JaxB
- [x] 2.0.14 Including Retenciones,Nomina and Pagos transformer methods
- [x] 3.0.0 SDK cleanup


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<!-- CONTACT -->
## Contact

Hugo Avelino - [Github](https://github.com/havelino) - hugo.avelino@ntlink.com.mx


<p align="right">(<a href="#top">back to top</a>)</p>