package uo.cpm.p6.service;


import java.time.LocalDateTime;
import java.util.List;

import uo.cpm.p6.model.*;

public class McDonalds {
	Carta carta = new Carta();
	Pedido pedido = new Pedido(); 
	
	
	public McDonalds() {
		inicializarPedido();
	}

	public Articulo[] getArticulosCarta() {
		return carta.getArticulos();
	}
	
	public Articulo[] getProducto(String tipo) {
		return carta.getProducto(tipo);
	}
	
	public List<Articulo> getListaPedido() {
		return pedido.getListaPedido();
	}
	
	public void inicializarPedido() {
		pedido.inicializar();
	}
	
	public String getCodigoPedido() {
		return pedido.getCodigo();
	}

	public void aniadirAPedido(Articulo articulo, int unidades) {
		pedido.add(articulo, unidades);
	}

	public float getImportePedido() {
		return pedido.getImporte();
	}
	
	public boolean estaEnPedido(Articulo articulo) {
		return pedido.estaEnPedido(articulo);
	}
	
	public double getPrecioArticulos() {
		return pedido.calcularPrecioArticulos();
	}
	
	public void guardarCliente(String nombre, int anio, String password) {
		pedido.setCliente(new Cliente(nombre, anio, password));
	}
	
	public void actualizarTipoPedido (boolean llevar) {
		pedido.setLocal(llevar);
	}
	
	public void grabarPedido() {
		pedido.grabarPedido();
	}
	
	public String[] getRangoAnios() {
	    int anioActual = LocalDateTime.now().getYear();
	    int rango = Cliente.EDAD_MAX-Cliente.EDAD_MIN;
		String[]anios = new String[rango];
		for (int i=0;i<rango;i++)
			anios[i] = String.valueOf((anioActual-Cliente.EDAD_MIN)-i);
		return anios;
	}
	
	public int getUnidadesArticulo(Articulo articulo) {
	    return pedido.getUnidadesArticulo(articulo);
	}
	
	public void eliminar(Articulo articulo, int unidades) {
		pedido.eliminar(articulo, unidades);
	}

	public String mostrarPedido() {
		return pedido.mostrarPedido();
		
	}

}
