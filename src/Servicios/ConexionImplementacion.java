package Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

/*
 * Implementacion que contiene la logica de los metodos de conexion con la base de datos
 */
public class ConexionImplementacion implements ConexionInterfaz {

	@Override
	public Connection conexionBaseDatos() {

		PGSimpleDataSource dataSource = new PGSimpleDataSource();
		String url = "jdbc:postgresql://localhost:5432/ProyectoMotos";

		String usuario = "postgres";
		String contraseña = "LW;+5,(*ui>B";
		Connection conexion;

		try {
			// Cargar el controlador de la base de datos (opcional desde JDBC 4.0)

			Class.forName("org.postgresql.Driver");

			// Obtener la conexión usando DriverManager

			conexion = DriverManager.getConnection(url, usuario, contraseña);

			if (conexion != null) {

				System.out.println("Conexión establecida con éxito.");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			conexion = null;
		}
		return conexion;

	}

	
}
