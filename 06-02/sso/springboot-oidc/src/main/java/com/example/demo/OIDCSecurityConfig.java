package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class OIDCSecurityConfig {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                // ①パスごとの認可条件設定
                authorizeHttpRequests(authorize -> authorize
                        // 認証に加え user ロールが必須
                        .requestMatchers("/user-area").hasRole("user")
                        // 認証に加え admin ロールが必須
                        .requestMatchers("/admin-area").hasRole("admin")
                        // 認証不要
                        .requestMatchers("/anonymous-area").permitAll())
                // ②ロールによる認可制御を利用する場合に必要
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userAuthoritiesMapper(this.userAuthoritiesMapper())))
                // ③バックチャネルログアウトを利用する場合に必要
                .oidcLogout((logout) -> logout
                        .backChannel(Customizer.withDefaults()))
                // ④RP起点ログアウトを利用する場合に必要
                .logout(logout -> logout
                        .logoutSuccessHandler(oidcLogoutSuccessHandler())
                );

        return http.build();
    }

    private GrantedAuthoritiesMapper userAuthoritiesMapper() {
        return (authorities) -> {
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();

            authorities.forEach(authority -> {
                if (OidcUserAuthority.class.isInstance(authority)) {
                    OidcUserAuthority oidcUserAuthority = (OidcUserAuthority)authority;

                    OidcIdToken idToken = oidcUserAuthority.getIdToken();

                    // IDトークンに設定された realm_access.roles を GrantedAuthority にマッピング（ROLE_ という接頭辞が必要）
                    Map<String, Object> realmAccess = idToken.getClaimAsMap("realm_access");
                    if (realmAccess != null) {
                        List roles = (List) realmAccess.get("roles");

                        roles.forEach(role -> {
                            String roleName = (String) role;
                            mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleName));
                        });
                    }
                }
            });

            return mappedAuthorities;
        };
    }

    private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
                new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);

        // ログアウト成功後の遷移先URLの指定
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/user-area");

        return oidcLogoutSuccessHandler;
    }
}