package softwave.servico;

import softwave.dados.ComentarioDAO;
import softwave.negocio.Comentario;
import softwave.negocio.Sessao;
import softwave.negocio.Usuario;

public class ComentarioServico implements ComentarioServicoInterface {

	private ComentarioDAO comentarioDao;
	
	public ComentarioServico(ComentarioDAO comentarioDao){
		this.comentarioDao = comentarioDao;
	}
	
	@Override
	public void alterarVisibilidade(Comentario comentario) {
		if(Sessao.getPermissao() == 2){
			comentarioDao.alterarVisibilidade(comentario);
		} else {
			//Permissao não concedida
		}

	}
	
	@Override
	public void comentarComentario(Usuario usuario, String descricao, Comentario comentario){ //comentario é o comentario mais no topo da hierarquia
		comentarioDao.comentarComentario(usuario, descricao, comentario);
	}

	@Override
	public Comentario pesquisarComentario(String comentario) {
		Comentario comentarioRetorno;
		comentarioRetorno = comentarioDao.pesquisarComentario(comentario);
		return comentarioRetorno;
	}

}
