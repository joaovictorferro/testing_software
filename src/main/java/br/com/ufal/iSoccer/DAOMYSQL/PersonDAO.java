package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;

import java.sql.PreparedStatement;
import br.com.ufal.iSoccer.persons.Person;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private Connection con = null;

    public PersonDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatPersonDAO(Person person){
        String sql = "INSERT INTO person (nome,cpf,tel,email,tipo,salary) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,person.getName());
            stmt.setString(2,person.getCpf());
            stmt.setString(3,person.getTel());
            stmt.setString(4,person.getEmail());
            stmt.setString(5,person.getType());
            stmt.setDouble(6,person.getSalary());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<Person> findPerson(String cpf){
        String sql = "SELECT * from person WHERE cpf=?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Person> persons = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,cpf);
            rs = stmt.executeQuery();

            if(rs!= null){
                while(rs.next()) {
                    Person person = new Person();
                    person.setName(rs.getString("nome"));
                    person.setCpf(rs.getString("cpf"));
                    person.setTel(rs.getString("tel"));
                    person.setEmail(rs.getString("email"));
                    person.setType(rs.getString("tipo"));
                    person.setSalary(rs.getDouble("salary"));
                    persons.add(person);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return persons;
    }

    public List<Person> findAll(){
        String sql = "SELECT * from person";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Person> persons = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Person person = new Person();
                person.setName(rs.getString("nome"));
                person.setCpf(rs.getString("cpf"));
                person.setTel(rs.getString("tel"));
                person.setEmail(rs.getString("email"));
                person.setType(rs.getString("tipo"));
                person.setSalary(rs.getDouble("salary"));
                persons.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }

        return persons;
    }

    public boolean updateNamePersonDAO(Person person){
        String sql = "UPDATE person SET nome = ? WHERE cpf = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,person.getName());
            stmt.setString(2,person.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean updateTelPersonDAO(Person person){
        String sql = "UPDATE person SET tel = ? where cpf = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,person.getTel());
            stmt.setString(2,person.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean updateEmailPersonDAO(Person person){
        String sql = "UPDATE person SET email = ? where cpf = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,person.getEmail());
            stmt.setString(2,person.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean updateTipoPersonDAO(Person person){
        String sql = "UPDATE person SET tipo = ? where cpf = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,person.getType());
            stmt.setString(2,person.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean updateSalaryPersonDAO(String cpf,Double newSalary){
        String sql = "UPDATE person SET salary = ? where cpf = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1,newSalary);
            stmt.setString(2,cpf);
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    public boolean deletePersonDAO(Person person){
        String sql = "DELETE FROM person  where cpf = ?";
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

    public boolean deletePersonDAO(String cpf){
        String sql = "DELETE FROM person  WHERE cpf = ?";
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