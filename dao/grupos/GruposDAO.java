package grupos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.Grupos;
import supportdao.SupportDAO;

public class GruposDAO implements IGruposDAO {
	
	private Grupos carrega(ResultSet rs) throws SQLException{
		Grupos grupo = new Grupos();
		grupo.setId(rs.getInt("id"));
		grupo.setNome(rs.getString("nome"));
		grupo.setIdDono(rs.getInt("idDono"));
		return grupo;
	}

	@Override
	public Grupos getGrupo(int id) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		Grupos item = null;
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM grupos WHERE id = ?");
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
	public List<Grupos> lista() {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		List<Grupos> lista = new ArrayList<Grupos>();
		try{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM grupos");
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
	public boolean criarGrupo(Grupos grupo) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try
		{
			CallableStatement cs = c.prepareCall("{call CriarGrupo(?, ?, ?)}");
			cs.setInt(1,grupo.getIdDono());
			cs.setString(2, grupo.getNome());
			cs.registerOutParameter(3, Types.INTEGER);
			cs.execute();
			
			int id = cs.getInt(3);
			grupo.setId(id);
			
			c.close();
			return true;

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean excluirGrupo(int id) {
	
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		
		try
		{
			CallableStatement cs = c.prepareCall("{call ExcluirGrupo(?)}");
			cs.setInt(1, id);
			cs.execute();	
			c.close();
			return true;

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
			return false;
		}
	}

}
