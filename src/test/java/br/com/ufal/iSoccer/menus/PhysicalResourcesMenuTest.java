package br.com.ufal.iSoccer.menus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.ufal.iSoccer.physicalResources.Bus;
import br.com.ufal.iSoccer.physicalResources.Stadium;
import br.com.ufal.iSoccer.physicalResources.TrainingCenter;

public class PhysicalResourcesMenuTest {

	@Test
	public void DeveSerMaiorQUeEscopo() {
		//acao
		Bus bus = null;// = new Bus(true,true);
		Stadium stadium = null;
		TrainingCenter trainingCenter = null;
		PhysicalResourcesMenu physicalResourcesMenu = new PhysicalResourcesMenu();
		
		//cenario
		try {
			physicalResourcesMenu.escolhaItem(10);
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
		Bus bus = null;// = new Bus(true,true);
		Stadium stadium = null;
		TrainingCenter trainingCenter = null;
		PhysicalResourcesMenu physicalResourcesMenu = new PhysicalResourcesMenu();
		
		//cenario
		try {
			physicalResourcesMenu.escolhaItem(-10);
			
			Assert.fail("Nao deveria esta passando");
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Menor que o escopo do menu"));
			
		}

	}
	
	@Test
	public void DevePassarEscolha() {
		// acao
		Bus bus = null;// = new Bus(true,true);
		Stadium stadium = null;
		TrainingCenter trainingCenter = null;
		PhysicalResourcesMenu physicalResourcesMenu = new PhysicalResourcesMenu();
		
		//cenario
		try {
			int result = physicalResourcesMenu.escolhaItem(2);
			
			Assert.assertEquals(result,2);
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.fail("Nao deveria esta passando");
			
		}

	}

}
