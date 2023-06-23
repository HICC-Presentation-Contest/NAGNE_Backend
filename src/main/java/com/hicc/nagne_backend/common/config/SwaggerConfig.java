package com.hicc.nagne_backend.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Nagne API",
                description = "Nagne API 문서입니다.",
                version = "v1"),
        servers = {
                @Server(url = "http://3.37.189.80", description = "운영서버"),
                @Server(url = "http://localhost:8080", description = "로컬서버")
        }

)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi tripOpenApi() {
        String[] paths = {"/trip/**"};
        return GroupedOpenApi.builder()
                .group("Trip API")
                .pathsToMatch(paths)
                .addOpenApiCustomiser(buildSecurityOpenApi())
                .build();
    }

    @Bean
    public GroupedOpenApi userOpenApi() {
        String[] paths = {"/user/**"};
        return GroupedOpenApi.builder()
                .group("User API")
                .pathsToMatch(paths)
                .addOpenApiCustomiser(buildSecurityOpenApi())
                .build();
    }

    @Bean
    public GroupedOpenApi bookmarkOpenApi() {
        String[] paths = {"/bookmark/**"};
        return GroupedOpenApi.builder()
                .group("Bookmark API")
                .pathsToMatch(paths)
                .addOpenApiCustomiser(buildSecurityOpenApi())
                .build();
    }

    @Bean
    public GroupedOpenApi followOpenApi() {
        String[] paths = {"/follow/**"};
        return GroupedOpenApi.builder()
                .group("Follow API")
                .pathsToMatch(paths)
                .addOpenApiCustomiser(buildSecurityOpenApi())
                .build();
    }

    @Bean
    public GroupedOpenApi reviewOpenApi() {
        String[] paths = {"/login/**"};
        return GroupedOpenApi.builder()
                .group("Auth API")
                .pathsToMatch(paths)
                .addOpenApiCustomiser(buildSecurityOpenApi())
                .build();
    }

    public OpenApiCustomiser buildSecurityOpenApi() {
        // jwt token 을 한번 설정하면 header 에 값을 넣어주는 코드
        return OpenApi -> OpenApi.addSecurityItem(new SecurityRequirement().addList("jwt token"))
                .getComponents().addSecuritySchemes("jwt token", new SecurityScheme()
                        .name("Authorization")
                        .type(SecurityScheme.Type.HTTP)
                        .in(SecurityScheme.In.HEADER)
                        .bearerFormat("JWT")
                        .scheme("Bearer"));
    }
}
