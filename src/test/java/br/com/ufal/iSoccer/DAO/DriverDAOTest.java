package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.entidades.Driver;
import br.com.ufal.iSoccer.entidades.Person;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverDAOTest {
    private static Person person;
    private static PersonDAO dao;

    @BeforeClass
    public static void setupClass(){
        person = new Person("Joao","12345678913","123456789","joao@gmail.com",200.00,"motorista");
        dao = new PersonDAO();
        dao.creatPersonDAO(person);
    }

    @AfterClass
    public static void tearDownClass(){
        dao = new PersonDAO();
        dao.deletePersonDAO("12345678913");
    }

    @Test
    public void t0001_DeveCreateDriver(){
        DriverDAO dao = new DriverDAO();
        Driver driver = new Driver(true,"12345678913");

        Assert.assertTrue(dao.creatDriver(driver));
    }
    @Test
    public void t0002_DeveFindAll(){
        DriverDAO dao = new DriverDAO();
        List<Driver> drivers = new ArrayList<>();

        drivers = dao.findAll();
        Assert.assertFalse(drivers.isEmpty());
    }

    @Test
    public void t0003_DeveUpdateDriverEnabling(){
        DriverDAO dao = new DriverDAO();
        Driver driver = new Driver(false,"12345678913");

        Assert.assertTrue(dao.UpdateDriverEnabling(driver));
    }

    @Test
    public void t0004_DeveDeleteDriverCpf() {
        DriverDAO dao = new DriverDAO();

        Assert.assertTrue(dao.deleteDriver("12345678913"));
    }

    @Test
    public void t0005_DeveDeleteClasse() {
        Driver driver = new Driver();
        DriverDAO dao = new DriverDAO();

        Assert.assertTrue(dao.deleteDriver(driver));
    }
}