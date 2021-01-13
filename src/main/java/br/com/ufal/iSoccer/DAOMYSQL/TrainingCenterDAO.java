package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.physicalResources.TrainingCenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainingCenterDAO {
    private Connection con = null;

    public TrainingCenterDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatTrainigCenter(TrainingCenter trainingCenter){
        String sql = "INSERT INTO stadium (id_trainingCenter,available,exist,bedroomNumber) VALUES (?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, trainingCenter.getId_trainingCenter());
            stmt.setBoolean(2, trainingCenter.isAvailable());
            stmt.setBoolean(3, trainingCenter.isExist());
            stmt.setInt(4,trainingCenter.getBedroomsNumber());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<TrainingCenter> findAll(){
        String sql = "select * from trainingCenter ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TrainingCenter> trainingCenters = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                TrainingCenter trainingCenter = new TrainingCenter();
                trainingCenter.setAvailable(rs.getBoolean("available"));
                trainingCenter.setExist(rs.getBoolean("exist"));
                trainingCenter.setId_trainingCenter(rs.getInt("id_trainingCenter"));
                trainingCenter.setBedroomsNumber(rs.getInt("bedroomNumber"));
                trainingCenters.add(trainingCenter);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return trainingCenters;
    }
    public boolean UpdateTrainingCenterAvailable(TrainingCenter trainingCenter){
        String sql = "UPDATE trainingCenter SET available = ? WHERE id_trainingCenter=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1,trainingCenter.isAvailable());
            stmt.setInt(2,trainingCenter.getId_trainingCenter());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateTrainingCenterExist(TrainingCenter trainingCenter){
        String sql = "UPDATE trainingCenter SET exist = ? WHERE id_trainingCenter=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1,trainingCenter.isExist());
            stmt.setInt(2,trainingCenter.getId_trainingCenter());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateTrainingCenterBedroomNumber(TrainingCenter trainingCenter){
        String sql = "UPDATE trainingCenter SET bedroomNumber= ? WHERE id_trainingCenter=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,trainingCenter.getBedroomsNumber());
            stmt.setInt(2,trainingCenter.getId_trainingCenter());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deleteTrainingCenter(TrainingCenter trainingCenter){
        String sql = "DELETE FROM trainingCenter  where id_trainingCenter = ? )";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,trainingCenter.getId_trainingCenter());
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
