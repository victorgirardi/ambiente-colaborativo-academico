package softwave.dados;

import java.util.List;

import softwave.negocio.AreaConhecimento;
import softwave.negocio.Comentario;
import softwave.negocio.Postagem;

public interface PostagemDAOInteface {
	public void criarComentario(Postagem postagem, Comentario comentario);
	public void alterarVisibilidadePostagem(Postagem postagem);
	public List<Postagem> pesquisarPostagemPorChave(String palavraChave);
	public List<Postagem> pesquisarPostagemPorArea(AreaConhecimento areaConhecimento);
}
