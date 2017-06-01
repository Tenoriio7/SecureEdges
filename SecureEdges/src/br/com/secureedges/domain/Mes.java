package br.com.secureedges.domain;

import java.util.ArrayList;
import java.util.List;

public class Mes {
	List<Dispositivo> listDispositivo;
	private String nome;
	private int numero;
	
	public List<Dispositivo> getListDispositivo() {
		if(listDispositivo ==null)
			listDispositivo = new ArrayList<>();
		return listDispositivo;
	}
	public void setListDispositivo(List<Dispositivo> listDispositivo) {
		this.listDispositivo = listDispositivo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
