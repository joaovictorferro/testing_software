package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.entidades.Doctor;
import br.com.ufal.iSoccer.entidades.Person;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoctorDAOTest {

    private static Person person;
    private static PersonDAO dao;

    @BeforeClass
    public static void setupClass(){
        person = new Person("Joao","12345678912","123456789","joao@gmail.com",200.00,"medico");
        dao = new PersonDAO();
        dao.creatPersonDAO(person);
    }

    @AfterClass
    public static void tearDownClass(){
        dao = new PersonDAO();
        dao.deletePersonDAO("12345678912");
    }

    @Test
    public void t0001_DeveCreatDoctor(){
        Doctor doctor = new Doctor("12345679","12345678912");
        DoctorDAO dao = new DoctorDAO();

        Assert.assertTrue(dao.creatDoctor(doctor));
    }

    @Test
    public void t0002_DeveFindAll(){
        DoctorDAO dao = new DoctorDAO();
        List<Doctor> doctors = new ArrayList<>();

        doctors = dao.findAll();
        Assert.assertFalse(doctors.isEmpty());
    }

    @Test
    public void t0003_DeveUpdateCrm(){
        Doctor doctor = new Doctor("123456780","12345678912");
        DoctorDAO dao = new DoctorDAO();

        Assert.assertTrue(dao.UpdateDoctorCrm(doctor));
    }

    @Test
    public void t0004_DeveDeleteDoctor(){
        Doctor doctor = new Doctor();
        DoctorDAO dao = new DoctorDAO();

        Assert.assertTrue(dao.deleteDoctor(doctor));
    }

    @Test
    public void t0005_DeveDeleteDoctor(){
        DoctorDAO dao = new DoctorDAO();

        Assert.assertTrue(dao.deleteDoctor("12345678912"));
    }
}
