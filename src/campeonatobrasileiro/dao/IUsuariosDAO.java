package campeonatobrasileiro.dao;

import java.util.List;

import campeonatobrasileiro.model.Usuarios;

public interface IUsuariosDAO {
	
	public Usuarios getUsuario(int id);
	
	public Usuarios getUsuarioPeloLoginESenha(String login, String senha);
	
	public Usuarios getUsuarioPeloLogin(String login);
	
	public boolean existeUsuario(Usuarios usuario);
	
	public List<Usuarios> lista();
	
	public boolean criarUsuario(Usuarios usuario);
	
	public boolean atualizarUsuario(Usuarios usuario);	
	
	public boolean atualizarSenha(Usuarios usuario);
	
	public boolean loginSucesso(Usuarios usuario);
	
	public boolean loginFalha(Usuarios usuario);
	
}