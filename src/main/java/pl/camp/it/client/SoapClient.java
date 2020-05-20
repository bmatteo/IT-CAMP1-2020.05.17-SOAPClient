package pl.camp.it.client;

import countries.Country;
import countries.GetCountryRequest;
import countries.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapClient extends WebServiceGatewaySupport {

    public Country getCountry(String country) {
        GetCountryRequest getCountryRequest = new GetCountryRequest();
        getCountryRequest.setName(country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(getCountryRequest);

        return response.getCountry();
    }
}
