package br.com.caelum.notasfiscais.mb;

import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	
	public void grava(Usuario usr){
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		dao.adiciona(usr);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
