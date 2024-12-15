# Base image with OpenJDK 17
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy Gradle files and source code
COPY ./ ./

# Build the Ktor project
RUN ./gradlew clean build -x test

# Copy the built JAR file into the container
RUN mkdir /app/build
RUN cp build/libs/*.jar /app/build/app.jar

# Set the default command to run the JAR
CMD ["java", "-jar", "/app/build/app.jar"]

# Expose the Ktor application port
EXPOSE 8080
