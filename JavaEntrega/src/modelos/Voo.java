package modelos;

import java.util.Date;

public class Voo {
	private int id;
	private int numero_assento;
	private String origem;
	private String destino;
	private String companhia_aerea;
	private String aereporto;
	private Date data_embarque;
	private double preco;
	
	
	public Voo() {
		super();
	}


	public Voo(int numero_assento, String origem, String destino, String companhia_aerea, String aereporto,
			Date data_embarque, double preco) {
		super();
		this.numero_assento = numero_assento;
		this.origem = origem;
		this.destino = destino;
		this.companhia_aerea = companhia_aerea;
		this.aereporto = aereporto;
		this.data_embarque = data_embarque;
		this.preco = preco;
	}


	public Voo(int id, int numero_assento, String origem, String destino, String companhia_aerea, String aereporto,
			Date data_embarque, double preco) {
		super();
		this.id = id;
		this.numero_assento = numero_assento;
		this.origem = origem;
		this.destino = destino;
		this.companhia_aerea = companhia_aerea;
		this.aereporto = aereporto;
		this.data_embarque = data_embarque;
		this.preco = preco;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumero_assento() {
		return numero_assento;
	}


	public void setNumero_assento(int numero_assento) {
		this.numero_assento = numero_assento;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getCompanhia_aerea() {
		return companhia_aerea;
	}


	public void setCompanhia_aerea(String companhia_aerea) {
		this.companhia_aerea = companhia_aerea;
	}


	public String getAereporto() {
		return aereporto;
	}


	public void setAereporto(String aereporto) {
		this.aereporto = aereporto;
	}


	public Date getData_embarque() {
		return data_embarque;
	}


	public void setData_embarque(Date data_embarque) {
		this.data_embarque = data_embarque;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void mostrar () {
		System.out.println("=====================================================================================");
		System.out.println("ID: " + this.id);
		System.out.println("Numero Assento: " + this.numero_assento);
		System.out.println("Origem: " + this.origem);
		System.out.println("Destino: " + this.destino);
		System.out.println("Companhia Aerea: " + this.companhia_aerea);
		System.out.println("Aeroporto: " + this.aereporto);
		System.out.println("Data Embarque: " + this.data_embarque);
		System.out.println("Preço: " + this.preco);
		System.out.println("=====================================================================================");
		
	}
	
	
}
