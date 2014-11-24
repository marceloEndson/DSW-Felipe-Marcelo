package campeonatobrasileiro.model;

public class Grupos {
	private int id;
	private String nome;
	private int idDono;
	
	public Grupos() {
		this.id = -1;
		this.nome = "";
		this.idDono = -1;
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

	public int getIdDono() {
		return idDono;
	}

	public void setIdDono(int idDono) {
		this.idDono = idDono;
	}
	
	

}