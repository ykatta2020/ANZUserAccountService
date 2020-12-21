package com.anz.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;


import com.google.common.base.Predicates;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Description : Swagger2UiConfiguration is used to configure Swagger
 * @author ANZ
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration extends WebMvcConfigurationSupport  
{
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .build().apiInfo(apiEndPointsInfo());
    }
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
	
    private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("ANZ User Account Service REST API")
				.description("ANZ User Account Service REST API")
				.contact(new Contact("ANZ WholeSale Account Team", "www.anz.com", ""))
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.1.0")
				.build();
	}
	 
    
}
