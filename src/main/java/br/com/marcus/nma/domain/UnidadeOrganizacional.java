package br.com.marcus.nma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class UnidadeOrganizacional extends GenericDomain {

	@Column(length = 5, nullable = false)
	private String sigla;
	@Column(length = 300, nullable = false)
	private String uo;

	public UnidadeOrganizacional() {
		super();
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getUo() {
		return uo;
	}

	public void setUo(String uo) {
		this.uo = uo;
	}

}
