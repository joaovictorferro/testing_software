package br.com.ufal.iSoccer.menus;

import br.com.ufal.iSoccer.adminsystem.BusManagement;
import br.com.ufal.iSoccer.physicalResources.Bus;
import br.com.ufal.iSoccer.prints.PrintMenus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusManagementMenu {
    private Scanner scanner = new Scanner(System.in);
    BusManagement busManagement;
    Bus bus;

    public BusManagementMenu(Bus bus) {
        this.bus = bus;
        this.busManagement = new BusManagement(bus);
    }
    
    
    public void busMenu() throws Exception{
        PrintMenus printMenus = new PrintMenus();
        int option = 0;
        
        printMenus.printBusManagementMenu();
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
    
   public void acessaSistema(int option) {
                switch (option){
                    case 1:
                        busManagement.checkBusAvailable();
                        break;
                    case 2:
                        busManagement.changeBusExisting();
                        break;
                    case 3:
                        busManagement.changeBusAvailability();
                        break;
                    default:
                        System.out.println("Escolha apenas entre as opcoes acima.");
                        break;
                }
   }
}