package br.com.secureedges.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.secureedges.models.Tipo_Dispositivo;
import br.com.secureedges.util.HibernateUtil;

public class Tipo_DispositivoDAO {
	public void salvar(Tipo_Dispositivo Tipo_Dispositivo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(Tipo_Dispositivo);
			transacao.commit();
		} catch (RuntimeException ex) {
			if(transacao!=null)
			transacao.rollback();
			throw ex; 

		}finally{
			sessao.close();
		}
	}
	
	public List<Tipo_Dispositivo> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Tipo_Dispositivo> tipo_dispositivos = null;

		try {
			Query consulta = sessao.getNamedQuery("Tipo_Dispositivo.listar");
			tipo_dispositivos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return tipo_dispositivos;

	}
	
	public static Tipo_Dispositivo buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Tipo_Dispositivo tipo_dispositivo = null;
		try{
			Query consulta = sessao.getNamedQuery("Tipo_Dispositivo.buscarProCodigo");
			consulta.setLong("codigo", codigo);
			tipo_dispositivo = (Tipo_Dispositivo)consulta.uniqueResult();
		}catch(RuntimeException ex)
		{
			throw ex;
		} finally{
			sessao.close();
		}
		return tipo_dispositivo;
	}
	
	
	public void excluir (Tipo_Dispositivo tipo_dispositivo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(tipo_dispositivo);
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
	
	
	public void editar(Tipo_Dispositivo tipo_dispositivo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(tipo_dispositivo);
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
