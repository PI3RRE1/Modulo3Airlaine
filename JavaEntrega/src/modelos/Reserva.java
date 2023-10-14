package modelos;

import java.util.Date;

	public class Reserva {
		private int id;
		private Date data_reserva;
		private int num_pessoas;
		private boolean cancelado;
		private Cliente cliente;
		private Voo voo;
		
		
		public Reserva() {
			super();
		}


		public Reserva(Date data_reserva, int num_pessoas, boolean cancelado, Cliente cliente, Voo voo) {
			super();
			this.data_reserva = data_reserva;
			this.num_pessoas = num_pessoas;
			this.cancelado = cancelado;
			this.cliente = cliente;
			this.voo = voo;
		}


		public Reserva(int id, Date data_reserva, int num_pessoas, boolean cancelado, Cliente cliente, Voo voo) {
			super();
			this.id = id;
			this.data_reserva = data_reserva;
			this.num_pessoas = num_pessoas;
			this.cancelado = cancelado;
			this.cliente = cliente;
			this.voo = voo;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public Date getData_reserva() {
			return data_reserva;
		}


		public void setData_reserva(Date data_reserva) {
			this.data_reserva = data_reserva;
		}


		public int getNum_pessoas() {
			return num_pessoas;
		}


		public void setNum_pessoas(int num_pessoas) {
			this.num_pessoas = num_pessoas;
		}


		public boolean isCancelado() {
			return cancelado;
		}


		public void setCancelado(boolean cancelado) {
			this.cancelado = cancelado;
		}


		public Cliente getCliente() {
			return cliente;
		}


		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}


		public Voo getVoo() {
			return voo;
		}


		public void setVoo(Voo voo) {
			this.voo = voo;
		}
		
		public void mostrar () {
			System.out.println("=====================================================================================");
			System.out.println("ID: " + this.id);
			System.out.println("Data Reserva: " + this.data_reserva);
			System.out.println("Numero de Pessoas: " + this.num_pessoas);
			System.out.println("Cancelado: " + this.cancelado);
			System.out.println("Cliente: " + this.cliente.getNome());
			System.out.println("Voo: " + this.voo.getDestino());
			System.out.println("=====================================================================================");
			
		}
		
		
		
}
