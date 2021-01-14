package br.com.ufal.iSoccer.entidades;

public class Ingresso {

    private Integer id;
    private Integer estoque;
    private Double precoVenda;
    private Integer quantComprada;

    public Ingresso(Integer id, Integer estoque, Double precoVenda,Integer quantComparada){
        this.id = id;
        this.estoque = estoque;
        this.precoVenda = precoVenda;
        this.quantComprada = quantComparada;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Ingresso(){ }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public Integer getQuantComprada() {
        return quantComprada;
    }

    public void setQuantComprada(Integer quantComprada) {
        this.quantComprada = quantComprada;
    }

}
