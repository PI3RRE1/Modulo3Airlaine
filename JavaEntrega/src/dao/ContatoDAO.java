package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Contato;

public class ContatoDAO {
	
	public void create(Contato contato) {

		String sql = "insert into Contato (nome, telefone, email, assunto, mensagem) values (?, ?, ?, ?, ? )";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getTelefone());
			pstm.setString(3, contato.getEmail());
			pstm.setString(4, contato.getAssunto());
			pstm.setString(5, contato.getMensagem());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public List<Contato> read() {
		List<Contato> contatos = new ArrayList<Contato>();
		String sql = "select * from Contato";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Contato contato = new Contato();

				contato.setId(rset.getInt("id_contato"));
				contato.setNome(rset.getString("nome"));
				contato.setTelefone(rset.getString("telefone"));
				contato.setEmail(rset.getString("email"));
				contato.setAssunto(rset.getString("assunto"));
				contato.setMensagem(rset.getString("mensagem"));

				contatos.add(contato);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return contatos;
	}
	
	public void update(Contato contato) {
		String sql = "UPDATE Contato SET nome = ?, telefone = ?, email = ?, assunto = ?, mensagem = ? WHERE id_contato = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getTelefone());
			pstm.setString(3, contato.getEmail());
			pstm.setString(4, contato.getAssunto());
			pstm.setString(5, contato.getMensagem());
			pstm.setInt(6, contato.getId());
			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void delete(int id) {
		String sql = "DELETE FROM Contato WHERE id_contato = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public Contato readById(int id) {
		Contato contato = new Contato();
		String sql = "select * from Contato WHERE id_contato = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			contato.setId(rset.getInt("id_contato"));
			contato.setNome(rset.getString("nome"));
			contato.setTelefone(rset.getString("telefone"));
			contato.setEmail(rset.getString("email"));
			contato.setAssunto(rset.getString("assunto"));
			contato.setMensagem(rset.getString("mensagem"));
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contato;
	}

}
