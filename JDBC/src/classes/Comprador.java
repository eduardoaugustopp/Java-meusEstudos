package classes;

import java.util.Objects;

public class Comprador {
	private Integer id;
	private String nome;
	private String cpf;
	
	
	public Comprador() {
	
	}
	
	
	public Comprador(Integer id, String cpf, String nome) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		
	}
	
	
	public Comprador(String cpf, String nome) {
		this.nome = nome;
		this.cpf = cpf;
		
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comprador other = (Comprador) obj;
		return Objects.equals(id, other.id);
	}
	
}
