package br.com.ufal.iSoccer.entidades;

public class Utilitario {

    private Integer id;
    private Integer estoque;
    private Double precoVenda;
    private Integer quantComprada;
    private String nome;

    public Utilitario(Integer id, Integer estoque, Double precoVenda,Integer quantComparada,String nome){
        this.id = id;
        this.estoque = estoque;
        this.precoVenda = precoVenda;
        this.quantComprada = quantComparada;
        this.nome = nome;
    }

    public Utilitario (){}

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
