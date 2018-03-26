package tk.douglazsilva.agendaeletronica;

import org.apache.wicket.markup.html.basic.Label;

public class Criar extends BasePage{	
	
	private static final long serialVersionUID = 3762781362998387919L;

	public Criar() {
		add(new Label("titulo", "Criação de Contato"));
	}

}
