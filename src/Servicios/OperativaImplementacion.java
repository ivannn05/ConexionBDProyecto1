package Servicios;

import java.util.Scanner;

import Controladores.Inicio;
import Dtos.DtoUsuario;
import Utilidades.Util;

public class OperativaImplementacion implements OperativaInterfaz {
Scanner sc= new Scanner(System.in);
	@Override
	public void registroUsu() {
		DtoUsuario usuario = new DtoUsuario();
		usuario.setIdUsuario(Util.autogeneracionIdUsu());
		
		System.out.println("Escriba el nombre del nuevo usuario");
		usuario.setNombreUsu(sc.next());
		
		System.out.println("Escriba su contraseña de registro");
		usuario.setContrasenia(sc.next());
		Inicio.listaUsus.add(usuario);
	}

}
