package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.persons.Driver;
import br.com.ufal.iSoccer.persons.Person;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverDAOTest {
    @Test
    public void t0001_CreateDriver(){
        Person person = new Person("Joao","12345678913","123456789","joao@gmail.com",200.00,"motorista");
        PersonDAO dao2 = new PersonDAO();
        dao2.creatPersonDAO(person);
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
    public void t0004_DeleteDriverString() {
        DriverDAO dao = new DriverDAO();
        PersonDAO dao2 = new PersonDAO();

        if (dao.deleteDriver("12345678913")) {
            System.out.println("Deletado com sucesso");
        } else {
            Assert.fail("Error ao Deletar");
        }

        dao2.deletePersonDAO("12345678913");
    }

    @Test
    public void t0005_DeleteDriverCpf() {
        Driver driver = new Driver();
        DriverDAO dao = new DriverDAO();

        if (dao.deleteDriver(driver)) {
            System.out.println("Deletado com sucesso");
        } else {
            Assert.fail("Error ao Deletar");
        }
    }
}
