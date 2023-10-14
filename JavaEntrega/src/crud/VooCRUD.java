package crud;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.VooDAO;
import modelos.Voo;

public class VooCRUD {
	
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		VooDAO vooDAO = new VooDAO();
		
		int opcao = 0, id = 0; 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String origem, destino, companhia_aerea, aereporto, data_embarque;
		int numero_assento;
		double preco;
		Date data = new Date();
		
		do {
			
			System.out.println("\n============================== VOOS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o Numero de Assento:");
				numero_assento = s.nextInt();
				s.nextLine();
				System.out.println("Digite a Origem:");
				origem = s.nextLine();
				System.out.println("Digite o Destino:");
				destino = s.nextLine();
				System.out.println("Digite a Companhia  Aerea:");
				companhia_aerea = s.nextLine();
				System.out.println("Digite o Aeroporto:");
				aereporto = s.nextLine();
				System.out.println("Digite a Data de embarque:");
				data_embarque = s.nextLine();
				try {
					data = sdf.parse(data_embarque);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				System.out.println("Digite o Preço:");
				preco = s.nextDouble();
				
				
				vooDAO.create(new Voo(numero_assento, origem, destino, companhia_aerea, aereporto, data, preco));
				break;
			case 2:
				
				for (Voo v : vooDAO.read()) {
					v.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o Numero de Assento:");
				numero_assento = s.nextInt();
				s.nextLine();
				System.out.println("Digite a Origem:");
				origem = s.nextLine();
				System.out.println("Digite o Destino:");
				destino = s.nextLine();
				System.out.println("Digite a Companhia  Aerea:");
				companhia_aerea = s.nextLine();
				System.out.println("Digite o Aeroporto:");
				aereporto = s.nextLine();
				System.out.println("Digite a Data de embarque:");
				data_embarque = s.nextLine();
				try {
					data = sdf.parse(data_embarque);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				System.out.println("Digite o Preço:");
				preco = s.nextDouble();
				
				
				
				
				vooDAO.update(new Voo(id, numero_assento, origem, destino, companhia_aerea, aereporto, data, preco));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				vooDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Voo voo = vooDAO.readById(id);
				
				voo.mostrar();
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}
