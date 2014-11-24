package campeonatobrasileiro.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import campeonatobrasileiro.model.ResultadosJogo;

public class ResultadosJogoDAO implements IResultadosJogoDAO{

	private ResultadosJogo carrega(ResultSet rs) throws SQLException {
		ResultadosJogo resultadoJogo = new ResultadosJogo();
		resultadoJogo.setId(rs.getInt("id"));
		resultadoJogo.setIdJogo(rs.getInt("idJogo"));
		resultadoJogo.setGolsMandante(rs.getInt("golsMandante"));
		resultadoJogo.setGolsVisitante(rs.getInt("golsVisitante"));
		return resultadoJogo;
	}
	
	@Override
	public ResultadosJogo getResultadoJogo(int id) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		ResultadosJogo item = null;
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM resultadosJogo WHERE id = ?");
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
				item = carrega(rs);

			c.close();
		} catch (SQLException e) {
			SupportDAO.log(e.getMessage());
		}
		return item;
	}

	@Override
	public List<ResultadosJogo> lista() {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		List<ResultadosJogo> lista = new ArrayList<ResultadosJogo>();
		try{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM resultadosJogo");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				lista.add(carrega(rs));
			c.close();
		}catch (SQLException e){
			SupportDAO.log(e.getMessage());
		}
		return lista;
	}

	@Override
	public boolean atualizarResultadoJogo(ResultadosJogo resultadoJogo) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try
		{
			CallableStatement cs = c.prepareCall("{call AtualizaResultadoJogo(?, ?, ?)}");
			cs.setInt(1,resultadoJogo.getIdJogo());
			cs.setInt(2, resultadoJogo.getGolsMandante());
			cs.setInt(3, resultadoJogo.getGolsVisitante());
			cs.execute();
						
			c.close();
			return true;

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
			return false;
		}
	}

	@Override
	public int getRodadaAtual() {
		Connection c = SupportDAO.getConnection();
		int rodada = 1;
		if (c == null)
			return 0;
		
		try
		{
			
			while(rodada <=38 ){
				PreparedStatement ps = c.prepareStatement("select count (resultadosJogo.id)"
						+ "from jogos, resultadosJogo where resultadosJogo.idJogo = jogos.id"
						+ "and jogos.rodada = ?");
				ps.setInt(1, rodada);
				ResultSet rs = ps.executeQuery();
				
				int resultadosNaRodada = 0;
				if (rs.next())
					resultadosNaRodada++;
				
				if (resultadosNaRodada == 10)
					return rodada;
			}			

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
			return 0;
		}
		return 1;
	}
	
	

}