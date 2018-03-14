package br.edu.unichristus.autores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
	@Autowired
	private AutorRepository repo;

	/* MÉTODOS CRUD */

	public void salvar(Autor autor) {
		this.repo.save(autor);
		System.out.println("AUTOR " + autor.getAutorID() + " SALVO!");
	}

	public List<Autor> buscarTodos() {
		System.out.println("OBTENDO A LISTA COMPLETA DE AUTORES");
		return this.repo.findAll();
	}

	public Autor buscarPeloID(Long idAutor) {
		System.out.println("OBTENDO O AUTOR COM O ID = " + idAutor);
		return this.repo.findOne(idAutor);
	}

	public List<Autor> buscarPelosIDs(ArrayList<Long> idsAutores) {
		System.out.println("OBTENDO OS AUTORES COM OS IDS " + idsAutores.toString());
		return this.repo.findAll(idsAutores);
	}

	public void remover(Long idAutor) {
		this.repo.delete(idAutor);
		System.out.println("REMOVIDO O AUTOR COM ID = " + idAutor);
	}

	public void remover(Autor autor) {
		this.repo.delete(autor);
		System.out.println("REMOVIDO O AUTOR COM ID = " + autor.getAutorID());
	}
	
	public Autor buscarPeloNome(String nome) {
		return repo.findByNomeContains(nome);
	}

}
