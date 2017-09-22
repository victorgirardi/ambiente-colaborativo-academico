package softwave.servico;

import softwave.dados.UsuarioDAO;
import softwave.negocio.Sessao;
import softwave.negocio.Usuario;

public class SessaoServico implements SessaoServicoInterface {

	private UsuarioDAO usuarioDao;
	
	@Override
	public void iniciarSessao(Usuario usuario) {
		Sessao.setPermissao(usuarioDao.entrar(usuario.getProntuario(), usuario.getSenha()));
	}

	@Override
	public void fecharSessao(Sessao sessao) {
		//Sair do programa
		System.exit(0);
	}

}
