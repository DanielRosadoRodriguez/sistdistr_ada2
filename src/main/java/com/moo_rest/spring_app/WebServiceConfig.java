package com.moo_rest.spring_app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.moo_rest.spring_app.controllers.UserController;

import org.apache.catalina.startup.UserConfig;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{

    private static final String NAMESPACE_URI = "http://www.moo_rest.com/spring_app/users"; // Define el namespace de tu servicio SOAP

    // Registra el MessageDispatcherServlet para recibir las solicitudes SOAP en "/ws/*"
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean(name = "users")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UserPort");
        wsdl11Definition.setLocationUri("/ws"); // debe coincidir con tu Servlet
        wsdl11Definition.setTargetNamespace("http://www.moo_rest.com/spring_app/users");
        wsdl11Definition.setSchema(userSchema);
        return wsdl11Definition;
    }

    // Este Bean es para exponer el servicio SOAP para User. Aquí puedes crear un Endpoint para CRUD de usuarios.
    @Bean
    public XsdSchema userSchema() {
        return new SimpleXsdSchema(new ClassPathResource("client.xsd"));
    }

}

