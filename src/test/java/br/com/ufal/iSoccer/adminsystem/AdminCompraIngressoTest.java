package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.DAO.FanDAO;
import br.com.ufal.iSoccer.DAO.PersonDAO;
import br.com.ufal.iSoccer.entidades.Fan;
import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.CompraIngressUtils;
import br.com.ufal.iSoccer.utils.DataUtils;
import org.junit.*;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminCompraIngressoTest {
    private static CompraIngressUtils compraIngressUtils;
    private static PersonDAO dao;
    private static FanDAO dao2;

    @BeforeClass
    public static void setup(){
        dao = new PersonDAO();
        dao2 = new FanDAO();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        dao.creatPersonDAO(person);
        Fan fan = new Fan(150.00,1,"12345678915");
        dao2.creatFan(fan);
    }
    @AfterClass
    public static void afeterWare(){
        FanDAO dao2 = new FanDAO();
        dao2.deleteFan("12345678915");
        PersonDAO dao = new PersonDAO();
        dao.deletePersonDAO("12345678915");
    }
    @Test
    public void t0001_DeveCompraIngresso() {
        //cenario
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("Joao", "12345678916", "12345679", "joao@gmail.com",0.0,"Fan");
        Ingresso ingresso = new Ingresso(1, 3, 5.00,1);

        //acao
        try {
            compraIngressUtils = adminCompraIngresso.CompraIngresso(person, ingresso);
            //verificacao
            Assert.assertEquals(5.00, compraIngressUtils.getValor(), 0.01);
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
        Person person = new Person("Joao", "12345678915", "12345679", "joao@gmail.com",0.0,"Fan");
        Ingresso ingresso = new Ingresso(1, 0, 5.00,1);

        try {
            compraIngressUtils = adminCompraIngresso.CompraIngresso(person, ingresso);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), is("Ingresso sem estoque"));
        }
    }

    @Test
    public void t0003_NaoDeveCompraIngressoPessoaVazio() {
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Ingresso ingresso = new Ingresso(1, 3, 5.00,1);

        try {
            compraIngressUtils = adminCompraIngresso.CompraIngresso(null, ingresso);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(), is("Pessoa vazio"));
        }
    }

    @Test
    public void t0003_NaoDeveComprarIngressoVazio() {
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("Joao", "12345678915", "12345679", "joao@gmail.com",0.0,"Fan");

        try {
            compraIngressUtils = adminCompraIngresso.CompraIngresso(person, null);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(), is("Ingresso vazio"));
        }
    }
    
    @Test
    public void t0004_DevePagar75pctFanTipo1(){
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Ingresso ingresso = new Ingresso(1,5,4.00,3);

        try {
             CompraIngressUtils resultado = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertEquals(resultado.getValor(),9.00,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0005_DevePagar50pctFanTipo2(){
        FanDAO dao = new FanDAO();
        Fan fan = new Fan(250.00,2,"12345678915");
        dao.updateFanType(fan);
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");

        Ingresso ingresso = new Ingresso(1,5,4.00,3);

        try {
            CompraIngressUtils resultado = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertEquals(resultado.getValor(),6.0,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0006_DevePagar25pctFanTipo3(){
        FanDAO dao = new FanDAO();
        Fan fan = new Fan(350.00,3,"12345678915");
        dao.updateFanType(fan);
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");

        Ingresso ingresso = new Ingresso(1,5,4.00,3);

        try {
            CompraIngressUtils resultado = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertEquals(resultado.getValor(),3.0,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0007_DevePagarNormal(){
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("joao","12345678918","123456789","joao@gmail.com",0.00,"fan");
        Ingresso ingresso = new Ingresso(1,5,4.00,3);

        try {
            CompraIngressUtils resultado = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertEquals(resultado.getValor(),12.0,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0008_DevePagarNormalUmGraca(){
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("joao","12345678919","123456789","joao@gmail.com",0.00,"fan");
        Ingresso ingresso = new Ingresso(1,5,4.00,4);

        try {
            CompraIngressUtils resultado = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertEquals(resultado.getValor(),12.0,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0009_DevePagarFanTipo1UmGraca(){
        FanDAO dao = new FanDAO();
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Fan fan = new Fan(150.00,1,"12345678915");
        dao.updateFanType(fan);
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Ingresso ingresso = new Ingresso(1,5,4.00,4);

        try {
            CompraIngressUtils resultado = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertEquals(resultado.getValor(),9.0,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0010_DevePagarFanTipo2UmGraca(){
        FanDAO dao = new FanDAO();
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Fan fan = new Fan(250.00,2,"12345678915");
        dao.updateFanType(fan);
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Ingresso ingresso = new Ingresso(1,5,4.00,4);

        try {
            CompraIngressUtils resultado = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertEquals(resultado.getValor(),6.0,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0011_DevePagarFanTipo3UmGraca(){
        FanDAO dao = new FanDAO();
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Fan fan = new Fan(350.00,3,"12345678915");
        dao.updateFanType(fan);
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Ingresso ingresso = new Ingresso(1,5,4.00,4);

        try {
            CompraIngressUtils resultado = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.assertEquals(resultado.getValor(),3.0,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0012_NaoDeveComprarMaisQueAQuantidade(){
        //cenario
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("Joao", "12345678915", "12345679", "joao@gmail.com",0.0,"Fan");
        Ingresso ingresso = new Ingresso(1, 4, 5.00,5);

        try {
            compraIngressUtils = adminCompraIngresso.CompraIngresso(person, ingresso);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), is("Quantidade excede o estoque"));
        }
    }
}