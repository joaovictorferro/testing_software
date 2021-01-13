package br.com.ufal.iSoccer.menus;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeMenuManagementTest {
	
	@Test
	public void deveSerMaiorQueEscopo() {
		//cenario
		 EmployeeMenuManagement  employeeMenuManagement = new  EmployeeMenuManagement();
		
		 //acao
		 try {
			employeeMenuManagement.escolhaItem(8);
			
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
		 EmployeeMenuManagement  employeeMenuManagement = new  EmployeeMenuManagement();
		
		 //acao
		 try {
			employeeMenuManagement.escolhaItem(-8);
			
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
		 EmployeeMenuManagement  employeeMenuManagement = new  EmployeeMenuManagement();
		
		 //acao
		 try {
			int result = employeeMenuManagement.escolhaItem(3);
			
			//verificacao
			Assert.assertEquals(result,3);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Nao deveria esta passando");
		}

	}
}