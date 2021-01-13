  
package br.com.ufal.iSoccer.prints;

public class PrintMenus {
    public void printMainMenu(){
        System.out.println("--- Menu de Administração Principal ---");
        System.out.println("1 - Adicionar funcionário ao sistema");
        System.out.println("2 - Gerenciar funcionários");
        System.out.println("3 - Adicionar sócio-torcedor");
        System.out.println("4 - Gerenciar sócio-torcedores");
        System.out.println("5 - Gerenciar recursos físicos");
        System.out.println("6 - Solicitar Relatórios");
        System.out.println("7 - Sair");
    }

    public void printEmployeeManagementMenu(){
        System.out.println("---- Gerência de Funcionários ----");
        System.out.println("1 - Listar todos os funcionários");
        System.out.println("2 - Deletar um funcionário");
        System.out.println("3 - Alterar salário de um funcionário");
        System.out.println("4 - Alterar disponibilidade de jogador");
        System.out.println("5 - Sair");
    }

    public void printFanManagementMenu(){
        System.out.println("---- Gerência de Associados ----");
        System.out.println("1 - Listar todos os sócios");
        System.out.println("2 - Deletar um sócio");
        System.out.println("3 - Alterar taxa de contribuição");
        System.out.println("4 - Sair");
    }

    public void printPhysicalResourcesMenu(){
        System.out.println("--- Gerência de Recursos Físicos ---");
        System.out.println("1 - Estádio");
        System.out.println("2 - Ônibus");
        System.out.println("3 - Centro de Treinamento");
        System.out.println("4 - Sair");
    }

    public void printStadiumManagementMenu(){
        System.out.println("---- Gerência de Estádio ----");
        System.out.println("1 - Verificar disponibilidade");
        System.out.println("2 - Alterar existência do estádio");
        System.out.println("3 - Alterar disponibilidade do estádio");
        System.out.println("4 - Alterar número de banheiros, assentos e lanchonetes");
        System.out.println("5 - Informações sobre os recursos do estádio");
        System.out.println("6 - Sair");
    }

    public void printBusManagementMenu(){
        System.out.println("---- Gerência de Ônibus ----");
        System.out.println("1 - Verificar disponibilidade");
        System.out.println("2 - Alterar existência do ônibus");
        System.out.println("3 - Alterar disponibilidade do ônibus");
        System.out.println("4 - Sair");
    }

    public void printTrainingCenterMenu(){
        System.out.println("---- Gerência do CT ----");
        System.out.println("1 - Verificar disponibilidade");
        System.out.println("2 - Alterar existência do CT");
        System.out.println("3 - Alterar disponibilidade do CT");
        System.out.println("4 - Número de dormitórios");
        System.out.println("5 - Sair");
    }

    public void printReportsMenu(){
        System.out.println("---- Relátorios -----");
        System.out.println("1 - Time");
        System.out.println("2 - Serviços Gerais");
        System.out.println("3 - Transporte");
        System.out.println("4 - Centro de Treinamento");
        System.out.println("5 - Estádio");
        System.out.println("6 - Sócio Torcedor");
        System.out.println("7 - Todos os relátorios");
        System.out.println("8 - Sair");
    }
}