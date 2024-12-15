# Base image with OpenJDK 17
FROM openjdk:17-jdk-slim

# Argument for application version
ARG APP_VERSION=1.0.0

# Set the working directory
WORKDIR /app

# Copy Gradle wrapper and build files
COPY ./ ./

# Build the Ktor application
RUN ./gradlew clean build -x test

# Copy the built JAR file into the container
RUN mkdir -p /app/build
# Copy the built JAR file into the container
RUN cp build/libs/ktor-app-${APP_VERSION}.jar /app/build/app.jar

# Set the default command to run the JAR
CMD ["java", "-jar", "/app/build/app.jar"]

# Expose the Ktor application port
EXPOSE 8080
