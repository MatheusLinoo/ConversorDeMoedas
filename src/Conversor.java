import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RequestApi cambioService = new RequestApi();
        Consulta historico = new Consulta();
        LogError logError = new LogError();

        String[][] opcoesMoedas = {
            {"USD", "ARS"},
            {"ARS", "USD"},
            {"USD", "BRL"},
            {"BRL", "USD"},
            {"USD", "COP"},
            {"COP", "USD"}
        };

        int opcao;

        do {
            System.out.println("\n=== Conversor de Moedas ===");
            for (int i = 0; i < opcoesMoedas.length; i++) {
                System.out.printf("%d - %s -> %s%n", i + 1, opcoesMoedas[i][0], opcoesMoedas[i][1]);
            }
            System.out.println("0 - Encerrar programa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 0) break;
            if (opcao < 1 || opcao > opcoesMoedas.length) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            String moedaOrigem = opcoesMoedas[opcao - 1][0];
            String moedaDestino = opcoesMoedas[opcao - 1][1];

            System.out.printf("Digite o valor em %s: ", moedaOrigem);
            double valorScanner = scanner.nextDouble();

            try {
                double taxa = cambioService.buscarTaxa(moedaOrigem, moedaDestino);
                double valorConvertido = valorScanner * taxa;
                String resultado = String.format("%.2f %s = %.2f %s", valorScanner, moedaOrigem, valorConvertido, moedaDestino);

                System.out.println(">> Resultado: " + resultado);
                historico.gravarConversao(resultado);

            } catch (Exception ex) {
                System.out.println("Falha ao converter moedas.");
                logError.registrarErro(ex.getMessage());
            }

        } while (true);

        scanner.close();
        System.out.println("Aplicação encerrada.");
    }
}