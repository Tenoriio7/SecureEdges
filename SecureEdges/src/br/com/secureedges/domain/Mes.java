package br.com.secureedges.domain;

import java.util.ArrayList;
import java.util.List;

public class Mes {
	List<Dispositivo> listDispositivo;
	
	public List<Dispositivo> getListDispositivo() {
		if(listDispositivo ==null)
			listDispositivo = new ArrayList<>();
		return listDispositivo;
	}
	public void setListDispositivo(List<Dispositivo> listDispositivo) {
		this.listDispositivo = listDispositivo;
	}
}
