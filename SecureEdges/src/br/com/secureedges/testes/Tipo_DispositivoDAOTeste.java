package br.com.secureedges.testes;

import org.junit.Test;

import br.com.secureedges.core.dao.Tipo_DispositivoDAO;
import br.com.secureedges.domain.Dispositivo;
import br.com.secureedges.domain.Tipo_Dispositivo;

public class Tipo_DispositivoDAOTeste {
	
	@Test
	public void  salvar()
	{
		Tipo_Dispositivo tipo_Dispositivo = new Tipo_Dispositivo();
		tipo_Dispositivo.setGenero("iluminação");
		Tipo_DispositivoDAO dao = new Tipo_DispositivoDAO();
		dao.salvar(tipo_Dispositivo);
		
	}

}
