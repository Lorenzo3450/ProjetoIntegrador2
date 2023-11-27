package controller.Ferramentas;

import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;


public class EnviaEmail {

	
	public static void EnviarEmail(String Email,String senha, String assunto,String mensagem,String Destinatario) {
	
		Properties properties =System.getProperties();
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "456");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(Email, senha));
		email.setSSLOnConnect(true);
		
		try {
			
			email.setFrom(Email);
			email.setSubject(assunto);
			email.setMsg(mensagem);
			email.addTo(Destinatario);
            email.send();

			System.out.println("email enviado :"+Email+","+senha+","+assunto+","+mensagem+","+Destinatario);
			
		} catch (Exception e) {
			 e.printStackTrace();		
			
		}
		
		
		
		
		
	}
	
	
	public static void main(String[] arg) {
		
		EnviarEmail("lorenzo.avizplay@gmail.com", "mqejalzozfbizaqd","teste", "oi", "lorenzo.aviz250@gmail.com");
		
	}
	
	
}
