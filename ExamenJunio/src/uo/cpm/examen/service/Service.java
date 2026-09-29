package uo.cpm.examen.service;

import java.util.List;

import uo.cpm.examen.model.Cine;
import uo.cpm.examen.model.Cliente;
import uo.cpm.examen.model.Pelicula;

public class Service {
	
	private Cine cine = new Cine();

	public void guardarDni(String text) {
		cine.guardarDni(text);
		
	}

	public List<Pelicula> getPeliculas() {
		return cine.getPeliculas();
	}

	public void inicializar() {
		cine.inicializar();
		
	}

	public Cliente getClienteVipSesion() {
		return cine.getClienteVipSesion();
	}
	
	public boolean isVip() {
		return cine.isVip();
	}

	public void limpiarVip() {
		cine.limpiarVip();
		
	}

	public float calcularPrecio(Pelicula pelicula) {
		return cine.calcularPrecio(pelicula);
	}

	public void setNumEntradas(int value) {
		cine.setNumEntradas(value);
		
	}

	public int getNumCasillas() {
		return cine.getNumCasillas();
	}

	public int getIndexCasillaPremio() {
		return cine.getIndexCasillaPremio();
	}

}
