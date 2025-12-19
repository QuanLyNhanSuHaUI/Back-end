FROM maven:3-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN ./mvnw package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/QuanLyNhanSu-0.0.1-SNAPSHOT.jar quanlynhansu.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quanlynhan.jar"]