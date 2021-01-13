package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.DAOMYSQL.FanDAO;
import br.com.ufal.iSoccer.persons.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FanAdmin {
    FanDAO dao = new FanDAO();
    public FanAdmin() { }

    public void receieveDatasAndAddFanToSystem() throws Exception{
        AdminFunctions adminFunctions = new AdminFunctions();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datas = new ArrayList<>();

        double rate = 0;
        int typeFan;

        datas = adminFunctions.receiveCommonDatasToPersons(2);
        typeFan = choiceFanType();

        switch (typeFan){
            case 1:
                rate = 150.00;
                break;
            case 2:
                rate = 225.00;
                break;
            case 3:
                rate = 364.45;
                break;
        }
        Fan newFan = new Fan(rate, typeFan,datas.get(1));

        try{
            dao.creatFan(newFan);
        }catch (Exception e){
            System.out.println("Erro ao adicionar socio-torcedor.");
        }
    }

    public int choiceFanType(){
        Scanner scanner = new Scanner(System.in);
        int type;
        while(true){
            System.out.println("Informe o tipo de torcedor: ");
            System.out.println("1 - Junior, 2 - Senior, 3 - Elite");
            try{
                type = scanner.nextInt();
                return type;
            }catch (InputMismatchException e){
                System.out.println("ERRO. Informe apenas n�meros. Tente novamente");
                scanner.nextLine();
            }
        }
    }

    public void changeRateOfAllFanTypes(){
        Scanner scanner = new Scanner(System.in);
        int type;
        double value;

        while(true){
            System.out.println("Selecione o tipo: ");
            System.out.println("1 - Junior, 2 - Senior, 3 - Elite");
            try{
                type = scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("ERRO. Informe apenas n�meros. ");
            }
        }
        while(true){
            System.out.println("Informe o novo valor: ");
            try{
                value = scanner.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println("ERRO. Informe apenas numeros separados por virgula.");
                scanner.nextLine();
            }
        }
        selectTypeToChangeRateValue(type, value);
    }

    public void selectTypeToChangeRateValue(int type, double value){
        switch (type){
            case 1:
                changeJuniorRate(value);
            case 2:
                changeSeniorRate(value);
                break;
            case 3:
                changeEliteRate(value);
                break;
            default:
                System.out.printf("ERRO. Tipo de associado nao existente. Tente novamente.");
        }
    }

    public void changeJuniorRate(double value){
        ArrayList<Fan> datas = new ArrayList<>();
        datas = (ArrayList<Fan>) dao.findAll();
        for(Fan fan : datas){
            if(fan.getTypeFan() == 1) {
                fan.setRateValue(value);
                dao.updateFanType(fan);
            }
        }
    }

    public void changeSeniorRate(double value){
        ArrayList<Fan> datas = new ArrayList<>();
        datas = (ArrayList<Fan>) dao.findAll();
        for(Fan fan : datas){
            if(fan.getTypeFan() == 2) {
                fan.setRateValue(value);
                dao.updateFanType(fan);
            }
        }
    }

    public void changeEliteRate(double value){
        ArrayList<Fan> datas = new ArrayList<>();
        datas = (ArrayList<Fan>) dao.findAll();
        for(Fan fan : datas){
            if(fan.getTypeFan() == 3)
                fan.setRateValue(value);
                dao.updateFanType(fan);
        }
    }

    public void deleteFan(){
        Scanner scanner = new Scanner(System.in);
        String cpf;

        System.out.println("Informe o cpf: ");
        cpf = scanner.nextLine();
        dao.deleteFan(cpf);
        }
}