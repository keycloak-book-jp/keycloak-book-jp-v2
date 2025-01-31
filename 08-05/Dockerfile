FROM registry.access.redhat.com/ubi9 AS ubi-micro-build

RUN mkdir -p /mnt/rootfs
RUN dnf install --installroot /mnt/rootfs vi curl java-21-openjdk-devel \
    --releasever 9 --setopt install_weak_deps=false --nodocs -y && \
    dnf --installroot /mnt/rootfs clean all && \
    rpm --root /mnt/rootfs -e --nodeps setup

FROM quay.io/keycloak/keycloak:26.0.0

COPY --from=ubi-micro-build /mnt/rootfs /

ADD --chown=keycloak:keycloak --chmod=644 sms-auth-theme.jar sms-authenticator.jar /opt/keycloak/providers/

RUN keytool -genkeypair -storepass password -storetype PKCS12 -keyalg RSA \
    -keysize 2048 -dname "CN=server" -alias server \
    -ext "SAN:c=DNS:localhost,IP:127.0.0.1" \
    -keystore /opt/keycloak/conf/server.keystore

ENV KC_HOSTNAME=localhost
ENV KC_DB=postgres
ENV KC_DB_URL=jdbc:postgresql://192.168.1.23:5432/keycloak
ENV KC_DB_USERNAME=keycloak
ENV KC_DB_PASSWORD=password

RUN /opt/keycloak/bin/kc.sh build

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]