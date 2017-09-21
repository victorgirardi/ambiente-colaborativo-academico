package softwave.dados;

import softwave.negocio.Comentario;
import softwave.negocio.Postagem;

public interface PostagemDAOInteface {
	public void criarComentario(Postagem postagem, Comentario comentario);
	public void alterarVisibilidadePostagem(Postagem postagem);
}
