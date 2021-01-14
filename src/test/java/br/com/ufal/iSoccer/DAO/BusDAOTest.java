package br.com.ufal.iSoccer.DAO;

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
    public void t0001_DeveCreatBus(){
        Bus bus = new Bus(false,false,1);
        BusDAO dao = new BusDAO();

        Assert.assertTrue(dao.creatBus(bus));
    }
    @Test
    public void t0002_DeveFindAllBus(){
        BusDAO dao = new BusDAO();
        List<Bus> buss = new ArrayList<>();

        buss = dao.findAll();
        Assert.assertFalse(buss.isEmpty());
    }
    @Test
    public void t0003_DeveUpdateExistBus(){
        Bus bus = new Bus(true,false,1);
        BusDAO dao = new BusDAO();

        Assert.assertTrue(dao.UpdateBusAvailable(bus));
    }

    @Test
    public void t0004_DeveUpdateAvaliableBus(){
        Bus bus = new Bus(true,true,1);
        BusDAO dao = new BusDAO();

        Assert.assertTrue(dao.UpdateBusAvailable(bus));
    }

    @Test
    public void t0005_DeveDeleteBusId(){
       BusDAO dao = new BusDAO();

       Assert.assertTrue(dao.deleteBus(1));
    }
}