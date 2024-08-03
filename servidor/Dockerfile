FROM openjdk:17
WORKDIR /app
COPY target/servidor-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "app.jar"]