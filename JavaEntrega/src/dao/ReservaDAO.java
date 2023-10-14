package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Cliente;

import modelos.Reserva;
import modelos.Voo;

public class ReservaDAO {
	
	public void create(Reserva reserva) {

		String sql = "insert into Reserva (data_reserva, num_pessoas, cancelado, id_cliente, id_voo ) values (?, ?, ?, ?, ? )";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new Date( reserva.getData_reserva().getTime()));
			pstm.setInt(2, reserva.getNum_pessoas());
			pstm.setBoolean(3, reserva.isCancelado());
			pstm.setInt(4, reserva.getCliente().getId());
			pstm.setInt(5, reserva.getVoo().getId());

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
	
	public List<Reserva> read() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		String sql = "select * from Reserva";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reserva = new Reserva();

				reserva.setId(rset.getInt("id_reserva"));
				reserva.setData_reserva(rset.getDate("data_reserva"));
				reserva.setNum_pessoas(rset.getInt("num_pessoas"));
				reserva.setCancelado(rset.getBoolean("cancelado"));
				int clienteid = rset.getInt("id_cliente");
				ClienteDAO clientedao = new ClienteDAO();
				Cliente cliente = clientedao.readById(clienteid);
				reserva.setCliente(cliente);
				int vooid = rset.getInt("id_voo");
				VooDAO voodao = new VooDAO();
				Voo voo = voodao.readById(vooid);
				reserva.setVoo(voo);

				reservas.add(reserva);
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

		return reservas;
	}
	
	public void update(Reserva reserva) {
		String sql = "UPDATE Reserva SET data_reserva = ?, num_pessoas = ?, cancelado = ?, id_cliente = ?, id_voo = ? WHERE id_reserva = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			
			pstm.setDate(1, new Date( reserva.getData_reserva().getTime()));
			pstm.setInt(2, reserva.getNum_pessoas());
			pstm.setBoolean(3, reserva.isCancelado());
			pstm.setInt(4, reserva.getCliente().getId());
			pstm.setInt(5, reserva.getVoo().getId());
			pstm.setInt(6, reserva.getId());

			
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
		String sql = "DELETE FROM Reserva WHERE id_reserva = ?";

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
	
	public Reserva readById(int id) {
		Reserva reserva = new Reserva();
		String sql = "select * from Reserva WHERE id_reserva = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			reserva.setId(rset.getInt("id_reserva"));
			reserva.setData_reserva(rset.getDate("data_reserva"));
			reserva.setNum_pessoas(rset.getInt("num_pessoas"));
			reserva.setCancelado(rset.getBoolean("cancelado"));
			int clienteid = rset.getInt("id_cliente");
			ClienteDAO clientedao = new ClienteDAO();
			Cliente cliente = clientedao.readById(clienteid);
			reserva.setCliente(cliente);
			int vooid = rset.getInt("id_voo");
			VooDAO voodao = new VooDAO();
			Voo voo = voodao.readById(vooid);
			reserva.setVoo(voo);
			

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
		return reserva;
	}
	
}
