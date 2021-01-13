package br.com.ufal.iSoccer.persons;

public class Driver extends Person{
    private boolean enabling;
    private String cpf;

    public Driver(boolean enabling, String cpf) {
        this.enabling = enabling;
        this.cpf=cpf;
    }

    public Driver(){}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getEnabling() {
        return enabling;
    }

    public void setEnabling(Boolean enabling) {
        this.enabling = enabling;
    }
}