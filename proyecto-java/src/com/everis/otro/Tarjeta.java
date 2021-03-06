package com.everis.otro;

public class Tarjeta {
	private int id;
	private String nombre;
	private String eMail;

	public Tarjeta(int id, String nombre, String eMail) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.eMail = eMail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", nombre=" + nombre + ", eMail=" + eMail + "]";
	}

}
