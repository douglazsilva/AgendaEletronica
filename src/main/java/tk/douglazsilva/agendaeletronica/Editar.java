package tk.douglazsilva.agendaeletronica;

import java.sql.Connection;

import org.apache.wicket.markup.html.basic.Label;

import tk.douglazsilva.agendaeletronica.contato.Contato;
import tk.douglazsilva.agendaeletronica.contato.ContatoDAO;

public class Editar extends Criar {
	
	private static final long serialVersionUID = -8140569558578354433L;

	public Editar(Contato contato) {
		super(contato);
		replace(new Label("titulo", "Edição de Contato"));
	}	
	
	protected void salvar(Contato contatoSubmetido) {
		Connection conexao = ((WicketApplication) getApplication()).getConexao();
		ContatoDAO dao = new ContatoDAO(conexao);
		dao.atualizar(contatoSubmetido);
	}
}
