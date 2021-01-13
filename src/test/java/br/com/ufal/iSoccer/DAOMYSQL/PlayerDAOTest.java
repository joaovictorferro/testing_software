package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.persons.Person;
import br.com.ufal.iSoccer.persons.Player;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayerDAOTest {
    @Test
    public void t0001_CreatPlayer(){
        Person person = new Person("Joao","12345678911","123456789","joao@gmail.com",200.00,"jogador");
        Player player = new Player("Meio Campo","12345678911",false);
        PlayerDAO dao = new PlayerDAO();
        PersonDAO dao2 = new PersonDAO();
        dao2.creatPersonDAO(person);

        if(dao.creatPlayer(player)){
            System.out.println("Salvo com sucesso");
        }else{
            fail("Erro ao salvar");
        }
    }

    @Test
    public void t0002_FindAllPLayer(){
        PlayerDAO dao = new PlayerDAO();
        List<Player> players = new ArrayList<>();

        players = dao.findAll();
        Assert.assertFalse(players.isEmpty());
    }
    @Test
    public void t0003_FindCpfPlayer(){
        PlayerDAO dao = new PlayerDAO();
        List<Player> players = new ArrayList<>();

        players = dao.findPlayerCpf("12345678911");
        Assert.assertFalse(players.isEmpty());
    }

    @Test
    public void t0004_UpdatePlayerFunction(){
        Player player = new Player("Atacante","12345678911",false);
        PlayerDAO dao = new PlayerDAO();
            if(dao.UpdatePlayerFunction(player)){
                System.out.println("alterado com sucesso");
            }else {
                Assert.fail("Error ao alterar");
            }
    }

    @Test
    public void t0004_UpdateAvailable(){
        Player player = new Player("Atacante","12345678911",true);
        PlayerDAO dao = new PlayerDAO();
        if(dao.UpdatePlayerAvailable(player)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0005_DeletePlayerCpf(){
        PlayerDAO dao = new PlayerDAO();
        PersonDAO dao2 = new PersonDAO();

        if(dao.deletePlayer("12345678911")){
            System.out.println("Deletado com sucesso");
        }else {
            Assert.fail("Error ao salvar");
        }
        dao2.deletePersonDAO("12345678911");
    }
}
