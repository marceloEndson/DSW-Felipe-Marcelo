package usuarios;

import java.util.List;

import model.Usuarios;

public interface IUsuariosDAO {
	
	public Usuarios getUsuario(int id);
	
	public List<Usuarios> lista();
	
	public boolean criarUsuario(Usuarios usuario);
	
	public boolean atualizarUsuario(Usuarios usuario);	
	
	public boolean atualizarSenha(Usuarios usuario);
	
	public boolean loginSucesso(Usuarios usuario);
	
	public boolean loginFalha(Usuarios usuario);
	
}
