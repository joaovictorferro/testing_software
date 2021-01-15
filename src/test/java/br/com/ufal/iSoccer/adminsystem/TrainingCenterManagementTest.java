package br.com.ufal.iSoccer.adminsystem;

import br.com.ufal.iSoccer.physicalResources.TrainingCenter;
import org.junit.Assert;
import org.junit.Test;

public class TrainingCenterManagementTest {
    @Test
    public void DeveExistirTrainingCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,true,true,20);
        TrainingCenterManagement trainingCenterManagement = new TrainingCenterManagement(trainingCenter);

        Assert.assertTrue(trainingCenterManagement.checkTrainingCenterAvailable());
    }

    @Test
    public void DeveNaoExistirTrainingCenter(){
        TrainingCenter trainingCenter = new TrainingCenter(1,true,true,20);
        TrainingCenterManagement trainingCenterManagement = new TrainingCenterManagement(trainingCenter);

        trainingCenterManagement.changeTrainingCenterExisting(2);

        Assert.assertFalse(trainingCenter.isExist());
    }

    @Test
    public void DeveNaoEstaAvaliado(){
        TrainingCenter trainingCenter = new TrainingCenter(1,true,true,20);
        TrainingCenterManagement trainingCenterManagement = new TrainingCenterManagement(trainingCenter);

        trainingCenterManagement.changeTrainingCenterAvailabilitySistema(2);

        Assert.assertFalse(trainingCenter.isAvailable());
    }

    @Test
    public void DeveTrocarDormitorios(){
        TrainingCenter trainingCenter = new TrainingCenter(1,true,true,20);
        TrainingCenterManagement trainingCenterManagement = new TrainingCenterManagement(trainingCenter);

        trainingCenterManagement.changeBedroom(50);

        Assert.assertEquals(50,trainingCenter.getBedroomsNumber());
    }
}