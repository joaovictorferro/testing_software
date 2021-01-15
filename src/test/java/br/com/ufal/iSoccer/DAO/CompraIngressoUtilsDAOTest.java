package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.adminsystem.AdminCompraIngresso;
import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.CompraIngressUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompraIngressoUtilsDAOTest {

    @Test
    public void t0001_DeveCreatCompraIngresso(){
        CompraIngressoUtilsDAO dao = new CompraIngressoUtilsDAO();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Ingresso ingresso = new Ingresso(1,10,50.00,10);
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();

        try {
            compraIngressUtils = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertTrue(dao.creatCompraIngresso(compraIngressUtils));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0002_DeveFindAllCompraIngresso(){
        CompraIngressoUtilsDAO dao = new CompraIngressoUtilsDAO();
        List<CompraIngressUtils> compraIngressUtils = new ArrayList<>();

        compraIngressUtils = dao.findAll();
        Assert.assertFalse(compraIngressUtils.isEmpty());
    }

    @Test
    public void t0003_DeveUpdatePrecoVendaCompraIngresso(){
        CompraIngressoUtilsDAO dao = new CompraIngressoUtilsDAO();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Ingresso ingresso = new Ingresso(1,10,40.00,10);
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();

        try {
            compraIngressUtils = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertTrue(dao.UpdateCompraIngressoValor(compraIngressUtils));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0004_DeveUpdateQuantCompradaUtilitario(){
        CompraIngressoUtilsDAO dao = new CompraIngressoUtilsDAO();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Ingresso ingresso = new Ingresso(1,10,50.00,5);
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();

        try {
            compraIngressUtils = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertTrue(dao.UpdateCompraIngressoQuantComprada(compraIngressUtils));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0005_DeveDeleteCompraIngresso(){
        CompraIngressoUtilsDAO dao = new CompraIngressoUtilsDAO();

        Assert.assertTrue(dao.deleteCompraIngresso("12345678915"));
    }
}
