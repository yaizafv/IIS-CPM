package uo.cpm.p3.service;


import java.time.LocalDateTime;

import uo.cpm.p3.model.*;

public class McDonalds {
	Carta carta = new Carta();
	Pedido pedido = new Pedido(); 
	
	
	public McDonalds() {
		inicializarPedido();
	}

	public Articulo[] getArticulosCarta() {
		return carta.getArticulos();
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

}
