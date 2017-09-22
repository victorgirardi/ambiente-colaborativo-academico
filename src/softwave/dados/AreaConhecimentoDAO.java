package softwave.dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import softwave.negocio.AreaConhecimento;
import softwave.negocio.Postagem;

public class AreaConhecimentoDAO extends DadosGenerico implements AreaConhecimentoDAOInteface {

	@Override
	public AreaConhecimento adicionarAreaConhecimento(AreaConhecimento areaConhecimento) {
		abrirConexao();
		String sql = "Insert into AreaConhecimento (nome) values (?);";
		try {

			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1, areaConhecimento.getNome());
			ResultSet resultado = stmt.executeQuery();
			areaConhecimento.setId(resultado.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		fecharConexao();

		return areaConhecimento;

	}

	@Override
	public void adicionarPostagem(AreaConhecimento areaConhecimento, Postagem postagem) {
		abrirConexao();

		fecharConexao();
	}

	@Override
	public List<Postagem> pesquisarPostagemPorChave(String palavraChave) {

		List<Postagem> postagensEncontradas = new ArrayList<Postagem>();

		abrirConexao();
		String sql = "Select * from postagem where postagem.tags like ?;";

		try {

			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1, "%".concat(palavraChave).concat("%"));
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Postagem postagem = new Postagem(
						
						resultado.getString("titulo"), 
						resultado.getNString("texto"),
						new UsuarioDAO().pesquisaPorProntuario(
								resultado.getString("prontuario")));
				postagensEncontradas.add(postagem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		fecharConexao();
		return postagensEncontradas;
	}

	@Override
	public List<Postagem> pesquisarPostagemPorArea(AreaConhecimento areaConhecimento) {
		abrirConexao();
		fecharConexao();
		return null;
	}

}
