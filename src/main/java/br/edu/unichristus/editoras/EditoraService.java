package br.edu.unichristus.editoras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	public void salvar(Editora e) {
		System.out.println("GRAVANDO EDITORA " + e.getNome());
		this.repo.save(e);
	}

	public Editora buscarPeloNome(String nome) {
		return this.repo.findByNomeEquals(nome);
	}

	public void remover(Editora e) {
		System.out.println("REMOVENDO A EDITORA " + e.getNome());
		this.repo.delete(e);
	}

	public List<Editora> buscarTodos() {
		return this.repo.findAll();
	}

	public List<Editora> buscarPeloAnoFundacao(int minimo, int maximo) {
		return this.repo.findByAnoFundacaoGreaterThanEqualAndAnoFundacaoLessThanEqual(minimo, maximo);
	}

}
