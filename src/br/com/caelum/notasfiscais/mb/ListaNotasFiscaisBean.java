package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.datamodel.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@Named
public class ListaNotasFiscaisBean {

	private List<NotaFiscal> notas;
	private LazyDataModel<NotaFiscal> dataModel;
	
	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<NotaFiscal> dataModel) {
		this.dataModel = dataModel;
	}

	public List<NotaFiscal> getNotas() {
		return notas;
	}

	public void setNotas(List<NotaFiscal> notas) {
		this.notas = notas;
	}

	public List<NotaFiscal> lista(){
		
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		notas = dao.listaTodos();
		return notas;
	}
	
	public ListaNotasFiscaisBean(){
		
		this.dataModel = new DataModelNotasFiscais();
		
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		this.dataModel.setRowCount(dao.contaTodos());
		
		
		
	}
}
