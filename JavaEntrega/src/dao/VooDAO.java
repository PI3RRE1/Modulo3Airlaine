package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Voo;

public class VooDAO {
	
	public void create(Voo voo) {

		String sql = "insert into Voo (numero_assento, origem, destino, companhia_aerea, aeroporto, data_embarque, preco) values (?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, voo.getNumero_assento());
			pstm.setString(2, voo.getOrigem());
			pstm.setString(3, voo.getDestino());
			pstm.setString(4, voo.getCompanhia_aerea());
			pstm.setString(5, voo.getAereporto());
			pstm.setDate(6,new Date( voo.getData_embarque().getTime()));
			pstm.setDouble(7, voo.getPreco());

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
	
	public List<Voo> read() {
		List<Voo> voos = new ArrayList<Voo>();
		String sql = "select * from Voo";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Voo voo = new Voo();

				voo.setId(rset.getInt("id_voo"));
				voo.setNumero_assento(rset.getInt("numero_assento"));
				voo.setOrigem(rset.getString("origem"));
				voo.setDestino(rset.getString("destino"));
				voo.setCompanhia_aerea(rset.getString("companhia_aerea"));
				voo.setAereporto(rset.getString("aeroporto"));
				voo.setData_embarque(rset.getDate("data_embarque"));
				voo.setPreco(rset.getDouble("preco"));

				voos.add(voo);
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

		return voos;
	}
	
	public void update(Voo voo) {
		String sql = "UPDATE Voo SET numero_assento = ?, origem = ?, destino = ?, companhia_aerea = ?, aeroporto = ?, data_embarque = ?, preco = ? WHERE id_voo = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			
			pstm.setInt(1, voo.getNumero_assento());
			pstm.setString(2, voo.getOrigem());
			pstm.setString(3, voo.getDestino());
			pstm.setString(4, voo.getCompanhia_aerea());
			pstm.setString(5, voo.getAereporto());
			pstm.setDate(6,new Date( voo.getData_embarque().getTime()));
			pstm.setDouble(7, voo.getPreco());
			pstm.setInt(8, voo.getId());
			
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
		String sql = "DELETE FROM Voo WHERE id_voo = ?";

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
	
	public Voo readById(int id) {
		Voo voo = new Voo();
		String sql = "select * from Voo WHERE id_voo = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			voo.setId(rset.getInt("id_voo"));
			voo.setNumero_assento(rset.getInt("numero_assento"));
			voo.setOrigem(rset.getString("origem"));
			voo.setDestino(rset.getString("destino"));
			voo.setCompanhia_aerea(rset.getString("companhia_aerea"));
			voo.setAereporto(rset.getString("aeroporto"));
			voo.setData_embarque(rset.getDate("data_embarque"));
			voo.setPreco(rset.getDouble("preco"));
			

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
		return voo;
	}

}
