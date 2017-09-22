package softwave.dados;



import java.util.List;
import softwave.negocio.AreaConhecimento;
import softwave.negocio.Postagem;

public interface AreaConhecimentoDAOInteface {
	public void adicionarPostagem(AreaConhecimento areaConhecimento, Postagem postagem);

	public List<Postagem> pesquisarPostagemPorChave(String palavraChave);

	public List<Postagem> pesquisarPostagemPorArea(AreaConhecimento areaConhecimento);

	public AreaConhecimento adicionarAreaConhecimento(AreaConhecimento areaConhecimento);
}
