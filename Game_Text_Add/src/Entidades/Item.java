package Entidades;

public class Item {
    private int id;
    private String name;
    private String description;
    private boolean isCollectible;
    private int sceneId;
    private String effect;
    private String message;

    public Item(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCollectible() {
        return isCollectible;
    }

    public int getSceneId() {
        return sceneId;
    }

    public String getEffect() {
        return effect;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public void setCollectible(boolean collectible) {
        isCollectible = collectible;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}