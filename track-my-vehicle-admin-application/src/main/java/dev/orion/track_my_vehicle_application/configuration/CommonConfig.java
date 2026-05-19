package dev.orion.track_my_vehicle_application.configuration;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
@ComponentScan(basePackages = {"dev.orion.commons", "dev.orion.track_my_vehicle_domain"})
public class CommonConfig {

//    @Bean
//    public StandardServletMultipartResolver multipartResolver() {
//        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
//        // This forces Spring to strictly respect the Servlet container (Tomcat) settings
//        resolver.setStrictServletCompliance(true);
//        return resolver;
//    }
//
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//
//        // Explicitly set sizes using DataSize parsing utility
//        factory.setMaxFileSize(DataSize.ofMegabytes(200));
//        factory.setMaxRequestSize(DataSize.ofMegabytes(500));
//
//        return factory.createMultipartConfig();
//    }

}
