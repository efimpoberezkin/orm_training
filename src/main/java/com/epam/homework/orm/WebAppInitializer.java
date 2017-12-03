package com.epam.homework.orm;

import com.epam.homework.orm.config.PersistenceJPAConfig;
import com.epam.homework.orm.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

//public class WebAppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) {
//
//        // Load Spring web application configuration
//        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
//        ac.register(WebConfig.class);
//        ac.register(PersistenceJPAConfig.class);
//        ac.refresh();
//
//        // Create and register the DispatcherServlet
//        DispatcherServlet servlet = new DispatcherServlet(ac);
//        ServletRegistration.Dynamic registration = servletContext.addServlet("orm", servlet);
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/rest/*");
//    }
//}

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebConfig.class, PersistenceJPAConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/rest/*" };
    }
}
