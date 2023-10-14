package crud;

import java.util.Scanner;

import dao.ContatoDAO;
import modelos.Contato;

public class ContatoCRUD {
	
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ContatoDAO contatoDAO = new ContatoDAO();
		
		int opcao = 0, id = 0; 
		
		String  nome, telefone, email, assunto, mensagem ;
		
		
		do {
			
			System.out.println("\n============================== CONTATO =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				
				System.out.println("Digite o Nome:");
				nome = s.nextLine();
				System.out.println("Digite o Telefone:");
				telefone = s.nextLine();
				System.out.println("Digite o Email:");
				email = s.nextLine();
				System.out.println("Digite o Assunto:");
				assunto = s.nextLine();
				System.out.println("Digite a Mensagem:");
				mensagem = s.nextLine();
				
				
				contatoDAO.create(new Contato(nome, telefone, email, assunto, mensagem));
				break;
			case 2:
				
				for (Contato c : contatoDAO.read()) {
					c.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o Nome:");
				nome = s.nextLine();
				System.out.println("Digite o Telefone:");
				telefone = s.nextLine();
				System.out.println("Digite o Email:");
				email = s.nextLine();
				System.out.println("Digite o Assunto:");
				assunto = s.nextLine();
				System.out.println("Digite a Mensagem:");
				mensagem = s.nextLine();
				
				
				
				
				contatoDAO.update(new Contato(id, nome, telefone, email, assunto, mensagem));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				contatoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Contato contato = contatoDAO.readById(id);
				
				contato.mostrar();
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}
