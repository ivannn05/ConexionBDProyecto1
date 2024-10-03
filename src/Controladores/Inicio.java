package Controladores;

import java.util.ArrayList;
import java.util.List;

import Dtos.DtoUsuario;
import Servicios.ConexionImplementacion;
import Servicios.ConexionInterfaz;
import Servicios.MenuImplementacion;
import Servicios.MenuInterfaz;

public class Inicio {
	public static List<DtoUsuario> listaUsus= new ArrayList<DtoUsuario>();
		


	public static void main(String[] args) {
		ConexionInterfaz ci = new ConexionImplementacion();
		MenuInterfaz mi = new MenuImplementacion();
		try {
			ci.ConexionBaseDatos();
		} catch (Exception e) {
			System.out.println("Ocurrio un error en la conexion");
		}

		int opc;
		boolean cerrarMenu = false;
		do {
			opc = mi.MostrarMenuIncial();
			switch (opc) {
			case 0:
				System.out.println("Se cerrara la aplicacion");
				cerrarMenu=true;
				break;
			case 1:
				System.out.println("Entro en Personas Independientes");
				
				break;
			case 2:
				System.out.println("Entro en clubs");

				break;

			default:
				System.out.println("Esta opcion no existe");
				break;
			}

		} while (!cerrarMenu);

	}

}
