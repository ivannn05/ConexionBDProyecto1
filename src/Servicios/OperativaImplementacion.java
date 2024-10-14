package Servicios;

import java.util.Scanner;

import Controladores.Inicio;
import Dtos.DtoClubs;
import Dtos.DtoUsuario;
import Utilidades.Util;

public class OperativaImplementacion implements OperativaInterfaz {
Scanner sc= new Scanner(System.in);
ConexionInterfaz ci= new ConexionImplementacion();
	@Override
	public void registroUsu() {
		DtoUsuario usuario = new DtoUsuario();
		
		long idUsu=Util.autogeneracionIdUsu();
		usuario.setIdUsuario(idUsu);
		System.out.println("Escriba el nombre del nuevo usuario");
		String nombre=sc.next();
		usuario.setNombreUsu(nombre);
		
		System.out.println("Escriba su contraseña de registro");
		String contrasenia=sc.next();
		usuario.setContrasenia(contrasenia);
		
		ci.subidaDatosUsu(idUsu,nombre,contrasenia);
		Inicio.listaUsus.add(usuario);
		
	}

	public void registroClub() {
		DtoClubs club = new DtoClubs();		
		long idClub=Util.autogeneracionIdClub();
		club.setId_club(idClub);
		System.out.println("Escriba el nombre del nuevo club");
		String nombre=sc.next();
		club.setNombre(nombre);
		
		ci.subidaDatosClub(idClub,nombre);
		Inicio.listaClubes.add(club);
		
	}
}
