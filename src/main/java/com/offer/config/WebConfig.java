package main.java.com.offer.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
        cxt.register(SpringConfig.class);
        cxt.setServletContext(servletContext);
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("One", DispatcherServlet.class);
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("One", new DispatcherServlet(cxt));
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(cxt));
//        servlet.addMapping("*.do");
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1); // spring container will be initialized on app server (tomcat etc) startup.
    }
}
