package com.pgrsoft.fihoca2019.cajondesastre.numberformatter;

/**
 * Convierte un número [0,999] a su nombre en castellano.
 * 
 * Ejemplo: 124 -> "ciento veinticuatro"
 * 
 */
public interface NumberFormatter {

	public String convert(int numero);

	public String convert(String strNumero);
	
}
