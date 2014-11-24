package campeonatobrasileiro.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import campeonatobrasileiro.model.Usuarios;


public class UsuariosDAO implements IUsuariosDAO{

	private Usuarios carrega(ResultSet rs) throws SQLException{
		Usuarios usuario = new Usuarios();
		usuario.setId(rs.getInt("id"));
		usuario.setLogin(rs.getString("login"));
		usuario.setNome(rs.getString("nome"));
		usuario.setEmail(rs.getString("email"));
		usuario.setCidade(rs.getString("cidade"));
		usuario.setFoto(rs.getBlob("foto"));
		usuario.setSenha(rs.getString("senha"));
		usuario.setNumeroPontos(rs.getInt("numeroPontos"));
		usuario.setAdministrador(rs.getBoolean("administrator"));
		usuario.setNumeroLogins(rs.getInt("numeroLogins"));
		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("ultimoLogin"));
		usuario.setUltimoLogin(data);
		return usuario;
	}
	
	@Override
	public Usuarios getUsuario(int id) {
		Connection c = SupportDAO.getConnection();
		
		if (c == null)
			return null;
		Usuarios item = null;
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
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
	public List<Usuarios> lista() {
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		List<Usuarios> lista = new ArrayList<Usuarios>();
		try{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuarios");
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
	public boolean criarUsuario(Usuarios usuario) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		
		try
		{
			CallableStatement cs = c.prepareCall("{call CriarUsuario(?, ?, ?, ?, ?, ?)}");
			cs.setString(1,usuario.getLogin());
			cs.setString(2, usuario.getNome());
			cs.setString(3,usuario.getEmail());
			cs.setString(4, usuario.getCidade());
			cs.setString(5,usuario.getSenha());
			cs.registerOutParameter(6, Types.INTEGER);
			cs.execute();	
			int id = cs.getInt(6);
			usuario.setId(id);
			c.close();
			return true;

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean atualizarUsuario(Usuarios usuario) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try
		{
			CallableStatement cs = c.prepareCall("{call AtualizarUsuario(?, ?, ?, ?, ?, ?)}");
			cs.setInt(1,usuario.getId());
			cs.setString(2, usuario.getNome());
			cs.setString(3,usuario.getEmail());
			cs.setString(4, usuario.getCidade());
			cs.setString(5,usuario.getSenha());
			cs.setBlob(6,usuario.getFoto());
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
	public boolean atualizarSenha(Usuarios usuario) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try
		{
			CallableStatement cs = c.prepareCall("{call AtualizarSenha(?, ?)}");
			cs.setInt(1,usuario.getId());
			cs.setString(2,usuario.getSenha());
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
	public boolean loginSucesso(Usuarios usuario) {
	
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try
		{
			CallableStatement cs = c.prepareCall("{call LoginSucesso(?)}");
			cs.setInt(1,usuario.getId());
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
	public boolean loginFalha(Usuarios usuario) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try
		{
			CallableStatement cs = c.prepareCall("{call LoginFalha(?)}");
			cs.setInt(1,usuario.getId());
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
	public boolean existeUsuario(Usuarios usuario) {
		Connection c = SupportDAO.getConnection();
		
		if (c == null)
			return false;
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuarios WHERE login = ?");
			ps.setString(1, usuario.getLogin());

			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return true;

			c.close();

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
		}
		
		return false;
	}

	@Override
	public Usuarios getUsuarioPeloLoginESenha(String login, String senha) {
		Connection c = SupportDAO.getConnection();
		
		if (c == null)
			return null;
		
		Usuarios usuario = null;
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuarios WHERE login = ? AND senha = ?");
			ps.setString(1, login);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
				usuario = carrega(rs);

			c.close();

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
		}
		    
		return usuario;
	}

	@Override
	public Usuarios getUsuarioPeloLogin(String login) {
		Connection c = SupportDAO.getConnection();
		
		if (c == null)
			return null;
		
		Usuarios usuario = null;
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuarios WHERE login = ?");
			ps.setString(1, login);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
				usuario = carrega(rs);

			c.close();

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
		}
		    
		return usuario;
	}
}