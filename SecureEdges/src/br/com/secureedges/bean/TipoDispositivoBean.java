package br.com.secureedges.bean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.secureedges.core.dao.Tipo_DispositivoDAO;
import br.com.secureedges.domain.Tipo_Dispositivo;
import br.com.secureedges.util.FacesUtil;

@ManagedBean
@ViewScoped
public class TipoDispositivoBean {
	private Tipo_Dispositivo tpDispositivo;
	List<Tipo_Dispositivo>listatpDispositivo;
	List<Tipo_Dispositivo>listatpDispositivoFiltrados;
	
	public Tipo_Dispositivo getTpDispositivo() {
		if(tpDispositivo == null)
			tpDispositivo = new Tipo_Dispositivo();
		return tpDispositivo;
	}
	public void setTpDispositivo(Tipo_Dispositivo tpDispositivo) {
		this.tpDispositivo = tpDispositivo;
	}
	public List<Tipo_Dispositivo> getListatpDispositivo() {
		return listatpDispositivo;
	}
	public void setListatpDispositivo(List<Tipo_Dispositivo> listatpDispositivo) {
		this.listatpDispositivo = listatpDispositivo;
	}
	public List<Tipo_Dispositivo> getListatpDispositivoFiltrados() {
		return listatpDispositivoFiltrados;
	}
	public void setListatpDispositivoFiltrados(List<Tipo_Dispositivo> listatpDispositivoFiltrados) {
		this.listatpDispositivoFiltrados = listatpDispositivoFiltrados;
	}
	
	public void salvar() {
				FacesUtil.adicionarMSGInfo("Salvo com Sucesso");
				FacesUtil.adicionarMSGInfo(tpDispositivo.toString());
				Tipo_DispositivoDAO tpDispositivoDAO = new Tipo_DispositivoDAO();
				tpDispositivoDAO.salvar(tpDispositivo);
		
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
