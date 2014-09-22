package model;

import java.sql.Date;

public class Jogos {
	private int id;
	private int idMandante;
	private int idVisitante;
	private int rodada;
	private String estadio;
	private Date dataHora;
	
	public Jogos() {
		this.id = -1;
		this.idMandante = -1;
		this.idVisitante = -1;
		this.rodada = -1;
		this.estadio = "";
		this.dataHora = new Date(80991131);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMandante() {
		return idMandante;
	}

	public void setIdMandante(int idMandante) {
		this.idMandante = idMandante;
	}

	public int getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	

}
