package br.com.secureedges.testes;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.secureedges.core.dao.ComodoDAO;
import br.com.secureedges.core.dao.DispositivoDAO;
import br.com.secureedges.core.dao.Tipo_DispositivoDAO;
import br.com.secureedges.domain.Comodo;
import br.com.secureedges.domain.Dispositivo;
import br.com.secureedges.domain.Tipo_Dispositivo;

public class DispositivoDAOTeste {
	@Test
	@Ignore
	public void salvar ()
	{
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setDescricao("Luz");
		Comodo comodo =  new Comodo();
		ComodoDAO dao = new ComodoDAO();
		comodo=dao.buscarPorCodigo(1L);
		dispositivo.setComodo(comodo);
		Tipo_Dispositivo tp = new  Tipo_Dispositivo();
		tp=Tipo_DispositivoDAO.buscarPorCodigo(1L);
		dispositivo.setTP_Dispositivo(tp);
		DispositivoDAO daoDispositivo = new DispositivoDAO();
		daoDispositivo.salvar(dispositivo);
		
	}
	@Test
	public void listar() {
		DispositivoDAO dao = new DispositivoDAO();
		List<Dispositivo> dispositivo = dao.listar();
		System.out.println("\n");
		System.out.println(dispositivo);
		System.out.println("\n");
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		DispositivoDAO dao = new DispositivoDAO();
		Dispositivo f1 = dao.buscarPorCodigo(3L);
		System.out.println(f1);
	}

	@Test
	@Ignore
	public void Excluir() {
		DispositivoDAO dao = new DispositivoDAO();
		Dispositivo dispositivo = dao.buscarPorCodigo(2L);
		if (dispositivo != null)
			dao.excluir(dispositivo);
	}

	/*
	 * @Test
	 * 
	 * @Ignore public void ExcluirPorCodigo(Long codigo) { DispositivoDAO dao = new
	 * DispositivoDAO(); dao.Excluir(3L);
	 * 
	 * }
	 */

	@Test
	@Ignore
	public void Editar() {
		DispositivoDAO dao = new DispositivoDAO();
		Dispositivo dispositivo = dao.buscarPorCodigo(2L);
		dispositivo.setDescricao("DescriacaoX");
		if (dispositivo != null)
			dao.editar(dispositivo);
	}
	

}
