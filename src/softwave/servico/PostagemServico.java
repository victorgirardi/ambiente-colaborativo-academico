package softwave.servico;

import softwave.dados.PostagemDAO;
import softwave.negocio.Comentario;
import softwave.negocio.Postagem;
import softwave.negocio.Sessao;
import softwave.negocio.Usuario;

public class PostagemServico implements PostagemServicoInterface {

	private PostagemDAO postagemDao;
	
	public PostagemServico(PostagemDAO postagemDao){
		this.postagemDao = postagemDao;
	}
	@Override
	public void criarComentario(Postagem postagem, Usuario autor, String descricao) {
		Comentario comentario = new Comentario(autor, descricao);
		postagemDao.criarComentario(postagem, comentario);
	}

	@Override
	public void alterarVisibilidadePostagem(Postagem postagem) {
		if(Sessao.getPermissao() == 1 || Sessao.getPermissao() == 2){
			postagemDao.alterarVisibilidadePostagem(postagem);
		} else {
			//Permissao não concedida
		}

	}

}
