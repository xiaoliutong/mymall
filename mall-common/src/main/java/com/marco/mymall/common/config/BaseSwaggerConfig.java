package com.marco.mymall.common.config;

import com.marco.mymall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author 刘壮壮
 * 这个是swagger基础配置类，每个模块可以通过继承这个配置类 实现swaggerProperties
 * 方法来实现swagger的配置
 *
 */
public abstract class BaseSwaggerConfig {
    /**
     * @apiNote 这里设置为抽象方法是为了让实现类，必须完成一些自定义的配置
     * @return
     */
    abstract SwaggerProperties swaggerProperties();

    @Bean
    public Docket createRestApi() {
        SwaggerProperties swaggerProperties = swaggerProperties();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                //设置标题，版本，联系方式等
                .apiInfo(apiInfo(swaggerProperties))
                .select()
                //
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getApiBasePackage()))
                .paths(PathSelectors.any())
                .build();
        //通过判断是否是安全框架来进行相应的配置
        /*if (swaggerProperties.isEnableSecurity()) {
            docket.securitySchemes(securitySchemes()).securityContexts(securityContexts());
        }*/
        return docket;
    }


    private ApiInfo apiInfo(SwaggerProperties swaggerProperties){
        return new ApiInfoBuilder().title(swaggerProperties.getTitle()).
                version(swaggerProperties.getVersion()).
                description(swaggerProperties.getDescription()).
                contact(new Contact(swaggerProperties.getContactName(),
                        swaggerProperties.getContactUrl(),swaggerProperties.getContactEmail()))
                .build();

    }
}
