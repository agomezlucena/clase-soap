package com.agomezlucena.clasesoap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
    @Value("${wsld.endpoint}")
    private String defaultUrl;
    @Bean
    public Jaxb2Marshaller marshaller(){
        var marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.oorgsprong.websamples.countryinfo");
        return marshaller;
    }
    @Bean
    public SoapClient soapClient(Jaxb2Marshaller marshaller){
        var client = new SoapClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setDefaultUri(defaultUrl);
        return client;
    }
}
