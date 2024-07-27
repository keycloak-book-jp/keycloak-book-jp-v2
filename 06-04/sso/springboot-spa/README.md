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

### アクセスURL

| 用途 | URL | ID/PW |
|-----------|------------|------------|
| 認証必須     | http://localhost:8280/spa-client-app/index.html        | user001/password         |
| Bearer認証必須     | http://localhost:8280/spa-resource-server/user        | XHR からの Bearerトークン         |
| Keycloak管理コンソール | http://localhost:8080/admin/master/console/        | admin/admin         |
