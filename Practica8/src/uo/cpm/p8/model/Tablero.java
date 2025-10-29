package uo.cpm.p8.model;

import uo.cpm.p8.model.Casilla.TipoCasilla;

public class Tablero {

	Casilla[] casillas;
	private int dim;
	private int nInvasores;
	private int nMeteoritos;

	public Tablero(int dim, int nInvasores, int nMeteoritos) {
		this.dim = dim;
		this.nInvasores = nInvasores;
		this.nMeteoritos = nMeteoritos;

		casillas = new Casilla[dim];
		for (int i = 0; i < dim; i++)
			casillas[i] = new Casilla("Espacio", TipoCasilla.ESPACIO, -200, "/img/space.jpg");
		colocaInvasores();
		colocaMeteoritos();
	}

	private void colocaInvasores() {
		int posicionInvasor;
		for (int i = 0; i < nInvasores; i++) {
			do
				posicionInvasor = (int) (Math.random() * dim);
			while (!casillas[posicionInvasor].getTipoCasilla().equals(TipoCasilla.ESPACIO));
			casillas[posicionInvasor] = new Casilla("Invasor", TipoCasilla.INVASOR, 3000, "/img/invader.jpg");
			System.out.println("Posicion invasor = " + posicionInvasor);
		}
	}

	private void colocaMeteoritos() {
		int posicionMeteorito;
		for (int i = 0; i < nMeteoritos; i++) {
			do {
				posicionMeteorito = (int) (Math.random() * dim);
			} while (!casillas[posicionMeteorito].getTipoCasilla().equals(TipoCasilla.ESPACIO));
			casillas[posicionMeteorito] = new Casilla("Meteorito", TipoCasilla.METEORITO, 0, "/img/meteorite.jpg");
			System.out.println("Posicion meteorito = " + posicionMeteorito);
		}
	}

	public Casilla getCasillaInvasor() {
		for (Casilla casilla : casillas) {
			if (casilla.getTipoCasilla() == TipoCasilla.INVASOR) {
				return casilla;
			}
		}
		return null;
	}

	public Casilla getCasillaMeteorito() {
		for (Casilla casilla : casillas) {
			if (casilla.getTipoCasilla() == TipoCasilla.METEORITO) {
				return casilla;
			}
		}
		return null;
	}

	public Casilla[] getCasillas() {
		return casillas;
	}

	public int getDim() {
		return dim;
	}

	public String obtenerImagen(int i) {
		return casillas[i].getImagen();
	}
}
