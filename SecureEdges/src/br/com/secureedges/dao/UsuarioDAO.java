package br.com.secureedges.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.secureedges.models.Usuario;
import br.com.secureedges.util.HibernateUtil;

public class UsuarioDAO {
	
	
	public void salvar(Usuario Usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(Usuario);
			transacao.commit();
		} catch (RuntimeException ex) {
			if(transacao!=null)
			transacao.rollback();
			throw ex; 

		}finally{
			sessao.close();
		}
	}
	
	public List<Usuario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			usuarios = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return usuarios;

	}
	
	public  Usuario buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;
		try{
			Query consulta = sessao.getNamedQuery("Usuario.buscarProCodigo");
			consulta.setLong("codigo", codigo);
			usuario = (Usuario)consulta.uniqueResult();
		}catch(RuntimeException ex)
		{
			throw ex;
		} finally{
			sessao.close();
		}
		return usuario;
	}
	
	
	public void excluir (Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(usuario);
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
	
	
	public void editar(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(usuario);
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
	
	public Usuario autenticar (String cpf, String senha){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.autenticar");
			consulta.setString("cpf", cpf);
			consulta.setString("senha", senha);
			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return usuario;  
		
	}


}
