package br.com.ufal.iSoccer.menus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.ufal.iSoccer.physicalResources.Stadium;

public class StadiumManagementMenuTest {

	@Test
	public void DeveSerMaiorQUeEscopo() {
		//acao
		Stadium stadium = null;
		StadiumManagementMenu stadiumManagementMenu = new StadiumManagementMenu(stadium);
		
		//cenario
		try {
			stadiumManagementMenu.escolhaItem(10);
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
		Stadium stadium = null;
		StadiumManagementMenu stadiumManagementMenu = new StadiumManagementMenu(stadium);
		
		//cenario
		try {
			stadiumManagementMenu.escolhaItem(-10);
			
			Assert.fail("Nao deveria esta passando");
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Menor que o escopo do menu"));
			
		}

	}
	
	@Test
	public void DevePassarEscolha() {
		// acao
		Stadium stadium = null;
		StadiumManagementMenu stadiumManagementMenu = new StadiumManagementMenu(stadium);
		
		//cenario
		try {
			int result =stadiumManagementMenu.escolhaItem(2);
			
			Assert.assertEquals(result,2);
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.fail("Nao deveria esta passando");
			
		}

	}

}
