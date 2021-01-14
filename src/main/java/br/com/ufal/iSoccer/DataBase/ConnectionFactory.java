package br.com.ufal.iSoccer.DataBase;

import java.sql.*;

public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/iSoccerDB?useTimezone=true&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "root123";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexao",e);
        }
    }

    public static void closeConnection(Connection con){
        try {
            con.close();
            con = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt){
        try {
            stmt.close();
            stmt = null;
            closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        try {
            rs.close();
            rs = null;
            closeConnection(con,stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}