package it.asl.application1.dao;

import it.asl.application1.model.Articolo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticoloDao {
    private Connection conn = null;
    private java.sql.ResultSet rs = null;

    public ArticoloDao() throws ClassNotFoundException, SQLException {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/eserciziocompleto";
            String user = "root";
            Class.forName(driver);
            this.conn = java.sql.DriverManager.getConnection(url, user, null);

    }

    public void destroy() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<Articolo>showAllArticoli() throws SQLException {
        List<Articolo> articoli = new ArrayList<>();
            Statement stmt = conn.createStatement();
            String prepereStatementAllArticoli = "SELECT * FROM articolo";
            rs = stmt.executeQuery(prepereStatementAllArticoli);
            while (rs.next()) {
                Articolo articolo = new Articolo(rs.getString("nome"),rs.getString("descrizione"),rs.getInt("quantita"),rs.getInt("codice"));
                articoli.add(articolo);
            }
        return articoli;
    }

    public void insertArticoli(Articolo articolo){
        String prepereStatementInsertArticoli = "INSERT INTO eserciziocompleto.articolo (nome, descrizione, quantita) VALUES (?,?,?)";
        try (java.sql.PreparedStatement pstmt = conn.prepareStatement(prepereStatementInsertArticoli)) {
            pstmt.setString(1, articolo.getNome());
            pstmt.setString(2, articolo.getDescrizione());
            pstmt.setInt(3, articolo.getQuantita());
            pstmt.executeUpdate();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
        }
    }

    public void updateArticoli(Articolo articolo){
        String prepereStatementInsertArticoli = "UPDATE eserciziocompleto.articolo (nome, descrizione, quantita) VALUES (?,?,?)";
        try (java.sql.PreparedStatement pstmt = conn.prepareStatement(prepereStatementInsertArticoli)) {
            pstmt.setString(1, articolo.getNome());
            pstmt.setString(2, articolo.getDescrizione());
            pstmt.setInt(3, articolo.getQuantita());
            pstmt.executeUpdate();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
        }
    }


}
