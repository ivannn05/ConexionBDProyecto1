package Servicios;

import java.util.Scanner;

import Controladores.Inicio;
import Dtos.DtoClubs;
import Dtos.DtoUsuario;
import Utilidades.Util;

/*
 * Clase implementacion encargada de contener la logica de los metodos de la app
 */
public class OperativaImplementacion implements OperativaInterfaz {
	Scanner sc = new Scanner(System.in);
	ConexionInterfaz ci = new ConexionImplementacion();
	OperacionesBDInterfaz opBD = new OperacionesBDImplementacion();

	@Override
	public void registroUsu() {
		DtoUsuario usuario = new DtoUsuario();

		long idUsu = Util.autogeneracionIdUsu();
		usuario.setIdUsuario(idUsu);
		System.out.println("Escriba el nombre del nuevo usuario");
		String nombre = sc.next();
		usuario.setNombreUsu(nombre);

		System.out.println("Escriba su contraseña de registro");
		String contrasenia = sc.next();
		String contraseniaEncriptada= Util.encriptarContraseña(contrasenia);
		usuario.setContrasenia(contraseniaEncriptada);
		System.out.println("Escriba el dni del nuevo usuario");
		String dni = sc.next();
		usuario.setNombreUsu(dni);

		opBD.subidaDatosUsu(idUsu, nombre, contraseniaEncriptada, dni);
		Inicio.listaUsus.add(usuario);

	}

	public void registroClub() {
		DtoClubs club = new DtoClubs();
		long idClub = Util.autogeneracionIdClub();
		club.setId_club(idClub);
		boolean existe;
		String nombre;

		do {
			existe = false;

			System.out.println("Escriba el nombre del nuevo club");
			nombre = sc.next();

			for (DtoClubs consulta : Inicio.listaClubes) {
				if (nombre.equals(consulta.getNombre())) {
					existe = true;
				}
			}

			if (existe) {
				System.out.println("Este nombre ya existe, por favor elija otro.");
			}

		} while (existe);

		club.setNombre(nombre);

		opBD.subidaDatosClub(idClub, nombre);
		Inicio.listaClubes.add(club);

	}

	@Override
	public void modificarUsu() {
		int contador = 0;
		System.out.println("Indique el DNI del alumno a modificar");
		String DNI = sc.next();
		for (DtoUsuario usu : Inicio.listaUsus) {

			if (usu.getDni().equals(DNI)) {
				contador++;
				System.out.println("Seleccione el numero para modificar \n 1=Nombre \n 2=Contraseña");
				int opc = sc.nextInt();
				switch (opc) {
				case 1:
					String nuevoNombreString;
					System.out.println("Escriba el nuevo nombre");
					nuevoNombreString = sc.next();
					opBD.modificarUsu(nuevoNombreString, usu.getContrasenia(), usu.getDni());
					usu.setNombreUsu(nuevoNombreString);
					System.out.println("Nombre Modificada");

					break;
				case 2:
					String nuevoContrasenia;
					System.out.println("Escriba la nueva contraseña");
					nuevoContrasenia = sc.next();
					String contraseñaEncriptada= Util.encriptarContraseña(nuevoContrasenia);
					opBD.modificarUsu(usu.getNombreUsu(), contraseñaEncriptada, usu.getDni());
					usu.setContrasenia(contraseñaEncriptada);
					System.out.println("Contraseña Modificada");
					break;

				default:
					System.out.println("Esta opcion no existe");
					break;
				}

			}
		}
		if (contador == 0) {
			System.out.println("Este DNI no existe");
		}
	}

	@Override
	public void eliminarUsu() {
		System.out.println("Indique el DNI del usuario a eliminar");
		String DNI = sc.next();
		int aux = 0;

		DtoUsuario usuarioAEliminar = new DtoUsuario();
		for (DtoUsuario usu : Inicio.listaUsus) {
			if (DNI.equals(usu.getDni())) {
				usuarioAEliminar = usu;
				aux = 1;
				break;
			}

		}
		if (aux == 1) {
			System.out.println("Se elimino el usuario");
		}
		opBD.eliminarUsu(DNI);
		Inicio.listaUsus.remove(usuarioAEliminar);
	}

	@Override
	public void modificarClub() {
		int contador = 0;
		System.out.println("Indique el nombre del club a modificar");
		String nombre = sc.nextLine();
		for (DtoClubs club : Inicio.listaClubes) {

			if (club.getNombre().equals(nombre)) {
				contador++;
				System.out.println("Seleccione el numero para modificar \n 1=Datos ");
				int opc = sc.nextInt();
				switch (opc) {
				case 1:
					String nuevoDatoString;
					System.out.println("Escriba el nuevo dato");
					nuevoDatoString = sc.nextLine();
					opBD.modificarClub(club.getNombre(),nuevoDatoString);
					club.setDatos(nuevoDatoString);
					System.out.println("Dato Modificado");

					break;
				/*
				 * case 2: String nuevoContrasenia; nuevoContrasenia = sc.next();
				 * System.out.println("Escriba la nueva contraseña");
				 * opBD.modificarUsu(usu.getNombreUsu(), nuevoContrasenia, usu.getDni());
				 * usu.setContrasenia(nuevoContrasenia);
				 * System.out.println("Contraseña Modificada"); break;
				 */
				default:
					System.out.println("Esta opcion no existe");
					break;
				}

			}
		}
		if (contador == 0) {
			System.out.println("Este nombre de club no existe");
		}

	}

	@Override
	public void eliminarClub() {
		System.out.println("Indique el Nombre del club a eliminar");
		String nombre = sc.next();
		int aux = 0;

		DtoClubs clubAEliminar = new DtoClubs();
		for (DtoClubs club : Inicio.listaClubes) {
			if (nombre.equals(club.getNombre())) {
				clubAEliminar = club;
				aux = 1;
				break;
			}

		}
		if (aux == 1) {
			System.out.println("Se elimino el club");
		}
		opBD.eliminarClub(nombre);
		Inicio.listaClubes.remove(clubAEliminar);
	}

	@Override
	public void loginUsu() {
		int aux=0;
		do {
			System.out.println("Bienvenido ChopperCompany");
			System.out.println(" \t Inicio de sesion");
			System.out.println("-Indique su nombre");
			String nombreUsu=sc.next();
			System.out.println("-Indique su contraseña");
			String contraseniaUsu=sc.next();
			String contraseniaEncriptada=Util.encriptarContraseña(contraseniaUsu);
			for (DtoUsuario usu : Inicio.listaUsus) {
				if (usu.getNombreUsu().equals(nombreUsu) && usu.getContrasenia().equals(contraseniaEncriptada)) {
					System.out.println("----------Bienvenido señ@r ".concat(usu.getNombreUsu()).concat("----------"));
					aux=1;
				}
				
			}
			if (aux==0) {
				System.err.println("Nombre o Contraseña no correctos");
				System.out.println("###########################");
			}
		} while (aux==0);
		
		
	}

}

















