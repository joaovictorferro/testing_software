package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.entidades.Ingresso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngressoDAO {
    private Connection con = null;

    public IngressoDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatIngresso(Ingresso ingresso){
            String sql = "INSERT INTO ingresso (id_ingresso,estoque,precoVenda,quantComprada) VALUES (?,?,?,?)";
            PreparedStatement stmt = null;

            try {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, ingresso.getId());
                stmt.setInt(2, ingresso.getEstoque());
                stmt.setDouble(3,ingresso.getPrecoVenda());
                stmt.setInt(4,ingresso.getQuantComprada());
                stmt.executeUpdate();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }finally {
                ConnectionFactory.closeConnection(con,stmt);
            }
    }

    public List<Ingresso> findAll(){
            String sql = "select * from ingresso ";

            PreparedStatement stmt = null;
            ResultSet rs = null;

            List<Ingresso> ingressos = new ArrayList<>();

            try {
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();

                while(rs.next()){
                    Ingresso ingresso = new Ingresso();
                    ingresso.setId(rs.getInt("id_ingresso"));
                    ingresso.setPrecoVenda(rs.getDouble("precoVenda"));
                    ingresso.setEstoque(rs.getInt("estoque"));
                    ingresso.setQuantComprada(rs.getInt("quantComprada"));
                    ingressos.add(ingresso);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                ConnectionFactory.closeConnection(con,stmt,rs);
            }
            return ingressos;
    }

    public boolean UpdateIngrssoEstoque(Ingresso ingresso){
            String sql = "UPDATE ingresso SET estoque = ? WHERE id_ingresso=?";
            PreparedStatement stmt = null;

            try {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,ingresso.getEstoque());
                stmt.setInt(2,ingresso.getId());
                stmt.executeUpdate();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }finally {
                ConnectionFactory.closeConnection(con,stmt);
            }
        }

        public boolean UpdateIngressoQuantComprada(Ingresso ingresso){
            String sql = "UPDATE ingresso SET quantComprada = ? WHERE id_ingresso=?";
            PreparedStatement stmt = null;

            try {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,ingresso.getQuantComprada());
                stmt.setInt(2,ingresso.getId());
                stmt.executeUpdate();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }finally {
                ConnectionFactory.closeConnection(con,stmt);
            }
        }
    public boolean UpdateIngressoPrecoVenda(Ingresso ingresso){
        String sql = "UPDATE ingresso SET precoVenda = ? WHERE id_ingresso=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1,ingresso.getPrecoVenda());
            stmt.setInt(2,ingresso.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
        public boolean deleteIngresso(int id_ingresso){
            String sql = "DELETE FROM ingresso where id_ingresso = ? ";
            PreparedStatement stmt = null;

            try {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,id_ingresso);
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