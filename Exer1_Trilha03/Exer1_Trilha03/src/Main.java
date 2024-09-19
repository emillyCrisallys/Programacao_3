public class Main {
    public static void main(String[] args) {
        // Criar objetos da classe Aluno
        Aluno aluno1 = new Aluno("Thiago José", 17, 65, 1.71);
        Aluno aluno2 = new Aluno("Maria ALice", 28, 80, 1.69);

        // Exibir informações dos alunos
        aluno1.exibirInformacoes();
        System.out.println();
        aluno2.exibirInformacoes();
    }
}
