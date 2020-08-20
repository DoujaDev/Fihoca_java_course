package com.pgrsoft.fihoca2019.cajondesastre.helloworld;

public class TestClass2 {

	public static void main(String[] args) {
		
		
		// COMECOCOS
		
		int[] a1 = {10,2,30};
		int[] a2 = new int[5];
		int[] a3 = a1;
		int[][] super1 = {null,a2,a2,a3};
		int[][] super2 = new int[a1[1]][];
		int[][][]monster = {super1,super2};
		
		monster[0][3] = a2;
		a3 = null;
		
		monster[0] = monster[1];
		super1 = super2;

		
		
		
		
	}

}
