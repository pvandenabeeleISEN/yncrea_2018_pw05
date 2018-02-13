package yncrea.pw05.client.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yncrea.pw05.contract.facade.StudentWS;

@Configuration
public class AppConfig {

    @Bean
    public StudentWS studentWS() {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setAddress("http://localhost:8080/services/student");
        factoryBean.setServiceClass(StudentWS.class);
        return (StudentWS) factoryBean.create();
    }
}
