# Respuesta 1

1-Se debe retirar la cadena de conexión y crearla en una clase independiente.

2-Se debe poner la ruta del fichero de recurso, no dbParam.

3-Sino se crea una conexión no se puede ejecutar connection.createStatement().

4-La línea de creación de la conexión debe ir antes de ejecutar el update a la BD.

5-Añadir validación al if del logToDatabase verificar que Statement sea ¡= null.

6- La propiedad initialized no se utiliza, por lo que se elimina.

7-Falta el nombre de la BD en la conexión.

8-En el executeUpdate el insert debe tener la palabra values para indicar los valores a insertar.

9- Se debe insertar el valor de la varieble 1 que contiene la fecha de la traza y el mensaje.

10-Se debe cerrar la conexión una vez finalizada la operación.

# Refactorización que debería realizarse

•	Clases con demasiadas funciones: clases con demasiadas funciones definidas como método, que hacen que adaptar el software se vuelva casi imposible.

•	Redundancias en el código: los códigos poco claros suelen contener repeticiones que han de corregirse una a una durante el mantenimiento, por lo que consumen mucho tiempo y recursos.

•	Middle man: una clase separada actúa como intermediaria entre los métodos y las distintas clases, en lugar de direccionar las solicitudes de los métodos directamente a una clase.

•	Permite un correcto rendimiento de la aplicación.

•	Código encapsulado y disponible para la reutilización.

# Este es el script para la BD, Se realizo en Postgres 9.0

CREATE TABLE trazas
(
  id serial NOT NULL,
  mensaje text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE trazas
  OWNER TO postgres;


