package yncrea.pw05.web;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import yncrea.pw05.core.config.AppConfig;
import yncrea.pw05.core.config.DBConfig;
import yncrea.pw05.web.config.WSConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class, DBConfig.class, WSConfig.class };
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }


    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        ServletRegistration.Dynamic cxfServlet = servletContext.addServlet("cxfServlet", new CXFServlet());
        cxfServlet.setLoadOnStartup(1);
        cxfServlet.addMapping("/services/*");
    }
}
