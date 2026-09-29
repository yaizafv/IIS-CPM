package uo.cpm.examen.model;

public class Pelicula {
	
	private String titulo;
	private String genero;
	private String sala;
	private float precio;
	
	public Pelicula(String titulo, String genero, String sala, float precio) {
		this.titulo = titulo;
		this.genero = genero;
		this.sala = sala;
		this.precio = precio;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		String strPelicula;
		strPelicula = this.titulo + " - " + this.genero + " - " + this.sala + " - " + this.precio + " �";
		return strPelicula;
	}
	
	
	

}
