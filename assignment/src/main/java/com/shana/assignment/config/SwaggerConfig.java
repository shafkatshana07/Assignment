
package com.shana.assignment.config;

import javax.servlet.ServletContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	  @Bean
	    public Docket api(ServletContext servletContext) {
	        return new Docket(DocumentationType.SWAGGER_2)
	            .useDefaultResponseMessages(false)
	                .pathProvider(new RelativePathProvider(servletContext) {
	                    @Override
	                    public String getApplicationBasePath() {
	                        return "";
	                    }
	                })
	            .groupName("ShanaSwagger")
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.dish.es.AssignmemtSwagger"))
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiInfo());
	    }
	  
	  private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	            .title("assignment")
	            .license("Internal Use Only")
	            .build();
	    }
	}


