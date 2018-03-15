package br.edu.unichristus.livros;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.editoras.Editora;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	// Consultas derivadas

	// Buscar um livro pelo seu título
	public Livro findByTitulo(String titulo);

	// Buscar os livros que contenham uma string
	public List<Livro> findByTituloLike(String string);

	// Buscar os livros dentro de uma faixa de páginas
	public List<Livro> findByNumeroPaginasBetween(int de, int ate);

	// Buscar os livros de um autor
	public List<Livro> findByAutoresNome(String nome);

	// Buscar os livros cujos autores sejam de um determinado país
	public List<Livro> findByAutoresPais(String pais);
	
	// Buscar os livros de uma editora
	public List<Livro> findByEditora(Editora e);
	
	// Buscar os livros de um autor e editora
	public List<Livro> findByAutoresNomeAndEditoraNome(String nomeAutor, String nomeEditora);

}
