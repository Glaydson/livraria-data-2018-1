package br.edu.unichristus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.autores.Autor;
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
		// Incluindo uma nova editora
		Editora e = new Editora("Érica", "Rio de Janeiro", 1937);

		// Incluindo um novo livro. É preciso dizer qual é a editora
		Livro l = new Livro("Java em 30 dias", LocalDate.now(), 250, new BigDecimal("15.00"));
		l.setEditora(e);

		// Criando uma variável para armazenar a lista de livros do autor
		List<Livro> livrosJose = (new ArrayList<Livro>() {
			{
				add(l);
			}
		});

		// Incluindo um novo autor
		Autor a = new Autor("Antonio José", "Brasil");
		a.setLivros(livrosJose);

		// SALVANDO AS ENTIDADES - OBSERVE A ORDEM
		this.servicoEditoras.salvar(e);
		this.servicoLivros.salvar(l);
		this.servicoAutores.salvar(a);

		// Autor antonio = servicoAutores.buscarPeloNome("Antonio José");
		// System.out.println(antonio.getLivros());
		// antonio.getLivros().forEach(liv -> System.out.println(liv));

		// Cria um novo livro, editora Campus
		Livro livro2 = new Livro("Java em 90 dias", LocalDate.of(2015, 3, 30), 300, new BigDecimal("50.00"));
		livro2.setEditora(servicoEditoras.buscarPeloNome("Campus"));

		// Busca um autor pelo seu ID
		Autor antonio = servicoAutores.buscarPeloNome("Antonio José");

		// Adiciona o livro no autor
		antonio.getLivros().add(livro2);

		// Salva as alterações no livro e autor
		this.servicoLivros.salvar(livro2);
		this.servicoAutores.salvar(antonio);

		// Todos os livros de uma editora - versão 1
		// Editora campus = servicoEditoras.buscarPeloNome("Campus");
		// campus.getLivros().forEach(livro -> System.out.println(livro));

		// Todos os livros de uma editora - versão 2
		System.out.println("LIVROS DA EDITORA CAMPUS");
		List<Livro> livrosCampus = servicoLivros.buscarLivrosEditora(servicoEditoras.buscarPeloNome("Campus"));
		livrosCampus.forEach(livro -> System.out.println(livro));

		// Todos os livros de um autor
		System.out.println("LIVROS DO AUTOR ANTONIO JOSÉ");
		List<Livro> livrosAntonio = servicoLivros.buscarLivrosAutor("Antonio José");
		livrosAntonio.forEach(livro -> System.out.println(livro));

		// Todos os livros de Antonio José na Editora Érica
		System.out.println("LIVROS DO AUTOR ANTONIO JOSÉ NA EDITORA ÉRICA");
		List<Livro> livrosAntonioErica = servicoLivros.buscarLivrosAutorEditora("Antonio José", "Érica");
		livrosAntonioErica.forEach(livro -> System.out.println(livro));

		// Todos os autores de um determinado livro
		System.out.println("AUTORES DO LIVRO JAVA COMO PROGRAMAR");
		List<Autor> autoresJavaProgramar = servicoAutores.buscarAutoresLivro("Java Como Programar");
		autoresJavaProgramar.forEach(autor -> System.out.println(autor));

		// Todos os livros cujos autores sejam de um determinado país
		System.out.println("LIVROS CUJOS AUTORES SEJAM DA INGLATERRA");
		List<Livro> livrosAutorInglaterra = servicoLivros.buscarLivrosAutorPais("Inglaterra");
		livrosAutorInglaterra.forEach(livro -> System.out.println(livro));

	}
}
