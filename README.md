# Práctica Tecnologías Web

Proyecto para la asignatura de Tecnologías Web de la UNED de 2019.

## Para empezar

Este proyecto se ha creado usando la herramienta Spring Initializr. Las dependencias son:

* Spring Boot Starter Web
* H2 Database
* JPA Dependency

### Base de Datos H2
   
   Se ha habilitado el acceso a la consola de H2 a través del archivo "application.properties". Acceso:
   
   ```
   http://localhost:8080/h2-console
   ```

En JDBC URL indicamos: "jdbc:h2:mem:testdb".

### Habilitando JSP en Spring Boot

Tenemos que añadir la siguiente dependencia para habilitar el soporte para JSP en Spring Boot: 

```
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <scope>provided</scope>
        </dependency>
```

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo


### Generar un WAR con Spring Boot

https://www.programmergate.com/deploy-spring-boot-application-external-tomcat/
https://stackoverflow.com/questions/47908312/create-war-file-from-springboot-project-in-eclipse