# Módulo Control Acceso Admon Back

![Logo de la USCO](https://www.usco.edu.co/imagen-institucional/logo/universidad-surcolombiana.png)

Este módulo de backend ha sido desarrollada utilizando Java 8 y Spring Boot, junto con las siguientes dependencias clave:

- **Spring Boot 2.2.5**  
  Documentación oficial: [https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/html/](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/html/)

- **JPA (Java Persistence API)**  
  Documentación oficial: [https://spring.io/projects/spring-data-jpa](https://spring.io/projects/spring-data-jpa)

- **Spring Security (OAuth2, JWT)**  
  Documentación oficial: [https://spring.io/projects/spring-security](https://spring.io/projects/spring-security)  
  Documentación OAuth2: [https://projects.spring.io/spring-security-oauth/](https://projects.spring.io/spring-security-oauth/)

- **Microsoft SQL Server JDBC Driver**  
  Documentación oficial: [https://docs.microsoft.com/en-us/sql/connect/jdbc/using-the-jdbc-driver?view=sql-server-ver15](https://docs.microsoft.com/en-us/sql/connect/jdbc/using-the-jdbc-driver?view=sql-server-ver15)

- **Apache POI (para manejar archivos Excel)**  
  Documentación oficial: [https://poi.apache.org/](https://poi.apache.org/)

- **JasperReports (Generación de reportes)**  
  Documentación oficial: [https://community.jaspersoft.com/project/jasperreports-library](https://community.jaspersoft.com/project/jasperreports-library)

## Descripción

Permite crear, parametrizar y gestionar el personal de vigilantes externo que contrata la institución para la supervisión de la seguridad y acceso a la universidad.

## Instalación y Uso

1. Clona el repositorio:

   ```bash
   git clone https://github.com/usuario/plantilla_admon_backend.git
   ```

2. Clonar el repositorio de WildFly:

   ```bash
   git clone https://github.com/JohnGuerreroCor/wildfly-10.git
   ```

3. Instala las dependencias con Maven:

   ```bash
   mvn clean install
   ```

4. Configura las propiedades de la base de datos en el archivo `application.properties`.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, sigue las pautas de contribución y el código de conducta del proyecto.

## Tecnologías y Dependencias

Este proyecto incluye las siguientes dependencias clave:

- Spring Boot
- JPA (Java Persistence API)
- Spring Security (OAuth2, JWT)
- Microsoft SQL Server JDBC Driver
- Apache POI para manejo de archivos Excel
- JasperReports para generación de reportes
