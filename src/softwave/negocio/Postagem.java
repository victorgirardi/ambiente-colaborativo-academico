package softwave.negocio;

import java.time.LocalDate;
import java.util.List;

public class Postagem {
	private int id;
	private String titulo;
	private Usuario autor;
	private boolean visibilidade;
	private List<String> tags;
	private LocalDate horario;
	private String texto;

	public Postagem(String titulo, String texto, Usuario autor) {
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
		this.visibilidade = true;
		this.horario = LocalDate.now();

	}
	
	public Postagem(int id, String titulo, String texto, Usuario autor){
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
		this.visibilidade = true;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void adicionarPalavrachave(String palavraChave) {
		this.tags.add(palavraChave);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public boolean getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}

	public List<String> getPalavrasChave() {
		return tags;
	}

	public LocalDate getHorario() {
		return this.horario;
	}

	public void addTag(String tag) {
		tags.add(tag);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
