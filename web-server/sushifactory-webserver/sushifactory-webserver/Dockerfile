FROM openjdk:21
LABEL authors="Mateusz Biernacki"
COPY ./target/*.jar /usr/src/webserver
WORKDIR /usr/src/webserver
EXPOSE 8081
CMD ["java", "-jar", "*.jar"]