package Dtos;

/*
 * Dtos que contiene los datos de los clubs
 */
public class DtoClubs {
	long id_club;
	String nombre = "aaaa";
	String datos="aaaa";

	

	public DtoClubs(long id_club, String nombre,String datos) {
		super();
		this.id_club = id_club;
		this.nombre = nombre;
		this.datos=datos;
	}

	public DtoClubs() {
		super();
	}
	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}


	public long getId_club() {
		return id_club;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId_club(long id_club) {
		this.id_club = id_club;
	}

}
