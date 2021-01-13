package br.com.ufal.iSoccer.menus;

import java.util.Scanner;

public class LoginMenu {
    public LoginMenu() { }

    public void loginMenuAndValidateAndOpenMainMenu() throws Exception{
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        String login, password;

            System.out.println("---- Login do Sistema ----");
            System.out.println("Login: ");
            login = scanner.nextLine();
            login = verificarLogin(login);
            System.out.println("Senha: ");
            password = scanner.nextLine();
            password = verificarPassword(password);
            if(validateDatasToLogin(login, password)) {
            	 mainMenu.mainMenuControl();
            }
    }
    
    public String verificarLogin(String login) throws Exception {
    	if (login.length() < 1)
  	   {
  		   throw new Exception("Esta vazio o Login");
  	   }
  	   
  	   if(login.length() > 256) {
         	throw new Exception("Login muito grande");
         }
  	   return login;
     }
    
    public String verificarPassword(String senha) throws Exception {
    	if (senha.length() < 8)
  	   {
  		   throw new Exception("Menor que a senha aceitavel");
  	   }
  	   
  	   if(senha.length() > 256) {
         	throw new Exception("Maior que o limite de senha aceitavel");
         }
  	   return senha;
     }

    public boolean validateDatasToLogin(String login, String password){
        if(login.equals("admin") && password.equals("123"))
            return true;
        else
            return false;
    }
}