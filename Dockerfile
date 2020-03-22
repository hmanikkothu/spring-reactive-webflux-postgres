FROM openjdk:13-alpine
COPY ./target/reservation-service-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
RUN sh -c 'touch app.jar'
ENTRYPOINT ["java","-jar","app.jar"]
