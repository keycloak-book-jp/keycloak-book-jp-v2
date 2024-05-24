### 起動手順

```
# レルムデータのインポート
$KEYCLOAK_HOME/bin/kc.sh import --file demo-realm.json

# Keycloak の起動
$KEYCLOAK_HOME/bin/kc.sh start-dev

# Spring Boot の起動（別コンソール）
./gradlew clean build bootRun
```



### アクセスURL

| 用途 | URL | ID/PW |
|-----------|------------|------------|
| 認証必須     | http://localhost:8180/user-area        | user001/password         |
| Adminロール必須     | http://localhost:8180/admin-area        | admin001/password         |
| 認証不要     | http://localhost:8180/anonymous-area        | -         |
| OP起点ログアウト    | http://localhost:8080/realms/demo/protocol/openid-connect/logout?post_logout_redirect_uri=http%3A%2F%2Flocalhost%3A8180%2Fuser-area&client_id=springboot-oidc        | -         |
