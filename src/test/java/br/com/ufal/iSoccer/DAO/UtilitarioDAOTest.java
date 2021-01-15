package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Utilitario;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UtilitarioDAOTest {
    @Test
    public void t0001_DeveCreatUtilitario(){
        UtilitarioDAO dao = new UtilitarioDAO();
        Utilitario utilitario = new Utilitario(1,10,50.00,10,"camisa");

        Assert.assertTrue(dao.creatUtilitario(utilitario));
    }

    @Test
    public void t0002_DeveFindAllUtilitario(){
        UtilitarioDAO dao = new UtilitarioDAO();
        List<Utilitario> utilitarios = new ArrayList<>();

        utilitarios = dao.findAll();
        Assert.assertFalse(utilitarios.isEmpty());
    }

    @Test
    public void t0003_DeveUpdateEstoqueUtilitario(){
        Utilitario utilitario = new Utilitario(1,20,50.00,10,"camisa");
        UtilitarioDAO dao = new UtilitarioDAO();

        Assert.assertTrue(dao.UpdateUtilitarioEstoque(utilitario));
    }

    @Test
    public void t0004_DeveUpdatePrecoVendaUtilitario(){
        Utilitario utilitario = new Utilitario(1,20,100.00,10,"camisa");
        UtilitarioDAO dao = new UtilitarioDAO();

        Assert.assertTrue(dao.UpdateUtilitarioPrecoVenda(utilitario));
    }

    @Test
    public void t0005_DeveUpdateQuantCompradaUtilitario(){
        Utilitario utilitario = new Utilitario(1,20,100.00,15,"camisa");
        UtilitarioDAO dao = new UtilitarioDAO();

        Assert.assertTrue(dao.UpdateUtilitarioQuantComprada(utilitario));
    }

    @Test
    public void t0006_DeveUpdateNomeUtilitario(){
        Utilitario utilitario = new Utilitario(1,20,100.00,15,"bermuda");
        UtilitarioDAO dao = new UtilitarioDAO();

        Assert.assertTrue(dao.UpdateUtilitarioNome(utilitario));
    }

    @Test
    public void t0007_DeveDeleteUtilitario(){
        UtilitarioDAO dao = new UtilitarioDAO();

        Assert.assertTrue(dao.deleteUtilitario(1));
    }
}