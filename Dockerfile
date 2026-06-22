# ===== Stage 1: Build =====
FROM maven:3.9-eclipse-temurin-17-alpine AS builder

WORKDIR /app

# Copy pom.xml first for layer caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn package -DskipTests -B

# ===== Stage 2: Runtime =====
FROM eclipse-temurin:17-jre-alpine AS runtime

WORKDIR /app

# Copy the packaged JAR from builder stage
COPY --from=builder /app/target/blog-system-1.0.0.jar app.jar

EXPOSE 8080

# Use H2 in-memory database for free deployment (no external DB needed)
ENV DB_PROFILE=h2

# JVM tuning for container environments
ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:+UseSerialGC -XX:TieredStopAtLevel=1"

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]
