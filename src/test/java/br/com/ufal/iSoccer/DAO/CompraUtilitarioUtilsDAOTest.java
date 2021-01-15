package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.adminsystem.AdminCompraUtilitario;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.entidades.Utilitario;
import br.com.ufal.iSoccer.utils.CompraUtilitarioUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompraUtilitarioUtilsDAOTest {

    @Test
    public void t0001_DeveCreatCompraUtilitario(){
        CompraUtilitarioUtilsDAO dao = new CompraUtilitarioUtilsDAO();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Utilitario utilitario = new Utilitario(1,10,50.00,10,"camisa");
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        CompraUtilitarioUtils compraUtilitarioUtils = new CompraUtilitarioUtils();

        try {
            compraUtilitarioUtils = adminCompraUtilitario.Comprautilirario(person,utilitario);
            Assert.assertTrue(dao.creatCompraUtilitario(compraUtilitarioUtils));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0002_DeveFindAllCompraUtilitario(){
        CompraUtilitarioUtilsDAO dao = new CompraUtilitarioUtilsDAO();
        List<CompraUtilitarioUtils> compraUtilitarioUtils = new ArrayList<>();

        compraUtilitarioUtils = dao.findAll();
        Assert.assertFalse(compraUtilitarioUtils.isEmpty());
    }

    @Test
    public void t0003_DeveUpdateValorCompraUtilitario(){
        CompraUtilitarioUtilsDAO dao = new CompraUtilitarioUtilsDAO();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Utilitario utilitario = new Utilitario(1,10,40.00,10,"camisa");
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        CompraUtilitarioUtils compraUtilitarioUtils = new CompraUtilitarioUtils();

        try {
            compraUtilitarioUtils = adminCompraUtilitario.Comprautilirario(person,utilitario);
            Assert.assertTrue(dao.UpdateCompraUtilitarioValor(compraUtilitarioUtils));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0004_DeveUpdateQuantCompradaUtilitario(){
        CompraUtilitarioUtilsDAO dao = new CompraUtilitarioUtilsDAO();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Utilitario utilitario = new Utilitario(1,10,40.00,5,"camisa");
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        CompraUtilitarioUtils compraUtilitarioUtils = new CompraUtilitarioUtils();

        try {
            compraUtilitarioUtils = adminCompraUtilitario.Comprautilirario(person,utilitario);
            Assert.assertTrue(dao.UpdateCompraUtilitarioQuantComprada(compraUtilitarioUtils));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0005_DeveDeleteCompraUtilitario(){
        CompraUtilitarioUtilsDAO dao = new CompraUtilitarioUtilsDAO();

        Assert.assertTrue(dao.deleteCompraUtilitario("12345678915"));
    }
}