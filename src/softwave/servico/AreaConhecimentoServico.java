package softwave.servico;


import java.util.List;

import softwave.dados.AreaConhecimentoDAO;
import softwave.negocio.AreaConhecimento;
import softwave.negocio.Postagem;
import softwave.negocio.Usuario;

public class AreaConhecimentoServico implements AreaConhecimentoServicoInterface {

	private AreaConhecimentoDAO areaConhecimentoDao;
	
	public AreaConhecimentoServico(AreaConhecimentoDAO areaConhecimentoDao){
		this.areaConhecimentoDao = areaConhecimentoDao;
	}
	
	@Override
	public void criarPostagem(AreaConhecimento areaConhecimento, String titulo, String descricao, Usuario autor, List<String> palavrasChave) {
		//TODO: Dados da postagem recebidos de uma classe view
		Postagem postagem = new Postagem(titulo, descricao, autor, palavrasChave);
		areaConhecimentoDao.adicionarPostagem(areaConhecimento, postagem);

	}

	@Override
	public List<Postagem> pesquisarPostagemPorChave(String palavraChave) {
		return areaConhecimentoDao.pesquisarPostagemPorChave(palavraChave);
	}

	@Override
	public List<Postagem> pesquisarPostagemPorArea(AreaConhecimento areaConhecimento) {
		return areaConhecimentoDao.pesquisarPostagemPorArea(areaConhecimento);
	}

}
