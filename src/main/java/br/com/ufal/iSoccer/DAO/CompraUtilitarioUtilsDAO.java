package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.utils.CompraUtilitarioUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraUtilitarioUtilsDAO {
    private Connection con = null;

    public CompraUtilitarioUtilsDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatCompraUtilitario(CompraUtilitarioUtils compraUtilitarioUtils){
        String sql = "INSERT INTO compraUtilitario (cpf,valor,quantComprada) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, compraUtilitarioUtils.getCpf());
            stmt.setDouble(2, compraUtilitarioUtils.getValor());
            stmt.setDouble(3,compraUtilitarioUtils.getQuantComprada());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<CompraUtilitarioUtils> findAll(){
        String sql = "select * from compraUtilitario ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CompraUtilitarioUtils> compraUtilitarioUtilss = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                CompraUtilitarioUtils compraUtilitarioUtils = new CompraUtilitarioUtils();
                compraUtilitarioUtils.setCpf(rs.getString("cpf"));
                compraUtilitarioUtils.setQuantComprada(rs.getInt("quantComprada"));
                compraUtilitarioUtils.setValor(rs.getDouble("valor"));
                compraUtilitarioUtilss.add(compraUtilitarioUtils);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return compraUtilitarioUtilss;
    }

    public boolean UpdateCompraUtilitarioValor(CompraUtilitarioUtils compraUtilitarioUtils){
        String sql = "UPDATE compraUtilitario SET valor = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, compraUtilitarioUtils.getValor());
            stmt.setString(2,compraUtilitarioUtils.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateCompraUtilitarioQuantComprada(CompraUtilitarioUtils compraUtilitarioUtils){
        String sql = "UPDATE compraUtilitario SET quantComprada = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,compraUtilitarioUtils.getQuantComprada());
            stmt.setString(2,compraUtilitarioUtils.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deleteCompraUtilitario(String cpf){
        String sql = "DELETE FROM compraUtilitario where cpf = ? ";
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