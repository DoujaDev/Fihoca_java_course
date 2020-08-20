package com.pgrsoft.fihoca2019.cajondesastre.exceptions;

public class TestOverflow {

	public void m1() {
		m2();
	}
	
	public void m2() {
		m1();
	}
	
	public static void main(String[] args) {
		
		new TestOverflow().m1();

		try{
			System.out.println("hola");
		} catch(Error e) {
			System.out.println("error!!!!");
		}
	}

}
