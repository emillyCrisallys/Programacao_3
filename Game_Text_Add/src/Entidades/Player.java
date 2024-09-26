package Entidades;

public class Player {
    private int id;
    private int currentScene;

    public Player() {
        this.id = 1;
        this.currentScene = 1;
    }

    public int getId() {

        return id;
    }

    public int getCurrentScene() {

        return currentScene;
    }

    public void setCurrentScene(int currentScene) {

        this.currentScene = currentScene;
    }


}