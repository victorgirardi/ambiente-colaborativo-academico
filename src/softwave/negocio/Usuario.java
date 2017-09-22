package softwave.negocio;

public class Usuario {
	private String prontuario;
	private int permissao;
	private String nome;
	private int turma;
	private String senha;
	
	
	
	public Usuario() {
		
	}

	public Usuario(String prontuario, int permissao, String nome, int turma){
		this.prontuario = prontuario;
		this.permissao = permissao;
		this.nome = nome;
		this.turma = turma;
	}
	
	public String getProntuario() {
		return prontuario;
	}
	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}
	public int getPermissao() {
		return permissao;
	}
	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTurma() {
		return turma;
	}
	public void setTurma(int turma) {
		this.turma = turma;
	}
	
	public String getSenha(){
		 return senha;
	}
	 
	public void setSenha(String senha){
		this.senha = senha;
	}
}
