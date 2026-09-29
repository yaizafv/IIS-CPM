package uo.cpm.examen.model;

public class Tablero {

	private Casilla[] tablero;
	private static int DIM = 4;
	private Casilla casillaPremio;

	public Tablero() {
		casillaPremio = new Casilla(true);
		generarTablero();
	}

	private void generarTablero() { // 0:no premio ; 1:premio
		tablero = new Casilla[DIM];
		for (int i = 0; i < DIM; i++) {
			tablero[i] = new Casilla(false); /* Inicialmente no hay ning�n premio */
		}
		int posicion = (int) (Math.random() * DIM);

		tablero[posicion] = casillaPremio; // * Se coloca el premio
		mostrarConsola();
	}

	private void mostrarConsola() {
		System.out.print("Premio: " + getIndexCasillaPremio());
	}

	public int getNumCasillas() {
		return tablero.length;
	}

	public Casilla getCasillaPremio() {
		return casillaPremio;
	}

	public int getIndexCasillaPremio() {
		for (int i = 0; i < DIM; i++) {
			if (tablero[i].isEsPremio()) {
				return i;
			}
		}
		return 0;
	}

}
