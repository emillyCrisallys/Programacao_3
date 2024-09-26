package jogo;

public class Item {
    private Integer id_Item;
    private Integer id_Cena_Item;
    private String name_Item;
    private Integer itens_Jogador_id;
    private Integer quant_Itens;

    public Integer getId_Item() {
        return id_Item;
    }

    public void setId_Item(Integer id_Item) {
        this.id_Item = id_Item;
    }

    public Integer getId_Cena_Item() {
        return id_Cena_Item;
    }

    public void setId_Cena_Item(Integer id_Cena_Item) {
        this.id_Cena_Item = id_Cena_Item;
    }

    public String getName_Item() {
        return name_Item;
    }

    public void setName_Item(String name_Item) {
        this.name_Item = name_Item;
    }

    public Integer getItens_Jogador_id() {
        return itens_Jogador_id;
    }

    public void setItens_Jogador_id(Integer itens_Jogador_id) {
        this.itens_Jogador_id = itens_Jogador_id;
    }

    public Integer getQuant_Itens() {
        return quant_Itens;
    }

    public void setQuant_Itens(Integer quant_Itens) {
        this.quant_Itens = quant_Itens;
    }
}
