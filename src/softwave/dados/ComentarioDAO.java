package softwave.dados;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import softwave.negocio.Comentario;
import softwave.negocio.Usuario;
import softwave.servico.UsuarioServico;

public class ComentarioDAO extends DadosGenerico  implements ComentarioDAOInterface {
	
	private UsuarioServico usuarioServico;
	
	public ComentarioDAO(UsuarioServico usuarioServico){
		this.usuarioServico = usuarioServico;
	}

	@Override
	public void alterarVisibilidade(Comentario comentario) {
		abrirConexao();
		String sql = "UPDATE comentario SET visibilidade = 0 WHERE id_comentario = ?;";
		
		try{
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setInt(1, comentario.getId());
			stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			fecharConexao();
		}


	}
	
	@Override
	public void comentarComentario(Usuario usuario, String descricao, Comentario comentario){
		abrirConexao();
		String sql = "INSERT INTO comentario(fk_autor_comentario, descricao, visbilidade, data, fk_comentario) values (?, ?, ?, ?, ?);";
		
		try{
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1, usuario.getProntuario());
			stmt.setString(2, descricao);
			stmt.setInt(3, 1);
			stmt.setDate(4, Date.valueOf(LocalDate.now()));
			stmt.setInt(5, comentario.getId());
			stmt.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
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
	
	private boolean converteInt(int visibilidade){
		if(visibilidade == 1){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Comentario pesquisarComentario(String comentario) {
		abrirConexao();
		String sql = "SELECT * FROM comentario WHERE descricao like ?;";
		
		try{
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1, "%" + comentario + "%");
			ResultSet resultado = stmt.executeQuery();
			Comentario comentarioRetorno = new Comentario(resultado.getInt("id_comentario"),usuarioServico.pesquisarPorProntuario(resultado.getString("fk_usuario_comentario")),
					 							   resultado.getString("descricao"), this.converteInt(resultado.getInt("visibilidade")));
			return comentarioRetorno;
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return null;
	}


}
