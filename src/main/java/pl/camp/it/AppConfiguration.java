package pl.camp.it;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pl.camp.it.client.SoapClient;

@Configuration
public class AppConfiguration {

    @Bean
    public Jaxb2Marshaller countriesMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("countries");

        return marshaller;
    }

    @Bean
    public SoapClient soapClient(Jaxb2Marshaller countriesMarshaller) {
        SoapClient soapClient = new SoapClient();
        soapClient.setMarshaller(countriesMarshaller);
        soapClient.setUnmarshaller(countriesMarshaller);
        soapClient.setDefaultUri("http://localhost:8080/ws/");

        return soapClient;
    }
}
