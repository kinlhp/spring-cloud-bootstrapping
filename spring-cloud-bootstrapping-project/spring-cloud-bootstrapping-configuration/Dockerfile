# FROM adoptopenjdk:13-jre-hotspot
FROM adoptopenjdk/openjdk13:jre-13_33-alpine

LABEL maintainer="kinlhp <lhp.kin@gmail.com>"

ARG tag=latest

#RUN apk --update add git less openssh \
#    && rm -rf /var/lib/apt/lists/* \
#    && rm /var/cache/apk/* \
#    && mkdir -p /spring-cloud-bootstrapping-configuration-repository.git/ \
#    && cd /spring-cloud-bootstrapping-configuration-repository.git/ \
#    && git init \
#    && cd -

ADD target/spring-cloud-bootstrapping-configuration-${tag}.jar spring-cloud-bootstrapping-configuration.jar

ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "spring-cloud-bootstrapping-configuration.jar" ]
## Needs run with 'native' profile (-Dspring.profiles.active=native) for file system store
#ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=native", "-jar", "spring-cloud-bootstrapping-configuration.jar" ]