
FROM quay.io/quarkus/quarkus-micro-image:1.0


WORKDIR /app

COPY target/*-runner.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]
