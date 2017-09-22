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
	public void entrar(String prontuario, String senha) {
		if(usuarioDao.entrar(prontuario, senha) != null){
			Sessao.setPermissao(usuarioDao.entrar(prontuario, senha));
		}
		
	}
	
	@Override
	public Usuario pesquisarPorProntuario(String prontuario){
		Usuario usuario = usuarioDao.pesquisaPorProntuario(prontuario);
		return usuario;
	}
}
