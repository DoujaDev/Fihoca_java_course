package com.pgrsoft.fihoca2019.cajondesastre.numberformatter;

public class NumberFormatterImpl implements NumberFormatter {

	private static final String[] CENTENAS = {"","","doscientos","trescientos","cuatrocientos","quinientos","seiscientos","setecientos","ochocientos","novecientos"};
	private static final String[] DECENAS = {"","diez","","treinta","cuarenta","cincuenta","sesenta","setenta","ochenta","noventa"};
	private static final String[] UNIDADES = {"","uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve"};
	private static final String[] EXCEPCIONES = {"once","doce","trece","catorce","quince","dieciséis","diecisiete","dieciocho","diecinueve","veinte","veintiuno","veintidos","veintitres","veinticuatro","veinticinco","veintiseis","veintisiete","veintiocho","veintinueve"};
	
	
	@Override
	public String convert(int numero) {
		
		if (numero == 100){
			return "cien";
		}
		
		final int C = numero / 100;
		final int D = (numero % 100) / 10;
		final int U = numero % 10;
		
		String resultado = CENTENAS[C] + " ";
		
		final int DU = D * 10 + U;
		
		if (DU > 10 && DU < 30) {
			resultado += EXCEPCIONES[DU-11];
		} else {
			String conector = (U == 0 || D == 0) ? "" : " y "; 
			resultado += DECENAS[D] + conector + UNIDADES[U];
		}
		
		return resultado.trim();
		
	}

	@Override
	public String convert(String strNumero) {
		return convert(Integer.parseInt(strNumero));
	}

}
