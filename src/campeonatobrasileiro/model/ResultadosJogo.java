package campeonatobrasileiro.model;

public class ResultadosJogo {
	private int id;
	private int idJogo;
	private int golsMandante;
	private int golsVisitante;
	
	public ResultadosJogo() {
		this.id = -1;
		this.idJogo = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public int getGolsMandante() {
		return golsMandante;
	}

	public void setGolsMandante(int golsMandante) {
		this.golsMandante = golsMandante;
	}

	public int getGolsVisitante() {
		return golsVisitante;
	}

	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}	

}