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
public class ConsultasComEditorasApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;

	public static void main(String[] args) {
		SpringApplication.run(ConsultasComEditorasApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		// 1 - Alterar a cidade da editora bookman para Porto Alegre
		Editora bookman = servicoEditoras.buscarPeloNome("Bookman");
		bookman.setCidade("Porto Alegre");
		servicoEditoras.salvar(bookman);

		// 2 - Remover a editora moderna
		Editora moderna = servicoEditoras.buscarPeloNome("Moderna");
		servicoEditoras.remover(moderna);

		// 3- Buscar editoras com ano de fundação entre 1970 e 2010
		List<Editora> editoras70a2010 = servicoEditoras.buscarPeloAnoFundacao(1970, 2010);
		editoras70a2010.forEach(e -> System.out.println(e));

	}
}
