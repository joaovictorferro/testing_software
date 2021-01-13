package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.DAOMYSQL.DoctorDAO;
import br.com.ufal.iSoccer.DAOMYSQL.DriverDAO;
import br.com.ufal.iSoccer.DAOMYSQL.PlayerDAO;
import br.com.ufal.iSoccer.persons.*;
import br.com.ufal.iSoccer.DAOMYSQL.PersonDAO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeAdmin {
    private AdminFunctions adminFunctions;
    PersonDAO dao = new PersonDAO();
    DoctorDAO dao2 = new DoctorDAO();
    DriverDAO dao3 = new DriverDAO();
    PlayerDAO dao4 = new PlayerDAO();
    public EmployeeAdmin() {
        this.adminFunctions = new AdminFunctions();
    }

    public void receiveDatasAndAddEmployeeToSystem() throws Exception{
        Scanner scanner = new Scanner(System.in);
        String type, additionalData = new String();
        ArrayList<String> datas = new ArrayList<>();
        double salary;
        
        datas = adminFunctions.receiveCommonDatasToPersons(1);

        System.out.println("Informe o cargo do funcionario: ");
        type = scanner.nextLine();

        switch (type){
            case "medico":
                System.out.println("Informe o CRM: ");
                additionalData = scanner.nextLine();
                break;
            case "motorista":
                System.out.println("Informe o n�mero de habilita��o: ");
                additionalData = scanner.nextLine();
                break;
            case "jogador":
                System.out.println("Informe a posi��o de jogo: ");
                additionalData = scanner.nextLine();
                break;
        }

        while(true){
            System.out.println("Informe o sal�rio: ");
            try{
                salary = scanner.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println("Informe o sal�rio apenas em n�meros. ");
                scanner.nextLine();
            }
        }
        checkTypeEmployeeAndAddToSystem(datas.get(0), datas.get(1), datas.get(2), datas.get(3),
                type, salary, additionalData);
    }

    public void checkTypeEmployeeAndAddToSystem(String name, String cpf, String email, String tel,
                                                String type, double salary, String additionalData){
        switch (type){
            case "cozinheiro":
                Person person = new Person(name, cpf, tel, email, salary, type);
                dao.creatPersonDAO(person);
                break;
            case "medico":
                Person person2 = new Person(name, cpf, tel, email, salary, type);
                Doctor newDoctor = new Doctor(additionalData,cpf);
                dao.creatPersonDAO(person2);
                dao2.creatDoctor(newDoctor);
                break;
            case "motorista":
                Person person3 = new Person(name, cpf, tel, email, salary, type);
                Driver newDriver = new Driver(true,cpf);
                dao.creatPersonDAO(person3);
                dao3.creatDriver(newDriver);
                break;
            case "preparador fisico":
                Person person4 = new Person(name, cpf, tel, email, salary, type);
                dao.creatPersonDAO(person4);
                break;
            case "jogador":
                Person person5 = new Person(name, cpf, tel, email, salary, type);
                dao.creatPersonDAO(person5);
                Player newPlayer = new Player(additionalData,cpf,false);
                dao4.creatPlayer(newPlayer);
                break;
            case "presidente":
                Person person6 = new Person(name, cpf, tel, email, salary, type);
                dao.creatPersonDAO(person6);
                break;
            case "tecnico":
                Person person7 = new Person(name, cpf, tel, email, salary, type);
                dao.creatPersonDAO(person7);
                break;
            default:
                System.out.println("N�o existe um cargo com essas especifica��es. Tente novamente.");
                break;
        }
    }
    public void changeEmployeeSalary(){
        Scanner scanner = new Scanner(System.in);
        double newSalary, oldSalary;
        String cpf;
        System.out.println("Digite o cpf do empregado que deseja mudar");
        cpf = scanner.nextLine();
        while (true){
            System.out.println("Informe o novo salario: ");
            try{
                newSalary = scanner.nextDouble();
                dao.updateSalaryPersonDAO(cpf,newSalary);
                break;
            }catch (InputMismatchException e){
                e.getMessage();
            }
        }
    }

    public void deleteEmployee(Person person) throws Exception{
        String type = person.getType();
        switch (type){
            case "cozinheiro":
                break;
            case "medico":
                dao2.deleteDoctor(person);
                break;
            case "motorista":
                dao3.deleteDriver(person);
                break;
            case"preparador fisico":
                break;
            case "player":
                dao4.deletePlayer(person);
                break;
            case "presidente":
                break;
            case "tecnico":
                break;
        }
        dao.deletePersonDAO(person);
    }

    public void changePlayerAvailability(){
        Scanner scanner = new Scanner(System.in);
        Player player;
        String cpf;

        System.out.println("Informe o cpf: ");
        cpf = scanner.nextLine();

        player = (Player) dao4.findPlayerCpf(cpf);
        if(player == null)
            System.out.println("Jogador nao existente.");
        else{
            if(player.isAvailable()){
                System.out.println("O jogador estava apto. Seu estado agora e: INAPTO");
                player.setAvailable(false);
            }else{
                System.out.println("O jogador estava inapto. Seu estado agora e: APTO");
                player.setAvailable(true);
          }
       }
    }
}