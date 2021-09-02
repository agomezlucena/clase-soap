package com.agomezlucena.clasesoap.config;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.transport.HeadersAwareSenderWebServiceConnection;
import org.springframework.ws.transport.context.TransportContextHolder;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Base64;

public class SoapClient extends WebServiceGatewaySupport {
    public <RQ,RP> RP callWebServices(RQ request,String url){
        return (RP) getWebServiceTemplate().marshalSendAndReceive(url,request);
    }

    public <RQ,RP> RP callWebServices(RQ request, String url, AuthHeader header){
        return (RP) getWebServiceTemplate().marshalSendAndReceive(url,request,header);
    }

    public static class AuthHeader implements WebServiceMessageCallback {
        private final String usernameAndPasswordEncoded;

        public AuthHeader(String username, String password) {
            this.usernameAndPasswordEncoded = Base64.getEncoder()
                    .encodeToString(String.format("%s:%s",username,password).getBytes());
        }

        @Override
        public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
            var context = TransportContextHolder.getTransportContext();
            var connection = (HeadersAwareSenderWebServiceConnection) context.getConnection();
            connection.addRequestHeader("Authorization",String.format("Basic %s",usernameAndPasswordEncoded));
        }
    }
}
