package uo.cpm.mcd.model;

import java.util.*;

import uo.cpm.mcd.util.FileUtil;

public class Carta {

	private static final String FICHERO_ARTICULOS = "files/articulos.dat";
	private List<Articulo> listaArticulos = null;
	private List<Articulo> listaArticulosFiltrados =null;

	public Carta() {
		listaArticulos = new ArrayList<Articulo>();
		listaArticulosFiltrados = new ArrayList<Articulo>();
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
	
	public void filtrar(String tipo) {
		listaArticulosFiltrados.clear();
		for (Articulo a : listaArticulos)
			if (tipo.equals("Todos"))
				listaArticulosFiltrados.add(a);
			else if (a.getTipo().equals(tipo))
				listaArticulosFiltrados.add(a);
	}

	public boolean isArticuloFiltrado(int PosicionEnCarta) {
		for (Articulo a : listaArticulosFiltrados)
			if (a.getCodigo().equals(listaArticulos.get(PosicionEnCarta).getCodigo()))
				return true;
		return false;

	}
	
}
