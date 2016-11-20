package br.com.secureedges.core.web.bean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.secureedges.core.dao.ComodoDAO;
import br.com.secureedges.core.dao.Tipo_DispositivoDAO;
import br.com.secureedges.domain.Comodo;
import br.com.secureedges.domain.EntidadeDominio;
import br.com.secureedges.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ComodoBean {
	private Comodo comodo;
	List<EntidadeDominio> listaComodos;
	List<Comodo> listaComodosFiltrados;

	public Comodo getComodo() {
		if (comodo == null)
			comodo = new Comodo();
		return comodo;
	}

	public void setComodo(Comodo comodo) {
		this.comodo = comodo;
	}

	public List<EntidadeDominio> getListaComodos() {
		return listaComodos;
	}

	public void setListaComodos(List<EntidadeDominio> listaComodos) {
		this.listaComodos = listaComodos;
	}

	public List<Comodo> getListaComodosFiltrados() {
		return listaComodosFiltrados;
	}

	public void setListaComodosFiltrados(List<Comodo> listaComodosFiltrados) {
		this.listaComodosFiltrados = listaComodosFiltrados;
	}

	public void salvar() throws SQLException {
		FacesUtil.adicionarMSGInfo("Salvo com Sucesso");
		FacesUtil.adicionarMSGInfo(comodo.toString());
		ComodoDAO comodoDAO = new ComodoDAO();
		comodoDAO.Salvar(comodo);

	}

	public void carregar() {
		try {
			ComodoDAO comodoDAO = new ComodoDAO();
			listaComodos = comodoDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMSGError("Erro ao Carregar");
		}
	}

}
