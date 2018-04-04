package tk.douglazsilva.agendaeletronica.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
	
	private static final String INSERT_SQL = "INSERT INTO usuario(usuario, senha) VALUES (?, ?)";
	//private static final String LIST_SQL = "SELECT id_usuario, usuario, senha FROM usuario WHERE usuario LIKE ?";

	private Connection conexao;

	public UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserir(Usuario usuario) {
		PreparedStatement ps = null;		
		try {
			ps = conexao.prepareStatement(INSERT_SQL);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());
			ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
