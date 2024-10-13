FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
COPY . /app
RUN apk add dos2unix
RUN dos2unix ./mvnw
RUN chmod +x ./mvnw
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:17-jre-alpine AS main
WORKDIR /app
COPY --from=builder /app/target/*.jar /usr/local/springboot-app.jar
EXPOSE 9001
CMD ["java", "-jar", "/usr/local/springboot-app.jar","--spring.profiles.active=docker"]