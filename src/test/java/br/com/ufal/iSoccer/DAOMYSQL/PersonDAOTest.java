package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.persons.Person;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonDAOTest {
    @Test
    public void t0001_CreatPerson(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        if(dao.creatPersonDAO(person)){
            System.out.println("Salvo com sucesso");
        }else {
            Assert.fail("Error ao salvar");
        }
    }

    @Test
    public void t0002_FindAll(){
        PersonDAO dao = new PersonDAO();
        List<Person> persons = new ArrayList<>();

         persons = dao.findAll();
         Assert.assertFalse(persons.isEmpty());
    }

    @Test
    public void t0003_FindPersonCpf(){
        PersonDAO dao = new PersonDAO();
        List<Person> persons = new ArrayList<>();

        persons = dao.findPerson("12345678910");

        Assert.assertFalse(persons.isEmpty());
    }

    @Test
    public void t0004_UpdatePersonNome(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        if(dao.updateNamePersonDAO(person)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0005_UpdatePersonTel(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        if(dao.updateTelPersonDAO(person)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0006_UpdatePersonEmail(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        if(dao.updateEmailPersonDAO(person)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0007_UpdatePersonTipo(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao = new PersonDAO();

        if(dao.updateTipoPersonDAO(person)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0008_UpdatePersonSalary(){
        Person person = new Person("Joao","12345678910","123456789","joao@gmail.com",200.00,"medico");

        PersonDAO dao = new PersonDAO();

        if(dao.updateSalaryPersonDAO("12345678910",2020.20)){
            System.out.println("Alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0009_DeletePerson(){
        Person person = new Person();
        PersonDAO dao = new PersonDAO();
        if(dao.deletePersonDAO(person)){
            System.out.println("Deletado com sucesso");
        }else {
            Assert.fail("Error ao salvar");
        }
    }

    @Test
    public void t0010_DeletePersonCpf(){
        PersonDAO dao = new PersonDAO();

        if(dao.deletePersonDAO("12345678910")){
            System.out.println("Deletado com sucesso");
        }else {
            Assert.fail("Error ao salvar");
        }
    }
}