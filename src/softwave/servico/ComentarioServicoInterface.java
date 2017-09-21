package softwave.servico;

import softwave.negocio.Comentario;
import softwave.negocio.Usuario;

public interface ComentarioServicoInterface {
	public void alterarVisibilidade(Comentario comentario);
	public void comentarComentario(Usuario autor, String descricao, Comentario comentario);
}
