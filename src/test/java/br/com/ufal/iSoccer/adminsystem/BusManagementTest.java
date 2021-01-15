package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.physicalResources.Bus;
import org.junit.Assert;
import org.junit.Test;

public class BusManagementTest {
    @Test
    public void DevechangeBusExistingSistema(){
        Bus bus = new Bus(true,true,1);
        Bus bus2 = new Bus();

        bus2 = BusManagement.changeBusExistingSistema(2,bus);

        Assert.assertFalse(bus2.isExist());
    }

    @Test
    public void DeveChangeBusAvailableSistema(){
        Bus bus = new Bus(true,true,1);
        Bus bus2 = new Bus();

        bus2 = BusManagement.changeBusAvailabilitySistema(2,bus);

        Assert.assertFalse(bus2.isAvailable());
    }
}
