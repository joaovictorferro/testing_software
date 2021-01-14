package br.com.ufal.iSoccer.DAO;

import br.com.ufal.iSoccer.physicalResources.Stadium;
import br.com.ufal.iSoccer.physicalResources.TrainingCenter;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainingCenterDAOTest {
    @Test
    public void t0001_creatTrainingCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,true,true,10);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        if(dao.creatTrainigCenter(trainingCenter)){
            System.out.println("Salvo com sucesso");
        }else {
            Assert.fail("Error ao salvar");
        }
    }

    @Test
    public void t0002_FindAll(){
        TrainingCenterDAO dao = new TrainingCenterDAO();
        List<TrainingCenter> trainingCenters = new ArrayList<>();

        trainingCenters = dao.findAll();
        Assert.assertFalse(trainingCenters.isEmpty());
    }

    @Test
    public void t0003_UpdateExistTrainingCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,false,true,10);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        if(dao.UpdateTrainingCenterExist(trainingCenter)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0004_UpdateAvaliableTraningCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,false,false,10);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        if(dao.UpdateTrainingCenterAvailable(trainingCenter)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0005_UpdateBedroomTraningCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,false,false,20);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        if(dao.UpdateTrainingCenterBedroomNumber(trainingCenter)){
            System.out.println("alterado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }

    @Test
    public void t0006_DeleteTraningCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,false,false,10);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        if(dao.deleteTrainingCenter(trainingCenter)){
            System.out.println("Deletado com sucesso");
        }else {
            Assert.fail("Error ao alterar");
        }
    }
}
