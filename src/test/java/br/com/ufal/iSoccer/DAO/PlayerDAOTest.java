package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.entidades.Person;
import br.com.ufal.iSoccer.entidades.Player;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayerDAOTest {

    private static Person person;
    private static PersonDAO dao;

    @BeforeClass
    public static void setupClass(){
        person = new Person("Joao","12345678911","123456789","joao@gmail.com",200.00,"jogador");
        dao = new PersonDAO();
        dao.creatPersonDAO(person);
    }

    @AfterClass
    public static void tearDownClass(){
        dao = new PersonDAO();
        dao.deletePersonDAO("12345678911");
    }
    @Test
    public void t0001_DeveCreatPlayer(){
        Player player = new Player("Meio Campo","12345678911",false);
        PlayerDAO dao = new PlayerDAO();

        Assert.assertTrue(dao.creatPlayer(player));
    }

    @Test
    public void t0002_DeveFindAllPLayer(){
        PlayerDAO dao = new PlayerDAO();
        List<Player> players = new ArrayList<>();

        players = dao.findAll();
        Assert.assertFalse(players.isEmpty());
    }

    @Test
    public void t0003_DeveFindCpfPlayer(){
        PlayerDAO dao = new PlayerDAO();
        List<Player> players = new ArrayList<>();

        players = dao.findPlayerCpf("12345678911");
        Assert.assertFalse(players.isEmpty());
    }

    @Test
    public void t0004_DeveUpdatePlayerFunction(){
        Player player = new Player("Atacante","12345678911",false);
        PlayerDAO dao = new PlayerDAO();

        Assert.assertTrue(dao.UpdatePlayerFunction(player));
    }

    @Test
    public void t0004_DeveUpdateAvailable(){
        Player player = new Player("Atacante","12345678911",true);
        PlayerDAO dao = new PlayerDAO();

        Assert.assertTrue(dao.UpdatePlayerAvailable(player));
    }

    @Test
    public void t0005_DeveDeletePlayerCpf(){
        PlayerDAO dao = new PlayerDAO();

        Assert.assertTrue(dao.deletePlayer("12345678911"));
    }
}