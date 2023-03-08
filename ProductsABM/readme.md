# Proyecto ABM con microservicios.

## Especificaciones

- Base de datos: h2 (para almacenamiento temporal)
- Java 11
- Dependencies manager: Gradle
- Spring 3.0.4

## Descripción

El proyecto esta constituido por 6 microservicios

1. **Config client**: Los microservicios toman las configuraciones que estén definidas en el directorio (config-data) con sus respectivos nombres `spring.application.name`
2. **Discovery Service**: Utiliza Netflix Eureka para descubrir los microservicios que estan activos
3. **Gateway service**: identifica a las instancias de los servicios activos con nombres e identificadores unicos
4. **Products service**
5. **Stock service**
6. **Category service**
