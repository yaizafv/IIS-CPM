package uo.cpm.examen.model;

import java.util.ArrayList;
import java.util.List;

import uo.cpm.examen.util.FileUtil;

public class Cine {

	private List<Pelicula> peliculas;
	private List<Cliente> vips;
	private Cliente clienteVipSesion;
	private int numEntradas;
	
	private Tablero tablero;

	static final String FILENAME_PELICULAS = "files/peliculas.dat";
	static final String FILENAME_VIPS = "files/peliculas.dat";

	public Cine() {
		peliculas = new ArrayList<Pelicula>();
		vips = new ArrayList<Cliente>();
		inicializar();
	}

	public void inicializar() {
		cargarPeliculas(FILENAME_PELICULAS, peliculas);
		cargarVips(FILENAME_VIPS, vips);
		tablero = new Tablero();
		clienteVipSesion = new Cliente(false, "");
	}

	public void cargarPeliculas(String filename, List<Pelicula> peliculas) {
		FileUtil.loadFile(filename, peliculas);
	}

	public void cargarVips(String filename, List<Cliente> vips) {
		FileUtil.loadVips(filename, vips);
	}

	public void guardarDni(String dni) {
		for (Cliente cliente : vips) {
			if (cliente.getDni().equals(dni)) {
				clienteVipSesion.setDni(dni);
				clienteVipSesion.setVip(true);
			}
		}

	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public Cliente getClienteVipSesion() {
		return clienteVipSesion;
	}

	public int getNumEntradas() {
		return numEntradas;
	}

	public String toString() {
		String text = "";
		for (Pelicula pelicula : peliculas) {
			text += pelicula.toString();
		}
		return text;
	}

	public boolean isVip() {
		return getClienteVipSesion() != null;
	}

	public void limpiarVip() {
		setClienteVipSesion(null);
	}

	private void setClienteVipSesion(Cliente clienteVipSesion) {
		this.clienteVipSesion = clienteVipSesion;
	}

	public float calcularPrecio(Pelicula pelicula) {
		float precio;
		if (clienteVipSesion == null) {
			precio = pelicula.getPrecio() * getNumEntradas();
		} else {
			int contador = getNumEntradas();
			precio = pelicula.getPrecio() * getNumEntradas() - contador;
		}
		return precio;
	}

	public void setNumEntradas(int value) {
		this.numEntradas = value;

	}

	public int getNumCasillas() {
		return tablero.getNumCasillas();
	}

	public Casilla getCasillaPremio() {
		return tablero.getCasillaPremio();
	}
	
	public int getIndexCasillaPremio() {
		return tablero.getIndexCasillaPremio();
	}

}
