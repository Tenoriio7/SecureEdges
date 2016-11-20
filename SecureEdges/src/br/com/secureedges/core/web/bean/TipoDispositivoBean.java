package br.com.secureedges.core.web.bean;


import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.secureedges.core.dao.Tipo_DispositivoDAO;
import br.com.secureedges.domain.EntidadeDominio;
import br.com.secureedges.domain.Tipo_Dispositivo;
import br.com.secureedges.util.FacesUtil;

@ManagedBean
@ViewScoped
public class TipoDispositivoBean {
	private Tipo_Dispositivo tpDispositivo;
	List<EntidadeDominio> listatpDispositivo;
	List<Tipo_Dispositivo>listatpDispositivoFiltrados;
	
	public Tipo_Dispositivo getTpDispositivo() {
		if(tpDispositivo == null)
			tpDispositivo = new Tipo_Dispositivo();
		return tpDispositivo;
	}
	public void setTpDispositivo(Tipo_Dispositivo tpDispositivo) {
		this.tpDispositivo = tpDispositivo;
	}
	public List<EntidadeDominio> getListatpDispositivo() {
		return listatpDispositivo;
	}
	public void setListatpDispositivo(List<EntidadeDominio> listatpDispositivo) {
		this.listatpDispositivo = listatpDispositivo;
	}
	public List<Tipo_Dispositivo> getListatpDispositivoFiltrados() {
		return listatpDispositivoFiltrados;
	}
	public void setListatpDispositivoFiltrados(List<Tipo_Dispositivo> listatpDispositivoFiltrados) {
		this.listatpDispositivoFiltrados = listatpDispositivoFiltrados;
	}
	
	public void salvar() throws SQLException {
				FacesUtil.adicionarMSGInfo("Salvo com Sucesso");
				FacesUtil.adicionarMSGInfo(tpDispositivo.toString());
				Tipo_DispositivoDAO tpDispositivoDAO = new Tipo_DispositivoDAO();
				tpDispositivoDAO.Salvar(tpDispositivo);
		
	}
	
	public void carregar()
	{
		try{
			Tipo_DispositivoDAO tipo_DispositivoDAO = new Tipo_DispositivoDAO();
			listatpDispositivo = tipo_DispositivoDAO.listar();
			
			
		}catch (RuntimeException ex) {
			FacesUtil.adicionarMSGError("Erro ao Carregar");
		}
	}

}
