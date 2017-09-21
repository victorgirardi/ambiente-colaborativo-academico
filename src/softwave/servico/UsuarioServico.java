package softwave.servico;

import softwave.dados.UsuarioDAO;
import softwave.negocio.Sessao;
import softwave.negocio.Usuario;

public class UsuarioServico implements UsuarioServicoInterface {

	private UsuarioDAO usuarioDao;
	
	public UsuarioServico(UsuarioDAO usuarioDao){
		this.usuarioDao = usuarioDao;
	}
	
	@Override
	public void entrar(int prontuario, String senha) {
		if(usuarioDao.entrar(prontuario, senha) != null){
			Sessao.setPermissao(this.pesquisarPermissao(usuarioDao.entrar(prontuario, senha)));
		}
		
	}

	@Override
	public int pesquisarPermissao(Usuario usuario){
		return usuarioDao.pesquisarPermissao(usuario);
	}
}
