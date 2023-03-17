FROM openjdk:11
COPY build/libs/discovery-service-0.0.1-SNAPSHOT.jar discovery-service-0.0.1.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/discovery-service-0.0.1.jar"]

#
# docker run -d --rm --name eureka -p 8761:8761 -e spring.cloud.config.uri=http://172.17.0.3:8081 discovery-service