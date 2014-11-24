package campeonatobrasileiro.component;

import javax.enterprise.context.SessionScoped;

import org.springframework.stereotype.Component;

import campeonatobrasileiro.model.Usuarios;

@Component
@SessionScoped
public class UsuarioLogado {
	
    private Usuarios usuarioLogado;
    public void efetuaLogin(Usuarios usuario) {
        this.usuarioLogado = usuario;
    }
    
    public Usuarios getUsuario() {
        return this.usuarioLogado;
    }
}
