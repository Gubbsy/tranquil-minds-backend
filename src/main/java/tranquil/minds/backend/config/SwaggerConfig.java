package tranquil.minds.backend.config;

import java.sql.Timestamp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration class to create beans needed by swagger.
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApiV10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user-api-1.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("sbexampleapi.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo("v1.0.0")).directModelSubstitute(Timestamp.class, String.class);
    }

    private ApiInfo apiInfo(String version) {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("SB-Skeleton-API")
                .description("Example API showing a prefered way of using the Spring Boot framework")
                .termsOfServiceUrl("tos.url.com")
                .version(version)
                .contact(new Contact("channie","channie.co.uk","andy@channie.co.uk"))
                .license("Some Licence")
                .licenseUrl("licence.url.com")
                .build();
        return apiInfo;
    }

}