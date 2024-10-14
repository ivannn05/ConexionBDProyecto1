package Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

public class ConexionImplementacion implements ConexionInterfaz {

	@Override
	public Connection ConexionBaseDatos() {

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

	@Override
	public void subidaDatosUsu(long idUsu, String nombre, String contrasenia) {
		try {
			Connection conexion = ConexionBaseDatos();
			String query = "INSERT INTO \"esquemaUsus\".usuarios (id_usu, nombre, contraseña) VALUES (?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setLong(1, idUsu);
			ps.setString(2, nombre);
			ps.setString(3, contrasenia);
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet consultaDatosUsu() {
		ResultSet resultSet = null;

		try {
			Connection conexion = ConexionBaseDatos();

			String query = "SELECT * FROM \"esquemaUsus\".usuarios";

			PreparedStatement ps = conexion.prepareStatement(query);

			resultSet = ps.executeQuery();
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return resultSet;
		}
		return resultSet;

	}

	@Override
	public void subidaDatosClub(long idClub, String nombre) {
		try {
			Connection conexion = ConexionBaseDatos();
			String query = "INSERT INTO \"esquemaUsus\".clubes (id_club, nombre) VALUES (?, ?)";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setLong(1, idClub);
			ps.setString(2, nombre);
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet consultaDatosClub() {
		ResultSet resultSet = null;

		try {
			Connection conexion = ConexionBaseDatos();

			String query = "SELECT * FROM \"esquemaUsus\".clubes";

			PreparedStatement ps = conexion.prepareStatement(query);

			resultSet = ps.executeQuery();
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return resultSet;
		}
		return resultSet;
	}

}
