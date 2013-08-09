package br.com.caelum.notasfiscais.mb;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@SessionScoped
@Named
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 8318227471966486607L;

	@Inject
	private UsuarioDAO dao;
	@Inject
	private UsuarioLogado usuarioLogado;
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public String efetuaLogin(){
		
		boolean loginValido = dao.existe(this.usuario);
		
		if (loginValido){
			usuarioLogado.setUsuario(usuario);
			return "produto?faces-redirect=true";
		}else{
			usuarioLogado.setUsuario(null);
			return "login";
		}
		
	}
	
	public boolean isLogado(){
		return usuarioLogado.isLogado();
	}
	
	public String logout(){
		this.usuario = new Usuario();
		return "login";
	}
	
}
