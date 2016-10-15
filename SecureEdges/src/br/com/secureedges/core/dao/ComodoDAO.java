package br.com.secureedges.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.secureedges.domain.Comodo;
import br.com.secureedges.util.HibernateUtil;

public class ComodoDAO {
	
	public void salvar(Comodo comodo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(comodo);
			transacao.commit();
		} catch (RuntimeException ex) {
			if(transacao!=null)
			transacao.rollback();
			throw ex; 

		}finally{
			sessao.close();
		}
	}
	
	public List<Comodo> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Comodo> comodo = null;

		try {
			Query consulta = sessao.getNamedQuery("Comodo.listar");
			comodo = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return comodo;

	}
	
	public static Comodo buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Comodo comodo = null;
		try{
			Query consulta = sessao.getNamedQuery("Comodo.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			comodo = (Comodo)consulta.uniqueResult();
		}catch(RuntimeException ex)
		{
			throw ex;
		} finally{
			sessao.close();
		}
		return comodo;
	}
	
	
	public void excluir (Comodo comodo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(comodo);
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
	
	
	public void editar(Comodo comodo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(comodo);
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
