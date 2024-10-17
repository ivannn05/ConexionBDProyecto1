package Servicios;

/*
 * Clase interfaz encargada de contener las cabeceras de los metodos de los menus
 */
public interface MenuInterfaz {
	/*
	 * Metodo encargado de mostrar el menu principal
	 */
	public int mostrarMenuIncial();
	/*
	 * Metodo encargado de mostrar el menu Usuarios
	 */
	public int mostrarMenuPersonasIndepencientes();
	
	public void mostrarMenuUsuario();
	public void mostrarMenuClubs();

}
