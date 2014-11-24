package campeonatobrasileiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import campeonatobrasileiro.model.Times;

public class TimesDAO implements ITimesDAO{

	private Times carrega(ResultSet rs) throws SQLException{
		Times time = new Times();
		time.setId(rs.getInt("id"));
		time.setNome(rs.getString("nome"));
		time.setNomeCurto(rs.getString("nomeCurto"));
		time.setPontosGanhos(rs.getInt("pontosganhos"));
		time.setNumeroJogos(rs.getInt("numeroJogos"));
		time.setGolsPro(rs.getInt("golsPro"));
		time.setGolsContra(rs.getInt("golsContra"));
		return time;
	}
	
	@Override
	public Times getTime(int id) {
	
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		Times item = null;
		try	{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM times WHERE id = ?");
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
	public List<Times> getLista() {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		List<Times> lista = new ArrayList<Times>();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM times");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				lista.add(carrega(rs));
			c.close();
		} catch (SQLException e) {
			SupportDAO.log(e.getMessage());
		}
		return lista;
	}

}