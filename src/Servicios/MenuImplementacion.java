package Servicios;

import java.util.Scanner;

/*
 * Clase encarda de contener la logica de los metodos de los menus
 */
public class MenuImplementacion implements MenuInterfaz {
	Scanner sc = new Scanner(System.in);

	@Override
	public int MostrarMenuIncial() {
		int opc;
		System.out.println("Seleccione una opcion");
		System.out.println("0.Cerra Menu");
		System.out.println("1.Personas Independientes");
		System.out.println("2.Clubs");
		opc = sc.nextInt();

		return opc;
	}

	@Override
	public int MostrarMenuPersonasIndepencientes() {
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

}
