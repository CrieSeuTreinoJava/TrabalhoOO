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
		controladorTreino.criarTreino("Bracinho");
		controladorTreino.criarTreino("Perna");
		controladorTreino.criarTreino("Peito");
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

	/*
	 * @Test String[] testListarTreinos() { return
	 * controladorTreino.listarTreinos(); }
	 * 
	 * @Test void testApagarTreino() { controladorTreino.apagarTreino("Peito"); }
	 */
}
