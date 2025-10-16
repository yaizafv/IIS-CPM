package uo.cpm.p6.model;

import java.util.*;

import uo.cpm.p6.util.FileUtil;

public class Carta {

	private static final String FICHERO_ARTICULOS = "files/articulos.dat";
	private List<Articulo> listaArticulos = null;

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

	public Articulo[] getProducto(String tipo) {
		List<Articulo> listaFiltrada = new ArrayList<Articulo>();
		if (tipo.equals("Todos")) {
			return listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		}
		for (Articulo a : listaArticulos) {
			if (a.getTipo().equals(tipo)) {
				listaFiltrada.add(a);
			}
		}
		return listaFiltrada.toArray(new Articulo[listaFiltrada.size()]);
	}

}
