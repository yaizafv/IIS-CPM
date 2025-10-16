package uo.cpm.p5.model;

public class Operaciones {

	private String operador;

	private int num1;
	private int num2;

	public void guardarOperador(String op, String numero) {
		num1 = Integer.parseInt(numero);
		operador = op;
	}

	public int calcularOperacion() {
		switch (operador) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "x":
			return num1 * num2;
		default:
			return 0;
		}
	}

	public void guardarNumero2(String numero) {
		num2 = Integer.parseInt(numero);
	}
}
