package jogo;

public class Save {
    private  Integer id_Save;
    private Cena cena_atual_save;

    public Integer getId_Save() {
        return id_Save;
    }

    public void setId_Save(Integer id_Save) {
        this.id_Save = id_Save;
    }

    public Cena getCena_atual_save() {
        return cena_atual_save;
    }

    public void setCena_atual_save(Cena cena_atual_save) {
        this.cena_atual_save = cena_atual_save;
    }

    @Override
    public String toString() {
        return "Save{" +
                "id_Save=" + id_Save +
                ", cena_atual_save=" + cena_atual_save +
                '}';
    }
}
