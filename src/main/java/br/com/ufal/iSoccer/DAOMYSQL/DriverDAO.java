package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.persons.Doctor;
import br.com.ufal.iSoccer.persons.Driver;
import br.com.ufal.iSoccer.persons.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {
    private Connection con = null;

    public DriverDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatDriver(Driver driver){
        String sql = "INSERT INTO driver (enabling,cpf) VALUES (?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, driver.getEnabling());
            stmt.setString(2,driver.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<Driver> findAll(){
        String sql = "select * from person p inner join driver d on p.cpf = d.cpf;  ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Driver> drivers = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Driver driver = new Driver();
                driver.setEnabling(rs.getBoolean("enabling"));
                driver.setCpf(rs.getString("cpf"));
                drivers.add(driver);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return drivers;
    }

    public boolean UpdateDriverEnabling(Driver driver){
        String sql = "UPDATE driver SET enabling = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1,driver.getEnabling());
            stmt.setString(2,driver.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deleteDriver(Person person){
        String sql = "DELETE FROM driver  where cpf = ?";
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

    public boolean deleteDriver(String cpf){
        String sql = "DELETE FROM driver WHERE cpf = ? ";
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
