package br.com.secureedges.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.secureedges.domain.Dispositivo;
import br.com.secureedges.util.HibernateUtil;

public class DispositivoDAO {
	
	
	public void salvar(Dispositivo dispositivo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(dispositivo);
			transacao.commit();
		} catch (RuntimeException ex) {
			if(transacao!=null)
			transacao.rollback();
			throw ex; 

		}finally{
			sessao.close();
		}
	}
	
	public List<Dispositivo> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Dispositivo> dispositivo = null;

		try {
			Query consulta = sessao.getNamedQuery("Dispositivo.listar");
			dispositivo = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return dispositivo;

	}
	
	public static Dispositivo buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Dispositivo dispositivo = null;
		try{
			Query consulta = sessao.getNamedQuery("Dispositivo.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			dispositivo = (Dispositivo)consulta.uniqueResult();
		}catch(RuntimeException ex)
		{
			throw ex;
		} finally{
			sessao.close();
		}
		return dispositivo;
	}
	
	
	public void excluir (Dispositivo dispositivo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(dispositivo);
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
	
	
	public void editar(Dispositivo dispositivo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(dispositivo);
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
