package br.com.crud.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	private String genero;
	private String cpf;
	private List<Endereco> endereco;
	private Cartao cartao;
	private Telefone telefone;
	private String dtNascimento;
	private Login login;
	
	
	@Override
	public String toString() {
		return "Cliente [genero=" + genero + ", cpf=" + cpf + ", endereco=" + endereco + ", cartao=" + cartao
				+ ", telefone=" + telefone + ", dataNasc=" + dtNascimento + ", login=" + login + "]";
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDataNasc(String dataNasc) {
		this.dtNascimento = dataNasc;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Endereco> getEndereco() {
		return endereco;
	}
	private void initializeEndereco() {
        if (endereco == null) {
            endereco = new ArrayList<>();
        }
    }
	public void setEndereco(Endereco novoEndereco) {
        initializeEndereco();
        this.endereco.add(novoEndereco);
    }
	
	public Cliente(Integer id) {
		super();
		setId(id);
	}
	public Cliente(String nome) {
		super();
		setNome(nome);
	}
	public Cliente(String nome, String genero, String cpf, String dataNasc, Login login) {
		super();
		setNome(nome);
		this.genero = genero;
		this.cpf = cpf;
		this.dtNascimento = dataNasc;
		this.login = login;
	}
	public Cliente(String nome, String genero, String cpf, List<Endereco> endereco, Cartao cartao, Telefone telefone,
			String dataNasc, Login login) {
		super();
		setNome(nome);
		this.genero = genero;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cartao = cartao;
		this.telefone = telefone;
		this.dtNascimento = dataNasc;
		this.login = login;
	}
	
	
	
	
}
