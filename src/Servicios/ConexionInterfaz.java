package Servicios;

import java.sql.Connection;
import java.sql.ResultSet;

/*
 * Clase interfaz que contiene la cabecera de los metodos de la conexion a la base de datos
 */
public interface ConexionInterfaz {
	/*
	 * Metodo que establece la conexion a la base de datos
	 */
	public Connection conexionBaseDatos();

	
}
