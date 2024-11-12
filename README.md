##        LiteraLura
<div align="center"><img src="https://raw.githubusercontent.com/patrickwebsdev/Encriptador-Oracle-Alura/master/img/one.png" width="200"/></div>
- Proyecto para el programa ONE-Backend. La app está desarrollada en Java 17 para realizar la busqueda de libros y guardarlos en una base de datos PostgreSQL . Se basa en el consumo de la API de gutendex-API , de este modo esta app se alimenta de los listados de libros con un menú de diferentes opciones para desarrollar.

- Se caracteriza por guardar los libros buscados en una base PostgreSQL.
- Se caracteriza por Lista de Autores.
- Se caracteriza por Lista de Top5 más descargados.
- Planimetria de la APP.
  <div align="center"><img src="https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/planimetria.png" width="200"/></div>


- Lo primero es descargar la APP.

<div align="center"><img src="https://cdn.prod.website-files.com/5f5a53e153805db840dae2db/64e79ca5aff2fb7295bfddf9_github-que-es.jpg" width="200"/></div>

####git clone -- Url de la APP
https://github.com/DiegoaMT13/Reto-Conversor-De-Moneda.git

**La podrás ejecutar la APP a través IntelliJ IDEA**
<div align="center"><img src="https://d3v6byorcue2se.cloudfront.net/wp-content/uploads/2018/09/logoIntelliJ-IDEA.png" width="200"/></div>
Es un entorno de desarrollo integrado con reconocimiento de contexto para trabajar con Java y otros lenguajes que se ejecutan en JVM, como Kotlin, Scala y Groovy. Un punto importante a considerar al crear código es la elección del IDE


### Reconociendo la App

Encontraras una rama de carpetas abre y ejecuta LiteraLuraApplication

<div align="center"><img src="https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/Aplicacion.png" width="200"/></div>


### Funcionalidades de la APP
En esta app te encuentras con seis opciones.
1 - Buscar libro por titulo
            2 - Listar libros Registrados
            3 - Listar autores registrados
            4 - Listar autores vivos en un determinado año
            5 - Listar libros por idioma
            6 - Top 5 libros más descargados
            0 - Salir




### Iniciando la busquedad de libros

- La app funciona con un menú inicial en el cual lo primero es: 1 - Buscar libro por titulo ,

![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/buscandoLibro.png)
- La app encontrara el libro y lo guardara en una tabla de PostgreSQL y mostrándote la información del mismo.
![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/libroEncontrado.png)


### Opción 2 del menú

- La opción 2 del menú te mostrara una lista de libros descargados que buscaste con la:
1 - Buscar libro por titulo ,

![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/listaLibras2.png)
### Opción 3 del menú

- La opción 3 del menú te mostrara una lista de autores registrados de los libros que buscaste con la: 1 - Buscar libro por titulo ,

![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/listaAutores.png)
### Opción 4 del menú

- La opción 4 del menú te mostrara una lista de autores vivos en un determinado año,

![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/listaporFecha.png)

### Opción 5 del menú

- La opción 5 del menú te mostrara una  Lista de libros por idioma encontraras un nuevo menu con opciones por idioma,

![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/listarPorIdioma.png)

- Seleccionemos por ejemplo el 4 mostrara una lista de libros por el idioma pt o portugués,

![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/listaIdiomasEn.png)
### Opción 6 del menú

- La opción 6 del menú te mostrara un top 5 de los libros mas descargados de base de datos,

![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/top5.png)
### Opción 0 del menú - salir
Para finalizar cerrando el programa la opción (0).

### Funcionalidad de la App
![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/funcionService.png)
![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/funcionModel.png)
![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/funcionModel2.png)
![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/funcionPrincipal.png)
![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/funcionMetodos.png)
![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/menuOpciones.png)
![image](https://raw.githubusercontent.com/DiegoaMT13/Reto-LiteraLura/refs/heads/main/literaLura/src/main/java/com/aluracursos/literaLura/imagenes/metodos.png)

- Final
