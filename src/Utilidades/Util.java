package Utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;

import Controladores.Inicio;
import Dtos.DtoClubs;
import Dtos.DtoUsuario;
import Servicios.ConexionImplementacion;
import Servicios.ConexionInterfaz;
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
	 * Metodo encargado de meter en la lista de usuarios los datos de la base de datos
	 */
	public static void meterEnListaDatosUsuBD() {
		ConexionInterfaz ci = new ConexionImplementacion();
		ResultSet resultadoConsulta = ci.consultaDatosUsu();

		// Leemos el resultado de la consulta hasta que no queden filas
		try {
			while (resultadoConsulta.next()) {

				Inicio.listaUsus.add(new DtoUsuario(resultadoConsulta.getLong("id_usu"),
						resultadoConsulta.getString("nombre"), resultadoConsulta.getString("contraseña")));
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
	 * Metodo encargado de meter en la lista de los clubes los datos de la base de datos
	 */
	public static void meterEnListaDatosClubsBD() {
		ConexionInterfaz ci = new ConexionImplementacion();
		ResultSet resultadoConsulta = ci.consultaDatosClub();

		// Leemos el resultado de la consulta hasta que no queden filas
		try {
			while (resultadoConsulta.next()) {

				Inicio.listaClubes.add(new DtoClubs(resultadoConsulta.getLong("id_club"),
						resultadoConsulta.getString("nombre")));
			}

			int i = Inicio.listaClubes.size();
			System.out.println("[INFORMACIÓN-ADto-resultsDtoClubes] Número clubes: " + i);
			System.out.println("#############################");

		} catch (SQLException e) {
			System.err
					.println("[ERROR-ADto-resultsAClubsDto] Error al pasar el result set a lista de DtoClubes" + e);
		}

	}

}
