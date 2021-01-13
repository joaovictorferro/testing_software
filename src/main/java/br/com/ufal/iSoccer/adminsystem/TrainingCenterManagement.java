package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.physicalResources.TrainingCenter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainingCenterManagement {
    private TrainingCenter trainingCenter;

    public TrainingCenterManagement(TrainingCenter trainingCenter) {
        this.trainingCenter = trainingCenter;
    }

    public void checkTrainingCenterAvailable(){
        if(trainingCenter.isExist()){
            if(trainingCenter.isAvailable())
                System.out.println("\n - Centro de treinamento disponivel para uso - \n");
            else
                System.out.println("\n - Centro de treinamento nao disponivel para uso - \n");
        }else{
            System.out.println("\n - O time nao possui Centro de treinamento. - \n");
        }
    }

    public void changeTrainingCenterExisting(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while(option != 1 && option != 2){
            if(trainingCenter.isExist()){
                System.out.println("O time possui Centro de Treinamento. \n" +
                        "Deseja alterar a exist�ncia do recurso ?");
            }else{
                System.out.println("O time n�o possui Centro de Treinamento. \n " +
                        "Deseja alterar esse estado e adicionar o recurso ?");
            }
            System.out.println("1 - Manter, 2 - Alterar");

            try{
                option = scanner.nextInt();

                switch (option){
                    case 1:
                        break;
                    case 2:
                        if(trainingCenter.isExist())
                            trainingCenter.setExist(false);
                        else
                            trainingCenter.setExist(true);
                        break;
                    default:
                        System.out.println("\n - Escolha apenas entre as duas op��es. -\n");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("ERRO. Informe apenas n�meros inteiros.");
                scanner.nextLine();
            }
        }
    }

    public void changeTrainingCenterAvailability(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while(option != 1 && option != 2){
            System.out.println("Alterar disponibilidade do centro de treinamento: ");
            System.out.println("1 - Dispon�vel, 2 - N�o dispon�vel");

            try{
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        trainingCenter.setAvailable(true);
                        break;
                    case 2:
                        trainingCenter.setAvailable(false);
                        break;
                    default:
                        System.out.println("Escolha apenas entre as duas op��es.");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("ERRO. Informe apenas n�meros inteiros.");
                scanner.nextLine();
            }
        }
    }

    public void printBedroomsNumber(){
        System.out.println("O Centro de treinamento possui " + trainingCenter.getBedroomsNumber() +
                " banheiros.");
    }
}