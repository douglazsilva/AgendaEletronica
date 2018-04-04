package tk.douglazsilva.agendaeletronica.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
	
	private static final String INSERT_SQL = "INSERT INTO contato(nome, email, telefone, estado_civil) VALUES (?, ?, ?, ?)";
	private final static String UPDATE_SQL = "UPDATE contato SET nome=?, email=?, telefone=?, estado_civil=? WHERE id_contato=?";
	private static final String LIST_SQL = "SELECT id_contato, nome, email, telefone, estado_civil FROM contato WHERE nome LIKE ?";
	
	private Connection conexao;

	public ContatoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserir(Contato contato) {
		PreparedStatement ps = null;		
		try {
			ps = conexao.prepareStatement(INSERT_SQL);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getTelefone());
			ps.setString(4, contato.getEstadoCivil().name());
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
	
	public void atualizar(Contato contato) {
        PreparedStatement p = null;
        try {
            p = conexao.prepareStatement(UPDATE_SQL);
            p.setString(1, contato.getNome());
            p.setString(2, contato.getEmail());
            p.setString(3, contato.getTelefone());
            p.setString(4, contato.getEstadoCivil().name());
            p.setLong(5, contato.getId());
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (p != null) {
                try {
                    p.close();
                } catch (SQLException e) {
                }
            }
        }
    }
	
	public List<Contato> listarPorNome(String nome){
		List<Contato> contatos = new ArrayList<Contato>();
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(LIST_SQL);
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong(1));
				contato.setNome(rs.getString(2));
				contato.setEmail(rs.getString(3));
				contato.setTelefone(rs.getString(4));
				//contato.setEstadoCivil(EstadoCivil.valueOf(rs.getString(columnIndex)));
				
				contatos.add(contato);
			}
			return contatos;
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			//fechar rs antes
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
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
