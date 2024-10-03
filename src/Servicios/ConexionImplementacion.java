package Servicios;

import java.sql.Connection;
import java.sql.DriverManager;

import org.postgresql.ds.PGSimpleDataSource;

public class ConexionImplementacion implements ConexionInterfaz {

	@Override
	public void ConexionBaseDatos() {

		PGSimpleDataSource dataSource = new PGSimpleDataSource();
		String url = "jdbc:postgresql://localhost:5432/ProyectoMotos";

		String usuario = "postgres";
		String contraseña = "LW;+5,(*ui>B";

		try {
			// Cargar el controlador de la base de datos (opcional desde JDBC 4.0)

			Class.forName("org.postgresql.Driver");

			// Obtener la conexión usando DriverManager

			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

			if (conexion != null) {

				System.out.println("Conexión establecida con éxito.");

				conexion.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
