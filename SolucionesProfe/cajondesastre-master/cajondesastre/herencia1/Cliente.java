package com.pgrsoft.fihoca2019.cajondesastre.herencia1;

public class Cliente extends Persona {
	
	private boolean vIP;
	
	public Cliente() {
		System.out.println("constructor de Cliente");
	}

	public boolean isvIP() {
		return vIP;
	}

	public void setvIP(boolean vIP) {
		this.vIP = vIP;
	}

	@Override
	public String toString() {
		return "Cliente [vIP=" + vIP + ", toString()=" + super.toString() + "]";
	}
	
}
