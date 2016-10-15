package br.com.secureedges.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.secureedges.core.dao.EnderecoDAO;
import br.com.secureedges.core.dao.LoginDAO;
import br.com.secureedges.core.dao.UsuarioDAO;
import br.com.secureedges.domain.Endereco;
import br.com.secureedges.domain.Login;
import br.com.secureedges.domain.Usuario;
import br.com.secureedges.util.FacesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	private Usuario usuario;
	private Endereco endereco;
	private Login login;
	List<Usuario>listaUsuarios;
	List<Usuario>listaUsuariosFiltrados;
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public List<Usuario> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}
	public void setListaUsuariosFiltrados(List<Usuario> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
	}
	
	public Login getLogin() {
		if(login  == null)
			login = new Login();
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public Endereco getEndereco() {
		if(endereco == null)
			endereco = new  Endereco();
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
		
	public Usuario getUsuario() {
		if (usuario == null)
			usuario= new Usuario();
			
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void salvar() {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.salvar(endereco);
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.salvar(login);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuario.setEndereco(endereco);
		usuario.setLogin(login);
		usuarioDAO.salvar(usuario);

		FacesUtil.adicionarMSGInfo("Salvo com Sucesso");
		FacesUtil.adicionarMSGInfo(usuario.toString());
		
	}
	
	public void carregar()
	{
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			listaUsuarios = usuarioDAO.listar();
			
			
		}catch (RuntimeException ex) {
			FacesUtil.adicionarMSGError("Erro ao Carregar");
		}
	}
	

}
