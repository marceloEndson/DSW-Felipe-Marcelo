package jogos;

import java.util.List;

import model.Jogos;

public interface IJogosDAO {
	
	public Jogos getJogo(int id);
	
	public List<Jogos> lista();

}
