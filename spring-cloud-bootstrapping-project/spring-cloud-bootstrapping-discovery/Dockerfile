# FROM adoptopenjdk:13-jre-hotspot
FROM adoptopenjdk/openjdk13:jre-13.0.1_9-alpine

LABEL maintainer="kinlhp <lhp.kin@gmail.com>"

ARG port=8081
ARG tag=latest

ADD target/spring-cloud-bootstrapping-discovery-${tag}.jar spring-cloud-bootstrapping-discovery.jar

EXPOSE ${port}

ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "spring-cloud-bootstrapping-discovery.jar" ]
