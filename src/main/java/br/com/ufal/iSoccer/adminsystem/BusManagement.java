package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.DAO.BusDAO;
import br.com.ufal.iSoccer.physicalResources.Bus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusManagement {
    private Bus bus;
    private BusDAO dao;

    public BusManagement(Bus bus) {
        this.bus = bus;
    }

    public Bus creatBus(int id, boolean exist,boolean avaliable){
        bus = new Bus();
        bus.setExist(exist);
        bus.setId_bus(id);
        bus.setAvailable(avaliable);
        dao.creatBus(bus);
        return bus;
    }

    public void checkBusAvailable(Bus bus){
        if(bus.isExist()){
            if(bus.isAvailable())
                System.out.println("\n - onibus disponovel para uso - \n");
            else
                System.out.println("\n - onibus nao disponovel para uso - \n");
        }else{
            System.out.println("\n - O time nao possui onibus. - \n");
        }
    }

    public void changeBusExisting(Bus bus) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        if (bus.isExist()) {
            System.out.println("O time possui onibus. Deseja alterar a existencia do recurso ?");
        } else {
            System.out.println("O time nao possui onibus. Deseja alterar esse estado e adicionar o recurso ?");
        }
        System.out.println("1 - Manter, 2 - Alterar");
        option = scanner.nextInt();
        option = verificarItem.verificarOption(option,2,1);
        changeBusExistingSistema(option,bus);
    }

    public static Bus changeBusExistingSistema(int option, Bus bus) {
        BusDAO dao = new BusDAO();
        switch (option) {
            case 1:
                break;
            case 2:
                if (bus.isExist())
                    bus.setExist(false);
                else
                    bus.setExist(true);
                break;
            default:
                System.out.println("\n - Escolha apenas entre as duas op��es. -\n");
                break;
        }
        dao.UpdateBusExist(bus);
        return bus;
    }

    public void changeBusAvailability(Bus bus) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        System.out.println("Alterar disponibilidade do �nibus: ");
        System.out.println("1 - Dispon�vel, 2 - N�o dispon�vel");

        option = scanner.nextInt();
        option = verificarItem.verificarOption(option,2,1);
        changeBusExistingSistema(option,bus);
    }

    public static Bus changeBusAvailabilitySistema(int option, Bus bus){
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
        return bus;
    }
}
