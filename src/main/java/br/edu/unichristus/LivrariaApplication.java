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

//@SpringBootApplication
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

		// Cria e salva 2 livros
		Livro livro = new Livro("Java Como Programar", LocalDate.now(), 250, new BigDecimal("15.00"));
		Livro livro2 = new Livro("PHP Básico", LocalDate.now(), 100, new BigDecimal("145.00"));
		this.servicoLivros.salvar(livro);
		this.servicoLivros.salvar(livro2);

		// Cria e salva duas editoras
		Editora editora = new Editora("Campus", "Rio de Janeiro");
		Editora editora2 = new Editora("Elsevier", "São Paulo");
		this.servicoEditoras.salvar(editora);
		this.servicoEditoras.salvar(editora2);

		// Buscar o livro com ID = 2
		Livro livroid2 = this.servicoLivros.buscarPeloID(2L);
		System.out.println(livroid2);

		// Buscar todos os livros
		List<Livro> livros = this.servicoLivros.buscarTodos();
		for (Livro l : livros) {
			System.out.println(l);
		}

		// Buscar todos os livros - opção 2
		livros.forEach(l -> System.out.println(l));

		// Alterar um livro que já existe
		Livro livroid3 = this.servicoLivros.buscarPeloID(3L);
		System.out.println(livroid3);

		livroid3.setLivroID(999L);
		livroid3.setTitulo("Os Sinos Deixaram de Dobrar");
		this.servicoLivros.salvar(livroid3);
		System.out.println(livroid3);

		// Remover um livro
		this.servicoLivros.remover(this.servicoLivros.buscarPeloID(3L));

		// Buscar o livro com um título
		Livro guerraepaz = this.servicoLivros.buscarPeloTitulo("Guerra e Paz");
		System.out.println(guerraepaz);

		// Buscar livros que contenham uma string
		List<Livro> livroscomde = this.servicoLivros.buscarTituloContendoString("%de%");
		// System.out.println(livroscomde);
		System.out.println("A CONSULTA RETORNOU " + livroscomde.size() + " LIVROS");
		livroscomde.forEach(l -> System.out.println(l));

		// Buscar livros com páginas dentro de uma faixa
		List<Livro> livrosde100a350 = this.servicoLivros.buscarLivrosComPaginasIntervalo(100, 350);
		System.out.println("A CONSULTA RETORNOU " + livrosde100a350.size() + " LIVROS");
		livrosde100a350.forEach(l -> System.out.println(l));
	}
}
