package softwave.dados;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import softwave.negocio.AreaConhecimento;
import softwave.negocio.Postagem;
import softwave.servico.UsuarioServico;

public class AreaConhecimentoDAO extends DadosGenerico implements AreaConhecimentoDAOInteface {
	
	private UsuarioServico usuarioServico;
	
	public AreaConhecimentoDAO(UsuarioServico usuarioServico){
		this.usuarioServico = usuarioServico;
	}

	@Override
	public void adicionarAreaConhecimento(AreaConhecimento areaConhecimento) {
		abrirConexao();
		String sql = "Insert into areaConhecimento (nome) values (?);";
		try {

			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1, areaConhecimento.getNome());
			ResultSet resultado = stmt.executeQuery();
			areaConhecimento.setId(resultado.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		fecharConexao();

	}

	@Override
	public void adicionarPostagem(AreaConhecimento areaConhecimento, Postagem postagem) {
		abrirConexao();
		String sql = "INSERT INTO postagem (titulo, fk_prontuario_usuario, texto, visibilidade, horario) values (?, ?, ?, ?, ?);";
		
		try{
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1, postagem.getTitulo());
			stmt.setString(2, postagem.getAutor().getProntuario());
			stmt.setString(3, postagem.getTexto());
			stmt.setInt(4, this.converteBool(postagem.getVisibilidade()));
			stmt.setDate(5, Date.valueOf(postagem.getHorario()));
			stmt.executeUpdate();
			
		} catch (SQLException e){
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

	@Override
	public AreaConhecimento pesquisarAreaConhecimento(String nome) {
		abrirConexao();
		AreaConhecimento areaConhecimento = new AreaConhecimento(nome);
		String sql = "SELECT * FROM areaConhecimento where nome like ?;";
		try{
			PreparedStatement stmt = preparaQuerry(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet resultado = stmt.executeQuery();
			areaConhecimento.setId(resultado.getInt("id_areaConhecimento"));
			return areaConhecimento;
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return areaConhecimento;
}

}
