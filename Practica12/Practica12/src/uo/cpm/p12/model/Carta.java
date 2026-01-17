package uo.cpm.p12.model;

import java.util.*;

import uo.cpm.p12.util.FileUtil;

public class Carta {

	private static final String FICHERO_ARTICULOS = "files/articulos.dat";
	private List<Articulo> listaArticulos = null;
	private String tipoFiltro = null;

	public Carta() {
		listaArticulos = new ArrayList<Articulo>();
		cargarArticulos();
	}

	private void cargarArticulos() {
		FileUtil.loadFile(FICHERO_ARTICULOS, listaArticulos);
	}

	public Articulo[] getArticulos() {
		Articulo[] articulos = listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		return articulos;
	}

	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	public void setTipoFiltro(String tipo) {
		tipoFiltro = tipo;
	}

	public boolean isArticuloFiltrado(int posicion) {
		if (listaArticulos.get(posicion).getTipo().equals(tipoFiltro) || tipoFiltro.equals("Todos")) {
			return true;
		}
		return false;
	}
}
