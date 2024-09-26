package repository;

import jogo.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public static Item addInventario(Integer idJogador, Integer item_id, Integer quantItens, String nameItem) throws SQLException {
        Item item = new Item();
        PreparedStatement stmt = null;
        Connection conn = Mysql.getConnection();
        String sql = "insert into itens_jogador (idJogador,item_id,quantItens,nameItem) values(?,?,?,?)";
        stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1,idJogador);
        stmt.setInt(2,item_id);
        stmt.setInt(3,quantItens);
        stmt.setString(4,nameItem);
        int up = stmt.executeUpdate();

        if (up > 0){
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                item.setItens_Jogador_id(rs.getInt(1));
                item.setId_Item(item_id);
                item.setQuant_Itens(quantItens);
                item.setName_Item(nameItem);
            }

        }

        return item;
    }


    public static Item checkItensInventario(Integer id_item) throws SQLException {

        Item item = new Item();
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM item WHERE id_item = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_item);
        ResultSet rs = stmt.executeQuery();


        if (rs.next()) {

            item.setId_Item(
                    rs.getInt("id_item"));
            item.setName_Item(rs.getString("nameItem"));
        }



        return item;
    }



    public static List<Item> exibirInventario(Integer id_Jogador) throws SQLException{
        List<Item> itms = new ArrayList<>();
        Connection coon = Mysql.getConnection();
        String sql = "SELECT * FROM itens_jogador WHERE id_Jogador = ?";
        PreparedStatement stmt = coon.prepareStatement(sql);
        stmt.setInt(1,id_Jogador);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Item item = new Item();
            item.setItens_Jogador_id(rs.getInt("id_Jogador"));
            item.setName_Item(rs.getString("nameItem"));
            item.setQuant_Itens(rs.getInt("quantItens"));
            itms.add(item);
        }




        return itms;
    }

}
