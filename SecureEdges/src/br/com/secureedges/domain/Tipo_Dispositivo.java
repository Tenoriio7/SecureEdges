package br.com.secureedges.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_TP_Dispositivo")
@NamedQueries
({
@NamedQuery(name="Tipo_Dispositivo.listar",query="SELECT tipo_dispositivo FROM Tipo_Dispositivo tipo_dispositivo"),
@NamedQuery(name="Tipo_Dispositivo.buscarProCodigo",query="SELECT tipo_dispositivo FROM Tipo_Dispositivo tipo_dispositivo WHERE tipo_dispositivo.Codigo=:codigo")
})
public class Tipo_Dispositivo {

	
	@Id
	@GeneratedValue
	@Column(name="tp_disp_Codigo")
	Long Codigo;
	
	@Column(name="tipo_Genero")
	String Genero;

	@Override
	public String toString() {
		return "Tipo_Dispositivo [Codigo=" + Codigo + ", Genero=" + Genero + "]";
	}

	public Long getCodigo() {
		return Codigo;
	}

	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}
	
}
