package softwave.servico;

import softwave.negocio.Postagem;
import softwave.negocio.Usuario;

public interface PostagemServicoInterface {
	public void criarComentario(Postagem postagem, Usuario autor, String descricao);
	public void alterarVisibilidadePostagem(Postagem postagem);
}
