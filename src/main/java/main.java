import br.com.ufal.iSoccer.menus.LoginMenu;

public class main {
    public static void main(String [] args) throws Exception{
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.loginMenuAndValidateAndOpenMainMenu();
    }
}