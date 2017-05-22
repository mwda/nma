package br.com.marcus.nma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class UnMedida extends GenericDomain {

	@Column(length = 5, nullable = false)
	private String unidade;
	@Column(length = 300, nullable = false)
	private String descricao;

	public UnMedida(){
		super();
	}
	
	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
