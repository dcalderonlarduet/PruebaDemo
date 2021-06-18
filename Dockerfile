FROM adoptopenjdk/openjdk11:jdk-11.0.7_10-alpine-slim
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/PruebaDemo-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]