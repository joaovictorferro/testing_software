package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.entidades.Person;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonDAOTest {

    @Test
    public void t0001_DeveCreatPerson(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        Assert.assertTrue(dao.creatPersonDAO(person));
    }

    @Test
    public void t0002_DeveFindAll(){
        PersonDAO dao = new PersonDAO();
        List<Person> persons = new ArrayList<>();

         persons = dao.findAll();
         Assert.assertFalse(persons.isEmpty());
    }

    @Test
    public void t0003_DeveFindPersonCpf(){
        PersonDAO dao = new PersonDAO();
        List<Person> persons = new ArrayList<>();

        persons = dao.findPerson("12345678910");

        Assert.assertFalse(persons.isEmpty());
    }

    @Test
    public void t0004_DeveUpdatePersonNome(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        Assert.assertTrue(dao.updateNamePersonDAO(person));
    }

    @Test
    public void t0005_DeveUpdatePersonTel(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        Assert.assertTrue(dao.updateTelPersonDAO(person));
    }

    @Test
    public void t0006_DeveUpdatePersonEmail(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        Assert.assertTrue(dao.updateEmailPersonDAO(person));
    }

    @Test
    public void t0007_DeveUpdatePersonTipo(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        Assert.assertTrue(dao.updateTipoPersonDAO(person));
    }

    @Test
    public void t0008_DeveUpdatePersonSalary(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        Assert.assertTrue(dao.updateSalaryPersonDAO("12345678910",2020.20));
    }

    @Test
    public void t0009_DeletePerson(){
        Person person = new Person();
        PersonDAO dao = new PersonDAO();

        Assert.assertTrue(dao.deletePersonDAO(person));
    }

    @Test
    public void t0010_DeletePersonCpf(){
        PersonDAO dao = new PersonDAO();

        Assert.assertTrue(dao.deletePersonDAO("12345678910"));
    }
}