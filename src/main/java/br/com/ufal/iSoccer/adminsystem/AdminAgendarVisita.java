package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.utils.DataUtils;

import java.util.Calendar;
import java.util.Date;

import static br.com.ufal.iSoccer.utils.DataUtils.adicionarDias;

public class AdminAgendarVisita {

    public DataUtils Agendamento(Person person) throws Exception {
        if (person == null) {
            throw new Exception("Pessoa vazio");
        }


        DataUtils dataUtils = new DataUtils();

        dataUtils.setPerson(person);
        dataUtils.setCpf(person.getCpf());
        Date dataEntrada = new Date();
        Date dataVisita = adicionarDias(dataEntrada, 1);
        if(DataUtils.verificarDiaSemana(dataVisita, Calendar.SUNDAY) || DataUtils.verificarDiaSemana(dataVisita, Calendar.WEDNESDAY)){
            dataVisita = adicionarDias(dataEntrada, 1);
        }
        dataUtils.setAgendamento(dataVisita);

        return dataUtils;
    }
}
