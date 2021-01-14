package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.CompraIngressUtils;

import java.util.Date;
import java.util.List;

public class AdminCompraIngresso {
    public CompraIngressUtils CompraIngresso (Person person, List<Ingresso> ingressos) throws Exception {

        if(person == null){
            throw new Exception("Pessoa vazio");
        }

        if(ingressos == null || ingressos.isEmpty()){
            throw new Exception("Ingresso vazio");
        }

        for (Ingresso ingresso : ingressos) {
            if (ingresso.getEstoque() == 0) {
                throw new Exception("Ingresso sem estoque");
            }
        }

        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();
        compraIngressUtils.setIngresso(ingressos);
        compraIngressUtils.setPerson(person);
        double valorTotal = 0.0;
        for(Ingresso ingresso: ingressos){
            valorTotal += ingresso.getPrecoVenda();
        }
        compraIngressUtils.setValor(valorTotal);
        compraIngressUtils.setDataCompra(new Date());

        return compraIngressUtils;
    }
}
