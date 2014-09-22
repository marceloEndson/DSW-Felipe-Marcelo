package palpites;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Palpites;
import supportdao.SupportDAO;

public class PalpitesDAO implements IPalpitesDAO{

	private Palpites carrega(ResultSet rs) throws SQLException{
		Palpites palpite = new Palpites();
		palpite.setIdUsuario(rs.getInt("idUsuario"));
		palpite.setIdJogo(rs.getInt("idJogo"));
		palpite.setGolsMandante(rs.getInt("golsMandante"));
		palpite.setGolsVisitante(rs.getInt("golsVisitante"));
		return palpite;
	}

	@Override
	public Palpites getPalpite(int idUsuario, int idJogo) {

		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;

		Palpites item = null;
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM palpites WHERE id = ?, ?");
			ps.setLong(1, idUsuario);
			ps.setLong(2, idJogo);

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
	public List<Palpites> lista() {

		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		List<Palpites> lista = new ArrayList<Palpites>();
		try{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM palpites");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				lista.add(carrega(rs));
			c.close();
		}catch (SQLException e) {
			SupportDAO.log(e.getMessage());
		}
		return lista;
	}

	@Override
	public boolean indicarPalpite(Palpites palpite) {

		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try {
			CallableStatement cs = c.prepareCall("{call IndicarPalpite(?, ?, ?, ?)}");
			cs.setInt(1,palpite.getIdUsuario());
			cs.setInt(2, palpite.getIdJogo());
			cs.setInt(3,palpite.getGolsMandante());
			cs.setInt(4, palpite.getGolsVisitante());
			cs.execute();

			c.close();
			return true;

		} catch (SQLException e) {
			SupportDAO.log(e.getMessage());
			return false;
		}
	}

}
