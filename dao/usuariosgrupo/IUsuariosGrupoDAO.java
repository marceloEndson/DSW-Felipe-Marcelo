package usuariosgrupo;

import java.util.List;

import model.UsuariosGrupo;

public interface IUsuariosGrupoDAO {
	
	public UsuariosGrupo getUsuarioGrupo(int idUsuario, int idGrupo);
	
	public List<UsuariosGrupo> lista();
	
	public boolean inserirUsuarioGrupo(UsuariosGrupo usuarioGrupo);
	
	public boolean retirarUsuarioGrupo(int idUsuario, int idGrupo);
	
}
