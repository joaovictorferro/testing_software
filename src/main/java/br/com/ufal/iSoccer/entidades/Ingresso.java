package br.com.ufal.iSoccer.entidades;

public class Ingresso {
    private String cpf;
    private Integer estoque;
    private Double precoVenda;

    public Ingresso(String cpf, Integer estoque, Double precoVenda){
        this.cpf = cpf;
        this.estoque = estoque;
        this.precoVenda = precoVenda;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Ingresso(){ }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
