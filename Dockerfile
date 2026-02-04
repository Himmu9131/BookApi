FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy everything
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Copy the built jar to a fixed name
RUN cp target/*.jar app.jar

# Run the app
CMD ["java", "-jar", "app.jar"]
