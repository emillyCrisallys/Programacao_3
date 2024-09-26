package jogo;

public class Console {
    private String mensagem;
    private Integer id_Save;
    private int id_Jogador;
    private int cena_atual;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getId_Save() {
        return id_Save;
    }

    public void setId_Save(Integer id_Save) {
        this.id_Save = id_Save;
    }

    public int getId_Jogador() {
        return id_Jogador;
    }

    public void setId_Jogador(int id_Jogador) {
        this.id_Jogador = id_Jogador;
    }

    public int getCena_atual() {
        return cena_atual;
    }

    public void setCena_atual(int cena_atual) {
        this.cena_atual = cena_atual;
    }
}
