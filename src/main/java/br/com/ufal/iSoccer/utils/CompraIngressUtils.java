package br.com.ufal.iSoccer.utils;

import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Person;

import java.util.Date;

public class CompraIngressUtils {
    private Person person;
    private Ingresso ingresso;
    private Double valor;
    private Date dataCompra;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        valor = valor;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

}
