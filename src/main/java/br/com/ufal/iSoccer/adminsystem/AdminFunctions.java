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
        name2 = verificarName(name);
        datas.add(name2);

        System.out.println("Informe o CPF: ");
        cpf = scanner.nextLine();
        cpf2 = verificarCpf(cpf);
        datas.add(cpf2);

        System.out.println("Informe o e-mail: ");
        email = scanner.nextLine();
        email2 = verificarEmail(email);
        datas.add(email2);

        System.out.println("Informe o telefone: ");
        telefone = scanner.nextLine();
        telefone2 = verificarTelefone(telefone);
        datas.add(telefone2);

        return datas;
    }
    
    public String verificarTelefone(String telefone) throws Exception{
    	if (telefone.length() != 11)
    	{
    		 throw new Exception("Telefone Errado!!");
    	}
    	 for (int i = 0; i < telefone.length(); i++) {
             char ch = telefone.charAt(i);
             if (ch < 48 || ch > 57)
            	 throw new Exception("Numero encontrado no Telefone!!");
       }
    	return telefone;
    }
    
    public String verificarName(String name) throws Exception{
    	if (name.length() < 1)
    	{
    		 throw new Exception("Esta vazio");
    	}
    	if (name.length() > 256)
    	{
    		 throw new Exception("Passou da capacidade limite");
    	}
    	
    	return name;
    }
    
    public String verificarCpf(String cpf) throws Exception{
    	if (cpf.length() != 11)
    	{
    		 throw new Exception("CPF Errado!!");
    	}
    	 for (int i = 0; i < cpf.length(); i++) {
             char ch = cpf.charAt(i);
             if (ch < 48 || ch > 57)
            	 throw new Exception("Numero encontrado no CPF!!");
       }
    	return cpf;
    }
    
    
    
    public String verificarEmail(String email) throws Exception{
    	if (email.length() < 1)
    	{
    		 throw new Exception("Esta vazio");
    	}
    	if (email.length() > 256)
    	{
    		 throw new Exception("Passou da capacidade limite");
    	}
    	
    	return email;
    }
}
