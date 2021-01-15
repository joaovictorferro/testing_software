  
package br.com.ufal.iSoccer.prints;

public class PrintMenus {
    public void printMainMenu(){
        System.out.println("--- Menu de Administra��o Principal ---");
        System.out.println("1 - Adicionar funcion�rio ao sistema");
        System.out.println("2 - Gerenciar funcion�rios");
        System.out.println("3 - Adicionar socio-torcedor");
        System.out.println("4 - Gerenciar socio-torcedores");
        System.out.println("5 - Gerenciar recursos f�sicos");
        System.out.println("6 - Solicitar Relat�rios");
        System.out.println("7 - Compra ingressos");
        System.out.println("8 - Compra utilitatios");
        System.out.println("9 - Sair");
    }

    public void printEmployeeManagementMenu(){
        System.out.println("---- Ger�ncia de Funcion�rios ----");
        System.out.println("1 - Listar todos os funcion�rios");
        System.out.println("2 - Deletar um funcion�rio");
        System.out.println("3 - Alterar sal�rio de um funcion�rio");
        System.out.println("4 - Alterar disponibilidade de jogador");
        System.out.println("5 - Sair");
    }

    public void printFanManagementMenu(){
        System.out.println("---- Ger�ncia de Associados ----");
        System.out.println("1 - Listar todos os s�cios");
        System.out.println("2 - Deletar um s�cio");
        System.out.println("3 - Alterar taxa de contribui��o");
        System.out.println("4 - Sair");
    }

    public void printPhysicalResourcesMenu(){
        System.out.println("--- Gerencia de Recursos F�sicos ---");
        System.out.println("1 - Estadio");
        System.out.println("2 - onibus");
        System.out.println("3 - Centro de Treinamento");
        System.out.println("4 - Sair");
    }

    public void printStadiumManagementMenu(){
        System.out.println("---- Ger�ncia de Est�dio ----");
        System.out.println("1 - Verificar disponibilidade");
        System.out.println("2 - Alterar exist�ncia do est�dio");
        System.out.println("3 - Alterar disponibilidade do est�dio");
        System.out.println("4 - Alterar n�mero de banheiros, assentos e lanchonetes");
        System.out.println("5 - Informa��es sobre os recursos do est�dio");
        System.out.println("6 - Sair");
    }

    public void printBusManagementMenu(){
        System.out.println("---- Ger�ncia de onibus ----");
        System.out.println("1 - Criar o onibus");
        System.out.println("2 - Alterar existencia do onibus");
        System.out.println("3 - Alterar disponibilidade do onibus");
        System.out.println("4 - Sair");
    }

    public void printTrainingCenterMenu(){
        System.out.println("---- Ger�ncia do CT ----");
        System.out.println("1 - Verificar disponibilidade");
        System.out.println("2 - Alterar exist�ncia do CT");
        System.out.println("3 - Alterar disponibilidade do CT");
        System.out.println("4 - N�mero de dormit�rios");
        System.out.println("5 - Sair");
    }

    public void printReportsMenu(){
        System.out.println("---- Rel�torios -----");
        System.out.println("1 - Time");
        System.out.println("2 - Servi�os Gerais");
        System.out.println("3 - Transporte");
        System.out.println("4 - Centro de Treinamento");
        System.out.println("5 - Est�dio");
        System.out.println("6 - S�cio Torcedor");
        System.out.println("7 - Todos os rel�torios");
        System.out.println("8 - Sair");
    }
}