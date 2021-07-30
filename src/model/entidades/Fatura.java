package model.entidades;

public class Fatura {
	private Double basicoPagamento;
	private Double imposto;

	
	public Fatura() {	
	}
	
	public Fatura(Double basicoPagamento, Double imposto) {
		this.basicoPagamento = basicoPagamento;
		this.imposto = imposto;
	}

	public Double getBasicoPagamento() {
		return basicoPagamento;
	}

	public void setBasicoPagamento(Double basicoPagamento) {
		this.basicoPagamento = basicoPagamento;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}
	
	public Double TotalPagamento() {
		return getBasicoPagamento() + getImposto();	
	}	
}
