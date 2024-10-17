package Servicios;

import java.sql.ResultSet;

public interface OperacionesBDInterfaz {
	/*
	 * Metodo encargado de subir los datos del usuario a la tabla usuarios
	 */
	public void subidaDatosUsu(long idUsu, String nombre, String contrasenia, String dni);

	public void eliminarUsu(String dni);
	public void modificarUsu(String nombre,String contrasenia,String dni);

	/*
	 * Metodo encargado de subir los datos de clubes a la tabla clubes
	 */
	public void subidaDatosClub(long idClub, String nombre);
	public void eliminarClub(String nombre);
	public void modificarClub(String nombre,String dato);
	/*
	 * Metodo encargado de hacer las consultas a las tabla de usuarios de las BD
	 */
	public ResultSet consultaDatosUsu();

	/*
	 * Metodo encargado de hacer las consultas a las tabla de clubes de las BD
	 */
	public ResultSet consultaDatosClub();
}
