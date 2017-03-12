package br.com.secureedges.domain;

import java.util.Date;

import org.hibernate.mapping.Set;

public class Solicitacao extends EntidadeDominio {

	private String status;

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private Usuario usuario;

	private Date data = new Date();

	private Dispositivo dispositivo;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Dispositivo getDispositivo() {
		if (dispositivo == null)
			dispositivo = new Dispositivo();
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

}
