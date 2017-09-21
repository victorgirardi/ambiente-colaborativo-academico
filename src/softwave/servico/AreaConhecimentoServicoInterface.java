package softwave.servico;

import java.util.ArrayList;
import softwave.negocio.AreaConhecimento;
import softwave.negocio.Postagem;
import softwave.negocio.Usuario;

public interface AreaConhecimentoServicoInterface {
	public void criarPostagem(AreaConhecimento areaConhecimento, String titulo, String descricao, Usuario autor, ArrayList<String> palavrasChave);
	public ArrayList<Postagem> pesquisarPostagemPorChave(String palavraChave);
	public ArrayList<Postagem> pesquisarPostagemPorArea(AreaConhecimento areaConhecimento);
}
