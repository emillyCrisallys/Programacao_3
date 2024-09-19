public class ContaBancaria {
    private int numeroConta;
    private String nomeCliente;
    private double saldo;


    public ContaBancaria(int numeroConta, String nomeCliente, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeCliente = nomeCliente;
        this.saldo = saldoInicial;
    }


    public void exibirSaldo() {
        System.out.printf(" - Conta: " + numeroConta + " - Cliente: " + nomeCliente);
        System.out.printf(" - Saldo atual: R$ " + saldo);
    }


    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$" + valor +" realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }


    public void sacar(double valor) {
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
                System.out.printf(" Saque de R$" + valor + " realizado com sucesso!");
            } else {
                System.out.println(" Saldo insuficiente para o saque!");
            }
        } else {
            System.out.println("Valor de saque inválido!");
        }
    }
}


