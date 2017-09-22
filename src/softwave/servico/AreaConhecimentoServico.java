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
		Postagem postagem = new Postagem(titulo, descricao, autor);
		for(String tag: palavrasChave){
			postagem.addTag(tag);
		}
		areaConhecimentoDao.adicionarPostagem(areaConhecimento, postagem);

	}

	@Override
	public void addAreaConhecimento(String nome) {
		AreaConhecimento areaConhecimento = new AreaConhecimento(nome);
		areaConhecimentoDao.adicionarAreaConhecimento(areaConhecimento);
		
	}

	@Override
	public AreaConhecimento pesquisarAreaConhecimento(String nome) {
		AreaConhecimento areaConhecimento = areaConhecimentoDao.pesquisarAreaConhecimento(nome);
		return areaConhecimento;
	}

}
