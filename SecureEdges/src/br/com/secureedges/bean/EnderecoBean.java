package br.com.secureedges.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.secureedges.models.Endereco;
import br.com.secureedges.util.FacesUtil;

@ManagedBean
@ViewScoped
public class EnderecoBean {
	Endereco endereco;
	public Endereco getEndereco() {
		if(endereco == null)
			endereco = new Endereco();
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void salvar()
	{
		FacesUtil.adicionarMSGInfo(endereco.toString());
	}

}
