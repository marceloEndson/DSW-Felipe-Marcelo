package campeonatobrasileiro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import campeonatobrasileiro.dao.ResultadosJogoDAO;

@Controller
public class JogoController {
	
	@RequestMapping("/exibirRodadas")
	public String exibirRodadas(HttpSession session){
		session.setAttribute("rodadaAtual", 1);
		return "jogo/exibir-jogos";
	}
	
	@RequestMapping("/proximaRodada")
	public String proximaRodada(HttpSession session){
		int rodada = (int)session.getAttribute("rodadaAtual");
		rodada++;
		session.setAttribute("rodadaAtual", rodada);
		return "jogo/exibir-jogos";
	}
	
	@RequestMapping("/rodadaAnterior")
	public String rodadaAnterior(HttpSession session){
		int rodada = (int)session.getAttribute("rodadaAtual");
		rodada--;
		session.setAttribute("rodadaAtual", rodada);
		return "jogo/exibir-jogos";
	}
	
	@RequestMapping("/exibirRodadaAtual")
	public String exibirRodadaAtual(HttpSession session){
		ResultadosJogoDAO dao = new ResultadosJogoDAO();
		int rodada = dao.getRodadaAtual();
		System.out.println(rodada);
		return "jogo/exibir-rodada-atual";
	}

}
