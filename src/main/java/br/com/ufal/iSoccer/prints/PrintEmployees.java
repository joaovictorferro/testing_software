package br.com.ufal.iSoccer.prints;

import br.com.ufal.iSoccer.DAOMYSQL.PersonDAO;
import br.com.ufal.iSoccer.persons.*;

import java.util.ArrayList;

public class PrintEmployees {
    PersonDAO dao = new PersonDAO();

    public PrintEmployees() {}

    public void printEmployeeDetails(Person person){
        System.out.println("------------------");
        System.out.println("Nome: " + person.getName());
        System.out.println("Tel: " + person.getTel());
        System.out.println("E-mail: " + person.getEmail());
        System.out.println("Fun��o: " + person.getType());
    }

    public void printDoctorDetails(Doctor doctor){
        printEmployeeDetails(doctor);
        System.out.println("CRM :" + doctor.getCrm());
        System.out.println("------------------");
    }

    public void printDriverDetails(Driver driver){
        printEmployeeDetails(driver);
        System.out.println("CNH: " + driver.getEnabling());
        System.out.println("------------------");
    }

    public void printPlayerDetails(Player player){
        printEmployeeDetails(player);
        System.out.println("Funcao do jogador: " + player.getPlayerFunction());
        System.out.printf("Apto: ");
        if(player.isAvailable())
            System.out.println("Apto para jogar");
        else
            System.out.println("Inapto");
        System.out.println("------------------");
    }

    public void printAllEmployees(){
        ArrayList<Person> datas = new ArrayList<>();
        datas = (ArrayList<Person>) dao.findAll();
        for(Person person : datas){
            printEmployeeDetails(person);
            System.out.println("------------------");
        }
    }

    public void printJustEmployeeNameAndType(){
        ArrayList<Person> datas = new ArrayList<>();
        datas = (ArrayList<Person>) dao.findAll();
        for(Person person : datas){
            System.out.println("Name: " + person.getName());
            System.out.println("Funcao: " + person.getType());
            System.out.println("-------------------------");
        }
    }
}