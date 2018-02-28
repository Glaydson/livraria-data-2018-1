package br.edu.unichristus.livros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repo;
	
	public void salvarLivro(Livro l) {
		System.out.println("GRAVANDO O LIVRO " + l.getTitulo());
		repo.save(l);
	}
	
	public Livro buscarPeloID(Long id) {
		return repo.findOne(id);
	}
	
	public List<Livro> buscarTodos() {
		return repo.findAll();
	}

}
