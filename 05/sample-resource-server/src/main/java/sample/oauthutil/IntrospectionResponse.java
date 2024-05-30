package sample.oauthutil;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IntrospectionResponse {
    private String active;
    private int exp;
    private int iat;
    private int authTime;
    private String jti;
    private String iss;
    private String aud;
    private String sub;
    private String typ;
    private String azp;
    private String session_state;
    private String acr;
    private String[] allowedOrigins;
    private Roles realmAccess;
    private ResourceAccess resourceAccess;
    private String scope;
    private String sid;
    private boolean emailVerified;
    private String name;
    private String preferredUsername;
    private String givenName;
    private String familyName;
    private String email;
    private String clientId;
    private String username;
    private String tokenType;

    public String getActive() {
        return active;
    }

    public void setActive(String value) {
        active = value;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getIat() {
        return iat;
    }

    public void setIat(int iat) {
        this.iat = iat;
    }

    public int getAuthTime() {
        return authTime;
    }

    public void setAuthTime(int authTime) {
        this.authTime = authTime;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getAzp() {
        return azp;
    }

    public void setAzp(String azp) {
        this.azp = azp;
    }

    public String getSession_state() {
        return session_state;
    }

    public void setSession_state(String session_state) {
        this.session_state = session_state;
    }

    public String getAcr() {
        return acr;
    }

    public void setAcr(String acr) {
        this.acr = acr;
    }

    public String[] getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(String[] allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public Roles getRealmAccess() {
        return realmAccess;
    }

    public void setRealmAccess(Roles realmAccess) {
        this.realmAccess = realmAccess;
    }

    public ResourceAccess getResourceAccess() {
        return resourceAccess;
    }

    public void setResourceAccess(ResourceAccess resourceAccess) {
        this.resourceAccess = resourceAccess;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setPreferredUsername(String preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public static class Roles {
        private String[] roles;

        public String[] getRoles() {
            return roles;
        }

        public void setRoles(String[] roles) {
            this.roles = roles;
        }
    }

    public static class ResourceAccess {
        private Roles account;

        public Roles getAccount() {
            return account;
        }

        public void setAccount(Roles account) {
            this.account = account;
        }
    }
}
