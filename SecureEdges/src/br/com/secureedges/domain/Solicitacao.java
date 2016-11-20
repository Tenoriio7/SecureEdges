package br.com.secureedges.domain;
import java.util.Date;
public class Solicitacao extends EntidadeDominio {
	
	

	private String status;
	
	private Usuario usuario;
	
	private Date horario;
	
	
	private Dispositivo dispositivo;


	


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
		return dispositivo;
	}


	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

 


	
	

}
