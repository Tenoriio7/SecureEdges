package br.com.secureedges.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Solicitacao")
@NamedQueries
({
@NamedQuery(name="Solicitacao.listar",query="SELECT solicitacao FROM Solicitacao solicitacao"),
@NamedQuery(name="Solicitacao.buscarProCodigo",query="SELECT solicitacao FROM Solicitacao solicitacao WHERE solicitacao.Codigo=:codigo")
})
public class Solicitacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sol_Codigo")
	private Long Codigo;
	

	@Column(name = "solicitacao_Status", length = 50, nullable = false)
	private Boolean Status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_usuario_usr_Codigo", referencedColumnName = "usr_Codigo", nullable = false)
	private Usuario usuario;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_Dispositivo_disp_Codigo", referencedColumnName = "disp_Codigo", nullable = false)
	private Dispositivo Dispositivo;


	public Long getCodigo() {
		return Codigo;
	}


	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}


	public Boolean getStatus() {
		return Status;
	}


	public void setStatus(Boolean status) {
		Status = status;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Dispositivo getDispositivo() {
		return Dispositivo;
	}


	public void setDispositivo(Dispositivo dispositivo) {
		Dispositivo = dispositivo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		return true;
	}

	
	

}
