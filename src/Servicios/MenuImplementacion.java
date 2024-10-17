package Servicios;

import java.util.Scanner;

/*
 * Clase encarda de contener la logica de los metodos de los menus
 */
public class MenuImplementacion implements MenuInterfaz {
	Scanner sc = new Scanner(System.in);

	@Override
	public int mostrarMenuIncial() {
		int opc;
		System.out.println("Seleccione una opcion");
		System.out.println("0.Cerra Menu");
		System.out.println("1.Personas Independientes");
		System.out.println("2.Clubs");
		opc = sc.nextInt();

		return opc;
	}

	@Override
	public int mostrarMenuPersonasIndepencientes() {
		int opc;
		System.out.println("Seleccione una opcion");
		System.out.println("0.Cerra Menu");
		System.out.println("1.Registrar Motos");
		System.out.println("2.Crear Rutas");
		System.out.println("3.Apuntarse Rutas");
		System.out.println("4.Apuntarse Eventos");
		System.out.println("5.Registrarse Clubs");
		opc = sc.nextInt();

		return opc;
	}

	@Override
	public void mostrarMenuUsuario() {
		MenuInterfaz mi = new MenuImplementacion();
		OperacionesBDInterfaz opBD= new OperacionesBDImplementacion();
		OperativaInterfaz op= new OperativaImplementacion();
		boolean cerrarMenu = false;
		int opc;
		while (!cerrarMenu) {
			System.out.println("Seleccione una opcion");
			System.out.println("0.Cerrar Menu");
			System.out.println("1.Crear nuevo Usuario");
			System.out.println("2.Eliminar Usuario");
			System.out.println("3.Modificar Usuario");
			System.out.println("4.Login Usuario");

			opc = sc.nextInt();

			switch (opc) {
			case 0:
				System.out.println("Se cerrara el menu");

				cerrarMenu = true;
				System.out.println("#######################################");
				break;

			case 1:
				System.out.println("Selecciono Crear nuevo cliente");
				op.registroUsu();
				System.out.println("#######################################");
				break;
			case 2:
				System.out.println("Selecciono Eliminar cliente");
				op.eliminarUsu();
				System.out.println("#######################################");
				break;
			case 3:
				System.out.println("Selecciono Modificar cliente");
				op.modificarUsu();
				System.out.println("#######################################");
				break;
			case 4:
				System.out.println("Selecciono Login Usuario");
				op.loginUsu();
				System.out.println("#######################################");
				break;
				
				
			default:
				System.out.println("Esta opcion no existe");

				break;
			}
		}

	}

	@Override
	public void mostrarMenuClubs() {
		MenuInterfaz mi = new MenuImplementacion();
		OperacionesBDInterfaz opBD= new OperacionesBDImplementacion();
		OperativaInterfaz op= new OperativaImplementacion();
		boolean cerrarMenu = false;
		int opc;
		while (!cerrarMenu) {
			System.out.println("Seleccione una opcion");
			System.out.println("0.Cerrar Menu");
			System.out.println("1.Crear nuevo club");
			System.out.println("2.Eliminar club");
			System.out.println("3.Modificar club");

			opc = sc.nextInt();

			switch (opc) {
			case 0:
				System.out.println("Se cerrara el menu");

				cerrarMenu = true;
				System.out.println("#######################################");
				break;

			case 1:
				System.out.println("Selecciono Crear nuevo club");
				op.registroClub();
				System.out.println("#######################################");
				break;
			case 2:
				System.out.println("Selecciono Eliminar club");
				op.eliminarClub();
				System.out.println("#######################################");
				break;
			case 3:
				System.out.println("Selecciono Modificar club");
				op.modificarClub();
				System.out.println("#######################################");
				break;

			default:
				System.out.println("Esta opcion no existe");

				break;
			}
		}
		
	}

}
