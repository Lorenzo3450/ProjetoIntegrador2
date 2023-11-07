package controller.Ferramentas;



public class EfeitoImage {

	
	public static double[] hexToHue(String hexColor) {
	    // Remova o caractere '#' (se presente) e divida o código de cor em R, G e B
	    hexColor = hexColor.replace("#", "");
	    int red = Integer.parseInt(hexColor.substring(0, 2), 16);
	    int green = Integer.parseInt(hexColor.substring(2, 4), 16);
	    int blue = Integer.parseInt(hexColor.substring(4, 6), 16);

	    // Converta os valores RGB em valores de matiz (hue) no intervalo -0.5 a 0.5
	    double hueRed = (red / 255.0) - 0.5;
	    double hueGreen = (green / 255.0) - 0.5;
	    double hueBlue = (blue / 255.0) - 0.5;

	    return new double[] { hueRed, hueGreen, hueBlue };
	}
	
	
	
}
