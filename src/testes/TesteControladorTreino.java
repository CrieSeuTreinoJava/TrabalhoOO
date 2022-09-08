package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import controlador.ControladorTreino;
import exercicio.Treino;

class TesteControladorTreino {

	ControladorTreino controladorTreino = new ControladorTreino();
	
	@Test
	void testCriarTreino() {
		assertTrue(controladorTreino.criarTreino("Bracinho"));
		assertTrue(controladorTreino.criarTreino("Perna"));
		assertTrue(controladorTreino.criarTreino("Peito"));
		assertFalse(controladorTreino.criarTreino("Bracinho"));
	
	}

	@Test
	void testEditarTreino() {

		Treino treinoAtualizadoJaExiste = controladorTreino.editarTreino("Bracinho", "Perna");
		assertNull(treinoAtualizadoJaExiste);
		
		Treino treinoAtualizadoCerto = controladorTreino.editarTreino("Perna", "quadriceps");
		assertEquals("quadriceps", treinoAtualizadoCerto.getNome());
		
		Treino treinoNaoExiste = controladorTreino.editarTreino("triceps", "biceps");
		assertNull(treinoNaoExiste);
	
	}

	 @Test void testApagarTreino() { 
		 assertTrue(controladorTreino.apagarTreino("Peito"));
		 assertFalse(controladorTreino.apagarTreino("Não existe"));
		 }

	 @Test 
	 void testListarTreinos() { 
		 String[] listar = controladorTreino.listarTreinos(); 
		 assertArrayEquals(new String[]{"Bracinho", "quadriceps"}, listar);
	 } 
	 
}
