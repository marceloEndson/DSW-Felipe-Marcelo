package campeonatobrasileiro.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import campeonatobrasileiro.model.Usuarios;
import campeonatobrasileiro.model.UsuariosGrupo;

public class UsuariosGrupoDAO implements IUsuariosGrupoDAO{

	private UsuariosGrupo carrega(ResultSet rs) throws SQLException{
		UsuariosGrupo usuarioGrupo = new UsuariosGrupo();
		usuarioGrupo.setIdUsuario(rs.getInt("idUsuario"));
		usuarioGrupo.setIdGrupo(rs.getInt("idGrupo"));
		return usuarioGrupo;
	}
	
	@Override
	public UsuariosGrupo getUsuarioGrupo(int idUsuario, int idGrupo) {
	
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		UsuariosGrupo item = null;
		try	{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuariosGrupo WHERE id = ?, ?");
			ps.setLong(1, idUsuario);
			ps.setLong(2, idGrupo);
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
	public List<UsuariosGrupo> getLista() {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		List<UsuariosGrupo> lista = new ArrayList<UsuariosGrupo>();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuariosGrupo");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				lista.add(carrega(rs));
			c.close();
		} catch (SQLException e) {
			SupportDAO.log(e.getMessage());
		}
		return lista;
	}

	@Override
	public boolean inserirUsuarioGrupo(UsuariosGrupo usuarioGrupo) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try	{
			CallableStatement cs = c.prepareCall("{call InserirUsuarioGrupo(?, ?)}");
			cs.setInt(1,usuarioGrupo.getIdUsuario());
			cs.setInt(2, usuarioGrupo.getIdGrupo());
			cs.execute();
						
			c.close();
			return true;

		} catch (SQLException e) {
			SupportDAO.log(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean retirarUsuarioGrupo(int idUsuario, int idGrupo) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try	{
			CallableStatement cs = c.prepareCall("{call RetirarUsuarioGrupo(?, ?)}");
			cs.setInt(1, idUsuario);
			cs.setInt(2, idGrupo);
			cs.execute();	
			c.close();
			return true;

		} catch (SQLException e) {
			SupportDAO.log(e.getMessage());
			return false;
		}
	}

	@Override
	public List<UsuariosGrupo> getUsuariosGrupoPeloIdUsuario(Usuarios usuario) {
		Connection c = SupportDAO.getConnection();
		
		if (c == null)
			return null;
		
		List<UsuariosGrupo> lista = new ArrayList<UsuariosGrupo>();
		
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuariosGrupo WHERE idUsuario = ?");
			ps.setInt(1, usuario.getId());
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