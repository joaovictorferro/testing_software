package br.com.ufal.iSoccer.menus;

import br.com.ufal.iSoccer.adminsystem.StadiumManagement;
import br.com.ufal.iSoccer.physicalResources.*;
import br.com.ufal.iSoccer.prints.PrintMenus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StadiumManagementMenu {
    private Stadium stadium;
    private StadiumManagement stadiumManagement;
    private Scanner scanner = new Scanner(System.in);

    public StadiumManagementMenu(Stadium stadium) {
        this.stadium = stadium;
        this.stadiumManagement = new StadiumManagement(stadium);
    }

    public void stadiumMenu() throws Exception{
        PrintMenus printMenus = new PrintMenus();
        int option = 0;
        printMenus.printStadiumManagementMenu();
        option = scanner.nextInt();
        option = escolhaItem(option);
        acessaSistema(option);   
    }
    public int escolhaItem(int option) throws Exception {
  	   
  	   if (option < 1)
  	   {
  		   throw new Exception("Menor que o escopo do menu");
  	   }
  	   
  	   if(option > 5) {
         	throw new Exception("Maior que o escopo do menu");
         }
  	   return option;
     }
     
     public void acessaSistema(int option) throws Exception {
                switch (option){
                    case 1:
                        stadiumManagement.checkStadiumAvailability();
                        break;
                    case 2:
                        stadiumManagement.changeStadiumExisting();
                        break;
                    case 3:
                        stadiumManagement.changeStadiumAvailability();
                        break;
                    case 4:
                        stadiumManagement.changeResourcesStadiumNumber();
                        break;
                    case 5:
                        stadiumManagement.returnStadiumInformations();
                        break;
                    default:
                        System.out.println("Escolha apenas entre as opcoes acima.");
                        break;
                }
            
        
    }
}