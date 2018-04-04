package tk.douglazsilva.agendaeletronica.contato;

public class Usuario {
	
	private Long id;
	private String usuario;
	private String senha;
	
	public Usuario() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "{Usuario: usuario='" + usuario + "' senha='" + senha;
	}
}
