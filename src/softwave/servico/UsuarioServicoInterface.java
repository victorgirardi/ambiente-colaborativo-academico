package softwave.servico;

import softwave.negocio.*;

public interface UsuarioServicoInterface {
	public void entrar(int prontuario, String senha);
	public int pesquisarPermissao(Usuario usuario);
}
