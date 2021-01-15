package br.com.ufal.iSoccer.adminsystem;

import java.util.*;
public class AdminFunctions {

    public AdminFunctions() { }

    public ArrayList<String> receiveCommonDatasToPersons(int typePerson) throws Exception{
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datas = new ArrayList<String>();
        String name, email,cpf,telefone;
        String name2, email2,cpf2,telefone2;
        
        System.out.println("Informe o nome: ");
        name = scanner.nextLine();
        name2 = verificarItem.verificarString(name,256,1);
        datas.add(name2);

        System.out.println("Informe o CPF: ");
        cpf = scanner.nextLine();
        cpf2 = verificarItem.verificarStringNumerica(cpf,11);
        datas.add(cpf2);

        System.out.println("Informe o e-mail: ");
        email = scanner.nextLine();
        email2 = verificarItem.verificarString(email,256,1);
        datas.add(email2);

        System.out.println("Informe o telefone: ");
        telefone = scanner.nextLine();
        telefone2 = verificarItem.verificarStringNumerica(telefone,9);
        datas.add(telefone2);

        return datas;
    }

}
