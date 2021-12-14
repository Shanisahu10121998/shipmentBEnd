
FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} shipmenttracking-1.0.DEV.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/shipmenttracking-1.0.DEV.jar"]