package campeonatobrasileiro.dao;

import java.util.List;

import campeonatobrasileiro.model.Usuarios;
import campeonatobrasileiro.model.UsuariosGrupo;


public interface IUsuariosGrupoDAO {
	
	public UsuariosGrupo getUsuarioGrupo(int idUsuario, int idGrupo);
	
	public List<UsuariosGrupo> getLista();
	
	public boolean inserirUsuarioGrupo(UsuariosGrupo usuarioGrupo);
	
	public boolean retirarUsuarioGrupo(int idUsuario, int idGrupo);
	
	public List<UsuariosGrupo> getUsuariosGrupoPeloIdUsuario(Usuarios usuario);
	
}