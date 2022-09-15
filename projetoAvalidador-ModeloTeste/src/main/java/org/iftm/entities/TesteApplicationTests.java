package org.iftm.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.iftm.entities.Avaliador;
import org.iftm.entities.Leilao;
import org.iftm.entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AvaliadorTest {
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Usuario usuario4;
	private Leilao leilao;
	private Avaliador avaliador;
	
// @BeforeEach força execução do método antes da execução de cada teste 
	@BeforeEach
	public void instanciarObjetos() {
		usuario1 = new Usuario("Shirley");
		usuario2 = new Usuario("Edna");
		usuario3 = new Usuario("Laiane");
		usuario4 = new Usuario("Cristina");
		leilao = new Leilao("Computador Apple");
		avaliador = new Avaliador();
	}
	
	@Test
	public void testaBuscarMaiorLanceSemOrdem() {
		//Entradas > criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance2 = new Lance(usuario2, 400.0000001);
		Lance lance3 = new Lance(usuario3, 250);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		double resultadoEsperado = 400.00;
		
		//execução
		avaliador.avalia(leilao); 
		double resultadoObtido = avaliador.getMaiorLance();
		
		//comparação
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}
	
	@Test
	public void testaBuscarMaiorLanceOrdemCrescente() {
		//Entradas > criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance3 = new Lance(usuario3, 250);
		Lance lance2 = new Lance(usuario2, 400);
		leilao.propoe(lance3);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		
		
		double resultadoEsperado = 400.00;
		
		//execução
		avaliador.avalia(leilao); 
		double resultadoObtido = avaliador.getMaiorLance();
		
		//comparação
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}
	
	@Test
	public void testaBuscarSemLances() {
		//Entradas > criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance2 = new Lance(usuario2, 400.0000001);
		Lance lance3 = new Lance(usuario3, 250);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		double resultadoEsperado = Double.NEGATIVE_INFINITY;
		
		//execução
		avaliador.avalia(leilao); 
		double resultadoObtido = avaliador.getMenorLance();
		
		//comparação
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}
	
	
	@Test
	public void testaBuscarMenorLanceSemOrdem() {
		//Entradas > criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance3 = new Lance(usuario3, 250);
		Lance lance2 = new Lance(usuario2, 400);
		// criar lances
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		
		double resultadoEsperado = 250.00;
		
		//execução
		avaliador.avalia(leilao); 
		double resultadoObtido = avaliador.getMenorLance();
		
		//comparação
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);				
		
	}
	@Test
	public void testaBuscarMenorLanceOrdemCrescente() {
		//Entradas > criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance3 = new Lance(usuario3, 250);
		Lance lance2 = new Lance(usuario2, 400);
		leilao.propoe(lance3);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		
		//execução
		avaliador.avalia(leilao);
		
		double resultadoEsperado = 250.00; 
		double resultadoObtido = avaliador.getMenorLance();
		
		//comparação
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}
	
	@Test
	public void testaBuscarMenorLanceDecrescente() {
		//Entradas > criar os lances e o resultado esperado
		Lance lance1 = (new Lance(usuario1, 300));
		Lance lance3 = (new Lance(usuario3, 250));
		Lance lance2 = (new Lance(usuario2, 400));
		//criar lances
		leilao.propoe(lance3);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		
		double resultadoEsperado = 250.00;
		
		//execução
		avaliador.avalia(leilao); 
		double resultadoObtido = avaliador.getMenorLance();
		
		//comparação
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);				
		
	}
	@Test
	public void testaBuscarApenasUmLance() {
		//Entradas > criar os lances e o resultado esperado
		Lance lance3 = new Lance(usuario3, 250);
		leilao.propoe(lance3);
		
		
		double resultadoEsperado = 250.00;
		
		//execução
		avaliador.avalia(leilao); 
		double resultadoObtido = avaliador.getMenorLance();
		
		//comparação
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}
	@Test
	public void testaBuscarSemLances() {
		//Entradas > criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance2 = new Lance(usuario2, 400.0000001);
		Lance lance3 = new Lance(usuario3, 250);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		double resultadoEsperado = Double.POSITIVE_INFINITY;
		
		//execução
		avaliador.avalia(leilao); 
		double resultadoObtido = avaliador.getMenorLance();
		
		//comparação
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}
	
}