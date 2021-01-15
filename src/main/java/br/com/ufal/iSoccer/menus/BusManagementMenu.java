package br.com.ufal.iSoccer.menus;

import br.com.ufal.iSoccer.adminsystem.BusManagement;
import br.com.ufal.iSoccer.adminsystem.verificarItem;
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
        option = verificarItem.verificarOption(option,4,1);
        acessaSistema(option,bus);
    }

   public void acessaSistema(int option,Bus bus) throws Exception {
                switch (option){
                    case 1:
                        busManagement.checkBusAvailable(bus);
                        break;
                    case 2:
                        busManagement.changeBusExisting(bus);
                        break;
                    case 3:
                        busManagement.changeBusAvailability(bus);
                        break;
                    default:
                        System.out.println("Escolha apenas entre as opcoes acima.");
                        break;
                }
   }
}