package com.sumer.labs.apigateway.configuration;

import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProxyApi {

    private final ZuulProperties zuulProperties;

    public ProxyApi(ZuulProperties zuulProperties){
        this.zuulProperties = zuulProperties;
    }


    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider (){
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>();
            zuulProperties.getRoutes()
                    .values()
                    .forEach(route -> resources.add(createSwaggerResourceRoute(route)));
            return resources;
        };
    }

    private SwaggerResource createSwaggerResourceRoute(ZuulProperties.ZuulRoute route){
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(route.getServiceId());
        swaggerResource.setLocation("/" + route.getId() + "/v2/api-docs");
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }


}
