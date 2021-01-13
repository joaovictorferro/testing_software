package br.com.ufal.iSoccer.menus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.ufal.iSoccer.physicalResources.Stadium;
import br.com.ufal.iSoccer.physicalResources.TrainingCenter;

public class TrainingCenterManagementMenuTest {

	@Test
	public void DeveSerMaiorQUeEscopo() {
		//acao
		TrainingCenter trainingCenter = null;
		TrainingCenterManagementMenu trainingCenterManagementMenu = new TrainingCenterManagementMenu(trainingCenter);
		
		//cenario
		try {
			trainingCenterManagementMenu.escolhaItem(10);
			//verificacao
			fail("Nao deveria ter passado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Maior que o escopo do menu"));
		}
		//verificacao
	}

	@Test
	public void DeveSerMenorQueEscopo() {
		// acao
		TrainingCenter trainingCenter = null;
		TrainingCenterManagementMenu trainingCenterManagementMenu = new TrainingCenterManagementMenu(trainingCenter);
		
		//cenario
		try {
			trainingCenterManagementMenu.escolhaItem(-10);
			
			Assert.fail("Nao deveria esta passando");
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Menor que o escopo do menu"));
			
		}

	}
	
	@Test
	public void DevePassarEscolha() {
		// acao
		TrainingCenter trainingCenter = null;
		TrainingCenterManagementMenu trainingCenterManagementMenu = new TrainingCenterManagementMenu(trainingCenter);
		//cenario
		try {
			int result =trainingCenterManagementMenu.escolhaItem(2);
			
			Assert.assertEquals(result,2);
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.fail("Nao deveria esta passando");
			
		}

	}

}
