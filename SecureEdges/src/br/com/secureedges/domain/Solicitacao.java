package br.com.secureedges.domain;
import java.util.Date;
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
	
	private Date horario;
	
	
	private Dispositivo dispositivo ;


	


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getHorario() {
		return horario;
	}


	public void setHorario(Date horario) {
		this.horario = horario;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Dispositivo getDispositivo() {
		if (dispositivo ==null)
			dispositivo=  new Dispositivo();
		return dispositivo;
	}


	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

 


	
	

}
