package Servicios;

/*
 * Clase interfaz encargada de contener las cabeceras de los metodos de la operativa
 */
public interface OperativaInterfaz {
	/*
	 * Metodo encargado de realizar el registro de usuario
	 */
	public void registroUsu();
	public void modificarUsu();
	public void eliminarUsu();
	
	public void loginUsu();
	
	/*
	 * Metodo encargado de realizar el registro de clubes
	 */
	public void registroClub();
	public void modificarClub();
	public void eliminarClub();
}
