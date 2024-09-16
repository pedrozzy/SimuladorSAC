import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class SimuladorSAC {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

        //input dos dados para simular o financiamento
        System.out.println("Digite o valor total do financiamento: ");
        double capital = in.nextDouble();

        System.out.println("Digite o prazo do financiamento em meses: ");
        int tempo = in.nextInt();

        System.out.println("Digite a taxa de juros anual (%)");
        double juros = in.nextDouble();

        System.out.println("Dados recebidos.");

        //mostrar dados recebidos

        System.out.println("Valor total do financiamento: R$" + capital);
        System.out.println("Prazo: " + tempo +" meses");
        System.out.println("Taxa de juros Anual: " + juros +"%");

        //amortização
        double amortizacao = capital/tempo;
        //converter juros para mês e float
        double i = (juros/100)/12;
        //Saldo devedor
        double saldoDevedor = capital;
        double totalPago = 0;

        //tabela sac
        System.out.println("\nTabela SAC:");
        System.out.println("Mês | Juros (R$) | Amortização (R$) | Parcela (R$) | Saldo Devedor (R$)");

        for (int mes = 1; mes <=tempo; mes++) {
            double jurosMes = saldoDevedor * i;
            double parcela = amortizacao + jurosMes;
            totalPago += parcela;
            saldoDevedor -= amortizacao;

            System.out.printf("%2d  | %.2f     | %.2f          | %.2f     | %.2f%n", mes, jurosMes, amortizacao, parcela, saldoDevedor);
        }

        //resumo

        double totalJuros = totalPago - capital;
        System.out.println("\nResumo do Financiamento:");
        System.out.println("Valor financiado: " + nf.format(capital));
        System.out.println("Valor total pago: " + nf.format(totalPago));
        System.out.println("Total de juros pago: " + nf.format(totalJuros));
        


        in.close();





    }
}
