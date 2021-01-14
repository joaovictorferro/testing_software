package br.com.ufal.iSoccer.entidades;

public class Doctor extends Person{
    private String crm;
    private String cpf;

    public Doctor(String crm,String cpf) {
        this.crm = crm;
        this.cpf = cpf;
    }

    public Doctor(){}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}