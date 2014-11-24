package campeonatobrasileiro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import campeonatobrasileiro.dao.ITokensDAO;
import campeonatobrasileiro.dao.TokensDAO;
import campeonatobrasileiro.dao.UsuariosDAO;
import campeonatobrasileiro.model.Usuarios;

@Controller
public class UsuarioController {
	
	@RequestMapping("/exibirCadastroUsuario")
	public String exibirCadastroUsuario(){
		return "usuario/cadastro-usuario";
	}
	
	@RequestMapping("/cadastrarUsuario")
	public String cadastrarUsuario(Usuarios usuario, HttpSession session){
		UsuariosDAO usuariosDAO = new UsuariosDAO();
		if (usuariosDAO.criarUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuariosDAO.getUsuarioPeloLogin(usuario.getLogin()));
			return "usuario/cadastrado-sucesso";
		}
			return "usuario/cadastrado-erro";
	}
	
	@RequestMapping("/exibirLoginUsuario")
	public String exibirLoginUsuario(){
		return "usuario/login-usuario";
	}
	
	@RequestMapping("/logarUsuario")
	public String logarUsuario(Usuarios usuario, HttpSession session){
		UsuariosDAO usuariosDAO = new UsuariosDAO();
		Usuarios usuarioLogado = usuariosDAO.getUsuarioPeloLoginESenha(usuario.getLogin(), usuario.getSenha());
		if (usuarioLogado != null){
			session.setAttribute("usuarioLogado", usuarioLogado);
			usuariosDAO.loginSucesso(usuarioLogado);
			return "usuario/pagina-principal";
		} else {
			usuariosDAO.loginFalha(usuarioLogado);
			return "redirect:exibirLoginUsuario";
		}
			
	}
	
	@RequestMapping("/exibirPaginaPrincipal")
	public String exibirPaginaPrincipal(){
		return "usuario/pagina-principal";
	}
	
	@RequestMapping("/exibirEnvioToken")
	public String exibirEnvioToken(){
		return "usuario/envio-token";
	}
	
	@RequestMapping("/enviarToken")
	public void enviarToken(Usuarios usuario, HttpSession session){
		Usuarios usuarioLogado = (Usuarios)session.getAttribute("usuarioLogado");
		if (usuarioLogado.getLogin().equals(usuario.getLogin()) && 
				usuarioLogado.getEmail().equals(usuario.getEmail())){
			ITokensDAO tokensDAO = new TokensDAO();
			//Falta terminar
		}
		
	}
	
	@RequestMapping("/exibirAtualizacaoUsuario")
	public String exibirAtualizacaoUsuario(){
		return "usuario/alteracao-usuario";
	}
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuarios usuario){
		System.out.println(usuario.getNome());
		return "usuario/alterado-sucesso";
	}
	
	@RequestMapping("/deslogarUsuario")
	public String deslogarUsuario(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}

}