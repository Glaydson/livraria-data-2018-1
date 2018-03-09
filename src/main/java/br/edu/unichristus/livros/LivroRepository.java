package br.edu.unichristus.livros;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	// Consultas derivadas

	// Buscar um livro pelo seu título
	public Livro findByTitulo(String titulo);

	// Buscar os livros que contenham uma string
	public List<Livro> findByTituloLike(String string);

	// Buscar os livros dentro de uma faixa de páginas
	public List<Livro> findByNumeroPaginasBetween(int de, int ate);

	public List<Livro> findByAutoresNome(String nome);

	public List<Livro> findByAutoresPais(String pais);

}
