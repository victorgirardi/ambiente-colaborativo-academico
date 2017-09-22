package softwave.negocio;

//Classe que simula a conexão com o servidor

public class Sessao {
	private static Usuario usuario;
	
	public Sessao(Usuario usuario){
		this.usuario = usuario;
	}
	
	public static int getPermissao(){
		return usuario.getPermissao();
	}
	
	public static void setPermissao(Usuario usuarioStatic){
		usuario.setPermissao(usuarioStatic.getPermissao());
	}
}
