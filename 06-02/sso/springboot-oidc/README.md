### 起動手順

- Linuxの場合
```
# レルムのインポート
[KEYCLOAK_HOME]/bin/kc.sh import --file demo-realm.json

# Keycloak の起動
[KEYCLOAK_HOME]/bin/kc.sh start-dev

# Spring Boot の起動（別コンソール）
./mvnw clean spring-boot:run
```

- Windows PowerShellの場合
```
# レルムのインポート
[KEYCLOAK_HOME]\bin\kc.bat import --file demo-realm.json

# Keycloak の起動
[KEYCLOAK_HOME]\bin\kc.bat start-dev

# Spring Boot の起動（別コンソール）
.\mvnw.cmd clean spring-boot:run
```

### バックチャネルログアウト不具合のワークアラウンド対応
※ これはspring-securityのバグ解消確認のためのな暫定対処方法です。

```
# spring-security の main ブランチ(6.4.0-SNAPSHOT)をcloneして、ビルド
git clone https://github.com/spring-projects/spring-security.git
cd spring-security
./gradlew build -x test

# 最新版のライブラリ(6.4.0-SNAPSHOT)をMaven Localレポジトリにコピー
./gradlew publishToMavenLocal

# spring-security の最新版(6.4.0-SNAPSHOT)で、Spring Boot の起動（別コンソール）
./mvnw -f pom_workaround.xml clean spring-boot:run
```


### アクセスURL

| 用途              | URL                                                                                                                                                           | ID/PW |
|-----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|------------|
| 認証必須            | http://localhost:8180/user-area                                                                                                                               | user001/password       |
| Adminロール必須      | http://localhost:8180/admin-area                                                                                                                              | admin001/password      |
| 認証不要            | http://localhost:8180/anonymous-area                                                                                                                          | -         |
| RP起点ログアウト       | http://localhost:8180/logout                                                                                                                                  | -         |
| OP起点ログアウト       | http://localhost:8080/realms/demo/protocol/openid-connect/logout?post_logout_redirect_uri=http%3A%2F%2Flocalhost%3A8180%2Fuser-area&client_id=springboot-oidc | -         |
| Keycloak管理コンソール | http://localhost:8080/admin/master/console/                                                                                                                   | admin/admin         |
