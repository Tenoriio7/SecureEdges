package br.com.secureedges.core.web.bean;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.secureedges.core.dao.DispositivoDAO;
import br.com.secureedges.core.dao.SolicitacaoDAO;
import br.com.secureedges.core.dao.UsuarioDAO;
import br.com.secureedges.domain.Dispositivo;
import br.com.secureedges.domain.EntidadeDominio;
import br.com.secureedges.domain.Solicitacao;
import br.com.secureedges.domain.Usuario;
import br.com.secureedges.util.FacesUtil;


@ManagedBean
@ViewScoped
public class SolicitacaoBean {
	List<EntidadeDominio> listaDispositivos;
	List<Dispositivo> listaDispositivosFiltrados;
	private Solicitacao solicitacaoCadastro;
	// pegando o valor que esta no AutenticacaoBean passando para a variavel local o valor do bean
	@ManagedProperty(value="#{AutenticacaoBean}")
	private AutenticacaoBean AutenticacaoBean;

	public Solicitacao getsolicitacaoCadastro() {
		if(solicitacaoCadastro==null){
			solicitacaoCadastro = new Solicitacao();
		}	
		return solicitacaoCadastro;
	}
	public void setsolicitacaoCadastro(Solicitacao solicitacaoCadastro) {
		this.solicitacaoCadastro = solicitacaoCadastro;
	}
		
	public List<EntidadeDominio> getlistaDispositivos() {
		
		return listaDispositivos;
	}
	public void setlistaDispositivos(List<EntidadeDominio> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}
	public List<Dispositivo> getlistaDispositivosFiltrados() {
		

		return listaDispositivosFiltrados;
	}
	public void setlistaDispositivosFiltrados(List<Dispositivo> listaDispositivosFiltrados) {
		this.listaDispositivosFiltrados = listaDispositivosFiltrados;
	}
	public AutenticacaoBean getAutenticacaoBean() {
		return AutenticacaoBean;
	}
	public void setAutenticacaoBean(AutenticacaoBean AutenticacaoBean) {
		this.AutenticacaoBean = AutenticacaoBean;
	}
	
	public void carregarDispositivos()
	{
		try
		{
			DispositivoDAO dispositivoDAO = new DispositivoDAO();
			listaDispositivos = dispositivoDAO.listar();			
		}catch(RuntimeException ex)
		{
			
			FacesUtil.adicionarMSGError("Erro ao tentar listar os  Produtos:"+ex.getMessage());
			
		}
	}
	
	public void adicionar(Dispositivo dispositivo){
		
	
		solicitacaoCadastro.setDispositivo(dispositivo);
		solicitacaoCadastro.setStatus("nova");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		solicitacaoCadastro.setUsuario(usuarioDAO.buscarPorCodigo(1L));
	}
	
	public void remover (Dispositivo dispositivo)
	{
		solicitacaoCadastro.setDispositivo(null);
		solicitacaoCadastro.setStatus("reprovada");
		solicitacaoCadastro.setUsuario(null);
			
		
	}
	
	public void carregarDadosSolicitacao( ) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario;
		SolicitacaoDAO SolicitacaoDAO = new SolicitacaoDAO();
		solicitacaoCadastro=new Solicitacao();
		usuario=usuarioDAO.buscarPorCodigo(AutenticacaoBean.getUsuarioLogado().getCodigo());
		solicitacaoCadastro.setUsuario(usuario);
		SolicitacaoDAO.Salvar(solicitacaoCadastro);		
	}
	
	public void  salvar(Dispositivo dispositivo){
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario;
			solicitacaoCadastro=new Solicitacao();
			solicitacaoCadastro.setDispositivo(dispositivo);
			usuario=usuarioDAO.buscarPorCodigo(AutenticacaoBean.getUsuarioLogado().getCodigo());
			solicitacaoCadastro.setUsuario(usuario);
			
		} catch (RuntimeException e) {
			FacesUtil.adicionarMSGError("Erro ao Salvar Solicitacao:" +e.getMessage());
		}
	}
}
