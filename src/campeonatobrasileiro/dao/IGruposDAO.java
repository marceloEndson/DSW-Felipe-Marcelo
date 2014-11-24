package campeonatobrasileiro.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import campeonatobrasileiro.model.Grupos;
import campeonatobrasileiro.model.Usuarios;


public interface IGruposDAO {
	
	public Grupos getGrupo(int id);
	
	public List<Grupos> getLista();
	
	public boolean criarGrupo(Grupos grupo);
	
	public boolean excluirGrupo(int id);
	
	public List<Grupos> getListaGruposUsuario(Usuarios usuario);

}