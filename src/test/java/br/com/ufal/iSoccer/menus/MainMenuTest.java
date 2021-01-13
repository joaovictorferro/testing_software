package br.com.ufal.iSoccer.menus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainMenuTest {
	
	@Before
	public void setup() { }
	
	@Test
	public void DeveSerMaiorQueEscopo(){
		//acao
		MainMenu mainMenu = new MainMenu();
		
		//cenario
		try {
			 mainMenu.escolhaItem(10);
			//verificacao
			Assert.fail("Nao deveria esta passando");
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Maior que o escopo do menu"));
			
		}
	}
	
	@Test
	public void DeveSerMenorQueEscopo(){
		//acao
		MainMenu mainMenu = new MainMenu();
		
		//cenario
		try {
			mainMenu.escolhaItem(-10);
			//verificacao
			Assert.fail("Nao deveria esta passando");
		} catch (Exception e) {	
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Menor que o escopo do menu"));
			
		}
	}
	
	@Test
	public void DevePassarEscolha() {
		//acao
		MainMenu mainMenu = new MainMenu();
				
				//cenario
				try {
					int result = mainMenu.escolhaItem(5);
					//verificacao
					Assert.assertEquals(result,5);
				} catch (Exception e) {	
					e.printStackTrace();
					
					Assert.fail("Nao deveria esta passando");
				}
	}
}
