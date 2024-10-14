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
	public Connection ConexionBaseDatos();

	/*
	 * Metodo encargado de subir los datos del usuario a la tabla usuarios
	 */
	public void subidaDatosUsu(long idUsu, String nombre, String contrasenia);

	/*
	 * Metodo encargado de subir los datos de clubes a la tabla clubes
	 */
	public void subidaDatosClub(long idClub, String nombre);

	/*
	 * Metodo encargado de hacer las consultas a las tabla de usuarios de las BD
	 */
	public ResultSet consultaDatosUsu();

	/*
	 * Metodo encargado de hacer las consultas a las tabla de clubes de las BD
	 */
	public ResultSet consultaDatosClub();
}
