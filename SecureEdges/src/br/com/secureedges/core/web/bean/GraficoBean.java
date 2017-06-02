package br.com.secureedges.core.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.junit.Test;

import br.com.secureedges.core.dao.RelatorioDAO;
import br.com.secureedges.domain.EntidadeDominio;

@ManagedBean
@ViewScoped
public class GraficoBean extends EntidadeDominio {
	 
	public RelatorioDAO relatorioDAO =  new RelatorioDAO();
	public List<EntidadeDominio> relatorios = relatorioDAO.listar();
	

}