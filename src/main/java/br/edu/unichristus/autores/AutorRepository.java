package br.edu.unichristus.autores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.livros.Livro;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	// Buscar um autor pelo nome
	public Autor findByNomeContains(String nome);
	
	// Buscar os autores de um determinado livro
	public List<Autor> findByLivrosTitulo(String tituloLivro);

}
