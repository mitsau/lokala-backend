FROM openjdk:17-jdk-slim

# Set the application version to match Gradle's version
ARG APP_VERSION=0.0.1
ENV APP_VERSION=${APP_VERSION}

WORKDIR /app

COPY ./ ./

# Build the application with Gradle
RUN ./gradlew clean build -x test && \
    mkdir -p /app/build && \
    cp build/libs/ktor-app-${APP_VERSION}.jar /app/build/app.jar

CMD ["java", "-jar", "/app/build/app.jar"]

EXPOSE 8080
