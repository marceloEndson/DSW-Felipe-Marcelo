package grupos;

import java.util.List;

import model.Grupos;

public interface IGruposDAO {
	
	public Grupos getGrupo(int id);
	
	public List<Grupos> lista();
	
	public boolean criarGrupo(Grupos grupo);
	
	public boolean excluirGrupo(int id);	

}
