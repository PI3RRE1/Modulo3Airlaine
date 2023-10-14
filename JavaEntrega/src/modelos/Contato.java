package modelos;


public class Contato {
	private int id;
	private String nome;
	private String telefone;
	private String email;
	private String assunto;
	private String mensagem;
	
	
	public Contato() {
		super();
	}


	public Contato(String nome, String telefone, String email, String assunto, String mensagem) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}


	public Contato(int id, String nome, String telefone, String email, String assunto, String mensagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAssunto() {
		return assunto;
	}


	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void mostrar () {
		System.out.println("=====================================================================================");
		System.out.println("ID: " + this.id);
		System.out.println("Nome: " + this.nome);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Email: " + this.email);
		System.out.println("Assunto: " + this.assunto);
		System.out.println("Mensagem: " + this.mensagem);
		System.out.println("=====================================================================================");
		
	}
	
	

}
