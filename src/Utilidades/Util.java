package Utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;

import Controladores.Inicio;
import Dtos.DtoUsuario;
import Servicios.ConexionImplementacion;
import Servicios.ConexionInterfaz;

public class Util {

	public static long autogeneracionIdUsu() {
		long id;
		if (Inicio.listaUsus.size() == 0) {
			id = 1;
		} else {
			id = Inicio.listaUsus.get(Inicio.listaUsus.size() - 1).getIdUsuario() + 1;
		}

		return id;
	}

	public static long autogeneracionIdClub() {
		long id;
		if (Inicio.listaClubes.size() == 0) {
			id = 1;
		} else {
			id = Inicio.listaClubes.get(Inicio.listaClubes.size() - 1).getId_club() + 1;
		}

		return id;
	}
	
	public static void meterEnListaDatosBD() {
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
					.println("[ERROR-ADto-resultsALibrosDto] Error al pasar el result set a lista de DtoUsuarios" + e);
		}

	}

}
