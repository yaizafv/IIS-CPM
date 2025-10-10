package uo.cpm.p5.console;

import java.util.Scanner;

import uo.cpm.p5.model.Articulo;
import uo.cpm.p5.service.McDonalds;

public class Console {

	private static McDonalds mc = new McDonalds();
	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		inicializar();
		hacerPedido();
		System.out.println("Pedido realizado.");
		System.out.println("Su código es: " + mc.getCodigoPedido());
		System.out.println("El coste del pedido es de: " + mc.getImportePedido() + "€");

	}

	/**
	 * Método que inicializa la lista
	 */
	private static void inicializar() {
		mc.inicializarPedido();
		Articulo[] carta = mc.getArticulosCarta();
		System.out.println("Bienvenido a McDonald's.");
		System.out.println("Seleccione los productos que quiera");
		for (int i = 0; i < carta.length; i++) {
			System.out.println(i + 1 + " ->  " + carta[i]);
		}
	}

	/**
	 * Método que hace el pedido
	 */
	private static void hacerPedido() {
		System.out.println("Haga su pedido");
		boolean correct = true;
		while (correct) {
			mc.aniadirAPedido(seleccionProducto(mc.getArticulosCarta()), seleccionUnidades());
			System.out.println("Si quiere algo más, pulse 1, sino, pulse 0");
			int num = reader.nextInt();
			if (num == 0) {
				correct = false;
			}
		}
		tipoPedido(correct);
		mc.grabarPedido();
	}

	private static void tipoPedido(boolean correct) {
		System.out.println("Pulse 1 si quiere el pedido para llevar o 0 para comer en local");
		int num = reader.nextInt();
		if (num == 1) {
			correct = false;
			mc.actualizarTipoPedido(correct);
		}
		if (num == 0) {			
			mc.actualizarTipoPedido(correct);
		}
	}

	/**
	 * Método que hace la selección de unidades
	 */
	private static int seleccionUnidades() {
		System.out.println("\n¿Cuantas unidades quiere?");
		int num = reader.nextInt();
		while (num <= 0) {
			num = reader.nextInt();
		}
		return num;
	}

	/**
	 * Método que hace la seleccion del producto
	 * 
	 * @return articulo
	 */
	private static Articulo seleccionProducto(Articulo[] carta) {
		System.out.println("\n¿Que productos quiere?");
		int num = reader.nextInt();
		while (num <= 0 || num > carta.length) {
			num = reader.nextInt();
		}
		return carta[num - 1];
	}

}
