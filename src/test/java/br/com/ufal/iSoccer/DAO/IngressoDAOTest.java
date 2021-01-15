package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.physicalResources.Bus;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IngressoDAOTest {

    @Test
    public void t0001_DeveCreatIngresso(){
        IngressoDAO dao = new IngressoDAO();
        Ingresso ingresso = new Ingresso(1,10,50.00,10);

        Assert.assertTrue(dao.creatIngresso(ingresso));
    }

    @Test
    public void t0002_DeveFindAllIngresso(){
        IngressoDAO dao = new IngressoDAO();
        List<Ingresso> ingressos = new ArrayList<>();

        ingressos = dao.findAll();
        Assert.assertFalse(ingressos.isEmpty());
    }

    @Test
    public void t0003_DeveUpdateEstoqueIngresso(){
        Ingresso ingresso = new Ingresso(1,20,50.00,10);
        IngressoDAO dao = new IngressoDAO();

        Assert.assertTrue(dao.UpdateIngrssoEstoque(ingresso));
    }

    @Test
    public void t0004_DeveUpdatePrecoVendaIngresso(){
        Ingresso ingresso = new Ingresso(1,20,100.00,10);
        IngressoDAO dao = new IngressoDAO();

        Assert.assertTrue(dao.UpdateIngressoPrecoVenda(ingresso));
    }

    @Test
    public void t0005_DeveUpdateQuantCompradaIngresso(){
        Ingresso ingresso = new Ingresso(1,20,100.00,15);
        IngressoDAO dao = new IngressoDAO();

        Assert.assertTrue(dao.UpdateIngressoQuantComprada(ingresso));
    }

    @Test
    public void t0006_DeveDeleteIngresso(){
        IngressoDAO dao = new IngressoDAO();

        Assert.assertTrue(dao.deleteIngresso(1));
    }
}
