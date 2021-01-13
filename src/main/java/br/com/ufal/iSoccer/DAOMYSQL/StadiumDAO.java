package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.physicalResources.Bus;
import br.com.ufal.iSoccer.physicalResources.Stadium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StadiumDAO {
    private Connection con = null;

    public StadiumDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatStadium(Stadium stadium){
        String sql = "INSERT INTO stadium (id_stadium,available,exist,chairsNumber,bathroomNumber,snackBarNumber) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, stadium.getId_stadium());
            stmt.setBoolean(2, stadium.isAvailable());
            stmt.setBoolean(3, stadium.isExist());
            stmt.setInt(4,stadium.getChairsNumber());
            stmt.setInt(5,stadium.getBathroomNumber());
            stmt.setInt(6,stadium.getSnackBarNumber());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<Stadium> findAll(){
        String sql = "select * from stadium ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Stadium> stadiums = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Stadium stadium= new Stadium();
                stadium.setAvailable(rs.getBoolean("available"));
                stadium.setExist(rs.getBoolean("exist"));
                stadium.setId_stadium(rs.getInt("id_stadium"));
                stadium.setChairsNumber(rs.getInt("chairsNumber"));
                stadium.setBathroomNumber(rs.getInt("bathroomNumber"));
                stadium.setSnackBarNumber(rs.getInt("snackBarNumber"));
                stadiums.add(stadium);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return stadiums;
    }
    public boolean UpdateStadiumAvailable(Stadium stadium){
        String sql = "UPDATE stadium SET available = ? WHERE id_stadium=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1,stadium.isAvailable());
            stmt.setInt(2,stadium.getId_stadium());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateStadiumExist(Stadium stadium){
        String sql = "UPDATE stadium SET exist = ? WHERE id_stadium=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1,stadium.isExist());
            stmt.setInt(2,stadium.getId_stadium());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateStadiumChairs(Stadium stadium){
        String sql = "UPDATE stadium SET chairsNumber = ? WHERE id_stadium=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,stadium.getChairsNumber());
            stmt.setInt(2,stadium.getId_stadium());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateStadiumBathroom(Stadium stadium){
        String sql = "UPDATE stadium SET bathroomNumer = ? WHERE id_stadium=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,stadium.getBathroomNumber());
            stmt.setInt(2,stadium.getId_stadium());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateStadiumSnack(Stadium stadium){
        String sql = "UPDATE stadium SET snackBarNumber = ? WHERE id_stadium=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,stadium.getSnackBarNumber());
            stmt.setInt(2,stadium.getId_stadium());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deleteStadium(Stadium stadium){
        String sql = "DELETE FROM stadium  where id_stadium = ? )";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,stadium.getId_stadium());
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
