package br.com.secureedges.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.secureedges.models.Login;
import br.com.secureedges.util.FacesUtil;

@ManagedBean
@ViewScoped
public class LoginBean {
	Login login ;
	public Login getLogin() {
		if(login ==null)
			login=new Login();
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public void salvar(){
		FacesUtil.adicionarMSGInfo(login.toString());
	}

}
