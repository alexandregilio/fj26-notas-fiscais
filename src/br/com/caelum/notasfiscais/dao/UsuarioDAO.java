package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.notasfiscais.modelo.Usuario;

public class UsuarioDAO implements Serializable{

	private static final long serialVersionUID = -3773813239409166061L;
	
	
	private EntityManager em;
	
	@Inject
	private UsuarioDAO(EntityManager em){
		this.em = em;
	} 
	
	private UsuarioDAO(){
	}
	
	public boolean existe(Usuario usuario) {
		
		Query query = em.createQuery("from Usuario where login = :login and senha = :senha")
						.setParameter("login", usuario.getLogin())
						.setParameter("senha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();
		System.out.println(encontrado);
		return encontrado;
	}
}