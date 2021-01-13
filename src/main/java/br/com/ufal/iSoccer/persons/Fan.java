package br.com.ufal.iSoccer.persons;

public class Fan extends Person{
    private double rateValue;
    private int typeFan;
    private String cpf;
    public Fan( double rateValue, int typeFan,String cpf) {
        this.rateValue = rateValue;
        this.typeFan = typeFan;
        this.cpf = cpf;
    }

    public Fan(){}

    public Fan returnFan(Fan fan){
        return fan;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getRateValue() {
        return rateValue;
    }

    public void setRateValue(double rateValue) {
        this.rateValue = rateValue;
    }

    public int getTypeFan() {
        return typeFan;
    }

    public void setTypeFan(int typeFan) {
        this.typeFan = typeFan;
    }
}