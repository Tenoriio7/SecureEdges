package br.com.secureedges.domain;

import java.util.List;

import br.com.secureedges.core.dao.DispositivoDAO;
import br.com.secureedges.core.dao.RelatorioDAO;


public class Grafico extends EntidadeDominio {
	 
	public RelatorioDAO relatorioDAO =  new RelatorioDAO();
	public List<EntidadeDominio> relatorios = relatorioDAO.listar();
	private DispositivoDAO dispositivoDAO = new DispositivoDAO();
	public List<EntidadeDominio> dispositivos = dispositivoDAO.listar();
	

}