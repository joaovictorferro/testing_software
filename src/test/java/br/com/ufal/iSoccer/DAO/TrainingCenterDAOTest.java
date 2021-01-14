package br.com.ufal.iSoccer.DAO;

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
    public void t0001_DevecreatTrainingCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,true,true,10);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        Assert.assertTrue(dao.creatTrainigCenter(trainingCenter));
    }

    @Test
    public void t0002_DeveFindAll(){
        TrainingCenterDAO dao = new TrainingCenterDAO();
        List<TrainingCenter> trainingCenters = new ArrayList<>();

        trainingCenters = dao.findAll();
        Assert.assertFalse(trainingCenters.isEmpty());
    }

    @Test
    public void t0003_DeveUpdateExistTrainingCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,false,true,10);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        Assert.assertTrue(dao.UpdateTrainingCenterExist(trainingCenter));
    }

    @Test
    public void t0004_DeveUpdateAvaliableTraningCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,false,false,10);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        Assert.assertTrue(dao.UpdateTrainingCenterAvailable(trainingCenter));
    }

    @Test
    public void t0005_DeveUpdateBedroomTraningCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,false,false,20);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        Assert.assertTrue(dao.UpdateTrainingCenterBedroomNumber(trainingCenter));
    }

    @Test
    public void t0006_DeveDeleteTraningCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,false,false,10);
        TrainingCenterDAO dao = new TrainingCenterDAO();

        Assert.assertTrue(dao.deleteTrainingCenter(trainingCenter));
    }
}
