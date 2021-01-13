package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.persons.Doctor;
import br.com.ufal.iSoccer.persons.Person;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoctorDAOTest {
    @Test
    public void t0001_CreatDoctor(){
        Person person = new Person("Joao","12345678912","123456789","joao@gmail.com",200.00,"medico");
        PersonDAO dao2 = new PersonDAO();
        dao2.creatPersonDAO(person);
        Doctor doctor = new Doctor("12345679","12345678912");
        DoctorDAO dao = new DoctorDAO();

        if(dao.creatDoctor(doctor)){
            System.out.println("Salvo com sucesso");
        }else{
            fail("Erro ao salvar");
        }
    }

    @Test
    public void t0002_FindAll(){
        DoctorDAO dao = new DoctorDAO();
        List<Doctor> doctors = new ArrayList<>();

        doctors = dao.findAll();
        Assert.assertFalse(doctors.isEmpty());
    }

    @Test
    public void t0003_UpdateCrm(){
        Doctor doctor = new Doctor("123456780","12345678912");
        DoctorDAO dao = new DoctorDAO();
        if(dao.UpdateDoctorCrm(doctor)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0004_DeleteDoctor(){
        Doctor doctor = new Doctor();
        DoctorDAO dao = new DoctorDAO();
        if(dao.deleteDoctor(doctor)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0005_DeleteDoctor(){
        DoctorDAO dao = new DoctorDAO();
        PersonDAO dao2 = new PersonDAO();

        if(dao.deleteDoctor("12345678912")){
            System.out.println("Deletado com sucesso");
        }else {
            Assert.fail("Error ao deletar");
        }

        dao2.deletePersonDAO("12345678912");
    }
}
