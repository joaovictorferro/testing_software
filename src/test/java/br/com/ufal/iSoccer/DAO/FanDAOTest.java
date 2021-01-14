package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.entidades.Fan;
import br.com.ufal.iSoccer.entidades.Person;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FanDAOTest {
    private static PersonDAO dao;
    private static Person person;

    @BeforeClass
    public static void setupClass(){
        person = new Person("Joao","12345678914","123456789","joao@gmail.com",200.00,"fan");
        dao = new PersonDAO();
        dao.creatPersonDAO(person);
    }

    @AfterClass
    public static void tearDownClass(){
        dao = new PersonDAO();
        dao.deletePersonDAO("12345678914");
    }

    @Test
    public void t0001_DeveCreatFan(){
        Fan fan = new Fan(150.00,1,"12345678914");
        FanDAO dao = new FanDAO();

        Assert.assertTrue(dao.creatFan(fan));
    }

    @Test
    public void t0002_DeveFindAll(){
        FanDAO dao = new FanDAO();
        List<Fan> fans = new ArrayList<>();

        fans = dao.findAll();
        Assert.assertFalse(fans.isEmpty());
    }

    @Test
    public void t0003_DeveFinFanCpf(){
        FanDAO dao = new FanDAO();
        List<Fan> fans = new ArrayList<>();

        fans = dao.findFanCpf("12345678914");
        Assert.assertFalse(fans.isEmpty());
    }

    @Test
    public void t0004_DeveUpdateRateValue(){
        Fan fan = new Fan(140.00,1,"12345678914");
        FanDAO dao = new FanDAO();

        Assert.assertTrue(dao.updateFanRateValue(fan));
    }

    @Test
    public void t0005_DeveUpdateType(){
        Fan fan = new Fan(140.00,2,"12345678914");
        FanDAO dao = new FanDAO();

        assertTrue(dao.updateFanType(fan));
    }

    @Test
    public void t0006_DeveDeleteFan() {
        FanDAO dao = new FanDAO();

        Assert.assertTrue(dao.deleteFan("12345678914"));
    }
}