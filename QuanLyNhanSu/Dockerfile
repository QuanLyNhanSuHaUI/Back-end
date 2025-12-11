# ------------------
# PHASE 1: BUILD STAGE (Biên dịch và đóng gói JAR)
# Sử dụng Java JDK 17 (cần cho quá trình build)
# ------------------
FROM eclipse-temurin:17-jdk-jammy AS builder

# Thiết lập thư mục làm việc bên trong container
WORKDIR /app

# Sao chép các file cấu hình và build tool
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# *** BƯỚC KHẮC PHỤC LỖI QUAN TRỌNG: Cấp quyền thực thi cho mvnw ***
RUN chmod +x mvnw

# Build ứng dụng thành file JAR, bỏ qua test
RUN ./mvnw package -DskipTests

# ------------------
# PHASE 2: RUN STAGE (Chạy ứng dụng)
# Sử dụng Java JRE 17 nhẹ hơn (chỉ cần để chạy)
# ------------------
FROM eclipse-temurin:17-jre-focal

# Thiết lập thư mục làm việc
WORKDIR /app

# Sao chép file JAR đã build từ 'builder' stage
# Đảm bảo tên file JAR khớp với tên trong thư mục target:
# Tên JAR: QuanLyNhanSu-0.0.1-SNAPSHOT.jar
# Tên mới (alias) là: app.jar
COPY --from=builder /app/target/QuanLyNhanSu-0.0.1-SNAPSHOT.jar app.jar

# *** LƯU Ý VỀ CỔNG (PORT): ***
# EXPOSE 8080: Chỉ là tuyên bố. Spring Boot của bạn phải dùng biến môi trường ${PORT}.
EXPOSE 8080

# Lệnh mặc định để chạy ứng dụng
# ENTRYPOINT sẽ chỉ vào file JAR được đổi tên thành app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]