package br.com.marcus.nma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Sequencial extends GenericDomain {

	@Column(nullable = false)
	private Long sequencial;

	public Long getSequencial() {
		return sequencial;
	}

	public void setSequencial(Long sequencial) {
		this.sequencial = sequencial;
	}

}
