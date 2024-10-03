package Dtos;

public class DtoUsuario {
	long idUsuario;
	String nombreUsu;
	String contrasenia;

	public DtoUsuario() {
		super();
	}

	public DtoUsuario(long idUsuario, String nombreUsu, String contrasenia) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsu = nombreUsu;
		this.contrasenia = contrasenia;
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

}
