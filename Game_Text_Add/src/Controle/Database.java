package Controle;
import Entidades.Item;
import Entidades.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection connection;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/game_Casa_Abandonada", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void saveGame(Player player) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Player_Save SET current_Cena = ? WHERE player_id = ?")) {
            statement.setInt(1, player.getCurrentScene());
            statement.setInt(2, player.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public String getSceneDescription(int sceneId) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT scene_description FROM Scenes WHERE id_scenes = ?")) {
            statement.setInt(1, sceneId);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    return result.getString("scene_description");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter a descrição da cena: " + e.getMessage());
        }
        return "";
    }

    public List<Item> getItemsInScene(int sceneId) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Scene_Items WHERE item_scene_id = ?")) {
            statement.setInt(1, sceneId);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    Item item = new Item(result.getString("item_name"));
                    item.setId(result.getInt("item_id"));
                    item.setDescription(result.getString("item_description"));
                    item.setCollectible(result.getBoolean("is_collectible"));
                    item.setSceneId(result.getInt("item_scene_id"));
                    item.setEffect(result.getString("efeito_uso"));
                    item.setMessage(result.getString("mensagem_uso"));
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter os itens da cena: " + e.getMessage());
        }
        return items;
    }



    public Item getItem(String itemName) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Scene_Items WHERE item_name = ?")) {
            statement.setString(1, itemName);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    Item item = new Item(result.getString("item_name"));
                    item.setId(result.getInt("item_id"));
                    item.setDescription(result.getString("item_description"));
                    item.setCollectible(result.getBoolean("is_collectible"));
                    item.setSceneId(result.getInt("item_scene_id"));
                    item.setEffect(result.getString("efeito_uso"));
                    item.setMessage(result.getString("mensagem_uso"));
                    return item;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter o item: " + e.getMessage());
        }
        return null;
    }

    public List<Item> getInventoryItems(int playerId) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Inventory WHERE player_id = ?")) {
            statement.setInt(1, playerId);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    Item item = new Item(result.getString("item_name"));
                    item.setId(result.getInt("item_id"));
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter os itens do inventário: " + e.getMessage());
        }
        return items;
    }


    public void addItem(Item item) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Scene_Items (item_name, item_description, is_collectible, item_scene_id, efeito_uso, mensagem_uso) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setBoolean(3, item.isCollectible());
            statement.setInt(4, item.getSceneId());
            statement.setString(5, item.getEffect());
            statement.setString(6, item.getMessage());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar o item: " + e.getMessage());
        }
    }




    public boolean addItemToInventory(int playerId, int itemId,String itemName) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO inventory (player_id, item_id, item_name) VALUES (?, ?, ?)")) {
            statement.setInt(1, playerId);
            statement.setInt(2, itemId);
            statement.setString(3, itemName);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar o item ao inventário: " + e.getMessage());
            return false;
        }

    }
    public boolean hasUsedItem(int playerId, int itemId) {
        return false;
    }

    public void markItemAsUsed(int playerId, int itemId) {

    }


    public boolean isValidScene(int sceneId) {

        return sceneId >= 1 && sceneId <= getMaxSceneId();
    }

    public int getMaxSceneId() {

        return 14;
    }

    public boolean removeItemFromInventory(int playerId, int itemId) {
        // Verifica se o jogador tem o item no inventário
        if (hasItemInInventory(playerId, itemId)) {
            // Remove o item do inventário
            // Aqui você pode usar uma consulta SQL para remover o item da tabela de inventário
            String query = "DELETE FROM inventory WHERE player_id = ? AND item_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, playerId);
                statement.setInt(2, itemId);
                statement.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("Erro ao remover item do inventário: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean hasItemInInventory(int playerId, int itemId) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Inventory WHERE player_id = ? AND item_id = ?")) {
            statement.setInt(1, playerId);
            statement.setInt(2, itemId);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    return true;
                }
            }


        } catch (SQLException e) {
            System.out.println("Erro ao verificar se o item está no inventário: " + e.getMessage());
        }
        return false;
    }



}