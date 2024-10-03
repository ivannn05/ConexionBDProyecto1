package Utilidades;

import Controladores.Inicio;

public class Util {

	public static long autogeneracionIdUsu() {
		long id;
		if (Inicio.listaUsus.size()==0) {
			id=1;
		}else {
			id=Inicio.listaUsus.get(Inicio.listaUsus.size()-1).getIdUsuario()+1;
		}
		
		return id;
	}
}
