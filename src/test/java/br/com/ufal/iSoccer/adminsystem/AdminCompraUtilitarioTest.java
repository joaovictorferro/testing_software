package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.DAO.FanDAO;
import br.com.ufal.iSoccer.DAO.PersonDAO;
import br.com.ufal.iSoccer.entidades.Fan;
import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.entidades.Utilitario;
import br.com.ufal.iSoccer.utils.CompraIngressUtils;
import br.com.ufal.iSoccer.utils.CompraUtilitariosUtils;
import br.com.ufal.iSoccer.utils.DataUtils;
import org.junit.*;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminCompraUtilitarioTest {
    private static CompraUtilitariosUtils compraUtilitariosUtils;
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
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        Person person = new Person("Joao", "12345678916", "12345679", "joao@gmail.com",0.0,"Fan");
        Utilitario utilitario = new Utilitario(1, 3, 5.00,1,"camisa");

        //acao
        try {
            compraUtilitariosUtils = adminCompraUtilitario.Comprautilirario(person, utilitario);
            //verificacao
            Assert.assertEquals(5.00, compraUtilitariosUtils.getValor(), 0.01);
            Assert.assertTrue(DataUtils.isMesmaData(compraUtilitariosUtils.getDataCompra(), new Date()));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void t0002_NaoDeveCompraIngressoSemEstoque() {
        //cenario
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        Person person = new Person("Joao", "12345678915", "12345679", "joao@gmail.com",0.0,"Fan");
        Utilitario utilitario = new Utilitario(1, 0, 5.00,1,"camisa");

        try {
            compraUtilitariosUtils = adminCompraUtilitario.Comprautilirario(person, utilitario);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), is("Utilitario sem estoque"));
        }
    }

    @Test
    public void t0003_NaoDeveCompraIngressoPessoaVazio() {
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        Utilitario utilitario = new Utilitario(1, 3, 5.00,1,"camisa");

        try {
            compraUtilitariosUtils = adminCompraUtilitario.Comprautilirario(null, utilitario);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(), is("Pessoa vazio"));
        }
    }

    @Test
    public void t0003_NaoDeveComprarUtilitarioVazio() {
        AdminCompraUtilitario adminCompraUtilatario = new AdminCompraUtilitario();
        Person person = new Person("Joao", "12345678915", "12345679", "joao@gmail.com",0.0,"Fan");

        try {
            compraUtilitariosUtils = adminCompraUtilatario.Comprautilirario(person, null);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(), is("Utilitario vazio"));
        }
    }

    @Test
    public void t0004_DevePagar75pctFanTipo1(){
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");
        Utilitario utilitario = new Utilitario(1,5,4.00,3,"camisa");

        try {
            CompraUtilitariosUtils resultado = adminCompraUtilitario.Comprautilirario(person,utilitario);
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
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");

        Utilitario utilitario = new Utilitario(1,5,4.00,3,"camisa");

        try {
            CompraUtilitariosUtils resultado = adminCompraUtilitario.Comprautilirario(person,utilitario);
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
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        Person person = new Person("joao","12345678915","123456789","joao@gmail.com",0.00,"fan");

        Utilitario utilitario = new Utilitario(1,5,4.00,3,"camisa");

        try {
            CompraUtilitariosUtils resultado = adminCompraUtilitario.Comprautilirario(person,utilitario);
            Assert.assertEquals(resultado.getValor(),3.0,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0007_DevePagarNormal(){
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        Person person = new Person("joao","12345678918","123456789","joao@gmail.com",0.00,"fan");
        Utilitario utilitario = new Utilitario(1,5,4.00,3,"camisa");

        try {
            CompraUtilitariosUtils resultado = adminCompraUtilitario.Comprautilirario(person,utilitario);
            Assert.assertEquals(resultado.getValor(),12.0,0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t008_NaoDeveComprarMaisQueAQuantidade(){
        //cenario
        AdminCompraUtilitario adminCompraUtilitario = new AdminCompraUtilitario();
        Person person = new Person("Joao", "12345678915", "12345679", "joao@gmail.com",0.0,"Fan");
        Utilitario utilitario = new Utilitario(1, 4, 5.00,5,"camisa");

        try {
            compraUtilitariosUtils = adminCompraUtilitario.Comprautilirario(person, utilitario);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), is("Quantidade excede o estoque"));
        }
    }
}