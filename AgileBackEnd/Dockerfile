FROM openjdk:java-8-openjdk-amd64
VOLUME /tmp
COPY ./target/AgileBackEnd-0.0.1-SNAPSHOT.jar AgileBackEnd.jar
ENTRYPOINT ["java", "-jar", "./AgileBackEnd.jar", "&"]