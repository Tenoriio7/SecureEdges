package br.com.secureedges.testes;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.secureedges.core.dao.EnderecoDAO;
import br.com.secureedges.core.dao.UsuarioDAO;
import br.com.secureedges.domain.Endereco;
import br.com.secureedges.domain.Solicitacao;
import br.com.secureedges.domain.Usuario;


public class UsuarioDAOTeste {
	
	@Test
	public void salvar (){
		Usuario usuario = new Usuario();
		usuario.setCPF("42167200803");
		usuario.setDtCadastro(new Date());
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscarPorCodigo(1L);
		System.out.println(endereco.getBairro());
		usuario.setEndereco(endereco);
		usuario.setIdade(18);
		usuario.setNome("Vinicius");
		usuario.setRG("494216128");
		usuario.setSobrenome("Tenorio");
		usuario.setStatus(1);
		usuario.setTipo_Usuario(1);		
		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usuario);
		List<Solicitacao> solicitacaos = null ;
	}
	

}
