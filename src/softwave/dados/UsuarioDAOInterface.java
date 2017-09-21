package softwave.dados;

import softwave.negocio.Usuario;

public interface UsuarioDAOInterface {
	public Usuario entrar(int prontuario, String senha);
	public int pesquisarPermissao(Usuario usuario);
}
