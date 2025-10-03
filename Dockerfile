# ---------- Build stage ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom and download dependencies first (better layer caching)
COPY pom.xml ./
RUN mvn -q -e -DskipTests dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn -q -DskipTests package

# ---------- Runtime stage ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy fat jar from build stage
COPY --from=build /app/target/mock-motor-api-0.0.1-SNAPSHOT.jar /app/app.jar

# Render/Railway will inject PORT. Default to 8080 for local runs.
ENV PORT=8080
EXPOSE 8080

# Pass the port to Spring Boot via server.port (also set in application.properties)
ENTRYPOINT ["java","-jar","/app/app.jar"]
