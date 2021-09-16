package com.liuwei.learn.config;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @author tujingwei
 */
@Configuration
public class Swagger2Configuration {
    @Value("${spring.application.name}")
    private String appname;

    @Value("${springfox.documentation.swagger-ui.enabled:false}")
    private boolean enabled;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enabled)
                .apiInfo(new ApiInfoBuilder()
                        .title(appname)
                        .version("v3")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private SecurityScheme securityScheme() {
        return new ApiKey("AUTH", "user_id", In.HEADER.toValue());
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("AUTH", new AuthorizationScope[0])))
                .build();
    }
}
