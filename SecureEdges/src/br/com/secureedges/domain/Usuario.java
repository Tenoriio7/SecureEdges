package br.com.secureedges.domain;

import java.io.Serializable;
import java.util.Date;
//import java.sql.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
@Table(name = "tb_usuario")
@NamedQueries
({
@NamedQuery(name="Usuario.listar",query="SELECT usuario FROM Usuario usuario"),
@NamedQuery(name="Usuario.buscarProCodigo",query="SELECT usuario FROM Usuario usuario WHERE usuario.Codigo=:codigo")
})
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_Codigo",unique=true)
	private Long Codigo;
	
	@Column(name = "usr_Nome", length = 50, nullable = false)
	private String Nome;
	
	@Column(name = "usr_Sobrenome", length = 50, nullable = false)
	private String Sobrenome;
	
	@Column(name = "dt_Cadastro", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtCadastro= new  Date();
	
	@Column(name="usr_RG",nullable=false,length=14)
	private String RG;
	
	@Column(name = "usr_cpf", length = 14, nullable = false, unique = true)
	private String CPF;
	
	@Column(name="usr_Idade",nullable = false)
	private Integer Idade;
	
	@Column(name="usr_Status",nullable = false)
	private Integer Status =0;  // 1 ativo 0 desativado
	
	@Column(name="usr_Tipo",nullable = false)
	private Integer Tipo_Usuario=0; //1 == Admin  2  == Usuario comum
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_Endereco_end_Codigo", referencedColumnName = "end_Codigo", nullable = false)
	private Endereco Endereco;
	
	
	@OneToOne
	@JoinColumn(name = "tb_Login_login_Codigo", referencedColumnName = "login_Codigo", nullable = false)
	private Login Login;


	public Long getCodigo() {
		return Codigo;
	}


	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getSobrenome() {
		return Sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}


	public Date getDtCadastro() {
		return dtCadastro;
	}


	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


	public String getRG() {
		return RG;
	}


	public void setRG(String rG) {
		RG = rG;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public Integer getIdade() {
		return Idade;
	}


	public void setIdade(Integer idade) {
		Idade = idade;
	}


	public Integer getStatus() {
		return Status;
	}


	public void setStatus(Integer status) {
		Status = status;
	}


	public Integer getTipo_Usuario() {
		return Tipo_Usuario;
	}


	public void setTipo_Usuario(Integer tipo_Usuario) {
		Tipo_Usuario = tipo_Usuario;
	}


	public Endereco getEndereco() {
		return Endereco;
	}


	public void setEndereco(Endereco endereco) {
		Endereco = endereco;
	}


	public Login getLogin() {
		return Login;
	}


	public void setLogin(Login login) {
		Login = login;
	}


	@Override
	public String toString() {
		return "Usuario [Codigo=" + Codigo + ", Nome=" + Nome + ", Sobrenome=" + Sobrenome + ", dtCadastro="
				+ dtCadastro + ", RG=" + RG + ", CPF=" + CPF + ", Idade=" + Idade + ", Status=" + Status
				+ ", Tipo_Usuario=" + Tipo_Usuario + ", Endereco=" + Endereco + ", Login=" + Login + "]";
	}
	
	
	
//	@OneToMany(mappedBy = "usuario", targetEntity = Solicitacao.class, fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
//	private List<Solicitacao> Solicitacoes;
	
    
	
}
