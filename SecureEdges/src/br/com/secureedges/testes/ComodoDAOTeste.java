package br.com.secureedges.testes;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.secureedges.core.dao.ComodoDAO;
import br.com.secureedges.domain.Comodo;

public class ComodoDAOTeste {

	@Test
	public void salvar() {
		Comodo comodo = new Comodo();
		comodo.setDescricao("Sala");
		ComodoDAO dao = new ComodoDAO();
		dao.salvar(comodo);

	}

	@Test
	public void listar() {
		ComodoDAO dao = new ComodoDAO();
		List<Comodo> comodos = dao.listar();
		System.out.println("\n");
		System.out.println(comodos);
		System.out.println("\n");
	}

	@Test
	public void buscarPorCodigo() {
		ComodoDAO dao = new ComodoDAO();
		Comodo f1 = dao.buscarPorCodigo(1L);
		System.out.println(f1);

	}

	@Test
	@Ignore
	public void Excluir() {
		ComodoDAO dao = new ComodoDAO();
		Comodo comodo = dao.buscarPorCodigo(1L);
		if (comodo != null)
			dao.excluir(comodo);
	}

	/*
	 * @Test
	 * 
	 * @Ignore public void ExcluirPorCodigo(Long codigo) { ComodoDAO dao = new
	 * ComodoDAO(); dao.Excluir(3L);
	 * 
	 * }
	 */

	@Test

	public void Editar() {
		ComodoDAO dao = new ComodoDAO();
		Comodo comodo = dao.buscarPorCodigo(1L);
		comodo.setDescricao("DescriacaoX");
		if (comodo != null)
			dao.editar(comodo);
	}

}
