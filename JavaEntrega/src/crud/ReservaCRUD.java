package crud;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.ReservaDAO;
import dao.VooDAO;
import modelos.Cliente;
import modelos.Reserva;
import modelos.Voo;

public class ReservaCRUD {
	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	ClienteDAO clienteDAO = new ClienteDAO();
	ReservaDAO reservaDAO = new ReservaDAO();
	VooDAO vooDAO = new VooDAO();
	
	int opcao = 0, id = 0,  num_pessoas, id_cliente, id_voo; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date data = new Date();
	String  data_reserva, status;
	boolean cancelado = false;
	
	
	do {
		
		System.out.println("\n============================== RESERVA =================================\n");
		System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
		opcao = s.nextInt();
		s.nextLine();
		
		switch (opcao) {
		case 1:
			
			System.out.println("Digite o ID do cliente:");
			id_cliente = s.nextInt();
			Cliente cliente = clienteDAO.readById(id_cliente);
			System.out.println("Digite o ID do voo:");
			id_voo = s.nextInt();
			Voo voo = vooDAO.readById(id_voo);
			s.nextLine();
			System.out.println("Digite a Data da Reserva:");
			data_reserva = s.nextLine();
			try {
				data = sdf.parse(data_reserva);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Digite o Numero de Pessoas:");
			num_pessoas = s.nextInt();
			s.nextLine();
			System.out.println("Informe o status da reserva");
			System.out.println("Digite C para cancelado e A para ativo");
			status = s.nextLine();
			cancelado = status.equals("C")? true:false;
			
			
			
			reservaDAO.create(new Reserva(data, num_pessoas, cancelado, cliente, voo));
			break;
		case 2:
			
			for (Reserva r : reservaDAO.read()) {
				r.mostrar();
			}
			
			break;
		case 3:
			
			System.out.println("Digite o id:");
			id = s.nextInt();
			s.nextLine();
			System.out.println("Digite o ID do cliente:");
			id_cliente = s.nextInt();
			Cliente cliente1 = clienteDAO.readById(id_cliente);
			System.out.println("Digite o ID do voo:");
			id_voo = s.nextInt();
			Voo voo1 = vooDAO.readById(id_voo);
			s.nextLine();
			System.out.println("Digite a Data da Reserva:");
			data_reserva = s.nextLine();
			try {
				data = sdf.parse(data_reserva);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Digite o Numero de Pessoas:");
			num_pessoas = s.nextInt();
			s.nextLine();
			System.out.println("Informe o status da reserva");
			System.out.println("Digite C para cancelado e A para ativo");
			status = s.nextLine();
			cancelado = status.equals("C")? true:false;
			
			
			
			
			reservaDAO.update(new Reserva(id, data, num_pessoas, cancelado, cliente1, voo1));
			break;
		case 4:
			System.out.println("Digite um id:");
			id = s.nextInt();
			s.nextLine();
			
			reservaDAO.delete(id);
			break;
		case 5:
			System.out.println("Digite um id:");
			id = s.nextInt();
			s.nextLine();
			
			Reserva reserva = reservaDAO.readById(id);
			
			reserva.mostrar();
			break;
		default:
			
			break;
		}
		
	} while (opcao != 0);
	
	System.out.println("Até mais!");
	s.close();

}

}

