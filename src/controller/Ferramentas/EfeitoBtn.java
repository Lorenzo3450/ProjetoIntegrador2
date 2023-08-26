package controller.Ferramentas;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;


//classe criada para adiciona um efeito ao botão assim que o mouse passar por cima dele 

public class EfeitoBtn {

	private DropShadow dropShadow = new DropShadow();
	 
	
	//retorna o efeito
	 public DropShadow Efeito() {
		 dropShadow.setColor(Color.LIGHTBLUE); // Definir a cor do brilho para azul claro
	        dropShadow.setRadius(10);
	        return this.dropShadow;
		 
	 }
	
	
}
