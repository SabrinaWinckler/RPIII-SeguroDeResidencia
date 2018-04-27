/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Montanha
 */
public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbSeguroDeResidencia";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection realizarConexao() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao efetuar a conexão.", ex);
        }
    }

    public static void fecharConexao(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public static void fecharConexao(Connection conexao, PreparedStatement stmt) {
        fecharConexao(conexao);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fecharConexao(Connection conexao, PreparedStatement stmt, ResultSet resultSet) {
        fecharConexao(conexao, stmt);
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     */
}
