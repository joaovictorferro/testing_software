package br.com.ufal.iSoccer.menus;

import br.com.ufal.iSoccer.physicalResources.*;
import br.com.ufal.iSoccer.prints.PrintMenus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhysicalResourcesMenu {
    Scanner scanner = new Scanner(System.in);
    Stadium stadium;
    Bus bus;
    TrainingCenter trainingCenter;
    StadiumManagementMenu stadiumManagementMenu;
    BusManagementMenu busManagementMenu;
    TrainingCenterManagementMenu trainingCenterManagementMenu;
    PrintMenus printMenus = new PrintMenus();

    public PhysicalResourcesMenu() {
        this.stadiumManagementMenu = new StadiumManagementMenu(stadium);
        this.busManagementMenu = new BusManagementMenu(bus);
        this.trainingCenterManagementMenu = new TrainingCenterManagementMenu(trainingCenter);
    }

    public void resourcesMenu() throws Exception{
        int option = 0;
        printMenus.printPhysicalResourcesMenu();
        option = scanner.nextInt();
        option = escolhaItem(option);
        acessaSistema(option);
    }
    
    public int escolhaItem(int option) throws Exception {
 	   
 	   if (option < 1)
 	   {
 		   throw new Exception("Menor que o escopo do menu");
 	   }
 	   
 	   if(option > 3) {
        	throw new Exception("Maior que o escopo do menu");
        }
 	   return option;
    }
    
    public void acessaSistema(int option) throws Exception {
                switch (option){
                    case 1:
                        stadiumManagementMenu.stadiumMenu();
                        break;
                    case 2:
                        busManagementMenu.busMenu();
                        break;
                    case 3:
                        trainingCenterManagementMenu.trainingCenterMenu();
                        break;
                    default:
                        System.out.println("Escolha apenas entre as opcoes dispon�veis.");
                        break;
                }
        }
}