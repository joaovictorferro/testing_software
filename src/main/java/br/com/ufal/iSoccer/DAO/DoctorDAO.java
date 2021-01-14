package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.entidades.Doctor;
import br.com.ufal.iSoccer.entidades.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    private Connection con = null;

    public DoctorDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatDoctor(Doctor doctor){
        String sql = "INSERT INTO doctor (crm,cpf) VALUES (?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, doctor.getCrm());
            stmt.setString(2,doctor.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<Doctor> findAll(){
        String sql = "select * from person p inner join doctor d on p.cpf = d.cpf;  ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Doctor> doctors = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Doctor doctor = new Doctor();
                doctor.setCrm(rs.getString("crm"));
                doctor.setCpf(rs.getString("cpf"));
                doctors.add(doctor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return doctors;
    }
    public boolean UpdateDoctorCrm(Doctor doctor){
        String sql = "UPDATE doctor SET crm = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,doctor.getCrm());
            stmt.setString(2,doctor.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deleteDoctor(Person person){
        String sql = "DELETE FROM doctor  where cpf = ? ";
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

    public boolean deleteDoctor(String cpf){
        String sql = "DELETE FROM doctor  where cpf = ? ";
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
