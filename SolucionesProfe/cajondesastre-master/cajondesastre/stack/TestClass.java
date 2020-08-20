package com.pgrsoft.fihoca2019.cajondesastre.stack;

public class TestClass {

	public void m1() {
		System.out.println("m1 antes de invocar a m2");
		
		try {
			m2();
		} catch(Exception e) {
			System.out.println(e.getClass().getSimpleName());
		}
			
		System.out.println("m1 después de invocar a m2");
	}
	
	public void m2() {
		System.out.println("m2 antes de invocar a m3");
		m3();
		System.out.println("m2 después de invocar a m3");
	}
	
	public void m3() {
		System.out.println("m3");
		int a = 1/0;
	}
	
	public static void main(String[] args) {
		new TestClass().m1();
	}

}
