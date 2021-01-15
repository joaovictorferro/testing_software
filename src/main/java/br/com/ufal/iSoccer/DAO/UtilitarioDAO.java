package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.entidades.Utilitario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilitarioDAO {
    private Connection con = null;

    public UtilitarioDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatUtilitario(Utilitario utilitario){
        String sql = "INSERT INTO utilitario (id_utilitario,estoque,precoVenda,quantComprada,nome) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, utilitario.getId());
            stmt.setInt(2, utilitario.getEstoque());
            stmt.setDouble(3,utilitario.getPrecoVenda());
            stmt.setInt(4,utilitario.getQuantComprada());
            stmt.setString(5,utilitario.getNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<Utilitario> findAll(){
        String sql = "select * from utilitario ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Utilitario> utilitarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Utilitario utilitario = new Utilitario();
                utilitario.setId(rs.getInt("id_utilitario"));
                utilitario.setPrecoVenda(rs.getDouble("precoVenda"));
                utilitario.setEstoque(rs.getInt("estoque"));
                utilitario.setQuantComprada(rs.getInt("quantComprada"));
                utilitario.setNome(rs.getString("nome"));
                utilitarios.add(utilitario);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return utilitarios;
    }

    public boolean UpdateUtilitarioEstoque(Utilitario utilitario){
        String sql = "UPDATE utilitario SET estoque = ? WHERE id_utilitario=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,utilitario.getEstoque());
            stmt.setInt(2,utilitario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateUtilitarioQuantComprada(Utilitario utilitario){
        String sql = "UPDATE utilitario SET quantComprada = ? WHERE id_utilitario=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,utilitario.getQuantComprada());
            stmt.setInt(2,utilitario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateUtilitarioPrecoVenda(Utilitario utilitario){
        String sql = "UPDATE utilitario SET precoVenda = ? WHERE id_utilitario=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1,utilitario.getPrecoVenda());
            stmt.setInt(2,utilitario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateUtilitarioNome(Utilitario utilitario){
        String sql = "UPDATE utilitario SET nome = ? WHERE id_utilitario=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,utilitario.getNome());
            stmt.setInt(2,utilitario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    public boolean deleteUtilitario(int id_utilitario){
        String sql = "DELETE FROM utilitario where id_utilitario = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,id_utilitario);
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
}