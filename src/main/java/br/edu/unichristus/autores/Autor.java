package br.edu.unichristus.autores;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.edu.unichristus.livros.Livro;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_AUTOR")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTOR_ID")
	private Long autorID;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "PAIS")
	private String pais;

	// Autor é o proprietário da relação many to many
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_AUTORES_LIVROS")
	private List<Livro> livros;

	public Autor(String nome, String pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public Autor() {

	}

	@Override
	public String toString() {
		return "Autor [autorID=" + autorID + ", nome=" + nome + ", pais=" + pais + ", livros=" + livros + "]";
	}

	// GETS E SETS, CONSTRUTOR, MÉTODO toString

}
