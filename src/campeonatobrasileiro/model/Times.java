package campeonatobrasileiro.model;

public class Times {
	private int id;
	private String nome;
	private String nomeCurto;
	private int pontosGanhos;
	private int numeroJogos;
	private int golsPro;
	private int golsContra;
	
	public Times() {
		this.id = -1;
		this.nome = "";
		this.nomeCurto = "";
		this.pontosGanhos = 0;
		this.numeroJogos = 0;
		this.golsPro = 0;
		this.golsContra = 0;
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

	public String getNomeCurto() {
		return nomeCurto;
	}

	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}

	public int getPontosGanhos() {
		return pontosGanhos;
	}

	public void setPontosGanhos(int pontosGanhos) {
		this.pontosGanhos = pontosGanhos;
	}

	public int getNumeroJogos() {
		return numeroJogos;
	}

	public void setNumeroJogos(int numeroJogos) {
		this.numeroJogos = numeroJogos;
	}

	public int getGolsPro() {
		return golsPro;
	}

	public void setGolsPro(int golsPro) {
		this.golsPro = golsPro;
	}

	public int getGolsContra() {
		return golsContra;
	}

	public void setGolsContra(int golsContra) {
		this.golsContra = golsContra;
	}	
	

}