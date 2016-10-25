package br.com.secureedges.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Dispositivo")
@NamedQueries
({
@NamedQuery(name="Dispositivo.listar",query="SELECT dispositivo FROM Dispositivo dispositivo"),
@NamedQuery(name="Dispositivo.buscarPorCodigo",query="SELECT dispositivo FROM Dispositivo dispositivo WHERE dispositivo.Codigo=:codigo")
})
public class Dispositivo extends EntidadeDominio {
	
	
	@Id
	@GeneratedValue
	@Column(name="disp_Codigo")
	Long Codigo;
	
	@Column(name="disp_Descricao",nullable=false,length=50)
	String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_Comodo_cmdo_Codigo", referencedColumnName = "cmdo_Codigo", nullable = false)
	private Comodo Comodo;
	
	@OneToOne
	@JoinColumn(name = "tb_TP_Dispositivo_tp_disp_Codigo", referencedColumnName = "tp_disp_Codigo", nullable = false)
	private Tipo_Dispositivo TP_Dispositivo;

	public Long getCodigo() {
		return Codigo;
	}

	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public Comodo getComodo() {
		if (Comodo ==null)
				Comodo =  new Comodo();
		return Comodo;
	}

	public void setComodo(Comodo comodo) {
		Comodo = comodo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
		
	}

	@Override
	public String toString() {
		return "Dispositivo [Codigo=" + Codigo + ", descricao=" + descricao + ", Comodo=" + Comodo + ", TP_Dispositivo="
				+ TP_Dispositivo + "]";
	}

	public Tipo_Dispositivo getTP_Dispositivo() {
		if (TP_Dispositivo ==null)
			TP_Dispositivo =  new Tipo_Dispositivo();
		return TP_Dispositivo;
	}

	public void setTP_Dispositivo(Tipo_Dispositivo tP_Dispositivo) {
		TP_Dispositivo = tP_Dispositivo;
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
		Dispositivo other = (Dispositivo) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		return true;
	}

	
	
	

}
