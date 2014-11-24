package campeonatobrasileiro.dao;

import java.util.List;

import campeonatobrasileiro.model.Tokens;

public interface ITokensDAO {
	
	public Tokens getToken(int id);
	
	public List<Tokens> lista();
	
	public boolean criarTokenSenha(Tokens token);

}