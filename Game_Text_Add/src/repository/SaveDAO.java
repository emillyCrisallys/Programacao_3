package repository;


import jogo.Save;
import jogo.Cena;
import java.sql.*;


public class SaveDAO {


    public static Save novoJogo(Integer idJogador, Integer cenarioId) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO save (id_jogador,id_cena) VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, idJogador);
        stmt.setInt(2, cenarioId);
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();
        if (generatedKeys.next()) {
            save.setId_Save(generatedKeys.getInt(1));
            save.setCena_atual_save(CenaDAO.findCenaById(cenarioId));
        }
        return save;
    }

    public static Save carregarJogo(int Id) throws SQLException {
        Save save = new Save();
        Connection conn = Mysql.getConnection();
        String sql = "SELECT s.id_cena, d.descricao FROM  save s INNER JOIN cena c ON s.id_cena = c.id WHERE s.id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Id);
        ResultSet rs = stmt.executeQuery();
        Cena cena = new Cena();

        if (rs.next()) {
            save.setId_Save(rs.getInt("id"));
            cena.setid_Cena(rs.getInt("cenario_id"));
            cena.setDescricao(rs.getString("descricao"));

        }

        return save;
    }

}