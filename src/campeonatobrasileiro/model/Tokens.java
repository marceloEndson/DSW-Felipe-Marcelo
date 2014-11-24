package campeonatobrasileiro.model;

import java.sql.Date;

public class Tokens {
	private int id;
	private int idUsuario;
	private String token;
	private Date validade;
	
	public Tokens() {
		this.id = -1;
		this.idUsuario = -1;
		this.token = "";
		this.validade = new Date(80991131);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}	
	

}