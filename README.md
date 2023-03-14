# SPRING CRUD GENERICS

Este proyecto esta creado con una implementacion de CRUDs genericos, con el fin de reutilizar los metodos de CREATE, READ, UPDATE, DELETE en base a una clase **"Padre"**.

Esta basado en la clase **JpaRepository** y en la forma que esta implementa sus metodos CRUD.

## Ejecutar Proyecto

El archivo **spring_crud_generics.postman_collection** es la coleccion de POSTMAN para realizar las pruebas.

```
    mvn spring-boot:run
```

## Controllers

Las clases de Tipo Controller hereda sus metodos de la clase BaseController y a su ves envia mediante los Generics de JAVA  las clases MODELO, el tipo de dato del ID y el Servicio o Logica de Negocio.

```java

public class DomainController extends BaseController<Domain, Integer, DomainService>

```

## Service

Las clases de Tipo Service hereda sus metodos de la clase BaseService y a su ves envia mediante los Generics de JAVA las clases de MODELO, el tipo de dato del ID y el Repositorio.

```java

public class DomainService extends BaseService<Domain, Integer, DomainRepository>

```

## Resultados de la implementacion de este proyecto

- Dismuniye el tiempo de creacion de CRUDs en el backend.
- Se escribe menos codigo
- Se pueden agregar mas metodos y endpoints a las clases ya existentes.


## Siguientes Pasos

Agregar una clase similar para los tests de los CRUDs.


## Colaboracion

Sientete libre de realizar fork o commit sobre el proyecto siempre y cuando se genere el issue del mismo.