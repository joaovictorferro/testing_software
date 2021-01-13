package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.persons.Driver;
import br.com.ufal.iSoccer.persons.Fan;
import br.com.ufal.iSoccer.persons.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FanDAO {
    private Connection con = null;

    public FanDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatFan(Fan fan){
        String sql = "INSERT INTO fan (typeFan,rateValue,cpf) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, fan.getTypeFan());
            stmt.setDouble(2,fan.getRateValue());
            stmt.setString(3,fan.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean findFan(String cpf){
        String sql = "SELECT * from fan WHERE cpf=?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Person> persons = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,cpf);
            rs = stmt.executeQuery();
            return true;
        } catch (SQLException throwables) {
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
    }

    public List<Fan> findAll(){
        String sql = "select * from person p inner join fan f on p.cpf = f.cpf;  ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fan> fans = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Fan fan = new Fan();
                fan.setTypeFan(rs.getInt("typeFan"));
                fan.setRateValue(rs.getDouble("rateValue"));
                fan.setCpf(rs.getString("cpf"));
                fans.add(fan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return fans;
    }
    public boolean updateFanType(Fan fan){
        String sql = "UPDATE fan SET typeFan = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,fan.getTypeFan());
            stmt.setString(2,fan.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean updateFanRateValue(Fan fan){
        String sql = "UPDATE fan SET rateValue = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1,fan.getRateValue());
            stmt.setString(2,fan.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deleteFan(String cpf){
        String sql = "DELETE FROM fan  where cpf = ? )";
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
