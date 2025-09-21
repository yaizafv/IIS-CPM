package uo.cpm.p3.console;

import java.io.PrintStream;
import java.util.Scanner;

import uo.cpm.p3.model.Articulo;
import uo.cpm.p3.model.Carta;
import uo.cpm.p3.model.Pedido;

public class Menu {

	/**
	 * Atributo listaDeArticulos
	 */
	private static Articulo[] listaDeArticulos;
	/**
	 * Atributo reader
	 */
	private static Scanner reader = new Scanner(System.in);
	/**
	 * Atributo precio
	 */
	private static double precio;
	/**
	 * Atributo codigo
	 */
	private static String codigo;

	/**
	 * Método que lanza el programa
	 * 
	 * @param args, argumento
	 */
	public static void main(String[] args) {
		inicializar(System.out);
		hacerPedido(System.out);
		System.out.println("Pedido realizado.");
		System.out.println("Su código es: " + codigo);
		System.out.println("El coste del pedido es de: " + precio + "€");

	}

	/**
	 * Método que inicializa la lista
	 * 
	 * @param out
	 */
	private static void inicializar(PrintStream out) {
		Carta carta = new Carta();
		listaDeArticulos = carta.getArticulos();
		out.println("Bienvenido a McDonald's.");
		out.println("Seleccione los productos que quiera\n");
		for (int i = 0; i < listaDeArticulos.length; i++) {
			out.println(i + 1 + " ->  " + listaDeArticulos[i]);
		}
	}

	/**
	 * Método que hace el pedido
	 * 
	 * @param out
	 */
	private static void hacerPedido(PrintStream out) {
		Pedido pedido = new Pedido();
		out.println("\nHaga su pedido");
		boolean correct = true;
		while (correct) {
			pedido.add(seleccionProducto(), seleccionUnidades());
			out.println("Si quiere algo más, pulse 1, sino, pulse 0");
			int num = reader.nextInt();
			if (num == 0) {
				correct = false;
			}
		}
		pedido.grabarPedido();
		codigo = pedido.getCodigo();
		precio = pedido.calcularImporte();
	}

	/**
	 * Método que hace la selección de unidades
	 * 
	 * @return num
	 */
	private static int seleccionUnidades() {
		System.out.println("¿Cuantas unidades quiere?");
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
	private static Articulo seleccionProducto() {
		System.out.println("¿Que productos quiere?");
		int num = reader.nextInt();
		while (num <= 0 || num > listaDeArticulos.length) {
			num = reader.nextInt();
		}
		return listaDeArticulos[num - 1];
	}

}
