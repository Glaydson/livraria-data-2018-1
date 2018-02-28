package br.edu.unichristus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.editoras.Editora;
import br.edu.unichristus.editoras.EditoraService;
import br.edu.unichristus.livros.Livro;
import br.edu.unichristus.livros.LivroService;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Livro livro = new Livro("Java Como Programar", LocalDate.now(), 250, new BigDecimal("15.00"));
		Livro livro2 = new Livro("PHP Básico", LocalDate.now(), 100, new BigDecimal("145.00"));
		this.servicoLivros.salvarLivro(livro);
		this.servicoLivros.salvarLivro(livro2);

		Editora editora = new Editora("Campus", "Rio de Janeiro");
		Editora editora2 = new Editora("Elsevier", "São Paulo");
		this.servicoEditoras.salvarEditora(editora);
		this.servicoEditoras.salvarEditora(editora2);
		
		// Buscar o livro com ID = 2
		Livro livroid2 = this.servicoLivros.buscarPeloID(2L);
		System.out.println(livroid2);
		
		// Buscar todos os livros
		List<Livro> livros = this.servicoLivros.buscarTodos();
		for (Livro l: livros) {
			System.out.println(l);
		}
		
		livros.forEach(l -> System.out.println(l));
	

	}
}
