package softwave.dados;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import softwave.negocio.AreaConhecimento;
import softwave.negocio.Comentario;
import softwave.negocio.Postagem;
import softwave.servico.UsuarioServico;

public class PostagemDAO extends DadosGenerico  implements PostagemDAOInteface {

	private UsuarioServico servicoUsuario;
	
	public PostagemDAO(UsuarioServico servicoUsuario){
		this.servicoUsuario = servicoUsuario;
	}
	
	@Override
	public void criarComentario(Postagem postagem, Comentario comentario) {
		abrirConexao();
		String sql = "INSERT INTO comentario(fk_postagem_comentario, descricao, visibilidade, data, fk_comentario) values (?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setInt(1, postagem.getId());
			stmt.setString(2,comentario.getDescricao());
			stmt.setInt(3, 1);
			stmt.setDate(4, Date.valueOf(LocalDate.now()));
			stmt.setInt(5, 0); //0 representa o topo da hieerarquia
			stmt.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			fecharConexao();
		}

	}

	@Override
	public void alterarVisibilidadePostagem(Postagem postagem) {
		abrirConexao();
		String sql = "UPDATE postagem SET visibilidade = ? WHERE id_postage = ?;";
		
		try{
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setInt(1, this.converteBool(!postagem.getVisibilidade())); //"inverte" o boolean da publicação
			stmt.setInt(2, postagem.getId());
			stmt.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

	}
	
	private int converteBool(boolean visibilidade){
		if(visibilidade == true){
			return 1;
		} else {
			return 0;
		}
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
				Postagem postagem = new Postagem(resultado.getString("titulo"), 
										resultado.getNString("texto"),
										servicoUsuario.pesquisarPorProntuario(resultado.getString("prontuario")));
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
		List<Postagem> postagensEncontradas = new ArrayList<>();
		String sql = "SELECT * FROM postagem WHERE postagem.fk_areaConhecimento_postage like ?;";
		
		try{
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1, "%" + areaConhecimento.getNome() + "%");
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				//public Postagem(int id, String titulo, String texto, Usuario autor, LocalDate horario)
				Postagem postagem = new Postagem(resultado.getInt("id_postagem"), resultado.getString("titulo"),
												resultado.getString("texto"),
												servicoUsuario.pesquisarPorProntuario(resultado.getString("fk_prontuario_usuario")));
				postagensEncontradas.add(postagem);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return postagensEncontradas;
	}
	

}
