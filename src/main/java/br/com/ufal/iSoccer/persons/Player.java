package br.com.ufal.iSoccer.persons;

public class Player extends Person{
    private String playerFunction;
    private boolean available;
    private String cpf;

    public Player(String playerFunction,String cpf,Boolean available) {
        this.playerFunction = playerFunction;
        this.available = available;
        this.cpf = cpf;
    }

    public Player(){}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPlayerFunction() {
        return playerFunction;
    }

    public void setPlayerFunction(String playerFunction) {
        this.playerFunction = playerFunction;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}