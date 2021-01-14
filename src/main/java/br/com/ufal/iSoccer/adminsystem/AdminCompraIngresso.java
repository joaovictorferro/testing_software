package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.CompraIngressUtils;

import java.util.Date;

import static br.com.ufal.iSoccer.utils.DataUtils.adicionarDias;

public class AdminCompraIngresso {
    public CompraIngressUtils CompraIngresso (Person person, Ingresso ingresso) throws Exception {

        if(ingresso.getEstoque() == 0){
            throw new Exception("Ingresso sem estoque");
        }
        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();
        compraIngressUtils.setIngresso(ingresso);
        compraIngressUtils.setPerson(person);
        compraIngressUtils.setValor(ingresso.getPrecoVenda());

        Date dataCompra = new Date();

        return compraIngressUtils;
    }
}
