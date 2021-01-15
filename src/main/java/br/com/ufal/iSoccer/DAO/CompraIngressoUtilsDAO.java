package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.utils.CompraIngressUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraIngressoUtilsDAO {
    private Connection con = null;

    public CompraIngressoUtilsDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatCompraIngresso(CompraIngressUtils compraIngressUtils){
        String sql = "INSERT INTO compraIngresso (cpf,valor,quantComprada) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, compraIngressUtils.getCpf());
            stmt.setDouble(2, compraIngressUtils.getValor());
            stmt.setDouble(3,compraIngressUtils.getQuantComprada());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<CompraIngressUtils> findAll(){
        String sql = "select * from compraIngresso ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CompraIngressUtils> compraIngressos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                CompraIngressUtils compraIngressoUtils = new CompraIngressUtils();
                compraIngressoUtils.setCpf(rs.getString("cpf"));
                compraIngressoUtils.setQuantComprada(rs.getInt("quantComprada"));
                compraIngressoUtils.setValor(rs.getDouble("valor"));
                compraIngressos.add(compraIngressoUtils);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return compraIngressos;
    }

    public boolean UpdateCompraIngressoValor(CompraIngressUtils compraIngressUtils){
        String sql = "UPDATE compraIngresso SET valor = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, compraIngressUtils.getValor());
            stmt.setString(2,compraIngressUtils.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean UpdateIngressoQuantComprada(CompraIngressUtils compraIngressUtils){
        String sql = "UPDATE compraIngresso SET quantComprada = ? WHERE cpf=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,compraIngressUtils.getQuantComprada());
            stmt.setString(2,compraIngressUtils.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public boolean deleteCompraIngresso(String cpf){
        String sql = "DELETE FROM compraIngresso where cpf = ? ";
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