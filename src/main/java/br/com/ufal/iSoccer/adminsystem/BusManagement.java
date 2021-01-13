package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.physicalResources.Bus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusManagement {
    private Bus bus;

    public BusManagement(Bus bus) {
        this.bus = bus;
    }

    public void checkBusAvailable(){
        if(bus.isExist()){
            if(bus.isAvailable())
                System.out.println("\n - onibus disponovel para uso - \n");
            else
                System.out.println("\n - onibus nao disponovel para uso - \n");
        }else{
            System.out.println("\n - O time nao possui onibus. - \n");
        }
    }

    public void changeBusExisting(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while(option != 1 && option != 2){
            if(bus.isExist()){
                System.out.println("O time possui �nibus. Deseja alterar a exist�ncia do recurso ?");
            }else{
                System.out.println("O time n�o possui �nibus. Deseja alterar esse estado e adicionar o recurso ?");
            }
            System.out.println("1 - Manter, 2 - Alterar");

            try{
                option = scanner.nextInt();

                switch (option){
                    case 1:
                        break;
                    case 2:
                        if(bus.isExist())
                            bus.setExist(false);
                        else
                            bus.setExist(true);
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

    public void changeBusAvailability(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while(option != 1 && option != 2){
            System.out.println("Alterar disponibilidade do �nibus: ");
            System.out.println("1 - Dispon�vel, 2 - N�o dispon�vel");

            try{
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        bus.setAvailable(true);
                        break;
                    case 2:
                        bus.setAvailable(false);
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
}