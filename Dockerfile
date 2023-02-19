FROM openjdk:11
COPY target/mockassessment-*.jar mockassessment.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","mockassessment.jar"]

