package jogo;

import java.util.List;

public class Cena {
    private Integer id_Cena;
    private String descricao;
    private List<Item> itens;

    public Integer getid_Cena() {
        return id_Cena;
    }

    public void setid_Cena(Integer id_Cena) {
        this.id_Cena = id_Cena;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Cena{" +
                "id_Cena=" + id_Cena +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

