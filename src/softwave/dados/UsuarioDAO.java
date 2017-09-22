package softwave.dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import softwave.negocio.Usuario;

public class UsuarioDAO extends DadosGenerico  implements UsuarioDAOInterface {

	@Override
	public Usuario entrar(int prontuario, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pesquisarPermissao(Usuario usuario){
		int permissao = 0;
		
		return permissao;
	}

	@Override
	public Usuario pesquisaPorProntuario(String prontuario) {
		Usuario usuario = new Usuario();
		
		abrirConexao();
		String sql = "Select * from usuario where usuario.prontuario = ?;";
		try {
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1,prontuario);
			ResultSet resultado = stmt.executeQuery();
			usuario.setNome(resultado.getString("nome"));
			usuario.setProntuario(prontuario);
			usuario.setTurma(resultado.getInt("turma"));
			
			
		} catch (SQLException e) {
			System.err.println(e);
		}
		fecharConexao();
		return usuario;
	}

}	
