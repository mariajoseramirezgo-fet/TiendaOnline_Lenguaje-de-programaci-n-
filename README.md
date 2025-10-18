# Proyecto Tienda Online - Taller JPA Relaciones  
Implementa un sistema básico de **tienda online**, donde se gestionan **clientes, productos, pedidos, categorías, 
direcciones e ítems de pedido**, aplicando correctamente las relaciones **OneToOne**, **OneToMany**, y **ManyToMany** 
con **Spring Boot** y una base de datos **H2** en memoria.

##  Objetivo del proyecto

Demostrar el manejo de **relaciones entre entidades en JPA** mediante la creación de un backend funcional que
permita realizar operaciones CRUD y validar las asociaciones entre tablas a través de pruebas en **Postman**.

##  Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Maven**
- **Lombok**
- **Postman** (para pruebas)
- **IntelliJ IDEA**

# Cómo ejecutar el proyecto con H2 Database

Este proyecto está configurado para usar H2, una base de datos en memoria que no requiere instalación ni configuración adicional.
Cada vez que se ejecuta la aplicación, las tablas se crean automáticamente a partir de las entidades JPA y los datos se almacenan temporalmente mientras el servidor está activo.

# Configuración en application.properties

El archivo src/main/resources/application.properties contiene la siguiente configuración:

# Configuración general
spring.application.name=TiendaOnline
server.port=8080

# Configuración de base de datos H2
spring.datasource.url=jdbc:h2:mem:tienda
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración de JPA e Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Habilitar consola web de H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

