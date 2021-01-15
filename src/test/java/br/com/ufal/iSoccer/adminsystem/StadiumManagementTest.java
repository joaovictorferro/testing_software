package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.physicalResources.Stadium;
import org.junit.Assert;
import org.junit.Test;

public class StadiumManagementTest {
    @Test
    public void DeveExistirStadium(){
        Stadium stadium = new Stadium(1,true,true,30000,20,3);
        StadiumManagement stadiumManagement= new StadiumManagement(stadium);

        Assert.assertTrue(stadiumManagement.checkStadiumAvailability());

    }

    @Test
    public void DevetrocarExistirStadiumParaNaoExistir(){
        Stadium stadium = new Stadium(1,true,true,30000,20,3);
        StadiumManagement stadiumManagement= new StadiumManagement(stadium);

        stadiumManagement.changeStadiumExisting(2);

        Assert.assertFalse(stadium.isExist());
    }

    @Test
    public void DeveTrocarAvaliadoParaNaoAvaliado(){
        Stadium stadium = new Stadium(1,true,true,30000,20,3);
        StadiumManagement stadiumManagement= new StadiumManagement(stadium);

        stadiumManagement.changeStadiumAvailabiliySistema(2);

        Assert.assertFalse(stadium.isAvailable());
    }

    @Test
    public void DeveTrocarAsCadeiras(){
        Stadium stadium = new Stadium(1,true,true,30000,20,3);
        StadiumManagement stadiumManagement= new StadiumManagement(stadium);

        stadiumManagement.changeStadiumChairs(40000);

        Assert.assertEquals(40000,stadium.getChairsNumber());
    }

    @Test
    public void DeveTrocarOsbanheiros(){
        Stadium stadium = new Stadium(1,true,true,30000,20,3);
        StadiumManagement stadiumManagement= new StadiumManagement(stadium);

        stadiumManagement.changeStadiumBathroom(50);

        Assert.assertEquals(50,stadium.getBathroomNumber());
    }

    @Test
    public void DeveTrocarAsLanchonetes(){
        Stadium stadium = new Stadium(1,true,true,30000,20,3);
        StadiumManagement stadiumManagement= new StadiumManagement(stadium);

        stadiumManagement.changeStadiumSnack(10);

        Assert.assertEquals(10,stadium.getSnackBarNumber());
    }
}
