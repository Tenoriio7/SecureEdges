package br.com.secureedges.testes;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.secureedges.dao.LoginDAO;
import br.com.secureedges.dao.UsuarioDAO;
import br.com.secureedges.models.Login;
import br.com.secureedges.models.Usuario;


public class LoginDAOTeste {
	
	@Test
	public void salvar (){
		Login login= new Login();
		login.setEmail("email");
		login.setLogin("login");
		login.setSenha("senha");
		login.setCodigo(1L);
		UsuarioDAO daoUsr = new UsuarioDAO();
		Usuario usuario = daoUsr.buscarPorCodigo(1L);
		//login.setUsuario(usuario);
		LoginDAO dao  = new LoginDAO();
		dao.salvar(login);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		LoginDAO dao = new LoginDAO();
		List<Login> Login = dao.listar();
		System.out.println("\n");
		System.out.println(Login);
		System.out.println("\n");
	}

	@Test
	public void buscarPorCodigo() {
		LoginDAO dao = new LoginDAO();
		Login f1 = dao.buscarPorCodigo(1L);
		System.out.println(f1);
	}

	@Test
	@Ignore
	public void Excluir() {
		LoginDAO dao = new LoginDAO();
		Login Login = dao.buscarPorCodigo(2L);
		if (Login != null)
			dao.excluir(Login);
	}

	/*
	 * @Test
	 * 
	 * @Ignore public void ExcluirPorCodigo(Long codigo) { LoginDAOdao = new
	 * LoginDAO(); dao.Excluir(3L);
	 * 
	 * }
	 */

	@Test
	public void Editar() {
		LoginDAO dao = new LoginDAO();
		Login Login = dao.buscarPorCodigo(3L);
		Login.setEmail("EmailX");
		if (Login != null)
			dao.editar(Login);
	}
	
	
	
	

}
