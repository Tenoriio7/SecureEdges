package br.com.secureedges.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "tb_Comodo")
@NamedQueries
({
@NamedQuery(name="Comodo.listar",query="SELECT comodo FROM Comodo comodo"),
@NamedQuery(name="Comodo.buscarPorCodigo",query="SELECT comodo FROM Comodo comodo WHERE comodo.Codigo=:codigo")
})
public class Comodo {
	
	@Id
	@GeneratedValue
	@Column(name="cmdo_Codigo")
	Long Codigo;
	
	@Column(name="cmdo_Descricao")
	String Descricao;

	public Long getCodigo() {
		return Codigo;
	}

	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	@Override
	public String toString() {
		return "Comodo [Codigo=" + Codigo + ", Descricao=" + Descricao + "]";
	}

}
