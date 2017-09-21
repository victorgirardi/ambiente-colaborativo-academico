package softwave.dados;

import java.util.ArrayList;

import softwave.negocio.AreaConhecimento;
import softwave.negocio.Postagem;

public interface AreaConhecimentoDAOInteface {
	public void criarPostagem(AreaConhecimento areaConhecimento, Postagem postagem);
	public ArrayList<Postagem> pesquisarPostagemPorChave(String palavraChave);
	public ArrayList<Postagem> pesquisarPostagemPorArea(AreaConhecimento areaConhecimento);
}
