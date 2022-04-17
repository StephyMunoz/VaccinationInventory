# VaccinationInventory

### Base de datos

Para realizar esta API REST se utilizó el model de base de datos relacional postgresql con tres entidades y sus respectivas relaciones como se puede ver a continuación.

![image](https://user-images.githubusercontent.com/58042439/163735351-ea4243ac-4577-4334-9f49-6d7553bc5b4c.png)

## Backend

El backend se realizó en el framework Spring Boot con el lenguaje de programación Java.

Existen dos tipos de roles, usuario y administrador (USER, ADMIN).
El administrador es el único que puede registrar nuevos empleados e inmediatamente debe asignarle al empleado creado un nombre de usuario y contraseña, el rol por defecto de todos los usuarios es User.

El administrador puede listar, crear nuevos empleados, modificar los datos y eliminar a un empleado.

El empleado puede acceder al sistema mediante su usuario y contraseña y una vez dentro puede guardar su información personal y la información correspondiente al estado de su vacunación. Si esta vacunado deberá ingresar el tipo de vacuna, la fecha de vacunación y número de dosis. Además, puede acceder a modificar esta información.

El administrador puede filtrar la información relacionada al estado de vacunación de los empleados. Listar empleados que están vacunados y los que no, filtrar según el tipo de vacuna y quiénes recibieron las vacunas en un rango determinado de tiempo.

### Estructura de los directorios

![image](https://user-images.githubusercontent.com/58042439/163735519-416cc53e-eac1-48ef-9279-00d99b8efb10.png)

### Configuración de seguridad

![image](https://user-images.githubusercontent.com/58042439/163735526-8917c297-6b76-4660-a070-2b47b854b6e6.png)

### Controlador

![image](https://user-images.githubusercontent.com/58042439/163735542-ec8c09ff-bd28-4b67-92ed-1ac9feb6a82f.png)

### Modelo con sus respectivas validaciones

![image](https://user-images.githubusercontent.com/58042439/163735565-679899de-acfd-496b-b1ac-af152c02a64c.png)

### Servicio

![image](https://user-images.githubusercontent.com/58042439/163735579-92a99c0a-73e9-40dc-b3e8-9949257d4b99.png)

