package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.DataUtils;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

public class AgendarVisitaTest {
    private DataUtils dataUtils;

    @Test
    public void DeveAgendarVisita(){
        Person person = new Person("joao","12345678914","123456789","joao@gmail.com",0.0,"Fan");
        AdminAgendarVisita adminAgendarVisita = new AdminAgendarVisita();

        try {
            dataUtils = adminAgendarVisita.Agendamento(person);
            Assert.assertTrue(DataUtils.isMesmaData(dataUtils.getAgendamento(), DataUtils.obterDataComDiferencaDias(1)));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void NaoDeveAgenderPersonNull(){
        AdminAgendarVisita adminAgendarVisita = new AdminAgendarVisita();

        try {
            dataUtils = adminAgendarVisita.Agendamento(null);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(),is("Pessoa vazio"));
        }
    }


    @Test
    public void NaoDeveAgendarNaQuarta() {
        Assume.assumeTrue(dataUtils.verificarDiaSemana(new Date(),Calendar.WEDNESDAY));
        Person person = new Person("joao","12345678914","123456789","joao@gmail.com",0.0,"Fan");
        AdminAgendarVisita adminAgendarVisita = new AdminAgendarVisita();

        try {
            dataUtils = adminAgendarVisita.Agendamento(person);

            boolean eQuinta = dataUtils.verificarDiaSemana(dataUtils.getAgendamento(), Calendar.THURSDAY);
            Assert.assertTrue(eQuinta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void NaoDeveAgendarNoDomingo() {
        Assume.assumeTrue(dataUtils.verificarDiaSemana(new Date(),Calendar.SUNDAY));
        Person person = new Person("joao","12345678914","123456789","joao@gmail.com",0.0,"Fan");
        AdminAgendarVisita adminAgendarVisita = new AdminAgendarVisita();

        try {
            dataUtils = adminAgendarVisita.Agendamento(person);

            boolean eSegunda = dataUtils.verificarDiaSemana(dataUtils.getAgendamento(), Calendar.SUNDAY);
            Assert.assertTrue(eSegunda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
