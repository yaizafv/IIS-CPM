package uo.cpm.p7.service;

import uo.cpm.p7.game.Juego;
import uo.cpm.p7.model.Casilla;
import uo.cpm.p7.model.Tablero;

public class SpaceInvaders {

	private Juego juego = new Juego();

	public Tablero getTablero() {
		return juego.getTablero();
	}

	public void inicializar() {
		juego.inicializarJuego();
	}

	public void dispara(int i) {
		juego.dispara(i);
	}

	public boolean isFinJuego() {
		return juego.isFinJuego();
	}
	
	public Casilla getCasillaDisparada() {
		return juego.getCasillaDisparada();
	}
	
	public Casilla getCasillaInvasor() {
		return juego.getTablero().getCasillaInvasor();
	}

	public Casilla getCasillaMeteorito() {
		return juego.getTablero().getCasillaMeteorito();
	}
	
	public int getPuntuacion() {
		return juego.getPuntos();
	}

	public void lanzarDado() {
		juego.lanzar();
	}

	public int getDisparos() {
		return juego.getDisparos();
	}

	public String obtenerImagen(int i) {
		return juego.obtenerImagen(i);
	}
}