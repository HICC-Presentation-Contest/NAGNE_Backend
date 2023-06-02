FROM openjdk:11
ARG JAR_FILE=/build/libs/nagne_backend-0.0.1-SNAPSHOT.jar
COPY  ${JAR_FILE} nagne.jar
ENTRYPOINT ["java","-jar","/nagne.jar","--spring.profiles.active=prod"]