package campeonatobrasileiro.dao;

import java.util.List;
import campeonatobrasileiro.model.Jogos;


public interface IJogosDAO {
	
	public Jogos getJogo(int id);
	
	public List<Jogos> getLista();

}