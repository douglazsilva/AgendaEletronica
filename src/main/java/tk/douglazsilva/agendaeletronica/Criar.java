package tk.douglazsilva.agendaeletronica;

import java.sql.Connection;
import java.util.Arrays;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tk.douglazsilva.agendaeletronica.contato.Contato;
import tk.douglazsilva.agendaeletronica.contato.ContatoDAO;
import tk.douglazsilva.agendaeletronica.contato.EstadoCivil;

public class Criar extends BasePage{	
	
	private static final long serialVersionUID = 3762781362998387919L;

	public Criar() {
		add(new Label("titulo", "Criação de Contato"));
		
		Contato contato = new Contato();
		CompoundPropertyModel<Contato> compoundPropertyModelContato = new CompoundPropertyModel<Contato>(contato);
		Form<Contato> form = new Form<Contato>("formularioContato",compoundPropertyModelContato) {			
			private static final long serialVersionUID = -5576287141403246286L;
			
			@Override
			protected void onSubmit() {
				Contato contatoSubmetido = getModelObject();
				salvar(contatoSubmetido);
				setResponsePage(Inicio.class);
			}			
			
		};
		add(form);
		
		TextField<String> inputNome = new TextField<String>("nome");
		TextField<String> inputEmail = new TextField<String>("email");
		TextField<String> inputTelefone = new TextField<String>("telefone");
		DropDownChoice<EstadoCivil> comboEstadoCivil = new DropDownChoice<EstadoCivil>("estadoCivil", 
				Arrays.asList(EstadoCivil.values()), new IChoiceRenderer<EstadoCivil>() {
					
					private static final long serialVersionUID = 9115153490742453499L;					

					@Override
					public Object getDisplayValue(EstadoCivil arg0) {						
						return arg0.getLabel();
					}

					@Override
					public String getIdValue(EstadoCivil arg0, int arg1) {						
						return arg0.name();
					}
		});
		form.add(inputNome,inputEmail, inputTelefone, comboEstadoCivil);
	}
	
	private void salvar(Contato contatoSubmetido) {
		//System.out.println("Contato a inserir: " + contatoSubmetido);
		Connection conexao = ((WicketApplication) getApplication()).getConexao();
		ContatoDAO dao = new ContatoDAO(conexao);
		dao.inserir(contatoSubmetido);
	}

}
