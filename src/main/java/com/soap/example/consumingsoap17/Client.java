package com.soap.example.consumingsoap17;

import com.soap.example.consumingsoap17.wsdl.AtualizaPagamentoNaEntrega;
import com.soap.example.consumingsoap17.wsdl.AtualizaPagamentoNaEntregaResponse;
import jakarta.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class Client extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public AtualizaPagamentoNaEntregaResponse getValue(String one, String two) {

        AtualizaPagamentoNaEntrega request = new AtualizaPagamentoNaEntrega();
        request.setSenha("");
        request.setUsuario("");

        log.info("Requesting location for " + request);

        Object o = getWebServiceTemplate()
                .marshalSendAndReceive("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente", request,
                        new SoapActionCallback(
                                ""));
        JAXBElement<AtualizaPagamentoNaEntregaResponse> o1 = (JAXBElement<AtualizaPagamentoNaEntregaResponse>) o;
return        o1.getValue();
    }
}
