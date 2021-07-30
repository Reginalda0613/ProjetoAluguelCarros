package model.servicos;

import model.entidades.AluguelCarros;
import model.entidades.Fatura;

public class ServicoAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	
	private ImpostoServico impostoServico;

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, ImpostoServico impostoServico) {

		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.impostoServico = impostoServico;
	}
	
	public void processoFatura(AluguelCarros aluguelCarros) {
		long t1 = aluguelCarros.getInicio().getTime();
		long t2= aluguelCarros.getFim().getTime();
		double horas = (double)(t2 - t1) /1000 /60 / 60;
		
		double basicoPagamento;
		if(horas <= 12.0) {
			basicoPagamento = Math.ceil(horas) * precoPorHora;	
		}
		else {
			basicoPagamento = Math.ceil(horas / 24) * precoPorDia;
		}
		
		double imposto = impostoServico.imposto(basicoPagamento);
		
		aluguelCarros.setFatura(new Fatura(basicoPagamento, imposto));
	}
	
}

