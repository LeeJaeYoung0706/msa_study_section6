## java version 기반 docker 이미지
FROM eclipse-temurin:17-jdk-jammy

MAINTAINER leejaeyoung4466
## jar 복사
COPY target/accounts-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]