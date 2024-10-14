package Servicios;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ConexionInterfaz {
	public Connection ConexionBaseDatos();

	public void subidaDatosUsu(long idUsu,String nombre,String contrasenia);
	public void subidaDatosClub(long idClub,String nombre);
	public ResultSet consultaDatosUsu();
	public ResultSet consultaDatosClub();
}
