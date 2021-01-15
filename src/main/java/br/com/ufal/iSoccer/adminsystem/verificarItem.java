package br.com.ufal.iSoccer.adminsystem;

public class verificarItem {

    public static String verificarStringNumerica(String numero, int tamanho) throws Exception {
        if (numero.length() != tamanho) {
            throw new Exception("String numerica Errada");
        }
        for (int i = 0; i < numero.length(); i++) {
            char ch = numero.charAt(i);
            if (ch < 48 || ch > 57)
                throw new Exception("Letra encontrado na String");
        }
        return numero;
    }

    public static String verificarString(String string, int maior, int menor) throws Exception {
        if (string.length() < menor) {
            throw new Exception("Esta vazio");
        }
        if (string.length() > maior) {
            throw new Exception("Passou da capacidade limite");
        }

        return string;
    }

    public static int verificarOption(int option,int maior, int menor) throws Exception {
        if(option > maior){
            throw new Exception("Maior que o escopo da option");
        }

        if(option < menor){
            throw new Exception("Menor que o escopo da option");
        }
        return option;
    }
}
