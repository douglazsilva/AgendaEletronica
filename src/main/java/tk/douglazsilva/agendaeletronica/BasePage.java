package tk.douglazsilva.agendaeletronica;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class BasePage extends WebPage{
	
	private static final long serialVersionUID = 8153482270330143703L;

	public BasePage() {
		String userName = (String) getSession().getAttribute("userName");
		if (userName == null) {
			setResponsePage(Login.class);
			return;
		}
		
		add(new Link<Void>("sair") {
			
			private static final long serialVersionUID = -7654994815237509042L;

			@Override
			public void onClick() {
				getSession().invalidate();
				setResponsePage(Inicio.class);
			}
		});
	}

}
