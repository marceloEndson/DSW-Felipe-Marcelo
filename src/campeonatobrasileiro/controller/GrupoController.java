package campeonatobrasileiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import campeonatobrasileiro.dao.GruposDAO;
import campeonatobrasileiro.dao.UsuariosGrupoDAO;
import campeonatobrasileiro.model.Grupos;
import campeonatobrasileiro.model.UsuariosGrupo;

@Controller
public class GrupoController {
	
	@RequestMapping("/exibirCadastroGrupo")
	public String exibirCadastroGrupo(){
		return "grupo/cadastro-grupo";
	}
	
	@RequestMapping("/cadastrarGrupo")
	public String cadastrarGrupo(Grupos grupo){
		GruposDAO gruposDAO = new GruposDAO();
		if (gruposDAO.criarGrupo(grupo))
			return "grupo/cadastrado-sucesso";			
		return "grupo/cadastrado-erro";
	}

}
