package uo.cpm.p6.model;

import java.util.*;

import uo.cpm.p6.util.FileUtil;

public class Pedido {

	private List<Articulo> listaPedido;
	private String codigo;
	private float importe;
	private boolean local;
	private Cliente cliente;

	private static final double PRECIO_BOLSA = 0.15;

	public Pedido() {
		listaPedido = new ArrayList<Articulo>();
		inicializar();
	}

	public void inicializar() {
		listaPedido.clear();
		generarCodigo();
		setImporte(0);
		setLocal(true);
		setCliente(null);
	}

	public void add(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloEnPedido = null;

		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo())) {
				articuloEnPedido = a;
				articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() + unidades);
				break;
			}
		}

		if (articuloEnPedido == null) {
			articuloEnPedido = new Articulo(articuloDelCatalogo);
			articuloEnPedido.setUnidades(unidades);
			listaPedido.add(articuloEnPedido);
		}
		calcularImporte();
	}

	public void eliminar(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloAEliminar = null;
		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo())) {
				if (a.getUnidades() <= unidades) {
					articuloAEliminar = a;
					a.setUnidades(0);
					break;
				} else {
					a.setUnidades(a.getUnidades() - unidades);
					break;
				}
			}
		}
		if (articuloAEliminar != null) {
			listaPedido.remove(articuloAEliminar);
		}
		calcularImporte();
	}

	public double calcularImporte() {
		importe = 0;
		for (Articulo a : listaPedido) {
			importe += a.getPrecio() * a.getUnidades();
		}
		if (isLocal()) {
			importe += PRECIO_BOLSA;
		}
		return importe;
	}

	public double calcularPrecioArticulos() {
		double precio = 0;
		for (Articulo a : listaPedido) {
			precio += a.getPrecio() * a.getUnidades();
		}
		return precio;
	}

	public boolean estaEnPedido(Articulo articulo) {
		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articulo.getCodigo())) {
				return true;
			}
		}
		return false;
	}

	public void grabarPedido() {
		FileUtil.saveToFile(this);
	}

	public List<Articulo> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Articulo> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public String getCodigo() {
		return codigo;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setLocal(boolean tipo) {
		local = tipo;
	}

	public boolean isLocal() {
		return local;
	}

	public void generarCodigo() {
		codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for (int i = 0; i < longitudCodigo; i++)
			codigo += base.charAt((int) (Math.random() * (base.length())));
	}

	public int getUnidadesArticulo(Articulo articulo) {
		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articulo.getCodigo())) {
				return a.getUnidades();
			}
		}
		return 0;
	}

	public String mostrarPedido() {
		String pedido = "";
		for (Articulo a : listaPedido) {
			pedido += a.getDenominacion() + " - " + a.getUnidades() + " uds.\n";
		}
		pedido += String.format("Total: %.2f\n", calcularPrecioArticulos());
		return pedido;
	}
	
	@Override
	public String toString() {
		String pedido = "";
		pedido += "Cliente: " + cliente.getNombreYApellidos() + "\n";
		pedido += "------------------------------- \n";
		for (Articulo a : listaPedido) {
			pedido += a.getDenominacion() + " - " + a.getUnidades() + " uds.\n";
		}
		pedido += "Total: " + getImporte() + "\n";
		if (isLocal()) {
			pedido += "Pedido en local";
		} else {
			pedido += "Pedido para llevar";
		}
		return pedido;
		
	}
}
