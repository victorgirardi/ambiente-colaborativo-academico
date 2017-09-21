package softwave.dados;

import softwave.negocio.Comentario;
import softwave.negocio.Usuario;

public interface ComentarioDAOInterface {
	public void alterarVisibilidade(Comentario comentario);
	public void comentarComentario(Usuario usuario, String descricao, Comentario comentario);
}
