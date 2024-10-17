package Dtos;

/*
 * Dtos que contiene los datos de los usuarios
 */
public class DtoUsuario {
	long idUsuario;
	String nombreUsu;
	String contrasenia;
	String dni;



	public DtoUsuario() {
		super();
	}

	public DtoUsuario(long idUsuario, String nombreUsu, String contrasenia,String dni) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsu = nombreUsu;
		this.contrasenia = contrasenia;
		this.dni = dni;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}
	

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String toStringUsu() {
		return "DtoUsuario [IdUsuario=" + idUsuario + ", NombreUsu=" + nombreUsu + ", Contrasenia=" + contrasenia + "]";
	}

}
