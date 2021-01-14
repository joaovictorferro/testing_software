package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.physicalResources.Stadium;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StadiumDAOTest {

    @Test
    public void t0001_DeveCreatStadium(){
        Stadium stadium = new Stadium(1,true,true,3000,20,2);
        StadiumDAO dao = new StadiumDAO();

        Assert.assertTrue(dao.creatStadium(stadium));
    }

    @Test
    public void t0002_DeveFindAll(){
        StadiumDAO dao = new StadiumDAO();
        List<Stadium> stadiums = new ArrayList<>();

        stadiums = dao.findAll();
        Assert.assertFalse(stadiums.isEmpty());
    }

    @Test
    public void t0003_DeveUpdateExistStadium(){
        Stadium stadium = new Stadium(1,false,true,3000,20,4);
        StadiumDAO dao = new StadiumDAO();

        Assert.assertTrue(dao.UpdateStadiumExist(stadium));
    }

    @Test
    public void t0004_DeveUpdateAvaliableStadium(){
        Stadium stadium = new Stadium(1,false,false,3000,20,4);
        StadiumDAO dao = new StadiumDAO();

        Assert.assertTrue(dao.UpdateStadiumAvailable(stadium));
    }

    @Test
    public void t0005_DeveUpdateChairsStadium(){
        Stadium stadium = new Stadium(1,false,false,4000,20,4);
        StadiumDAO dao = new StadiumDAO();

        Assert.assertTrue(dao.UpdateStadiumChairs(stadium));
    }

    @Test
    public void t0006_DeveUpdateBathroomStadium(){
        Stadium stadium = new Stadium(1,false,false,4000,30,4);
        StadiumDAO dao = new StadiumDAO();

        Assert.assertTrue(dao.UpdateStadiumBathroom(stadium));
    }

    @Test
    public void t0007_DeveUpdateSnackBarStadium(){
        Stadium stadium = new Stadium(1,false,false,4000,30,8);
        StadiumDAO dao = new StadiumDAO();

        Assert.assertTrue(dao.UpdateStadiumSnack(stadium));
    }

    @Test
    public void t0008_DeveDeleteStadium(){
        Stadium stadium = new Stadium(1,false,false,4000,30,8);
        StadiumDAO dao = new StadiumDAO();

        Assert.assertTrue(dao.deleteStadium(stadium));
    }
}