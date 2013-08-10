package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ViewScoped
@Named
public class ProdutoBean implements Serializable{


	private static final long serialVersionUID = 8586404269864818730L;
	
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public Produto getProduto() {

		return this.produto;

	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void grava() {

		DAO<Produto> dao = new DAO<Produto>(Produto.class);

		if (produto.getId() == null) {
			dao.adiciona(produto);
		} else {
			dao.atualiza(produto);
		}
		this.produtos = new DAO<Produto>(Produto.class).listaTodos();
		this.produto = new Produto();

	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			produtos = new DAO<Produto>(Produto.class).listaTodos();
		}
		return produtos;
	}

	public void remove(Produto produto) {
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.remove(produto);
		this.produtos = new DAO<Produto>(Produto.class).listaTodos();
	}

	public void limpa() {
		this.produto = new Produto();
	}
}
