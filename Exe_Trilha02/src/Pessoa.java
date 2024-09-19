public class Pessoa {
    private String nome;
    private String dataNascimento;
    private Universidade universidade;


    public Pessoa(String nome, String dataNascimento, Universidade universidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.universidade = universidade;
    }


    public String getNome() {
        return nome;
    }


    public String getDataNascimento() {
        return dataNascimento;
    }


    public String infoUniversidade() {
        return nome + " trabalha na Universidade " + universidade.getNome();
    }
}
