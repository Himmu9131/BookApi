FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot jar (EXACT NAME)
CMD ["java", "-jar", "target/BookApi-0.0.1-SNAPSHOT.jar"]
