package Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacionesBDImplementacion implements OperacionesBDInterfaz {
	ConexionInterfaz ci = new ConexionImplementacion();

	@Override
	public void subidaDatosUsu(long idUsu, String nombre, String contrasenia, String dni) {
		try {
			Connection conexion = ci.conexionBaseDatos();
			String query = "INSERT INTO \"esquemaUsus\".usuarios (id_usu, nombre, contraseña, dni) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setLong(1, idUsu);
			ps.setString(2, nombre);
			ps.setString(3, contrasenia);
			ps.setString(4, dni);
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
			Connection conexion = ci.conexionBaseDatos();

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
			Connection conexion = ci.conexionBaseDatos();
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
			Connection conexion = ci.conexionBaseDatos();

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

	@Override
	public void eliminarUsu(String dni) {
		try {
			Connection conexion = ci.conexionBaseDatos();
			String query = "DELETE FROM \"esquemaUsus\".usuarios WHERE dni = ?";
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, dni);
			ps.executeUpdate();
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modificarUsu(String nombre, String contrasenia, String dni) {
		try {
			Connection conexion = ci.conexionBaseDatos();

			String query = "UPDATE \"esquemaUsus\".usuarios SET nombre = ?, contraseña = ? WHERE dni = ?";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, contrasenia);
			ps.setString(3, dni);
			ps.executeUpdate();
			conexion.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);

		}

	}

	@Override
	public void eliminarClub(String nombre) {
		try {
			Connection conexion = ci.conexionBaseDatos();
			String query = "DELETE FROM \"esquemaUsus\".clubes WHERE nombre = ?";
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, nombre);
			ps.executeUpdate();
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modificarClub(String nombre,String datos) {
		try {
			Connection conexion = ci.conexionBaseDatos();

			String query = "UPDATE \"esquemaUsus\".clubes SET nombre = ?, datos = ? WHERE nombre = ?";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, datos);
			ps.setString(3, nombre);
			ps.executeUpdate();
			conexion.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);

		}

		
	}

}
