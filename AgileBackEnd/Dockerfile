FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/AgileBackEnd-0.0.1-SNAPSHOT.jar AgileBackEnd.jar
ENTRYPOINT ["java", "-jar", "./AgileBackEnd.jar", "&"]