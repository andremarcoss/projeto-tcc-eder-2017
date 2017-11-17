package com.eder.tcc.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.eder.tcc.modelo.email.Mensagem;


public class EmailUtil {

	private static final String HOSTNAME = "smtp.gmail.com";
	private static final String USERNAME = "portal.academico.eder2017";
	private static final String PASSWORD = "54518_eder";
	private static final String EMAIL_ORIGEM = "portal.academico.eder2017@gmail.com";
	
	public static Email conectaEmail() throws EmailException{
		Email email = new SimpleEmail();
		email.setHostName(HOSTNAME);
		email.setSmtpPort(587);
		email.setAuthentication(USERNAME, PASSWORD);
		email.setTLS(true);
		email.setFrom(EMAIL_ORIGEM);
		
		return email;
	}
	
	public static void enviaEmail(Mensagem mensagem) throws EmailException{
		Email email = new SimpleEmail();
		email = conectaEmail();
		
		email.setSubject(mensagem.getTitulo());
		email.setMsg(mensagem.getMensagem());
		
		email.addTo(mensagem.getDestinatario());
		
		String resposta = email.send();
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Email enviado para: " + mensagem.getDestinatario(), "Informação"));
	}

}
