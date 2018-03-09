package br.edu.unichristus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.autores.AutorService;
import br.edu.unichristus.editoras.Editora;
import br.edu.unichristus.editoras.EditoraService;
import br.edu.unichristus.livros.Livro;
import br.edu.unichristus.livros.LivroService;

@SpringBootApplication
public class ConsultasComMaisTabelasApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;
	
	@Autowired
	private AutorService servicoAutores;

	public static void main(String[] args) {
		SpringApplication.run(ConsultasComMaisTabelasApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Editora ceara = new Editora("Ceará", "São Paulo", 1950);
		this.servicoEditoras.salvar(ceara);
		
		
	}
}
