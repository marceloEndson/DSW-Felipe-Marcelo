package campeonatobrasileiro.dao;

import java.util.List;

import campeonatobrasileiro.model.Palpites;

public interface IPalpitesDAO {
	
	public Palpites getPalpite(int idUsuario, int idJogo);
	
	public List<Palpites> lista();
	
	public boolean indicarPalpite(Palpites palpite);
}