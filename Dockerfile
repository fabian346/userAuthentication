FROM eclipse-temurin:17
LABEL author="Anderson F. Causa"

COPY target/userAuthentication-0.0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]