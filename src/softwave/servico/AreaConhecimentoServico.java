package softwave.servico;

import java.util.ArrayList;

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
	public void criarPostagem(AreaConhecimento areaConhecimento, String titulo, String descricao, Usuario autor, ArrayList<String> palavrasChave) {
		//TODO: Dados da postagem recebidos de uma classe view
		Postagem postagem = new Postagem(titulo, descricao, autor, palavrasChave);
		areaConhecimentoDao.criarPostagem(areaConhecimento, postagem);

	}

	@Override
	public ArrayList<Postagem> pesquisarPostagemPorChave(String palavraChave) {
		return areaConhecimentoDao.pesquisarPostagemPorChave(palavraChave);
	}

	@Override
	public ArrayList<Postagem> pesquisarPostagemPorArea(AreaConhecimento areaConhecimento) {
		return areaConhecimentoDao.pesquisarPostagemPorArea(areaConhecimento);
	}

}
