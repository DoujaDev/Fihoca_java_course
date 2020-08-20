package com.pgrsoft.fihoca2019.cajondesastre.exceptions;

public class TestClass {

	public void m1() throws Exception {
		m2();
	}
	
	public void m2() throws Exception {
	 throw new Exception();	
	}
	
	public static void main(String[] args) {
		
		try {
			new TestClass().m1();
		} catch (Exception e) {
			System.out.println("todo bien...");
		}
	}

}
