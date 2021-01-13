package br.com.ufal.iSoccer.menus;

import br.com.ufal.iSoccer.adminsystem.FanAdmin;
import br.com.ufal.iSoccer.prints.PrintFans;
import br.com.ufal.iSoccer.prints.PrintMenus;

import java.util.Scanner;

public class FanMenuManagement {
    private PrintFans printFans;
    private PrintMenus printMenus = new PrintMenus();
    private FanAdmin fanAdmin;

    public FanMenuManagement() {
        this.printFans = new PrintFans();
        this.fanAdmin = new FanAdmin();
    }

    public void fanManagement() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        printMenus.printFanManagementMenu();
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
    
    public void acessaSistema(int option) {
        switch (option){
                    case 1:
                        printFans.printAllFans();
                        break;
                    case 2:
                        fanAdmin.deleteFan();
                        break;
                    case 3:
                        fanAdmin.changeRateOfAllFanTypes();
                        break;
                }
        }
    }