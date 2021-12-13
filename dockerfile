FROM openjdk:11
ADD target/shipmenttracking-1.0.DEV.jar shipmenttracking-1.0.DEV
EXPOSE 8085
ENTRYPOINT ["java","-jar","shipmenttracking-1.0.DEV.jar"]

