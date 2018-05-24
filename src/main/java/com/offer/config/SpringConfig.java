package main.java.com.offer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "main.java.com.offer") // it should be base package for scan all the beans
public class SpringConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver obj = new InternalResourceViewResolver();
        obj.setPrefix("/");
        obj.setSuffix(".jsp");
        return obj;
    }
}