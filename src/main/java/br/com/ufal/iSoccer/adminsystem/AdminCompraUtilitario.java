package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.DAO.FanDAO;
import br.com.ufal.iSoccer.entidades.Fan;
import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.entidades.Utilitario;
import br.com.ufal.iSoccer.utils.CompraUtilitariosUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminCompraUtilitario {
    private FanDAO dao = new FanDAO();

    public CompraUtilitariosUtils Comprautilirario(Person person, Utilitario utilitario) throws Exception {
        if (person == null) {
            throw new Exception("Pessoa vazio");
        }

        if (utilitario == null) {
            throw new Exception("Utilitario vazio");
        }

        if (utilitario.getEstoque() == 0) {
            throw new Exception("Utilitario sem estoque");
        }
        if (utilitario.getQuantComprada() > utilitario.getEstoque()) {
            throw new Exception("Quantidade excede o estoque");
        }

        CompraUtilitariosUtils compraUtilitariosUtils = new CompraUtilitariosUtils();
        compraUtilitariosUtils.setUtilitario(utilitario);
        compraUtilitariosUtils.setPerson(person);

        double valorTotal = 0.0;
        valorTotal += utilitario.getPrecoVenda() * utilitario.getQuantComprada();


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

        compraUtilitariosUtils.setValor(valorTotal);
        compraUtilitariosUtils.setDataCompra(new Date());

        return compraUtilitariosUtils;
    }

    public CompraUtilitariosUtils VendaUtilitarios(Utilitario utilitario) throws Exception {
        if (utilitario == null) {
            throw new Exception("Ingresso vazio");
        }

        CompraUtilitariosUtils compraUtilitariosUtils = new CompraUtilitariosUtils();
        compraUtilitariosUtils.setUtilitario(utilitario);

        return compraUtilitariosUtils;
    }
}