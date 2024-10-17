package Utilidades;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controladores.Inicio;
import Dtos.DtoClubs;
import Dtos.DtoUsuario;
import Servicios.ConexionImplementacion;
import Servicios.ConexionInterfaz;
import Servicios.OperacionesBDImplementacion;
import Servicios.OperacionesBDInterfaz;

/*
 * Clase encargada de contener la logica de los metodos utiles de la aplicacion
 */
public class Util {
	/*
	 * Metodo encargado de autogenerar la id de los usuarios
	 */
	public static long autogeneracionIdUsu() {
		long id;
		if (Inicio.listaUsus.size() == 0) {
			id = 1;
		} else {
			id = Inicio.listaUsus.get(Inicio.listaUsus.size() - 1).getIdUsuario() + 1;
		}

		return id;
	}

	/*
	 * Metodo encargado de autogenerar la id de clubes
	 */
	public static long autogeneracionIdClub() {
		long id;
		if (Inicio.listaClubes.size() == 0) {
			id = 1;
		} else {
			id = Inicio.listaClubes.get(Inicio.listaClubes.size() - 1).getId_club() + 1;
		}

		return id;
	}

	/*
	 * Metodo encargado de meter en la lista de usuarios los datos de la base de
	 * datos
	 */
	public static void meterEnListaDatosUsuBD() {
		ConexionInterfaz ci = new ConexionImplementacion();
		OperacionesBDInterfaz opBD = new OperacionesBDImplementacion();
		ResultSet resultadoConsulta = opBD.consultaDatosUsu();

		// Leemos el resultado de la consulta hasta que no queden filas
		try {
			while (resultadoConsulta.next()) {

				Inicio.listaUsus
						.add(new DtoUsuario(resultadoConsulta.getLong("id_usu"), resultadoConsulta.getString("nombre"),
								resultadoConsulta.getString("contraseña"), resultadoConsulta.getString("dni")));
			}

			int i = Inicio.listaUsus.size();
			System.out.println("[INFORMACIÓN-ADto-resultsDtoUsuario] Número usuarios: " + i);
			System.out.println("#############################");

		} catch (SQLException e) {
			System.err
					.println("[ERROR-ADto-resultsAUsuarioDto] Error al pasar el result set a lista de DtoUsuarios" + e);
		}

	}

	/*
	 * Metodo encargado de meter en la lista de los clubes los datos de la base de
	 * datos
	 */
	public static void meterEnListaDatosClubsBD() {
		ConexionInterfaz ci = new ConexionImplementacion();
		OperacionesBDInterfaz opBD = new OperacionesBDImplementacion();

		ResultSet resultadoConsulta = opBD.consultaDatosClub();

		// Leemos el resultado de la consulta hasta que no queden filas
		try {
			while (resultadoConsulta.next()) {

				Inicio.listaClubes
						.add(new DtoClubs(resultadoConsulta.getLong("id_club"), resultadoConsulta.getString("nombre"),resultadoConsulta.getString("datos")));
			}

			int i = Inicio.listaClubes.size();
			System.out.println("[INFORMACIÓN-ADto-resultsDtoClubes] Número clubes: " + i);
			System.out.println("#############################");

		} catch (SQLException e) {
			System.err.println("[ERROR-ADto-resultsAClubsDto] Error al pasar el result set a lista de DtoClubes" + e);
		}

	}
	
	
	public static String encriptarContraseña(String password) {
        try {
            // Creamos una instancia de MessageDigest con el algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convertimos la contraseña a bytes y generamos el hash
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convertimos los bytes a una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            // Retornamos el hash en formato de String
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }	
	
	
	

}
