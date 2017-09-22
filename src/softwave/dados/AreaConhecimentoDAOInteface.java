package softwave.dados;

import softwave.negocio.AreaConhecimento;
import softwave.negocio.Postagem;

public interface AreaConhecimentoDAOInteface {
	public void adicionarPostagem(AreaConhecimento areaConhecimento, Postagem postagem);
	public void adicionarAreaConhecimento(AreaConhecimento areaConhecimento);
	public AreaConhecimento pesquisarAreaConhecimento(String nome);
}
