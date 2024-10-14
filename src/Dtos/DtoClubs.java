package Dtos;

/*
 * Dtos que contiene los datos de los clubs
 */
public class DtoClubs {
	long id_club;
	String nombre = "aaaa";

	

	public DtoClubs(long id_club, String nombre) {
		super();
		this.id_club = id_club;
		this.nombre = nombre;
	}

	public DtoClubs() {
		super();
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
