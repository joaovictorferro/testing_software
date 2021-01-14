package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.DAO.FanDAO;
import br.com.ufal.iSoccer.entidades.Fan;
import br.com.ufal.iSoccer.entidades.Ingresso;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.CompraIngressUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminCompraIngresso {
    private FanDAO dao = new FanDAO();

    public CompraIngressUtils CompraIngresso(Person person, Ingresso ingresso) throws Exception {
        if (person == null) {
            throw new Exception("Pessoa vazio");
        }

        if (ingresso == null) {
            throw new Exception("Ingresso vazio");
        }

        if (ingresso.getEstoque() == 0) {
            throw new Exception("Ingresso sem estoque");
        }
        if(ingresso.getQuantComprada() > ingresso.getEstoque()){
            throw new Exception("Quantidade excede o estoque");
        }

        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();
        compraIngressUtils.setIngresso(ingresso);
        compraIngressUtils.setPerson(person);

        double valorTotal = 0.0;
        valorTotal += ingresso.getPrecoVenda() * ingresso.getQuantComprada();

        if (ingresso.getQuantComprada() >= 4) {
            valorTotal -= ingresso.getPrecoVenda();
        }


        List<Fan> fans = new ArrayList<>();
        fans = dao.findFanCpf(person.getCpf());

        if (!fans.isEmpty()) {
            Fan fan = new Fan();
            fan = fans.get(0);

            if (fan.getTypeFan() == 1) {
                valorTotal = valorTotal * 0.75;
            }
            if (fan.getTypeFan() == 2) {
                valorTotal = valorTotal * 0.50;
            }
            if (fan.getTypeFan() == 3) {
                valorTotal = valorTotal * 0.25;
            }
        }

        compraIngressUtils.setValor(valorTotal);
        compraIngressUtils.setDataCompra(new Date());

        return compraIngressUtils;
    }

    public CompraIngressUtils VendaIngresso(Ingresso ingresso) throws Exception {
        if (ingresso == null) {
            throw new Exception("Ingresso vazio");
        }

        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();
        compraIngressUtils.setIngresso(ingresso);

        return compraIngressUtils;
    }

    public CompraIngressUtils AtualizarEstoqueIngresso(Ingresso ingresso) throws Exception {
        if (ingresso == null ) {
            throw new Exception("Ingresso vazio");
        }
        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();
        compraIngressUtils.setIngresso( ingresso);
        return compraIngressUtils;
    }

    public CompraIngressUtils AtualizarPrecoVenda(Ingresso ingresso) throws Exception {
        if (ingresso == null) {
            throw new Exception("Ingresso vazio");
        }

        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();
        compraIngressUtils.setIngresso(ingresso);
        return compraIngressUtils;
    }

    public CompraIngressUtils AtualizarQuantidadeComprada(Ingresso ingresso) throws Exception {
        if (ingresso == null ) {
            throw new Exception("Ingresso vazio");
        }

        CompraIngressUtils compraIngressUtils = new CompraIngressUtils();
        compraIngressUtils.setIngresso(ingresso);
        return compraIngressUtils;
    }
}
