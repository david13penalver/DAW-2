# Especifica la imagen base
FROM eclipse-temurin:21-jdk-jammy

# Instrucciones para configurar la imagen
RUN mkdir -p /opt/davidp/bookstore

# Copia archivos locales al contenedor
COPY /bookstore-0.0.1.jar /opt/davidp/bookstore

# Expone un puerto en el contenedor
EXPOSE 8080

#El directorio de trabajo
WORKDIR /opt/davidp/bookstore

# Define variables de entorno
ENV ENTORNO=produccion

# Comando para ejecutar la aplicación o servicio
CMD ["java", "-jar","/opt/davidp/bookstore/bookstore-0.0.1.jar"]
