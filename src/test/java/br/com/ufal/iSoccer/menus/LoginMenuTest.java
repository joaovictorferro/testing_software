package br.com.ufal.iSoccer.menus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class LoginMenuTest {

	@Test
	public void DeveSerMaiorLogin() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
		try {
			loginMenu.verificarLogin("fdsnfdsjkndskfndsfkjsdfkjasasassdfgfdgkfdjgdfghfiudghiuhfguifhdiguhdfiugnhfdiugnauigfuiagnfduigbfidugbaignbuaigbaigbigngubiaguiagnuaigbauifgbfuiagbfiuabgiuagbdjgbnuifdvbfuidvbfudibguaibgfudibgiuadfgbudagbiudgbiadgbiugbiaugbiubiubiaugbiuagbiubgafgbidgbifdbguiadd");
			//verificacao
			fail("Nao deveria esta passando");
		} catch (Exception e) {
			e.printStackTrace();
			assertThat(e.getMessage(), is("Login muito grande"));
		}
	}
	
	@Test
	public void DeveSerVazioLogin() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
		try {
			loginMenu.verificarLogin("");
			//verificacao
			fail("Nao deveria esta passando");
		} catch (Exception e) {
			e.printStackTrace();
			assertThat(e.getMessage(), is("Esta vazio o Login"));
		}
	}
	
	@Test
	public void DevePassarLogin() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
		try {
			String result = loginMenu.verificarLogin("fdfdsfsfd");
			
			//verificacao
			assertEquals("fdfdsfsfd",result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Nao deveria esta passando");
		}

	}
	
	@Test
	public void DeveSerMaiorPassword() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
		try {
			loginMenu.verificarPassword("fdsnfdsjkndskfndsfkjsdfkjasasassdfgfdgkfdjgdfghfiudghiuhfguifhdiguhdfiugnhfdiugnauigfuiagnfduigbfidugbaignbuaigbaigbigngubiaguiagnuaigbauifgbfuiagbfiuabgiuagbdjgbnuifdvbfuidvbfudibguaibgfudibgiuadfgbudagbiudgbiadgbiugbiaugbiubiubiaugbiuagbiubgafgbidgbifdbguiadd");
			//verificacao
			fail("Nao deveria esta passando");
		} catch (Exception e) {
			e.printStackTrace();
			assertThat(e.getMessage(), is("Maior que o limite de senha aceitavel"));
		}
	}
	
	@Test
	public void DeveSerVazioPassword() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
		try {
			loginMenu.verificarPassword("");
			//verificacao
			fail("Nao deveria esta passando");
		} catch (Exception e) {
			e.printStackTrace();
			assertThat(e.getMessage(), is("Menor que a senha aceitavel"));
		}
	}
	
	@Test
	public void DeveSerMenorPassword() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
		try {
			loginMenu.verificarPassword("12345");
			//verificacao
			fail("Nao deveria esta passando");
		} catch (Exception e) {
			e.printStackTrace();
			assertThat(e.getMessage(), is("Menor que a senha aceitavel"));
		}
	}
	@Test
	public void DevePassarPassword() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
		try {
			String result = loginMenu.verificarPassword("123456789");
			
			//verificacao
			assertEquals("123456789",result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Nao deveria esta passando");
		}

	}
	
	@Test
	public void DeveDaErroSenha() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
		try {
			String result = loginMenu.verificarPassword("123456789");
			
			//verificacao
			assertEquals("123456789",result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Nao deveria esta passando");
		}

	}
	
	@Test
	public void DeveDaErroPassword() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
			boolean result = loginMenu.validateDatasToLogin("admin","6164165");
			
		//verificacao
		assertEquals(false,result);

	}

	@Test
	public void DeveDaErroLogin() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
			boolean result = loginMenu.validateDatasToLogin("fdfdsfds","123");
			
		//verificacao
		assertEquals(false,result);

	}
	
	@Test
	public void DeveAcessarSistema() {
		//cenario
		LoginMenu loginMenu = new LoginMenu();
		
		//acao
			boolean result = loginMenu.validateDatasToLogin("admin","123");
			
		//verificacao
		assertEquals(true,result);

	}
}
