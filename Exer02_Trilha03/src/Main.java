public class Main {
    public static void main(String[] args) {

        ContaBancaria conta1 = new ContaBancaria(14876, "Thiago José", 2000.00);
        ContaBancaria conta2 = new ContaBancaria(67890, "Maria ALice", 500.00);


        conta1.exibirSaldo();
        conta2.exibirSaldo();
        System.out.println();


        conta1.depositar(200.00);
        conta1.sacar(150.00);
        conta1.sacar(2000.00);
        conta1.exibirSaldo();
        System.out.println();


        conta2.sacar(300.00);
        conta2.sacar(300.00);
        conta2.exibirSaldo();
    }
}
