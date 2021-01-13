package br.com.ufal.iSoccer.menus;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class FanMenuManagementTest {

	@Test
	public void deveSerMaiorQueEscopo() {
		//cenario
		FanMenuManagement  fanMenuManagement = new  FanMenuManagement();
		
		 //acao
		 try {
			 fanMenuManagement.escolhaItem(8);
			
			//verificacao
			Assert.fail("Nao deveria esta passando");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Maior que o escopo do menu"));
		}

	}
	
	@Test
	public void deveSerMenorQueEscopo() {
		//cenario
		FanMenuManagement  fanMenuManagement = new  FanMenuManagement();
		
		 //acao
		 try {
			 fanMenuManagement.escolhaItem(-8);
			
			//verificacao
			Assert.fail("Nao deveria esta passando");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertThat(e.getMessage(), is("Menor que o escopo do menu"));
		}

	}
	
	@Test
	public void devePassarEscolha() {
		//cenario
		FanMenuManagement  fanMenuManagement = new  FanMenuManagement();
		
		 //acao
		 try {
				int result = fanMenuManagement.escolhaItem(2);
				
				//verificacao
				Assert.assertEquals(result,2);
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Nao deveria esta passando");
			}

		}

}
