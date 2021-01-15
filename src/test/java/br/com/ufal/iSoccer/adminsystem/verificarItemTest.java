package br.com.ufal.iSoccer.adminsystem;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class verificarItemTest {
    @Test
    public void DevePassarStringNumerica(){
        try {
            verificarItem.verificarString("nfjnfdkjngkfdjgfd",256,1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void NaoDevePassarStringNumericaVazia(){
        try {
            verificarItem.verificarString("",256,1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(),is("Esta vazio"));
        }
    }

    @Test
    public void NaoDevePassarStringNumericaMuitoGrande(){
        try {
            verificarItem.verificarString("fdsnfdsjkndskfndsfkjsdfkjasasassdfgfdgkfdjgdfghfiudghiuhfguifhdiguhdfiugnhfdiugnauigfuiagnfduigbfidugbaignbuaigbaigbigngubiaguiagnuaigbauifgbfuiagbfiuabgiuagbdjgbnuifdvbfuidvbfudibguaibgfudibgiuadfgbudagbiudgbiadgbiugbiaugbiubiubiaugbiuagbiubgafgbidgbifdbguiadd",256,1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(),is("Passou da capacidade limite"));
        }
    }

    @Test
    public void NaoDeveSerMaiorQueEscopo(){
        try {
            verificarItem.verificarOption(10,5,1);
            //verificacao
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(), is("Maior que o escopo da option"));

        }
    }

    @Test
    public void NaoDeveSerMenorQueEscopo(){
        try {
            verificarItem.verificarOption(-10,10,1);
            //verificacao
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(), is("Menor que o escopo da option"));

        }
    }

    @Test
    public void DevePassarOption() {
        try {
            verificarItem.verificarOption(5,10,1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void DevePassaStringNumerica(){
        try {
            verificarItem.verificarStringNumerica("12345678911",11);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void NaoDeveSerMaiorQueStringNumerica(){
        try {
            verificarItem.verificarStringNumerica("123456789112",11);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(),is("String numerica Errada"));
        }
    }

    @Test
    public void NaoDeveTerLetraNaString(){
        try {
            verificarItem.verificarStringNumerica("123456a7891",11);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertThat(e.getMessage(),is("Letra encontrado na String"));
        }
    }
}