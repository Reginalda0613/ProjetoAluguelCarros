package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entidades.AluguelCarros;
import model.entidades.Veiculo;
import model.servicos.BrasilImpostoServicos;
import model.servicos.ServicoAluguel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entre com a data do aluguel");
		System.out.print("Modelo do carro");
		String carroModelo = sc.nextLine();
		System.out.print("Celta (dd/MM/yyyy hh:ss):");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Retorno (dd/MM/yyyy hh:ss): ");
		Date fim = sdf.parse(sc.nextLine());
		
		AluguelCarros ac = new AluguelCarros (inicio, fim, new Veiculo(carroModelo));
		
		System.out.print("Digite o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Digite o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
        ServicoAluguel servicoAluguel = new  ServicoAluguel(precoPorDia, precoPorHora, new BrasilImpostoServicos());
        servicoAluguel.processoFatura(ac);
        
        System.out.println("Fatura: ");
        System.out.println("Basico pagamento: " + String.format("%.2f", ac.getFatura().getBasicoPagamento()));
        System.out.println("Imposto: " + String.format("%.2f", ac.getFatura().getImposto()));
        System.out.println("Total pagamento: " + String.format("%.2f", ac.getFatura().getBasicoPagamento()));
        
		
		sc.close();
	}
}
