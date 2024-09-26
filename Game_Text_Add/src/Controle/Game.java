package Controle;

import Entidades.Item;
import Entidades.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private Database database;
    private Scanner scanner;



    public Game() {
        this.player = new Player();
        this.database = new Database();
        this.scanner = new Scanner(System.in);
        this.player.setCurrentScene(1);

    }

    public void start() {
        System.out.println("Bem-vindo ao jogo de aventura em texto!");
        System.out.println("Você está em uma casa abandonada. O que você deseja fazer?");
        checkScene();
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            switch (command) {
                case "get":
                    getPlayerInfo();
                    break;
                case "check":
                    checkScene();
                    break;
                case "save":
                    saveGame();
                    break;
                case "restart":
                    restartGame();
                    break;
                case "use":
                    useItem();
                    break;
                case "add":
                    addItem();
                    break;
                case "help":
                    showHelp();
                    break;
                case "check inventory":
                    checkInventory();
                    break;
                case "next":
                    nextScene();
                    break;
                case "delete":
                    deleteItem();
                    break;
                case "exit":
                    System.out.println("Saindo do jogo...");
                    return;
                default:
                    System.out.println("Comando inválido. Tente novamente.");
            }
        }
    }

    private void getPlayerInfo() {
        System.out.println("Informações do jogador:");
        System.out.println("ID: " + player.getId());
        System.out.println("Cena atual: " + player.getCurrentScene());
    }

    private void checkScene() {
        System.out.println("Cena atual:" );
        System.out.println(database.getSceneDescription(player.getCurrentScene()));

        List<Item> items = database.getItemsInScene(player.getCurrentScene());
        if (!items.isEmpty()) {
            System.out.println("Itens disponíveis:");
            for (Item item : items) {
                System.out.println(item.getName());
            }
        }
    }

    private void saveGame() {
        database.saveGame(player);
        System.out.println("Jogo salvo com sucesso!");
    }

    private void restartGame() {
        player = new Player();
        System.out.println("Jogo reiniciado com sucesso!");
        checkScene();
    }



    private void addItem() {
        System.out.print("Digite o nome do item que você deseja adicionar: ");
        String itemName = scanner.nextLine();

        Item item = database.getItem(itemName);
        if (item != null) {
            if (database.hasUsedItem(player.getId(), item.getId())) {
                System.out.println("Você já usou esse item.");
            } else {
                if (database.addItemToInventory(player.getId(), item.getId(),item.getName())) {
                    System.out.println("Você adicionou o item ao seu inventário.");
                } else {
                    System.out.println("Você não pode adicionar esse item ao seu inventário.");
                }
            }


        } else {
            System.out.println("Item não encontrado.");
        }

    }

    private void useItem() {
        System.out.print("Digite o nome do item que você deseja usar: ");
        String itemName = scanner.nextLine();

        Item item = database.getItem(itemName);
        if (item != null) {
            if (database.hasItemInInventory(player.getId(), item.getId())) {
                if (database.hasUsedItem(player.getId(), item.getId())) {
                    System.out.println("Você já usou esse item.");
                } else {
                    database.markItemAsUsed(player.getId(), item.getId());
                    System.out.println("Você usou o item.");
                    System.out.println(item.getMessage());
                }
            } else {
                System.out.println("Você não tem esse item no seu inventário.");
            }
        } else {
            System.out.println("Item não encontrado.");
        }
    }
    private void checkInventory() {
        List<Item> inventoryItems = database.getInventoryItems(player.getId());
        if (!inventoryItems.isEmpty()) {
            System.out.println("Itens no inventário:");
            for (Item item : inventoryItems) {
                System.out.println(item.getName());
            }
        } else {
            System.out.println("Inventário vazio.");
        }
    }


    private void nextScene() {

        int nextSceneId = player.getCurrentScene() + 1;
        if (database.isValidScene(nextSceneId)) {
            player.setCurrentScene(nextSceneId);
            checkScene();
        } else {
            System.out.println("Você não pode ir para a próxima cena.");
        }

    }

    private void deleteItem() {
        System.out.print("Digite o nome do item que você deseja deletar: ");
        String itemName = scanner.nextLine();

        Item item = database.getItem(itemName);
        if (item != null) {
            if (database.hasItemInInventory(player.getId(), item.getId())) {
                if (database.removeItemFromInventory(player.getId(), item.getId())) {
                    System.out.println("Você removeu o item do seu inventário.");
                } else {
                    System.out.println("Você não pode remover esse item do seu inventário.");
                }
            } else {
                System.out.println("Você não tem esse item no seu inventário.");
            }
        } else {
            System.out.println("Item não encontrado.");
        }
    }
    private void showHelp() {
        System.out.println("Comandos disponíveis:");
        System.out.println("HELP - Mostra esta ajuda.");
        System.out.println("GET - Informações do jogador");
        System.out.println("USE [ITEM] - Usa um item do inventário.");
        System.out.println("CHECK INVENTORY - Checa a descrição dos itens do inventário.");
        System.out.println("CHECK - Apresenta a cena novamente");
        System.out.println("ADD - Adiciona o item ao inventario");
        System.out.println("NEXT - Muda a cena");
        System.out.println("DELETE - Apaga um item do inventário");
        System.out.println("SAVE - Salva o jogo.");
        System.out.println("LOAD - Carrega o jogo salvo.");
        System.out.println("RESTART - Reinicia o jogo.");
        System.out.println("EXIT - Sair do jogo.");
    }


}