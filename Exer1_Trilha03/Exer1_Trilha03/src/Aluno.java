public class Aluno {
    private String nome;
    private int idade;
    private double peso;
    private double altura;

    public Aluno(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }


    public double calcularIMC() {
        return peso / (altura * altura);
    }


    public boolean isMenorDeIdade() {
        return idade < 18;
    }


    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Altura: " + altura + " m");
        System.out.printf("IMC: %.2f\n", calcularIMC());
        if (isMenorDeIdade()) {
            System.out.println("O aluno " + nome + " é menor de idade e tem direito a desconto.");
        } else {
            System.out.println("O aluno " + nome + " é maior de idade.");
        }
    }

}


