package com.estudos.__first_steps.configs;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.estudos.__first_steps.serelization.converter.YamlJackson2HttpMessageCoverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    private static MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        // //via QUERY PARAM. http://localhost:8080/api/person/v1?mediaType=xml
        // configurer.favorParameter(true)
        //     .parameterName("mediaType")
        //     .ignoreAcceptHeader(true)
        //     .useRegisteredExtensionsOnly(false)
        //     .defaultContentType(MediaType.APPLICATION_JSON)
        //         .mediaType("json", MediaType.APPLICATION_JSON)
        //         .mediaType("xml", MediaType.APPLICATION_XML);

        // via HEADER PARAM. http://localhost:8080/api/person/v1
        configurer.favorParameter(false)
            .ignoreAcceptHeader(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageCoverter());
    }

}
