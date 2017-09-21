package softwave.servico;

import softwave.negocio.Sessao;
import softwave.negocio.Usuario;

public interface SessaoServicoInterface {
	public void iniciarSessao(Usuario usuario);
	public void fecharSessao(Sessao sessao);
}
