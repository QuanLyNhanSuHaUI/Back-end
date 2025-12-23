# Giai đoạn build
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# 1. Chỉ copy file pom.xml trước
COPY pom.xml .

# 2. Tải thư viện về (bước này sẽ chạy lâu ở lần đầu)
RUN mvn dependency:go-offline

# 3. BÂY GIỜ mới copy thư mục src vào
COPY src ./src

# 4. Build file jar (lệnh này sẽ hết lỗi "Main class" nếu bạn đã copy src)
RUN mvn package -DskipTests

# Giai đoạn chạy
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy file jar từ giai đoạn build sang
# Lưu ý: tên file jar thường là artifactId-version.jar
COPY --from=build /app/target/QuanLyNhanSu-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]