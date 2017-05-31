package br.com.marcus.nma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Entity
public class Categoria extends GenericDomain {

	@Column(length = 5, nullable = false)
	private String categoria;
	@Column(length = 300, nullable = false)
	private String descricao;
	
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long sequencial;
	
	public Categoria(){
		super();
	}

	public Categoria(String categoria, String descricao) {
		super();
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getSequencial() {
		return sequencial;
	}

	public void setSequencial(Long sequencial) {
		this.sequencial = sequencial;
	}
}
