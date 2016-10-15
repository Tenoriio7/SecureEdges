package br.com.secureedges.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.secureedges.dao.UsuarioDAO;
import br.com.secureedges.util.FacesUtil;
import br.com.secureedges.models.Usuario;

@ManagedBean
@SessionScoped  // diferença :  ele vai existir durante todo tempo de sessão
public class AutenticacaoBean {

	private Usuario usuarioLogado= new Usuario();
	
	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null)
				usuarioLogado = new Usuario();
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public String  autenticar(){
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado=usuarioDAO.autenticar(usuarioLogado.getCPF(), usuarioLogado.getLogin().getSenha());
			System.out.println(usuarioLogado.getCPF());
			System.out.println(usuarioLogado.getLogin().getSenha());
			if(usuarioLogado == null){
				FacesUtil.adicionarMSGError("CPF ou Senha invalidos" );
				return null;
			}
			else{
				FacesUtil.adicionarMSGInfo("Usuario autenticado com sucesso");
				if(usuarioLogado.getStatus().equals("ativo"))
				{
					System.out.println("if");
					return "/templates/modeloGeralUsuario.xhtml?faces-redirect=true";
				}
				else{
				return "/templates/modeloGeral.xhtml?faces-redirect=true";
				}
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String  sair (){
		usuarioLogado =  null;
		return "/templates/modeloGeralUsuario.xhtml?faces-redirect=true";
		
	}
	
}
