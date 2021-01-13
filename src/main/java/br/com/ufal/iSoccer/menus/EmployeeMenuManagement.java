  
package br.com.ufal.iSoccer.menus;

import br.com.ufal.iSoccer.adminsystem.EmployeeAdmin;
import br.com.ufal.iSoccer.prints.PrintEmployees;
import br.com.ufal.iSoccer.prints.PrintMenus;

import java.util.Scanner;

public class EmployeeMenuManagement {
    private EmployeeAdmin employeeAdmin;
    private PrintEmployees printEmployees;
    private PrintMenus printMenus = new PrintMenus();


    public EmployeeMenuManagement() {
        this.printEmployees = new PrintEmployees();
        this.employeeAdmin = new EmployeeAdmin();
    }

    public void employeeManagement() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        printMenus.printEmployeeManagementMenu();
        option = scanner.nextInt();
        option = escolhaItem(option);
        acessaSistema(option);
    }
    
    public int escolhaItem(int option) throws Exception {
 	   
 	   if (option < 1)
 	   {
 		   throw new Exception("Menor que o escopo do menu");
 	   }
 	   
 	   if(option > 4) {
        	throw new Exception("Maior que o escopo do menu");
        }
 	   return option;
    }
    
    public void acessaSistema(int option) throws Exception {
    	switch (option){
                    case 1:
                        printEmployees.printJustEmployeeNameAndType();
                        break;
                    case 2:
                        employeeAdmin.changeEmployeeSalary();
                        break;
                    case 3:
                        employeeAdmin.changePlayerAvailability();
                        break;
                }
     }
}