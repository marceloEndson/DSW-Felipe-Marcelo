package campeonatobrasileiro.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import campeonatobrasileiro.model.Tokens;

public class TokensDAO implements ITokensDAO{

	private Tokens carrega(ResultSet rs) throws SQLException{
		Tokens token = new Tokens();
		token.setId(rs.getInt("id"));
		token.setIdUsuario(rs.getInt("idUsuario"));
		token.setToken(rs.getString("token"));
		token.setValidade(rs.getDate("validade"));
		return token;
	}
	
	@Override
	public Tokens getToken(int id) {
		
		Connection c = SupportDAO.getConnection();	
		if (c == null)
			return null;
		Tokens item = null;
		try	{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tokens WHERE id = ?");
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
	public List<Tokens> lista() {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return null;
		List<Tokens> lista = new ArrayList<Tokens>();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tokens");
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
	public boolean criarTokenSenha(Tokens token) {
		
		Connection c = SupportDAO.getConnection();
		if (c == null)
			return false;
		try	{
			CallableStatement cs = c.prepareCall("{call CriarTokenSenha(?, ?, ?)}");
			cs.setInt(1,token.getIdUsuario());
			cs.setString(2, token.getToken());
			cs.setDate(3, token.getValidade());
			cs.execute();
			c.close();
			return true;
		} catch (SQLException e) {
			SupportDAO.log(e.getMessage());
			return false;
		}
	}
}