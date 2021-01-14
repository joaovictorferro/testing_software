  
package br.com.ufal.iSoccer.prints;

import br.com.ufal.iSoccer.DAO.FanDAO;
import br.com.ufal.iSoccer.DAO.PersonDAO;
import br.com.ufal.iSoccer.entidades.Fan;

import java.util.ArrayList;

public class PrintFans {
    private PersonDAO dao = new PersonDAO();
    private FanDAO dao2 = new FanDAO();
    public PrintFans() {}

    public void printAllFans(){
        ArrayList<Fan> datas2 = new ArrayList<>();
        datas2 = (ArrayList<Fan>) dao2.findAll();
        if(datas2.size() == 0)
            System.out.println("- Nao existem socios associados. - \n");
        else{
            for(Fan fan: datas2){
                printFanDetails(fan);
            }
        }
    }

    public void printFanDetails(Fan fan){
        System.out.println("---------------");
        System.out.println("Nome: " + fan.getName());
        System.out.println("E-mail: " + fan.getEmail());
        System.out.printf("Tipo: ");
        switch (fan.getTypeFan()){
            case 1:
                System.out.println("Junior");
                break;
            case 2:
                System.out.println("Senior");
                break;
            case 3:
                System.out.println("Elite");
                break;
        }
    }
}