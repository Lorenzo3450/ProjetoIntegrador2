package controller.Ferramentas;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EnviaEmail {

	
	public static void EMaiNotaFiscal() {
		String emailDoSuperMercado="";
		String senha="";
		
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(emailDoSuperMercado, senha));
		email.setSSLOnConnect(true);
		
		try {
			
			email.setFrom(emailDoSuperMercado);
			email.setSubject("assunto");
			email.setMsg("mensagem");
			email.addTo("email do destinatario");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}
	
	
}
