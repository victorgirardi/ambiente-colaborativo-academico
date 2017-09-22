package softwave.servico;

import java.util.List;

import softwave.negocio.AreaConhecimento;
import softwave.negocio.Postagem;
import softwave.negocio.Usuario;

public interface PostagemServicoInterface {
	public void criarComentario(Postagem postagem, Usuario autor, String descricao);
	public void alterarVisibilidadePostagem(Postagem postagem);
	public List<Postagem> pesquisarPostagemPorChave(String palavraChave);
	public List<Postagem> pesquisarPostagemPorArea(AreaConhecimento areaConhecimento);
}
