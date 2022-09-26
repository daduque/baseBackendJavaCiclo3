# Simple Back With Spring Boot - JWT - Mysql

un repositorio de github con un backend que cuenta con un CRUD de usuarios,

Listar usuario, eliminar usuario, añadir usuarios, editar usuarios y ver detalle de un usuario.

El backend implementa un proyecto de Java con Maven junto con el framework de Spring Boot, conexión con base de datos local, la cual deberán crear y actualizar las credenciales en el archivo de configuración.

Cuenta con 2 controladores, uno para el CRUD de usuario y otro para manejar la autenticación, dentro de la autenticación, se trabaja con JWT (JSON Web Token), para manejar la sesión del usuario y en el controlador de usuario, se deja un ejemplo de un método (listar usuarios) que implementa el requerimiento de token para contestar la petición.

El controlador es un REST Controller, el cual contesta con un JSON a las peticiones exitosas.

En los modelos pueden encontrar la estructura que lleva la tabla, con sus campos y atributos y cuenta con un mapeo de los mismos a un patron llamado DAO (Data Access Object), muy similar al DTO, para crear interfaces entre los controladores y los modelos.

El proyecto ya es funcional, sin embargo faltaría subir la base de datos a la nube, crear otra entidad que pueda corresponder con su proyecto, y afinar las respuestas del controlador.