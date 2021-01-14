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
    @BeforeClass
    public static void setupClass(){
        person = new Person("Joao","12345678913","123456789","joao@gmail.com",200.00,"fan");
        PersonDAO dao2 = new PersonDAO();
        dao2.creatPersonDAO(person);
    }

    @AfterClass
    public static void tearDownClass(){
        PersonDAO dao2 = new PersonDAO();
        dao2.deletePersonDAO("12345678913");
    }

    @Test
    public void t0001_CreateDriver(){
        DriverDAO dao = new DriverDAO();
        Driver driver = new Driver(true,"12345678913");

        if(dao.creatDriver(driver)){
            System.out.println("Salvo com sucesso");
        }else {
            Assert.fail("Error ao salvar");
        }
    }
    @Test
    public void t0002_FindAll(){
        DriverDAO dao = new DriverDAO();
        List<Driver> drivers = new ArrayList<>();

        drivers = dao.findAll();
        Assert.assertFalse(drivers.isEmpty());
    }

    @Test
    public void t0003_UpdateDriverEnabling(){
        DriverDAO dao = new DriverDAO();
        Driver driver = new Driver(false,"12345678913");
        if(dao.UpdateDriverEnabling(driver)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0004_DeleteDriverCpf() {
        DriverDAO dao = new DriverDAO();

        if (dao.deleteDriver("12345678913")) {
            System.out.println("Deletado com sucesso");
        } else {
            Assert.fail("Error ao Deletar");
        }
    }

    @Test
    public void t0005_DeleteClasse() {
        Driver driver = new Driver();
        DriverDAO dao = new DriverDAO();

        if (dao.deleteDriver(driver)) {
            System.out.println("Deletado com sucesso");
        } else {
            Assert.fail("Error ao Deletar");
        }
    }
}
