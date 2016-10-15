package br.com.secureedges.testes;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.secureedges.dao.EnderecoDAO;
import br.com.secureedges.models.Endereco;

public class EnderecoDAOTeste {
	
	@Test
	public void salvar ()
	{
		Endereco endereco = new Endereco();
		endereco.setBairro("nova Poa");
		endereco.setCEP("08567450");
		endereco.setCidade("Poa");
		endereco.setEstado("SP");
		endereco.setNumero(265);
		endereco.setRua("Eugenio Rossoni");	
		EnderecoDAO dao = new EnderecoDAO();
		dao.salvar(endereco);
		
	}
	
	@Test
	public void listar() {
		EnderecoDAO dao = new EnderecoDAO();
		List<Endereco> endereco = dao.listar();
		System.out.println("\n");
		System.out.println(endereco);
		System.out.println("\n");
	}

	@Test
	public void buscarPorCodigo() {
		EnderecoDAO dao = new EnderecoDAO();
		Endereco f1 = dao.buscarPorCodigo(3L);
		System.out.println(f1);
	}

	@Test
	@Ignore
	public void Excluir() {
		EnderecoDAO dao = new EnderecoDAO();
		Endereco endereco = dao.buscarPorCodigo(2L);
		if (endereco != null)
			dao.excluir(endereco);
	}

	/*
	 * @Test
	 * 
	 * @Ignore public void ExcluirPorCodigo(Long codigo) { EnderecoDAO dao = new
	 * EnderecoDAO(); dao.Excluir(3L);
	 * 
	 * }
	 */

	@Test
	public void Editar() {
		EnderecoDAO dao = new EnderecoDAO();
		Endereco endereco = dao.buscarPorCodigo(3L);
		endereco.setBairro("BairroX");
		if (endereco != null)
			dao.editar(endereco);
	}
	
	
	
	
	

}
