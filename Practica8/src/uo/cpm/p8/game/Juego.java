package uo.cpm.p7.game;

import uo.cpm.p7.model.*;
import uo.cpm.p7.model.Casilla.TipoCasilla;

public class Juego {

	private int puntos;
	private int disparos;
	private Tablero tablero;
	private Casilla casillaDisparada;
	private boolean finJuego;
	private Nivel nivel;

	public Juego() {
		inicializarJuego(Nivel.INTERMEDIO);
	}

	public void inicializarJuego(Nivel nivel) {
		tablero = new Tablero(nivel.getNumCasillas(), nivel.getNumInvasores(), nivel.getNumMeteoritos());
		puntos = 1000;
		disparos = 0;
		this.nivel = nivel;
		casillaDisparada = null;
		finJuego = false;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public Casilla getCasillaDisparada() {
		return casillaDisparada;
	}

	public void setCasillaDisparada(Casilla casillaDisparada) {
		this.casillaDisparada = casillaDisparada;
	}

	public boolean isFinJuego() {
		return finJuego;
	}

	public void dispara(int i) {
		disparos--;
		setCasillaDisparada(tablero.getCasillas()[i]);
		if (getCasillaDisparada().getTipoCasilla().equals(TipoCasilla.METEORITO)) {
			puntos = 0;
		} else {
			puntos += tablero.getCasillas()[i].getPuntos();
		}

		finJuego = isPartidaFinalizada();
	}

	public boolean isPartidaFinalizada() {
		return (getCasillaDisparada().getTipoCasilla().equals(TipoCasilla.INVASOR)
				|| getCasillaDisparada().getTipoCasilla().equals(TipoCasilla.METEORITO) || disparos == 0);
	}

	public int getPuntos() {
		return puntos;
	}

	public void lanzar() {
		setDisparos(Dado.lanzar(nivel));
	}

	public int getDisparos() {
		return disparos;
	}

	private void setDisparos(int disparos) {
		this.disparos = disparos;
	}

	public String obtenerImagen(int i) {
		return getTablero().obtenerImagen(i);
	}

	public Nivel getNivel() {
		return nivel;
	}
	
}
