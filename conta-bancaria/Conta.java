import java.util.Scanner;

public class Conta {
    
    private Pessoa pessoa;
    private double saldo;
    private double chequeEspecial;

    public void abrirConta() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome completo do titular:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF:");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o telefone:");
        String telefone = scanner.nextLine();

        System.out.println("Digite o valor do depósito inicial:");
        double depositoInicial = scanner.nextDouble();

        this.pessoa = new Pessoa(nome, cpf, endereco, telefone);
        this.saldo = depositoInicial + chequeEspecial;
        this.chequeEspecial = calcularChequeEspecial(depositoInicial);


        System.out.println("Conta aberta Sr(a) " + pessoa.getNome() + ". Seja bem vindo(a)!");

        scanner.close();
    }
    
    private double calcularChequeEspecial(double depositoInicial) {
        if (depositoInicial <= 500) {
            return 50.0;
        } else {
            return depositoInicial * 0.5;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (saldo + chequeEspecial >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void pagarBoleto(double valorBoleto) {
        if (saldo >= valorBoleto) {
            saldo -= valorBoleto;
            System.out.println("Boleto pago com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para pagar o boleto.");
        }
    }
}
