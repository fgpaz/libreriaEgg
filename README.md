# Ejercicio de aprendizaje. Proyecto integral Spring
El objetivo de este ejercicio consiste en el desarrollo de un sistema web de guardado de libros en JAVA utilizando una base de datos MySQL, JPA Repository para persistir objetos y Spring Boot como framework de desarrollo web.

## Estructura:
![image](https://user-images.githubusercontent.com/21107178/148463352-6c46d10f-3b62-481e-801b-a91c7d987cdf.png)

## Base de datos:
![image](https://user-images.githubusercontent.com/21107178/148463265-78a77011-c86a-43f6-89dc-6707854b30ee.png)

## Entidades:
### Entidad Libro 
La entidad libro modela los libros que están disponibles en la biblioteca para ser prestados. En esta entidad, el atributo “ejemplares” contiene la cantidad total de ejemplares de ese libro, mientras que el atributo “prestados” contiene cuántos de esos ejemplares se encuentran prestados en este momento y el atributo “restantes” tiene cuando libros nos quedan para prestar. El repositorio que persiste a esta entidad (LibroRepositorio) debe contener los métodos necesarios para guardar/actualizar libros en la base de datos, realizar consultas o dar de baja según corresponda.
### Entidad Autor 
La entidad autor modela los autores de libros. El repositorio que persiste a esta entidad debe contener todos los métodos necesarios para guardar en la base de datos, realizar consultas y eliminar o dar de baja según corresponda. El repositorio que persiste a esta entidad (AutorRepositorio) debe contener los métodos necesarios para guardar/actualizar un cliente en la base de datos, realizar consultas o dar de baja según corresponda.
### Entidad Editorial 
La entidad editorial modela las editoriales que publican libros. El repositorio que persiste a esta entidad (EditorialRepositorio) debe contener los métodos necesarios para guardar/actualizar una editorial en la base de datos, realizar consultas o dar de baja según corresponda.

## Capa de Servicios:
### LibroServicio 
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para administrar libros (consulta, creación, modificación y dar de baja).
### AutorServicio 
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para administrar autores (consulta, creación, modificación y dar de baja).
### EditorialServicio 
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para administrar editoriales (consulta, creación, modificación y dar de baja).

## Capa de Comunicacion/Controladores
### LibroController 
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para operar con la vista del usuario diseñada para la gestión de libros (guardar/modificar libro, listar libros, dar de baja).
### AutorController 
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para operar con la vista que gestiona los autores (guardar/actualizar, listar autores, dar de baja).
### EditorialController 
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para operar con las vistas que gestiona editoriales (guardar/modificar, listar editoriales, dar de baja).

## Capa de Vistas
Esta capa tiene la responsabilidad de llevar adelante las funcionalidades necesarias para interactuar con el usuario. Las vistas para este proyecto tienen que estar desarrolladas en HTML5 y se debe utilizar la biblioteca Thymeleaf y CSS para implementar las plantillas. Además, se debe utilizar el framework de Bootstrap para los componentes. Se deben diseñar y crear todas las vistas web necesarias para llevar a cabo las siguientes funcionalidades:
- Administrar Autores: cargar datos de un autor, modificar datos, listar autores y dar de baja.
- Administrar Editoriales: cargar los datos de una editorial, modificar los datos, listar editoriales y dar de baja.
- Administrar Libros: cargar datos de un nuevo libro, modificar datos, listar libros, y dar de baja.
A continuación, se muestran algunos ejemplos para el módulo de Administración de Autores.
1. Listar autores

![image](https://user-images.githubusercontent.com/21107178/148470564-1c4fbc4f-e3b9-4b77-bc94-8e776ad7f3c8.png)

2. Cargar Autor

![image](https://user-images.githubusercontent.com/21107178/148470587-601fcdc3-6cd9-463e-8b57-230a30620694.png)

## Progreso:
- [x] Creacion de base de datos.
- [x] Creacion de entidades.
- [x] Creacion de repositorios.
- [x] Creacion de servicios.
- [x] Integrar entidades, repositorios y servicios.
- [x] Portal controlador.
- [ ] Controladores especificos.
- [ ] Creacion de vistas.
