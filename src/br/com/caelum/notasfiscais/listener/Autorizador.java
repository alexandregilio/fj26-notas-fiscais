package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.caelum.notasfiscais.mb.LoginBean;

public class Autorizador implements PhaseListener {

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

	@Override
	public void afterPhase(PhaseEvent event) {

		FacesContext context = event.getFacesContext();
		
		if("/login.xhtml".equals(context.getViewRoot().getViewId())){
			return;
		}
		
		LoginBean lb = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		
		if(!lb.isLogado()){
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
	}
}
