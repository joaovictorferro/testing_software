package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.entidades.Fan;
import br.com.ufal.iSoccer.entidades.Person;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FanDAOTest {

    private static Person person;

    @BeforeClass
    public static void setupClass(){
        person = new Person("Joao","12345678914","123456789","joao@gmail.com",200.00,"fan");
        PersonDAO dao2 = new PersonDAO();
        dao2.creatPersonDAO(person);
    }

    @AfterClass
    public static void tearDownClass(){
        PersonDAO dao2 = new PersonDAO();
        dao2.deletePersonDAO("12345678914");
    }

    @Test
    public void t0001_CreatFan(){
        Fan fan = new Fan(150.00,1,"12345678914");
        FanDAO dao = new FanDAO();

        if(dao.creatFan(fan)){
            System.out.println("Salvo com sucesso");
        }else{
            fail("Erro ao salvar");
        }
    }

    @Test
    public void t0002_FindAll(){
        FanDAO dao = new FanDAO();
        List<Fan> fans = new ArrayList<>();

        fans = dao.findAll();
        Assert.assertFalse(fans.isEmpty());
    }

    @Test
    public void t0003_FinFanCpf(){
        FanDAO dao = new FanDAO();
        List<Fan> fans = new ArrayList<>();

        fans = dao.findFanCpf("12345678914");
        Assert.assertFalse(fans.isEmpty());
    }

    @Test
    public void t0004_UpdateRateValue(){
        Fan fan = new Fan(140.00,1,"12345678914");

        FanDAO dao = new FanDAO();
        if(dao.updateFanRateValue(fan)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0005_UpdateType(){
        Fan fan = new Fan(140.00,2,"12345678914");

        FanDAO dao = new FanDAO();
        if(dao.updateFanType(fan)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0006_DeleteFan(){
        PersonDAO dao2 = new PersonDAO();
        FanDAO dao = new FanDAO();
        if(dao.deleteFan("12345678914")){
            System.out.println("Deletado com sucesso");
        }else {
            Assert.fail("Erro ao deletar");
        }
        dao2.deletePersonDAO("12345678914");
    }
}