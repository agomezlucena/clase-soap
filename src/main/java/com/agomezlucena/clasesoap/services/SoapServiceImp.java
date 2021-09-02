package com.agomezlucena.clasesoap.services;

import com.agomezlucena.clasesoap.config.SoapClient;
import lombok.RequiredArgsConstructor;
import org.oorgsprong.websamples.countryinfo.CountryCurrency;
import org.oorgsprong.websamples.countryinfo.CountryCurrencyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import static com.agomezlucena.clasesoap.config.SoapClient.AuthHeader;

@Service
@RequiredArgsConstructor
public class SoapServiceImp implements SoapService{
    @Value("${api.username}")
    private String username;
    @Value("${api.password}")
    private String password;

    private final SoapClient client;

    @Override
    public CountryCurrencyResponse getByIsoCode(String isoCode) {
        var authHeader = new AuthHeader(username,password);
        var request = new CountryCurrency();
        request.setSCountryISOCode("ES");
        return client.callWebServices(request,client.getDefaultUri(),authHeader);
    }
}
