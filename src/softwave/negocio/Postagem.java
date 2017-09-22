package softwave.negocio;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Postagem {
	private String titulo;
	private String descricao;
	private Usuario autor;
	private boolean visibilidade;
	private List<String> tags;
	private LocalTime horario;
	private String texto;

	public Postagem(String titulo, String texto, Usuario autor) {
		setTitulo(titulo);
		setTexto(texto);
		setAutor(autor);

	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Postagem(String titulo, String descricao, Usuario autor, List<String> palavrasChave) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.visibilidade = true;
		this.tags = new ArrayList<>();
		this.tags = palavrasChave;
		this.horario = LocalTime.now();
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

	public String getDescrição() {
		return descricao;
	}

	public void setDescrição(String descrição) {
		this.descricao = descrição;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public boolean isVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}

	public List<String> getPalavrasChave() {
		return tags;
	}

	public LocalTime getHorario() {
		return this.horario;
	}

	public void addTag(String tag) {
		tags.add(tag);
	}

}
