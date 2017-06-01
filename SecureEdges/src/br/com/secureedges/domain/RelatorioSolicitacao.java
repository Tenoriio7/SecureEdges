package br.com.secureedges.domain;

import java.util.ArrayList;
import java.util.List;

public class RelatorioSolicitacao {
	private List<Mes> meses;
	
	public List<Mes> getListMes() {
		if(meses ==null)
			meses = new ArrayList<>();
		return meses;
	}
	public void setListMes(List<Mes> meses) {
		this.meses = meses;
	}
	
}
