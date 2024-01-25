#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

# Usar una imagen base con JDK 17 y Maven
FROM maven:3.8.4-openjdk-17 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY . /app

# Exponer el puerto
EXPOSE 8080

# Ejecutar Maven para construir el proyecto
RUN mvn clean package -DskipTests

# Crear una nueva imagen basada en OpenJDK 17
FROM openjdk:17-alpine

# Copiar los archivos del proyecto de la imagen de construcción a la imagen de producción
COPY --from=build /app/target/init-contact-info-0.0.1-SNAPSHOT.jar /app/init-contact-info.jar

# Establecer el punto de entrada de la aplicación
ENTRYPOINT ["java", "-jar", "/app/init-contact-info.jar"]