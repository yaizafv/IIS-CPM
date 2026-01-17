package uo.cpm.mcd.service;

import java.time.LocalDateTime;
import java.util.List;

import uo.cpm.mcd.model.*;
import uo.cpm.mcd.model.Cliente;

public class McDonalds {
	Carta carta = new Carta();
	Pedido pedido = new Pedido(); 
	

	public String[] getRangoAnios() {
		int anioActual = LocalDateTime.now().getYear();
		int rango = Cliente.EDAD_MAX-Cliente.EDAD_MIN;
		String[]anios = new String[rango];
		for (int i=0;i<rango;i++)
			anios[i] = String.valueOf((anioActual-Cliente.EDAD_MIN)-i);
		return anios;
	}
	
	public Articulo[] getArticulosCarta() {
			return carta.getArticulos();
	}
	
	public int getNumArticulos() {
		return carta.getArticulos().length;
	}
	
	public void inicializarPedido() {
		pedido.inicializar();
	}
	
	
	public String getCodigoPedido() {
		return pedido.getCodigo();
	}
	
	
	public Pedido aniadirAPedido(Articulo articulo, int unidades) {
		return pedido.add(articulo, unidades);
	
	}

	
	public void eliminarDePedido(Articulo articulo, int unidades) {
		pedido.remove(articulo, unidades);
	}

	public boolean esBebida(Articulo a) {
		 if (a.getTipo().equals("Bebida"))
			 return true;
		return false; 
	}
	
	public float getImportePedido() {
		return pedido.getImporte();
	}
	
	public void grabarPedido() {
		pedido.grabarPedido();
	}
	
	
	public int buscarUnidades(Articulo a) {
		return pedido.buscarUnidades(a);
	}
	
	
	public boolean sePuedenEliminar( Articulo a,int unidades){
		return pedido.sePuedenEliminar(a,unidades);
	}
	
		
	public int cuantasUnidades(Articulo articuloSeleccionado) {
		return pedido.buscarUnidades(articuloSeleccionado);
	}
	
	public void guardarCliente(String nombre, int anio, String password) {
		pedido.setCliente(new Cliente(nombre, anio, password));
	}
	
	public void actualizarTipoPedido (boolean llevar) {
		pedido.actualizarTipoPedido(llevar);	
	}
		
	public String getTextoPedido() {
		return pedido.toString();
	}
	
	public boolean noHayUnidadesArticulo(Articulo a) {
		return pedido.noHayUnidadesArticulo(a);
	}
	
	public boolean noHayPedido() {
		return pedido.noHayPedido();
	}
	
	public Articulo getArticulo(int i) {
	   return carta.getListaArticulos().get(i);
   }

	public String getCodigoArticulo(int i) {
		return carta.getArticulos()[i].getCodigo();
	}

	public String getToStringArticulo(int i) {
		return carta.getArticulos()[i].toString();
	}
		
	 public List<Articulo> getArticulosEnPedido(String tipo) {
		  return pedido.getArticulosEnPedido(tipo);
	 }

	public void filtrar(String tipo) {
			carta.filtrar(tipo);
	}
	 
	public boolean isArticuloFiltrado(int posicionEnCarta) {
			return carta.isArticuloFiltrado(posicionEnCarta);
	}

	public String toString() {
		return pedido.toString();
	}
	
}
