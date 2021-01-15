package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.physicalResources.TrainingCenter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainingCenterManagement {
    private TrainingCenter trainingCenter;

    public TrainingCenterManagement(TrainingCenter trainingCenter) {
        this.trainingCenter = trainingCenter;
    }

    public boolean checkTrainingCenterAvailable(){
        if(trainingCenter.isExist()){
            if(trainingCenter.isAvailable()) {
                System.out.println("\n - Centro de treinamento disponivel para uso - \n");
                return true;
            }else {
                System.out.println("\n - Centro de treinamento nao disponivel para uso - \n");
                return false;
            }
        }else{
            System.out.println("\n - O time nao possui Centro de treinamento. - \n");
            return false;
        }
    }

    public void changeTrainingCenterExisting() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        if (trainingCenter.isExist()) {
            System.out.println("O time possui Centro de Treinamento. \n" +
                    "Deseja alterar a exist�ncia do recurso ?");
        } else {
            System.out.println("O time n�o possui Centro de Treinamento. \n " +
                    "Deseja alterar esse estado e adicionar o recurso ?");
        }
        System.out.println("1 - Manter, 2 - Alterar");

        option = scanner.nextInt();
        option = verificarItem.verificarOption(option,2,1);
    }

    public void changeTrainingCenterExisting(int option){
        switch (option){
            case 1:
                break;
            case 2:
                 if(trainingCenter.isExist())
                     trainingCenter.setExist(false);
                 else
                     trainingCenter.setExist(true);
                        break;
        }
    }

    public void changeTrainingCenterAvailability() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        System.out.println("Alterar disponibilidade do centro de treinamento: ");
        System.out.println("1 - Dispon�vel, 2 - N�o dispon�vel");
        option = scanner.nextInt();
        option = verificarItem.verificarOption(option,2,1);
        changeTrainingCenterAvailabilitySistema(option);
    }

    public void changeTrainingCenterAvailabilitySistema(int option){
        switch (option){
            case 1:
                trainingCenter.setAvailable(true);
                break;
            case 2:
                trainingCenter.setAvailable(false);
                break;
        }
    }

    public void changeBedroom(int bedroom){
        trainingCenter.setBedroomsNumber(bedroom);
    }

    public void printBedroomsNumber(){
        System.out.println("O Centro de treinamento possui " + trainingCenter.getBedroomsNumber() +
                " banheiros.");
    }
}