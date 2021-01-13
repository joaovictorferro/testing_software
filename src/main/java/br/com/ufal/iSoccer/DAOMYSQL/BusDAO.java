package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.persons.Doctor;
import br.com.ufal.iSoccer.physicalResources.Bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {

    private Connection con = null;

    public BusDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatBus(Bus bus){
        String sql = "INSERT INTO bus (available,exist,id_bus) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, bus.isAvailable());
            stmt.setBoolean(2, bus.isExist());
            stmt.setInt(3,bus.getId_bus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<Bus> findAll(){
        String sql = "select * from bus ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Bus> buss = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Bus bus = new Bus();
                bus.setAvailable(rs.getBoolean("available"));
                bus.setExist(rs.getBoolean("exist"));
                bus.setId_bus(rs.getInt("id_bus"));
                buss.add(bus);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return buss;
    }
    public boolean UpdateBusAvailable(Bus bus){
        String sql = "UPDATE bus SET available = ? WHERE id_bus=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1,bus.isAvailable());
            stmt.setInt(2,bus.getId_bus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateBusExist(Bus bus){
        String sql = "UPDATE bus SET exist = ? WHERE id_bus=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1,bus.isExist());
            stmt.setInt(2,bus.getId_bus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deleteBus(int id_bus){
        String sql = "DELETE FROM bus  where id_bus = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,id_bus);
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
