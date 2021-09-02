package com.agomezlucena.clasesoap;

import com.agomezlucena.clasesoap.config.SoapClient;
import com.agomezlucena.clasesoap.services.SoapService;
import org.oorgsprong.websamples.countryinfo.CountryCurrency;
import org.oorgsprong.websamples.countryinfo.CountryCurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClaseSoapApplication implements CommandLineRunner {
    @Autowired
    private SoapClient client;

    @Autowired
    private SoapService soapService;
    public static void main(String[] args) {
        SpringApplication.run(ClaseSoapApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var request = new CountryCurrency();
        request.setSCountryISOCode("ES");
        CountryCurrencyResponse response = soapService.getByIsoCode("ES"); /*= client.callWebServices(request,client.getDefaultUri());
        System.out.println(response.getCountryCurrencyResult().getSName()+" "+response.getCountryCurrencyResult().getSISOCode());
        response = soapService.getByIsoCode("ES");*/

        System.out.println(response.getCountryCurrencyResult().getSName()+" "+response.getCountryCurrencyResult().getSISOCode());
    }
}
