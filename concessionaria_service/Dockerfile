FROM amazoncorretto:21

WORKDIR /app

COPY target/concessionaria_service-0.0.1-SNAPSHOT.jar concessionaria-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "concessionaria-service.jar"]