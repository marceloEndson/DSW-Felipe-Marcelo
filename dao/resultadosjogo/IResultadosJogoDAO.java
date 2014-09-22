package resultadosjogo;

import java.util.List;

import model.ResultadosJogo;

public interface IResultadosJogoDAO {
	
	public ResultadosJogo getResultadoJogo(int id);
	
	public List<ResultadosJogo> lista();
	
	public boolean atualizarResultadoJogo(ResultadosJogo resultadoJogo);

}
