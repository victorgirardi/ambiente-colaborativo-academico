package softwave.negocio;

//Classe que simula a conexão com o servidor

public class Sessao {
	private static int permissao;
	
	public Sessao(int permissao){
		this.permissao = permissao;
	}
	
	public static int getPermissao(){
		return permissao;
	}
	
	public static void setPermissao(int permissaoStatic){
		permissao = permissaoStatic;
	}
}
