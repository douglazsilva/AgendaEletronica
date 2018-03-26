package tk.douglazsilva.agendaeletronica;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class Inicio extends BasePage{

	
	private static final long serialVersionUID = -3241050482647374041L;
	
	public Inicio() {
		Label labelBoasVindas = new Label("mensagemBoasVindas", Model.of("Bem vindo à agenda eletrônica"));
		add(labelBoasVindas);
	}

}
