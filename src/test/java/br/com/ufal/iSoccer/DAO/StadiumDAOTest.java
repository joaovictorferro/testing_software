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
    public void t0001_creatStadium(){
        Stadium stadium = new Stadium(1,true,true,3000,20,2);
        StadiumDAO dao = new StadiumDAO();

        if(dao.creatStadium(stadium)){
            System.out.println("Salvo com sucesso");
        }else {
            Assert.fail("Error ao salvar");
        }
    }

    @Test
    public void t0002_FindAll(){
        StadiumDAO dao = new StadiumDAO();
        List<Stadium> stadiums = new ArrayList<>();

        stadiums = dao.findAll();
        Assert.assertFalse(stadiums.isEmpty());
    }

    @Test
    public void t0003_UpdateExistStadium(){
        Stadium stadium = new Stadium(1,false,true,3000,20,4);
        StadiumDAO dao = new StadiumDAO();

        if(dao.UpdateStadiumExist(stadium)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0004_UpdateAvaliableStadium(){
        Stadium stadium = new Stadium(1,false,false,3000,20,4);
        StadiumDAO dao = new StadiumDAO();

        if(dao.UpdateStadiumAvailable(stadium)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0005_UpdateChairsStadium(){
        Stadium stadium = new Stadium(1,false,false,4000,20,4);
        StadiumDAO dao = new StadiumDAO();

        if(dao.UpdateStadiumChairs(stadium)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0006_UpdateBathroomStadium(){
        Stadium stadium = new Stadium(1,false,false,4000,30,4);
        StadiumDAO dao = new StadiumDAO();

        if(dao.UpdateStadiumBathroom(stadium)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0007_UpdateSnackBarStadium(){
        Stadium stadium = new Stadium(1,false,false,4000,30,8);
        StadiumDAO dao = new StadiumDAO();

        if(dao.UpdateStadiumSnack(stadium)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0008_DeleteStadium(){
        Stadium stadium = new Stadium(1,false,false,4000,30,8);
        StadiumDAO dao = new StadiumDAO();

        if(dao.deleteStadium(stadium)){
            System.out.println("Deletado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }
}
