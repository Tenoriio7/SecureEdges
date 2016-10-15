package br.com.secureedges.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.secureedges.domain.Solicitacao;
import br.com.secureedges.util.HibernateUtil;

public class SolicitacaoDAO {
	
	public  void salvar(Solicitacao Solicitacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(Solicitacao);
			transacao.commit();
		} catch (RuntimeException ex) {
			if(transacao!=null)
			transacao.rollback();
			throw ex; 

		}finally{
			sessao.close();
		}
	}
	
	public List<Solicitacao> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Solicitacao> solicitacaos = null;

		try {
			Query consulta = sessao.getNamedQuery("Solicitacao.listar");
			solicitacaos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return solicitacaos;

	}
	
	public Solicitacao buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Solicitacao solicitacao = null;
		try{
			Query consulta = sessao.getNamedQuery("Solicitacao.buscarProCodigo");
			consulta.setLong("codigo", codigo);
			solicitacao = (Solicitacao)consulta.uniqueResult();
		}catch(RuntimeException ex)
		{
			throw ex;
		} finally{
			sessao.close();
		}
		return solicitacao;
	}
	
	
	public void excluir (Solicitacao solicitacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(solicitacao);
			transacao.commit();
			}catch (RuntimeException ex){
				if(transacao !=null){
					transacao.rollback();
			}
			throw ex;
		} finally{
			sessao.close();
		}
		
	}
	
	
	public void editar(Solicitacao solicitacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(solicitacao);
			transacao.commit();
			}catch (RuntimeException ex){
				if(transacao !=null){
					transacao.rollback();
			}
			throw ex;
		} finally{
			sessao.close();
		}
		
	}

}
