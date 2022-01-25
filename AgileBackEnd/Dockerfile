FROM openjdk:java-8-openjdk-amd64
VOLUME /tmp
COPY ./target/AgileBackEnd.jar AgileBackEnd.jar
ENTRYPOINT ["java", "-jar", "./AgileBackEnd.jar", "&"]