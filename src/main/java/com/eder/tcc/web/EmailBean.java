package com.eder.tcc.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;

import com.eder.tcc.modelo.email.Mensagem;
import com.eder.tcc.util.EmailUtil;

@ManagedBean
public class EmailBean {

	private Mensagem mensagem = new Mensagem();

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public void enviaEmail() {
		try {
			EmailUtil.enviaEmail(mensagem);
			mostrarMenssagem("Email enviado com sucesso.");
			mensagem = new Mensagem();
		} catch (EmailException ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro! Occoreu um erro ao enviar a mensagem.", "Erro"));
			Logger.getLogger(EmailBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void mostrarMenssagem(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(msg);
		context.addMessage(null, facesMessage);
	}
	
	public void limpaCampos() {
		mensagem = new Mensagem();
	}
}
