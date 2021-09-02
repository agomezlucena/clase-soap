package com.agomezlucena.clasesoap.services;

import org.oorgsprong.websamples.countryinfo.CountryCurrencyResponse;

/**
 * This class call to the SOAP API use it async
 */
public interface SoapService {
    CountryCurrencyResponse getByIsoCode(String isoCode);
}
