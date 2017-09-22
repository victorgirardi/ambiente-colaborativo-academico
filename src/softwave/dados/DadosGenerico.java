package softwave.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DadosGenerico {

	private Connection conexao;

	protected PreparedStatement preparaQuerry(String sql) throws SQLException {

		return conexao.prepareStatement(sql);
	}

	protected void abrirConexao() {
		conexao = Conexao.abrir();
	}

	protected void fecharConexao() {
		Conexao.fechar(conexao);
	}
}
