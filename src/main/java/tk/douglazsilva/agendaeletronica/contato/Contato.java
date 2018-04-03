package tk.douglazsilva.agendaeletronica.contato;

import java.io.Serializable;

public class Contato implements Serializable {

	private static final long serialVersionUID = -2809329970091208576L;
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private EstadoCivil estadoCivil;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@Override
	public String toString() {
		return "{Contato: nome='" + nome + "' email='" + email +"' telefone='"+ telefone +"'}";
	}
}
