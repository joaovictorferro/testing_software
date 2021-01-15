package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.physicalResources.Stadium;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StadiumManagement {
    private Stadium stadium;
    private Scanner scanner = new Scanner(System.in);

    public StadiumManagement(Stadium stadium) {
        this.stadium = stadium;
    }

    public boolean checkStadiumAvailability(){
        if(stadium.isExist()){
            if(stadium.isAvailable()) {
                System.out.println("\n - Estadio disponivel para uso - \n");
                return true;
            }else {
                System.out.println("\n - Estadio nao disponivel para uso - \n");
                return false;
            }
        }else{
            System.out.println("\n - O time nao possui estadio. - \n");
            return false;
        }
    }

    public void changeStadiumExisting() throws Exception {
        int option = 0;

            if (stadium.isExist())
                System.out.println("O time possui est�dio. Deseja alterar a exist�ncia desse recruso?");
            else
                System.out.println("O time n�o possui est�dio. Deseja alterar a exist�ncia desse recurso?");
            System.out.println("1 - Manter, 2 - Alterar");
            option = scanner.nextInt();
            option = verificarItem.verificarOption(option, 2, 1);
    }

    public void changeStadiumExisting(int option){
        switch (option){
            case 1:
                break;
            case 2:
                if(stadium.isExist() == true)
                    stadium.setExist(false);
                else
                    stadium.setExist(true);
                break;
            default:
                System.out.println("\n - Escolha apenas entre as duas op��es. -\n");
                break;
        }
    }

    public void changeStadiumAvailability() throws Exception {
        int option = 0;

        System.out.println("Alterar disponibilidade do est�dio: ");
        System.out.println("1 - Dispon�vel, 2 - N�o dispon�vel");
        option = scanner.nextInt();
        option = verificarItem.verificarOption(option, 2, 1);
        changeStadiumAvailabiliySistema(option);
    }
    public void changeStadiumAvailabiliySistema(int option){
        switch (option){
            case 1:
                stadium.setAvailable(true);
                break;
            case 2:
                stadium.setAvailable(false);
                break;
            default:
                System.out.println("Escolha apenas entre as duas op��es.");
                break;
        }
    }

    public void changeResourcesStadiumNumber() throws Exception {
        int option = 0;
        int newSnackBarNumber,newChairsValue,newBathroomValue;

        System.out.println("Alterar os recursos fisicos do estadio: ");
        System.out.println("1 - Capacidade, 2 - banheiros,3 - lanchonetes");
        option = scanner.nextInt();
        option = verificarItem.verificarOption(option, 2, 1);

        switch (option) {
            case 1:
                System.out.println("Informe o novo n�mero de assentos: ");
                newChairsValue = scanner.nextInt();
                changeStadiumChairs(newChairsValue);
                break;
            case 2:
                System.out.println("Informe o novo n�mero de banheiros: ");
                newBathroomValue = scanner.nextInt();
                changeStadiumBathroom(newBathroomValue);
            case 3:
                System.out.println("Informe o novo n�mero de lanchonetes: ");
                newSnackBarNumber = scanner.nextInt();
                changeStadiumSnack(newSnackBarNumber);
        }
    }

    public void changeStadiumChairs(int newChairsValue) {
        stadium.setChairsNumber(newChairsValue);
    }

    public void changeStadiumBathroom(int newBathroomValue){
        stadium.setBathroomNumber(newBathroomValue);
    }

    public void changeStadiumSnack(int newSnackBarNumber){
        stadium.setSnackBarNumber(newSnackBarNumber);
    }

    public void returnStadiumInformations(){
        System.out.println("------------------------------------------");
        System.out.println("Capacidade maxima do estadio: " + stadium.getChairsNumber());
        System.out.println("Numero de banheiros: " + stadium.getBathroomNumber());
        System.out.println("Numero de lanchonetes: " + stadium.getSnackBarNumber());
        System.out.println("------------------------------------------");
    }
}