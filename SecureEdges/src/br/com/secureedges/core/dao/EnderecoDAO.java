package br.com.secureedges.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.secureedges.domain.Endereco;
import br.com.secureedges.util.HibernateUtil;

public class EnderecoDAO {
	
	
	public void salvar(Endereco endereco) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(endereco);
			transacao.commit();
		} catch (RuntimeException ex) {
			if(transacao!=null)
			transacao.rollback();
			throw ex; 

		}finally{
			sessao.close();
		}
	}
	
	public List<Endereco> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Endereco> endereco = null;

		try {
			Query consulta = sessao.getNamedQuery("Endereco.listar");
			endereco = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return endereco;

	}
	
	public  Endereco buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Endereco endereco = null;
		try{
			Query consulta = sessao.getNamedQuery("Endereco.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			endereco = (Endereco)consulta.uniqueResult();
		}catch(RuntimeException ex)
		{
			throw ex;
		} finally{
			sessao.close();
		}
		if (endereco == null)
		{
			System.out.println("nulo");
		}
		return endereco;
	}
	
	
	public void excluir (Endereco endereco) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(endereco);
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
	
	
	public void editar(Endereco endereco) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(endereco);
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
