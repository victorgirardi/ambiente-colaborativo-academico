package softwave.servico;

import softwave.negocio.*;

public interface UsuarioServicoInterface {
	public void entrar(String prontuario, String senha);
	public Usuario pesquisarPorProntuario(String prontuario);
}
