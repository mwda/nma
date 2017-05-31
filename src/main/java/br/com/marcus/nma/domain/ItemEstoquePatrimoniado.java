package br.com.marcus.nma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class ItemEstoquePatrimoniado extends GenericDomain{
	
	@Column(length = 1, nullable = false)
	private Character movimento;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Categoria categoria;
	
	@Column(length = 4, nullable = false)
	private String patrimonio;
	
	@Column(length = 300, nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private UnMedida unMedida;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private EntradaPatrimoniado entradaPatrimoniado;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private SaidaPatrimoniado saidaPatrimoniado;

	public Character getMovimento() {
		return movimento;
	}
	
	@Transient
	public String getMovimentoFormatado(){
		String movimentoFormatado = null;
		
		if(movimento == 'E'){
			movimentoFormatado = "Entrada";
		}else if(movimento == 'S'){
			movimentoFormatado = "Saída";
		}
		
		return movimentoFormatado;
	}

	public void setMovimento(Character movimento) {
		this.movimento = movimento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UnMedida getUnMedida() {
		return unMedida;
	}

	public void setUnMedida(UnMedida unMedida) {
		this.unMedida = unMedida;
	}

	public EntradaPatrimoniado getEntradaPatrimoniado() {
		return entradaPatrimoniado;
	}

	public void setEntradaPatrimoniado(EntradaPatrimoniado entradaPatrimoniado) {
		this.entradaPatrimoniado = entradaPatrimoniado;
	}

	public SaidaPatrimoniado getSaidaPatrimoniado() {
		return saidaPatrimoniado;
	}

	public void setSaidaPatrimoniado(SaidaPatrimoniado saidaPatrimoniado) {
		this.saidaPatrimoniado = saidaPatrimoniado;
	}
	
	
}
