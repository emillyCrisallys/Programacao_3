package repository;

import jogo.Cena;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CenaDAO {

    public static Cena findCenaById(Integer idCena) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM Cena WHERE idCena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idCena);
        ResultSet rs = stmt.executeQuery();
        Cena cena = new Cena();

        if (rs.next()) {
            cena.setid_Cena(
                    rs.getInt("id"));
            cena.setDescricao(rs.getString("conteudo"));
        }
        return cena;
    }


}
