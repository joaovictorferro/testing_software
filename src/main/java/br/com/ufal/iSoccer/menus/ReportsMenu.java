package br.com.ufal.iSoccer.menus;

import br.com.ufal.iSoccer.DAOMYSQL.*;
import br.com.ufal.iSoccer.adminsystem.EmployeeAdmin;
import br.com.ufal.iSoccer.adminsystem.FanAdmin;
import br.com.ufal.iSoccer.persons.Fan;
import br.com.ufal.iSoccer.persons.Person;
import br.com.ufal.iSoccer.physicalResources.Bus;
import br.com.ufal.iSoccer.physicalResources.Stadium;
import br.com.ufal.iSoccer.physicalResources.TrainingCenter;
import br.com.ufal.iSoccer.prints.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportsMenu {
    PrintMenus printMenus = new PrintMenus();
    PrintEmployees printEmployees;
    PrintFans printFans;
    EmployeeAdmin employeeAdmin;
    FanAdmin fanAdmin;
    PersonDAO dao = new PersonDAO();
    BusDAO dao2 = new BusDAO();
    TrainingCenterDAO dao3 = new TrainingCenterDAO();
    StadiumDAO dao4 = new StadiumDAO();
    FanDAO dao5 = new FanDAO();
    public ReportsMenu() {
        this.employeeAdmin = new EmployeeAdmin();
        this.printEmployees = new PrintEmployees();
        this.fanAdmin = new FanAdmin();
        this.printFans = new PrintFans();
    }

    public void reportsMenu () throws Exception{
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        printMenus.printReportsMenu();
        option = scanner.nextInt();
        option = escolhaItem(option);
        acessaSistema(option);
    }
    
    public int escolhaItem(int option) throws Exception {
  	   
  	   if (option < 1)
  	   {
  		   throw new Exception("Menor que o escopo do menu");
  	   }
  	   
  	   if(option > 7) {
         	throw new Exception("Maior que o escopo do menu");
         }
  	   return option;
     }
     
     public void acessaSistema(int option) throws Exception {

                switch (option){
                    case 1:
                        teamReports();
                        break;
                    case 2:
                        generalServicesReports();
                        break;
                    case 3:
                        transportReports();
                        break;
                    case 4:
                        trainigCenterReports();
                        break;
                    case 5:
                        stadiumReports();
                        break;
                    case 6:
                        fanReports();
                        break;
                    case 7:
                        allRports();
                        break;
                    default:
                        System.out.println("Escolha apenas uma das opcoes disponiveis.");
                        break;
                }
        }

    public void allRports(){
        teamReports();
        generalServicesReports();
        transportReports();
        trainigCenterReports();
        stadiumReports();
        fanReports();
    }

    public void teamReports() {
        System.out.println("\n - Relatorio sobre o time - \n");
        ArrayList<Person> datas = new ArrayList<>();
        datas = (ArrayList<Person>) dao.findAll();

        try {
            for (Person person : datas) {
                if (person.getType() == "tecnico") {
                    System.out.println("name" + person.getName() + "cpf" + person.getCpf() +
                            "tipo" + person.getType() + "email" + person.getEmail() +
                            "telefone" + person.getTel());

                }
            }
        } catch (NullPointerException e) {
            System.out.println("Nao existe um tecnico cadastrado.");
        }

        for (Person person : datas) {
            if (person.getType() == "player") {
                System.out.println("name" + person.getName() + "cpf" + person.getCpf() +
                        "tipo" + person.getType() + "email" + person.getEmail() +
                        "telefone" + person.getTel());
            }
            System.out.println();
        }
    }

    public void  generalServicesReports(){
        System.out.println("\n - Relatorio sobre servicos gerais - \n");
        ArrayList<Person> datas = new ArrayList<>();
        datas = (ArrayList<Person>) dao.findAll();
        for (Person person : datas){
            if(!person.getType().equals("jogador") && !person.getType().equals("t�cnico")){
                System.out.println("name" + person.getName()+"cpf" + person.getCpf()+
                        "tipo" + person.getType() + "email" + person.getEmail()+
                        "telefone" + person.getTel());
            }
        }
        System.out.println();
    }

    public void transportReports(){
        System.out.println("\n - Relotorio sobre onibus - \n");
        ArrayList<Bus> datas = new ArrayList<>();
        datas = (ArrayList<Bus>) dao2.findAll();

        for (Bus bus : datas) {
            System.out.printf("Existencia: ");
            if (bus.isExist())
                System.out.println("Recurso existente");
            else
                System.out.println("Recurso nao existente");

            System.out.printf("Disponibilidade: ");
            if (bus.isAvailable())
                System.out.println("Disponovel");
            else
                System.out.println("Indisponovel");
        }
        System.out.println();
    }

    public void trainigCenterReports(){
        System.out.println("\n - Relatorio sobre CT - \n");
        ArrayList<TrainingCenter> datas = new ArrayList<>();
        datas = (ArrayList<TrainingCenter>) dao3.findAll();

        for (TrainingCenter trainingCenter : datas) {
            System.out.printf("Existencia: ");
            if (trainingCenter.isExist())
                System.out.println("Recurso existente");
            else
                System.out.println("Recurso nao existente");

            System.out.printf("Disponibilidade: ");
            if (trainingCenter.isAvailable())
                System.out.println("Disponovel");
            else
                System.out.println("Indisponivel");

            System.out.println("Dormitorios: " + trainingCenter.getBedroomsNumber());
        }
        System.out.println();
    }

    public void stadiumReports(){
        System.out.println("\n - Relatorio sobre Estadio - \n");
        ArrayList<Stadium> datas = new ArrayList<>();
        datas = (ArrayList<Stadium>) dao4.findAll();

        for(Stadium stadium:datas) {
            System.out.printf("Exist�ncia: ");
            if (stadium.isExist())
                System.out.println("Recurso existente");
            else
                System.out.println("Recurso n�o existente");

            System.out.printf("Disponibilidade: ");
            if (stadium.isAvailable())
                System.out.println("Dispon�vel");
            else
                System.out.println("Indispon�vel");

            System.out.println("Capacidade: " + stadium.getChairsNumber());
            System.out.println("Banheiros: " + stadium.getBathroomNumber());
            System.out.println("Lanchonetes: " + stadium.getSnackBarNumber());
        }
        System.out.println();
    }

    public void fanReports(){
        ArrayList<Fan> datas = new ArrayList<>();
        datas = (ArrayList<Fan>) dao5.findAll();

        System.out.println("\n - Relat�rio de S�cio Torcedores - \n");
        System.out.println("Quantidade: " + datas.size());
        printFans.printAllFans();

        System.out.println();
    }
}