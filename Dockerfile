FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/mvcdocker-1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]