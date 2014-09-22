package tokens;

import java.util.List;

import model.Tokens;

public interface ITokensDAO {
	
	public Tokens getToken(int id);
	
	public List<Tokens> lista();
	
	public boolean criarTokenSenha(Tokens token);

}
