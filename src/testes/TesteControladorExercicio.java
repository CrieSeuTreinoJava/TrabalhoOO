package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controlador.ControladorExercicio;
import controlador.ControladorTreino;
import exercicio.ExercicioPeso;

class TesteControladorExercicio {

	ControladorTreino controladorTreino = new ControladorTreino();
	ControladorExercicio controladorExercicioPeso = new ControladorExercicio();
	
	
	@Test
	void testCriarExercicioPeso() {
		controladorTreino.criarTreino("Terca");
		ArrayList<ExercicioPeso> exercicios = controladorExercicioPeso.criarExercicioPeso("Terca", "Biceps uni lateral", "biceps",12, 12, 12);
		System.out.println(exercicios.get(0).getNome());
		assertEquals("Biceps uni lateral", exercicios.get(0).getNome());
	}

	@Test
	void testCriarExercicioSemPeso() {
		fail("Not yet implemented");
	}

	@Test
	void testEditarExercicioPeso() {
		fail("Not yet implemented");
	}

	@Test
	void testEditarExercicioSemPeso() {
		fail("Not yet implemented");
	}

}
