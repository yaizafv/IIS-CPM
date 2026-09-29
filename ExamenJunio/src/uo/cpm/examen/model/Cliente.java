package uo.cpm.examen.model;

public class Cliente {
	
	private boolean isVip;
	private String dni;

	public Cliente(boolean isVip, String dni) {
		this.isVip = isVip;
		this.dni = dni;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	

}
