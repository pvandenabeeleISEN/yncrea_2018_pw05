package yncrea.pw05.web.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import yncrea.pw05.contract.facade.StudentWS;

import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@Configuration
@ComponentScan(basePackages = "yncrea.pw05.web.service.impl")
@ImportResource("classpath:META-INF/cxf/cxf.xml")
public class WSConfig {

    @Inject
    private Bus bus;

    @Inject
    private StudentWS studentWS;

    @Bean
    public Endpoint endpoint(){
        final EndpointImpl endpoint = new EndpointImpl(bus, studentWS);
        endpoint.setAddress("/student");
        endpoint.publish();
        return endpoint;
    }

}
