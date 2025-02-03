# Especifica la imagen base
FROM eclipse-temurin:21-jdk-jammy

# Instrucciones para configurar la imagen
RUN mkdir -p /opt/davidp/motos_crud

# Copia archivos locales al contenedor
COPY /src/motos_crud.jar /opt/davidp/motos_crud/motos_crud.jar

# Expone un puerto en el contenedor
EXPOSE 13011

#El directorio de trabajo
WORKDIR /opt/davidp/motos_crud

# Define variables de entorno
ENV ENTORNO=produccion

# Comando para ejecutar la aplicación o servicio
CMD ["java", "-jar","/opt/davidp/motos_crud/motos_crud.jar"]
