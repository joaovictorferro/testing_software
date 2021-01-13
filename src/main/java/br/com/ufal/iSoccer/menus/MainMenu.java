package br.com.ufal.iSoccer.menus;

import br.com.ufal.iSoccer.DataBase.ConnectionFactory;
import br.com.ufal.iSoccer.prints.*;
import br.com.ufal.iSoccer.adminsystem.*;

import java.util.Scanner;

public class MainMenu {
    private PrintMenus printMenus = new PrintMenus();;
    private PrintEmployees printEmployees;
    private EmployeeAdmin employeeAdmin;
    private FanAdmin fanAdmin;
    private EmployeeMenuManagement employeeMenuManagement;
    private FanMenuManagement managementFanMenu;
    private PhysicalResourcesMenu physicalResourcesMenu;
    private ReportsMenu reportsMenu;
    
    public MainMenu() {
        this.printEmployees = new PrintEmployees();
        this.employeeAdmin = new EmployeeAdmin();
        this.fanAdmin = new FanAdmin();
        this.employeeMenuManagement = new EmployeeMenuManagement();
        this.managementFanMenu = new FanMenuManagement();
        this.physicalResourcesMenu = new PhysicalResourcesMenu();
        this.reportsMenu = new ReportsMenu();
    }

    public void mainMenuControl() throws Exception{
        Scanner scanner = new Scanner(System.in);
   
            printMenus.printMainMenu();
            int option = scanner.nextInt();
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
                        employeeAdmin.receiveDatasAndAddEmployeeToSystem();
                        break;
                    case 2:
                        employeeMenuManagement.employeeManagement();
                        break;
                    case 3:
                        fanAdmin.receieveDatasAndAddFanToSystem();
                        break;
                    case 4:
                        managementFanMenu.fanManagement();
                        break;
                    case 5:
                        physicalResourcesMenu.resourcesMenu();
                        break;
                    case 6:
                        reportsMenu.reportsMenu();
                        break;
                    case 7:
                        LoginMenu loginMenu = new LoginMenu();
                        loginMenu.loginMenuAndValidateAndOpenMainMenu();
                        break;
                }
			}
}