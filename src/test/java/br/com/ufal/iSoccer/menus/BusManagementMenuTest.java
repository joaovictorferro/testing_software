package br.com.ufal.iSoccer.menus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.ufal.iSoccer.adminsystem.BusManagement;
import br.com.ufal.iSoccer.physicalResources.Bus;

public class BusManagementMenuTest {

	@Test
	public void DeveSerMaiorQueEscopo() {
		// acao
		Bus bus = new Bus();
		BusManagementMenu busManagementMenu = new BusManagementMenu(bus);
		
		//cenario
		try {
			busManagementMenu.escolhaItem(10);
			
			Assert.fail("Nao deveria esta passando");
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Maior que o escopo do menu"));
			
		}

	}
	
	@Test
	public void DeveSerMenorQueEscopo() {
		// acao
		Bus bus = new Bus();
		BusManagementMenu busManagementMenu = new BusManagementMenu(bus);
		
		//cenario
		try {
			busManagementMenu.escolhaItem(-10);
			
			Assert.fail("Nao deveria esta passando");
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Menor que o escopo do menu"));
			
		}

	}
	
	@Test
	public void DevePassarEscolha() {
		// acao
		Bus bus = new Bus();
		BusManagementMenu busManagementMenu = new BusManagementMenu(bus);
		
		//cenario
		try {
			int result = busManagementMenu.escolhaItem(3);
			
			Assert.assertEquals(result,3);
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.fail("Nao deveria esta passando");
			
		}

	}
}
