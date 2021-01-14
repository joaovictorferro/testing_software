package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.DAO.FanDAO;
import br.com.ufal.iSoccer.entidades.Fan;
import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.CompraIngressUtils;
import br.com.ufal.iSoccer.utils.DataUtils;
import org.junit.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class AdminCompraIngressoTest {
    private static FanDAO dao;

    @BeforeClass
    public static void setupClass(){
        dao = new FanDAO();
        Fan fan = new Fan(150.0,1,"12345678915");
        dao.creatFan(fan);
        Fan fan2 = new Fan(250.0,2,"12345678916");
        dao.creatFan(fan2);
        Fan fan3 = new Fan(350.0,3,"12345678917");
        dao.creatFan(fan3);
    }

    @AfterClass
    public static void tearDownClass(){
        dao = new FanDAO();
        dao.deleteFan("12345678915");
        dao.deleteFan("12345678916");
        dao.deleteFan("12345678917");
    }

    @Test
    public void t0001_DeveCompraIngresso() {
        //cenario
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("Joao", "12345678915", "12345679", "joao@gmail.com");
        List<Ingresso> ingressos = Arrays.asList(new Ingresso("12345678915", 3, 5.0));

        //acao
        try {
            CompraIngressUtils compraIngressUtils = adminCompraIngresso.CompraIngresso(person, ingressos);
            //verificacao
            Assert.assertEquals(5.0, compraIngressUtils.getValor(), 0.1);
            Assert.assertTrue(DataUtils.isMesmaData(compraIngressUtils.getDataCompra(), new Date()));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void t0002_NaoDeveCompraIngressoSemEstoque() {
        //cenario
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("Joao", "12345678915", "12345679", "joao@gmail.com");
        List<Ingresso> ingressos = Arrays.asList(new Ingresso("12345678915", 0, 5.0));

        try {
            CompraIngressUtils compraIngressUtils = adminCompraIngresso.CompraIngresso(person, ingressos);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), is("Ingresso sem estoque"));
        }

    }

    @Test
    public void t0003_NaoDeveCompraIngressoPessoaVazio() {
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        List<Ingresso> ingressos = Arrays.asList(new Ingresso("12345678915", 3, 5.0));

        try {
            CompraIngressUtils compraIngressUtils = adminCompraIngresso.CompraIngresso(null, ingressos);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(), is("Pessoa vazio"));
        }
    }

    @Test
    public void t0003_NaoDeveComprarIngressoVazio() {
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("Joao", "12345678915", "12345679", "joao@gmail.com");

        try {
            CompraIngressUtils compraIngressUtils = adminCompraIngresso.CompraIngresso(person, null);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(), is("Ingresso vazio"));
        }
    }
    
    @Test
    public void t0004_DevePagar75pctFanTipo1(){

    }
}