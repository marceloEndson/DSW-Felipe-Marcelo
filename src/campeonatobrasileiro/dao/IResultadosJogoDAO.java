package campeonatobrasileiro.dao;

import java.util.List;

import campeonatobrasileiro.model.ResultadosJogo;

public interface IResultadosJogoDAO {
	
	public ResultadosJogo getResultadoJogo(int id);
	
	public List<ResultadosJogo> lista();
	
	public boolean atualizarResultadoJogo(ResultadosJogo resultadoJogo);
	
	public int getRodadaAtual();

}