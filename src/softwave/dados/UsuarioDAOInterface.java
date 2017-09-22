package softwave.dados;

import softwave.negocio.Usuario;

public interface UsuarioDAOInterface {
	public Usuario entrar(String prontuario, String senha);
	public Usuario pesquisaPorProntuario(String pronturaio);
}
