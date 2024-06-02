package sample.resourceserver;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(prefix = "resourceserver.config")
public class ResourceServerConfiguration {
    private String authserverUrl;
    private String introspectionEndpoint;
    private String clientId;
    private String clientSecret;

    public String getAuthserverUrl() {
        return authserverUrl;
    }

    public void setAuthserverUrl(String value) {
        authserverUrl = value;
    }

    public String getIntrospectionEndpoint() {
        return introspectionEndpoint;
    }

    public void setIntrospectionEndpoint(String introspectionEndpoint) {
        this.introspectionEndpoint = introspectionEndpoint;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String value) {
        clientId = value;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder RestTemplateBuilder = new RestTemplateBuilder();
        return RestTemplateBuilder.build();
    }
}