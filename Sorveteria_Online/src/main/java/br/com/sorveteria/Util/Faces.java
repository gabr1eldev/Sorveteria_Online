package br.com.sorveteria.Util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Faces implements Serializable {
	private static final long serialVersionUID = 1L;

	public void msgInfor(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext msgTela = FacesContext.getCurrentInstance();
		msgTela.addMessage(null, message);
	}
	
	public void msgError(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,msg);
		FacesContext msgTela = FacesContext.getCurrentInstance();
		msgTela.addMessage(null, message);
	}

}
