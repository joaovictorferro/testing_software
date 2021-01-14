package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.entidades.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    private Connection con = null;

    public PlayerDAO(){
        con = ConnectionFactory.getConnection();
    }

    public boolean creatPlayer(Player player){
        String sql = "INSERT INTO player (playerFunction,available,cpf) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,player.getPlayerFunction());
            stmt.setBoolean(2,player.isAvailable());
            stmt.setString(3,player.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<Player> findAll(){
        String sql = "select * from person p inner join player pl on p.cpf = pl.cpf;  ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Player> players = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Player player = new Player();
                player.setPlayerFunction(rs.getString("playerFunction"));
                player.setAvailable(rs.getBoolean("available"));
                player.setCpf(rs.getString("cpf"));
                players.add(player);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return players;
    }

    public List<Player> findPlayerCpf(String cpf){
        String sql = "select * from player WHERE cpf=?;  ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Player> players = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,cpf);
            rs = stmt.executeQuery();

            while(rs.next()){
                Player player = new Player();
                player.setPlayerFunction(rs.getString("playerFunction"));
                player.setAvailable(rs.getBoolean("available"));
                player.setCpf(rs.getString("cpf"));
                players.add(player);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return players;
    }

    public boolean UpdatePlayerFunction(Player player){
        String sql = "UPDATE player SET playerFunction = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,player.getPlayerFunction());
            stmt.setString(2,player.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdatePlayerAvailable(Player player){
        String sql = "UPDATE player SET available = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1,player.isAvailable());
            stmt.setString(2,player.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deletePlayer(Person person){
        String sql = "DELETE FROM player  where cpf = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,person.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deletePlayer(String cpf){
        String sql = "DELETE FROM player  where cpf = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,cpf);
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