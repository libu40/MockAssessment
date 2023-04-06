FROM openjdk:11
COPY ./assessment-web/target/assessment-web-*.jar mockassessment.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","mockassessment.jar"]

