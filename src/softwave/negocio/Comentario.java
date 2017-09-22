package softwave.negocio;

import java.time.LocalDate;

public class Comentario {

	private int id;
	private Usuario autor;
	private String descricao;
	private LocalDate horario;
	private boolean visibilidade;
	
	public Comentario(int id, Usuario autor, String descricao, boolean visibilidade){
		this.autor = autor;
		this.descricao = descricao;
		this.visibilidade = true;
		this.id = id;
	}
	public Comentario(Usuario autor, String descricao){
		this.autor = autor;
		this.descricao = descricao;
		this.visibilidade = true;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDate getHorario() {
		return horario;
	}
	
	public boolean getVisibilidade(){
		return visibilidade;
	}
	
	public void setVisibilidade(boolean visibilidade){
		this.visibilidade = visibilidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
