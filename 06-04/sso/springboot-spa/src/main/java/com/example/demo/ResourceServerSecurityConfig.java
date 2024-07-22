package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // リソースサーバーのパスは認証必須（Bearer認証）
                        .requestMatchers("/spa-resource-server/user").authenticated()
                        // SPAのパス（/spa-client-app/*）はSpring Securityとしてはすべて許可（JavaScriptアダプターで認証がチェックされるため）
                        .requestMatchers("/spa-client-app/**").permitAll()
                )
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }


}