package br.com.ufal.iSoccer.utils;

import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.entidades.Utilitario;

import java.util.Date;

public class CompraUtilitariosUtils {
    private Person person;
    private Utilitario utilitario;
    private Double valor;
    private Date dataCompra;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Utilitario getUtilitario() {
        return utilitario;
    }

    public void setUtilitario(Utilitario utilitario) {
        this.utilitario = utilitario;
    }
}