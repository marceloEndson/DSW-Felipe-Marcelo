package model;

import java.sql.Blob;
import java.sql.Date;

public class Usuarios {
	private int id;
	private String login;
	private String nome;
	private String email;
	private String cidade;
	private Blob foto;
	private String senha;
	private int numeroPontos;
	private boolean administrator;
	private int numeroLogins;
	private Date ultimoLogin;
	
	public Usuarios() {
		this.id = -1;
		this.login = "";
		this.nome = "";
		this.email = "";
		this.cidade = "";
		this.senha = "";
		this.numeroPontos = 0;
		this.administrator = false;
		this.numeroLogins = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNumeroPontos() {
		return numeroPontos;
	}

	public void setNumeroPontos(int numeroPontos) {
		this.numeroPontos = numeroPontos;
	}

	public boolean isAdministrador() {
		return administrator;
	}

	public void setAdministrador(boolean administrador) {
		this.administrator = administrador;
	}

	public int getNumeroLogins() {
		return numeroLogins;
	}

	public void setNumeroLogins(int numeroLogins) {
		this.numeroLogins = numeroLogins;
	}

	public Date getUltimoLogin() {
		return ultimoLogin;
	}

	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}
	
	
	
	
}
