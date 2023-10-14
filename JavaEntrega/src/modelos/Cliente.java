package modelos;

public class Cliente {
	private int id;
	private String cpf;
	private String nome;
	private String endereco;
	private String cep;
	private String telefone;
	private String email;
	private String senha;
	
	
	public Cliente() {
		super();
	}
	public Cliente(String cpf, String nome, String endereco, String cep, String telefone, String email, String senha) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	public Cliente(int id, String cpf, String nome, String endereco, String cep, String telefone, String email,
			String senha) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void mostrar () {
		System.out.println("=====================================================================================");
		System.out.println("ID: " + this.id);
		System.out.println("CPF: " + this.cpf);
		System.out.println("NOME: " + this.nome);
		System.out.println("ENDEREÇO: " + this.endereco);
		System.out.println("CEP: " + this.cep);
		System.out.println("TELEFONE: " + this.telefone);
		System.out.println("EMAIL: " + this.email);
		System.out.println("SENHA: " + this.senha);
		System.out.println("=====================================================================================");
		
	}

}
