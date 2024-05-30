package sample.clientapp.jwt;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessToken extends JsonWebToken {
    private String scope;

    public String getScope() {
        return scope;
    }

    public void setScope(String value) {
        scope = value;
    }

    public List<String> getScopeList() {
        return Arrays.asList(scope.split(" "));
    }
}
