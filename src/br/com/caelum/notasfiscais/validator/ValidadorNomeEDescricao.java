package br.com.caelum.notasfiscais.validator;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

@FacesValidator("validadorNomeEDescricao")
public class ValidadorNomeEDescricao implements Validator,Serializable{

	private static final long serialVersionUID = -593855679207943679L;
	
	@Inject @InputField
	private String nome;
	
	@Inject @InputField
	private String descricao;
	
	@Override
	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {
		
		if(nome != null && descricao != null && nome.equals(descricao)){
			throw new ValidatorException(new FacesMessage("Nome e Descricao náo podem ser iguais", "teste"));
		}
	}

}
