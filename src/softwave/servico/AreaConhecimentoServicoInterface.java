package softwave.servico;

import java.util.List;
import softwave.negocio.AreaConhecimento;
import softwave.negocio.Usuario;

public interface AreaConhecimentoServicoInterface {
	public void criarPostagem(AreaConhecimento areaConhecimento, String titulo, String descricao, Usuario autor,List<String> palavrasChave);
	public void addAreaConhecimento(String nome);
	public AreaConhecimento pesquisarAreaConhecimento(String nome);
}
