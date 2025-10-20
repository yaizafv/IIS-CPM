package uo.cpm.p7.model;
import uo.cpm.p7.game.Juego;

public class Dado {
	
	public static int lanzar()
	{ 
		return ((int) (Math.random() * Juego.MAX_DISPAROS) + 1);
	}
}
