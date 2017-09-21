package softwave.negocio;

import java.time.LocalTime;
import java.util.ArrayList;

public class Comentario {

	private Usuario autor;
	private String descricao;
	private LocalTime horario;
	private ArrayList<Comentario> comentarios;
	
	public Comentario(Usuario autor, String descricao){
		this.autor = autor;
		this.descricao = descricao;
		this.horario = LocalTime.now();
		this.comentarios = new ArrayList<>();
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
	public LocalTime getHorario() {
		return horario;
	}
	
	public ArrayList<Comentario> getComentario(){
		return comentarios;
	}
	
	public void addComentario(Comentario comentario){
		this.addComentario(comentario);
	}
}
