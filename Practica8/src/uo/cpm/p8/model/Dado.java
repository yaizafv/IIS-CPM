package uo.cpm.p8.model;

public class Dado {
	
	public static int lanzar(Nivel nivel)
	{ 
		return ((int) (Math.random() * nivel.getNumDisparos()) + 1);
	}
}
