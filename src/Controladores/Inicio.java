package Controladores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicSplitPaneUI.BasicHorizontalLayoutManager;

import Dtos.DtoClubs;
import Dtos.DtoUsuario;
import Servicios.ConexionImplementacion;
import Servicios.ConexionInterfaz;
import Servicios.MenuImplementacion;
import Servicios.MenuInterfaz;
import Servicios.OperativaImplementacion;
import Servicios.OperativaInterfaz;
import Utilidades.Util;

/*
 * Clase principal de la app
 */
public class Inicio {
	public static List<DtoUsuario> listaUsus = new ArrayList<DtoUsuario>();
	public static List<DtoClubs> listaClubes = new ArrayList<DtoClubs>();

	/*
	 * Metodo por el cual se lazara la app
	 */
	public static void main(String[] args) {
		ConexionInterfaz ci = new ConexionImplementacion();
		MenuInterfaz mi = new MenuImplementacion();
		OperativaInterfaz op = new OperativaImplementacion();
		try {
			ci.conexionBaseDatos();

		} catch (Exception e) {
			System.out.println("Ocurrio un error en la conexion");
		}

		try {
			Util.meterEnListaDatosUsuBD();
			Util.meterEnListaDatosClubsBD();
		} catch (Exception e) {
			System.out.println("Ocurrio un error en la carga de datos");
		}

		int opc;
		boolean cerrarMenu = false;
		do {
			opc = mi.mostrarMenuIncial();
			switch (opc) {
			case 0:
				System.out.println("Se cerrara la aplicacion");
				cerrarMenu = true;
				break;
			case 1:
				System.out.println("Entro en Personas Independientes");
				
				mi.mostrarMenuUsuario();
				break;
			case 2:
				System.out.println("Entro en clubs");
				mi.mostrarMenuClubs();

				break;

			default:
				System.out.println("Esta opcion no existe");
				break;
			}

		} while (!cerrarMenu);

	}

}
