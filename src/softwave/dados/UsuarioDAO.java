package softwave.dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import softwave.negocio.Sessao;
import softwave.negocio.Usuario;

public class UsuarioDAO extends DadosGenerico  implements UsuarioDAOInterface {

	@Override
	public Usuario entrar(String prontuario, String senha) {
		abrirConexao();
		
		String sql = "SELECT * FROM usuario WHERE prontuario = ? AND senha = ?;";
		
		try{
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1, prontuario);
			stmt.setString(2, senha);
			ResultSet resultado = stmt.executeQuery();
			Usuario usuario = new Usuario(resultado.getString("prontuario"), resultado.getInt("permissao"), resultado.getString("nome"));
			Sessao.setPermissao(usuario);
			
			return usuario;
		} catch (SQLException e){
			//Senha ou prontuario errado
			//Sem conexão
			return null;
		} finally {
			fecharConexao();
		}
	}


	@Override
	public Usuario pesquisaPorProntuario(String prontuario) {
		
		abrirConexao();
		String sql = "Select * from usuario where usuario.prontuario = ?;";
		try {
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1,prontuario);
			ResultSet resultado = stmt.executeQuery();
			Usuario usuario = new Usuario(resultado.getString("prontuario"), resultado.getInt("senha"), resultado.getString("nome"));

			return usuario;
			
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}finally{
			fecharConexao();
		}

	}

}	
