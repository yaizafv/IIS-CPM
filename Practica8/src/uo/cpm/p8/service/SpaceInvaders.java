package uo.cpm.p8.service;

import uo.cpm.p8.game.Juego;
import uo.cpm.p8.model.Casilla;
import uo.cpm.p8.model.Nivel;
import uo.cpm.p8.model.Tablero;

public class SpaceInvaders {

	private Juego juego = new Juego();

	public Tablero getTablero() {
		return juego.getTablero();
	}

	public void inicializar(Nivel nivel) {
		juego.inicializarJuego(nivel);
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
	
	public int getDim() {
		return juego.getTablero().getDim();
	}

	public String obtenerImagen(int i) {
		return juego.obtenerImagen(i);
	}
}