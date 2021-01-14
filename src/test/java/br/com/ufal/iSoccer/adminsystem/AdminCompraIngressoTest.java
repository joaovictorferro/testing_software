package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.CompraIngressUtils;
import br.com.ufal.iSoccer.utils.DataUtils;
import org.junit.*;
import org.junit.Test;

import java.util.Date;

public class AdminCompraIngressoTest {
    @Test
    public void t0001_CompraIngresso(){
        //cenario
         AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("Joao","12345678915","12345679","joao@gmail.com");
        Ingresso ingresso = new Ingresso("12345678915",3,5.0);

        //acao
        try {
            CompraIngressUtils compraIngressUtils = adminCompraIngresso.CompraIngresso(person,ingresso);
            //verificacao
            Assert.assertEquals(5.0,compraIngressUtils.getValor(),0.1);
            Assert.assertTrue(DataUtils.isMesmaData(compraIngressUtils.getDataCompra(),new Date()));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Nao deveria lancar excecao")
        }
    }
    @Test
    public void t0002_CompraIngressoSemEstoque(){
        //cenario
        AdminCompraIngresso adminCompraIngresso = new AdminCompraIngresso();
        Person person = new Person("Joao","12345678915","12345679","joao@gmail.com");
        Ingresso ingresso = new Ingresso("12345678915",3,5.0);

        //acao
        try {
            CompraIngressUtils compraIngressUtils = adminCompraIngresso.CompraIngresso(person,ingresso);
            Assert.fail("Não deveria estar passando");
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(),"Ingresso sem estoque");
        }


    }
}
