package uo.cpm.p7.model;

import uo.cpm.p7.model.Casilla.TipoCasilla;

public class Tablero {

	public static final int DIM = 8;
	Casilla[] casillas;

	public Tablero() {
		casillas = new Casilla[DIM];
		for (int i = 0; i < DIM; i++)
			casillas[i] = new Casilla("Espacio", TipoCasilla.ESPACIO, -200, "/img/space.jpg");
		colocaInvasor();
		colocaMeteorito();
	}

	private void colocaInvasor() {
		int posicionInvasor = (int) (Math.random() * DIM);
		casillas[posicionInvasor] = new Casilla("Invasor", TipoCasilla.INVASOR, 3000, "/img/invader.jpg");
		System.out.println("Posicion invasor = " + posicionInvasor);
	}

	private void colocaMeteorito() {
		int posicionMeteorito;
		do {
			posicionMeteorito = (int) (Math.random() * DIM);
		} while (casillas[posicionMeteorito].getTipoCasilla() == TipoCasilla.INVASOR);

		casillas[posicionMeteorito] = new Casilla("Meteorito", TipoCasilla.METEORITO, -1000, "/img/meteorite.jpg");
		System.out.println("Posicion meteorito = " + posicionMeteorito);
	}
	
	public Casilla getCasillaInvasor() {
		for (Casilla casilla: casillas) {
			if (casilla.getTipoCasilla() == TipoCasilla.INVASOR) {
				return casilla;
			}
		}
		return null;
	}
	
	public Casilla getCasillaMeteorito() {
		for (Casilla casilla: casillas) {
			if (casilla.getTipoCasilla() == TipoCasilla.METEORITO) {
				return casilla;
			}
		}
		return null;
	}

	public Casilla[] getCasillas() {
		return casillas;
	}

	public String obtenerImagen(int i) {
		return casillas[i].getImagen();
	}
}
