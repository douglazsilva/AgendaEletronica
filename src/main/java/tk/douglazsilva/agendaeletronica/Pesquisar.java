package tk.douglazsilva.agendaeletronica;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import tk.douglazsilva.agendaeletronica.contato.Contato;
import tk.douglazsilva.agendaeletronica.contato.ContatoDAO;

public class Pesquisar extends BasePage {

	private static final long serialVersionUID = 4140393735013934391L;	
	
	private ContatoDAO dao = new ContatoDAO(((WicketApplication) getApplication()).getConexao());

	public Pesquisar() {
		Form<String> formPesquisa = new Form<String>("formPesquisa");
		add(formPesquisa);
		
		final TextField<String> pesquisaNome = new TextField<String>("pesquisaNome", new Model<String>());
		formPesquisa.add(pesquisaNome);
		
		final WebMarkupContainer containerResultados = new WebMarkupContainer("divResultados");
		containerResultados.setVisible(false);
		containerResultados.setOutputMarkupPlaceholderTag(true);
		add(containerResultados);
		
		final PropertyListView<Contato> listaResultados = new PropertyListView<Contato>("contatos", new ListModel<Contato>()) {
			private static final long serialVersionUID = 5041563898142279229L;
			@Override
			protected void populateItem(final ListItem<Contato> listItem) {
				listItem.add(new Label("nome"));
				listItem.add(new Label("email"));
				listItem.add(new Label("telefone"));
				listItem.add(new Label("estadoCivil"));
				listItem.add(new Link<Void>("linkEditar") {
                    
					private static final long serialVersionUID = -1795419836618844578L;

					@Override
                    public void onClick() {
                        setResponsePage(new Editar(listItem.getModelObject()));
                    }
                });
			}
		};
		containerResultados.add(listaResultados);
		
		AjaxButton botaoPesquisar = new AjaxButton("botaoPesquisar", formPesquisa) {
			private static final long serialVersionUID = 2094269088350251119L;			
			@Override
			public void onSubmit(AjaxRequestTarget target, Form<?> form) {
				String nomeAPesquisar = pesquisaNome.getConvertedInput();
                List<Contato> contatos = dao.listarPorNome(nomeAPesquisar);
                listaResultados.setDefaultModelObject(contatos);
				containerResultados.setVisible(true);
				target.add(containerResultados);
			}			
		};
		formPesquisa.add(botaoPesquisar);
	}
}
