package controller.Ferramentas;

import java.time.LocalDate;

public class ObterAnoAtual {

    public static int ObtemAno() {
        LocalDate dataAtual = LocalDate.now();
        int anoAtual = dataAtual.getYear();
		return anoAtual;
    }
    
}