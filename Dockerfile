FROM maven:latest
LABEL authors="axerex"

WORKDIR /app

# Copy pom.xml first for better layer caching
COPY pom.xml /app/

# Copy source code
COPY src /app/src

# Build the application with explicit platform
RUN mvn clean package -DskipTests

# List the target directory contents for debugging
RUN ls -la target/

# Verify the jar file is executable
RUN test -f target/TemperatureConverter.jar && echo "JAR file exists" || echo "JAR file missing"

# Run the application
CMD ["java", "-jar", "target/ShoppingCart.jar"]