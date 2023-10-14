package crud;

import java.util.Scanner;

import dao.ClienteDAO;
import modelos.Cliente;

public class ClienteCRUD {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		
		int opcao = 0, id = 0; 
		
		String cpf, nome, endereco, cep, telefone, email, senha ;
		
		
		do {
			
			System.out.println("\n============================== CLIENTES =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o cpf:");
				cpf = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o endereco:");
				endereco = s.nextLine();
				System.out.println("Digite o cep:");
				cep = s.nextLine();
				System.out.println("Digite o telefone:");
				telefone = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();
				
				
				clienteDAO.create(new Cliente(cpf, nome, endereco, cep, telefone, email, senha));
				break;
			case 2:
				
				for (Cliente c : clienteDAO.read()) {
					c.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o cpf:");
				cpf = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o endereco:");
				endereco = s.nextLine();
				System.out.println("Digite o cep:");
				cep = s.nextLine();
				System.out.println("Digite o telefone:");
				telefone = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();
				
				
				
				
				clienteDAO.update(new Cliente(id, cpf, nome, endereco, cep, telefone, email, senha));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				clienteDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Cliente cliente = clienteDAO.readById(id);
				
				cliente.mostrar();
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}
