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
	
}
