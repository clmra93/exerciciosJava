import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private final static Conta conta = new Conta();

    public static void main(String[] args) {
        var option =- 1;

        do {
            System.out.println("===Escolha uma opção===");
            System.out.println("1. Abrir conta");
            System.out.println("2. Verificar saldo da conta");
            System.out.println("3. Fazer depósito");
            System.out.println("4. Fazer saque");
            System.out.println("5. Pagar boleto");
            System.out.println("0. Sair");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> conta.abrirConta();
                case 2 -> System.out.println("Seu saldo é de: R$" + conta.getSaldo());
                case 3 -> {
                    System.out.println("Digite o valor do deposito: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                }
                case 4 -> {
                    System.out.println("Digite o valor que deseja sacar: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                }
                case 5 -> {
                    System.out.println("Digite o valor do boleto: ");
                    double valorBoleto = scanner.nextDouble();
                    conta.pagarBoleto(valorBoleto);
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        } while (true);
    }
}