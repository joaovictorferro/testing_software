package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.utils.DataUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {
    private Connection con = null;

    public AgendamentoDAO(){ con = ConnectionFactory.getConnection(); }

    public boolean creatAgendamento(DataUtils dataUtils){
        String sql = "INSERT INTO agendarVisita (cpf,dia_visita) VALUES (?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, dataUtils.getCpf());
            stmt.setDate(2, (Date) dataUtils.getAgendamento());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

    public List<DataUtils> findAll(){
        String sql = "select * from agendarVisita ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<DataUtils> dataUtilss = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                DataUtils dataUtils = new DataUtils();
                dataUtils.setCpf(rs.getString("cpf"));
                dataUtils.setAgendamento(rs.getDate("dia_visita"));
                dataUtilss.add((DataUtils) dataUtilss);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return dataUtilss;
    }

    public boolean deleteAgendamento(String cpf){
        String sql = "DELETE FROM agendarVisita  where cpf = ? ";
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
