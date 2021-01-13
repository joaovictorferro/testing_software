package br.com.ufal.iSoccer.menus;

import br.com.ufal.iSoccer.adminsystem.TrainingCenterManagement;
import br.com.ufal.iSoccer.physicalResources.TrainingCenter;
import br.com.ufal.iSoccer.prints.PrintMenus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainingCenterManagementMenu {
    Scanner scanner = new Scanner(System.in);
    PrintMenus printMenus = new PrintMenus();
    TrainingCenter trainingCenter;
    TrainingCenterManagement trainingCenterManagement;

    public TrainingCenterManagementMenu(TrainingCenter trainingCenter) {
        this.trainingCenter = trainingCenter;
        this.trainingCenterManagement = new TrainingCenterManagement(trainingCenter);
    }

    public void trainingCenterMenu() throws Exception {
        int option = 0;
        printMenus.printTrainingCenterMenu();
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
                        trainingCenterManagement.checkTrainingCenterAvailable();
                        break;
                    case 2:
                        trainingCenterManagement.changeTrainingCenterExisting();
                        break;
                    case 3:
                        trainingCenterManagement.changeTrainingCenterAvailability();
                        break;
                    case 4:
                        trainingCenterManagement.printBedroomsNumber();
                        break;
                    default:
                        System.out.println("Escolha apenas entre as opcoes disponiveis.");
                        break;
                }

    }

}