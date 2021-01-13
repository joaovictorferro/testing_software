package br.com.ufal.iSoccer.DAOMYSQL;

import br.com.ufal.iSoccer.physicalResources.Bus;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusDAOTest {
    @Test
    public void t0001_CreatBus(){
        Bus bus = new Bus(false,false,1);
        BusDAO dao = new BusDAO();

        if(dao.creatBus(bus)){
            System.out.println("Salvo com sucesso");
        }else {
            Assert.fail("Error ao salvar");
        }
    }
    @Test
    public void t0002_FindAllBus(){
        BusDAO dao = new BusDAO();
        List<Bus> buss = new ArrayList<>();

        buss = dao.findAll();
        Assert.assertFalse(buss.isEmpty());
    }
    @Test
    public void t0003_UpdateExistBus(){
        Bus bus = new Bus(true,false,1);
        BusDAO dao = new BusDAO();

        if(dao.UpdateBusExist(bus)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0004_UpdateAvaliableBus(){
        Bus bus = new Bus(true,true,1);
        BusDAO dao = new BusDAO();

        if(dao.UpdateBusAvailable(bus)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0005_DeleteBusId(){
       BusDAO dao = new BusDAO();
        if(dao.deleteBus(1)){
            System.out.println("Deletado com sucesso");
        }else {
            Assert.fail("Error ao salvar");
        }
    }

}
