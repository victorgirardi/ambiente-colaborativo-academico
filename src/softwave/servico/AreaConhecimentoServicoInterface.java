package softwave.servico;

import java.util.List;
import softwave.negocio.AreaConhecimento;
import softwave.negocio.Postagem;
import softwave.negocio.Usuario;

public interface AreaConhecimentoServicoInterface {
	public void criarPostagem(AreaConhecimento areaConhecimento, String titulo, String descricao, Usuario autor,List<String> palavrasChave);
	public List<Postagem> pesquisarPostagemPorChave(String palavraChave);
	public List<Postagem> pesquisarPostagemPorArea(AreaConhecimento areaConhecimento);
}
