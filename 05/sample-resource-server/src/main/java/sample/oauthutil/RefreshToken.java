package sample.oauthutil;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RefreshToken {
    private long exp;

    public long getExp() {
        return exp;
    }

    public void setExp(long value) {
        exp = value;
    }
}
