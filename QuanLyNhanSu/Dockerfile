# ------------------
# PHASE 1: BUILD STAGE (Biên dịch và đóng gói JAR)
# Sử dụng Java JDK 17 (dựa trên log build Maven trước đó)
# ------------------
FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /app

# Sao chép các file cấu hình và build tool
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Build ứng dụng thành file JAR, bỏ qua test để đảm bảo build thành công
# (Vì bạn đã gặp lỗi kết nối DB trong lúc chạy test)
RUN ./mvnw package -DskipTests

# ------------------
# PHASE 2: RUN STAGE (Chạy ứng dụng)
# Sử dụng Java JRE 17 nhẹ hơn
# ------------------
FROM eclipse-temurin:17-jre-focal

WORKDIR /app

# Sao chép file JAR đã build từ 'builder' stage
# Tên file JAR chính xác: QuanLyNhanSu-0.0.1-SNAPSHOT.jar (dựa trên project name và default version)
COPY --from=builder /app/target/QuanLyNhanSu-0.0.1-SNAPSHOT.jar quan-ly-nhan-su.jar

# Cổng mà ứng dụng Spring Boot sử dụng
EXPOSE 8080

# Lệnh mặc định để chạy ứng dụng
ENTRYPOINT ["java", "-jar", "quan-ly-nhan-su.jar"]