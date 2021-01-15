package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.adminsystem.AdminAgendarVisita;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.DataUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AgendamentoDAOTest {
    @Test
    public void t0001_DeveCreatAgendamento(){
        Person person = new Person("joao","12345678914","123456789","joao@gmail.com",0.0,"Visitante");
        AgendamentoDAO dao = new AgendamentoDAO();
        AdminAgendarVisita adminAgendarVisita = new AdminAgendarVisita();

        DataUtils agendar = null;
        try {
            agendar = adminAgendarVisita.Agendamento(person);
            Assert.assertTrue(dao.creatAgendamento(agendar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0002_DeveFindAllAgendamento(){
        AgendamentoDAO dao = new AgendamentoDAO();
        List<DataUtils> dataUtilss = new ArrayList<>();

        dataUtilss = dao.findAll();

        Assert.assertTrue(dataUtilss.isEmpty());
    }

    @Test
    public void t0003_DeveDeleteAgendaCpf(){
        AgendamentoDAO dao = new AgendamentoDAO();

        Assert.assertTrue(dao.deleteAgendamento("12345678915"));
    }
}
