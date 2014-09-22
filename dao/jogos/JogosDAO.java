package jogos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogos;
import supportdao.SupportDAO;

public class JogosDAO implements IJogosDAO{

	private Jogos carrega(ResultSet rs) throws SQLException{
		Jogos jogo = new Jogos();
		jogo.setId(rs.getInt("id"));
		jogo.setIdMandante(rs.getInt("idMandante"));
		jogo.setIdVisitante(rs.getInt("idVisitante"));
		jogo.setRodada(rs.getInt("rodada"));
		jogo.setEstadio(rs.getString("estadio"));
		jogo.setDataHora(rs.getDate("dataHora"));
		return jogo;
	}
	
	@Override
	public Jogos getJogo(int id) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		Jogos item = null;
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM jogos WHERE id = ?");
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
				item = carrega(rs);

			c.close();

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
		}
		    
		return item;
	}

	@Override
	public List<Jogos> lista() {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		List<Jogos> lista = new ArrayList<Jogos>();
		try{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM jogos");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				lista.add(carrega(rs));
			c.close();
		}catch (SQLException e){
			SupportDAO.log(e.getMessage());
		}
		return lista;
	}
}
