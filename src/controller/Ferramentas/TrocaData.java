package controller.Ferramentas;

import java.util.Scanner;

public class TrocaData {
	
	
	public static String trocaData(String data) {	
		
		data = data.substring(6,10)+data.substring(2,6)+data.substring(0,2);
		return data;
		
	}	
	

}
