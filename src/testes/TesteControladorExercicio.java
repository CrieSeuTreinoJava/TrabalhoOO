package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controlador.ControladorExercicio;
import controlador.ControladorTreino;
import exercicio.ExercicioPeso;
import exercicio.ExercicioSemPeso;

class TesteControladorExercicio {

		ControladorExercicio controladorExercicioPeso = new ControladorExercicio();
		ControladorExercicio controladorExercicioSemPeso = new ControladorExercicio();
		ControladorTreino controladorTreino = new ControladorTreino();

	
	
	@Test
	void testCriarExercicioPeso() {
		controladorTreino.criarTreino("Terca");
		ArrayList<ExercicioPeso> exercicios = controladorExercicioPeso.criarExercicioPeso("Terca", "Biceps uni lateral", "biceps",12, 12, 12);
		System.out.println(exercicios.get(0).getNome());
		assertEquals("Biceps uni lateral", exercicios.get(0).getNome());
	}

	@Test
	void testCriarExercicioSemPeso() {
		controladorTreino.criarTreino("Quarta");
		ArrayList<ExercicioSemPeso> exercicios = controladorExercicioSemPeso.criarExercicioSemPeso("Quarta", "Corrida", "Coracao", 1, 30, 5);
		System.out.println(exercicios.get(0).getNome());
		assertEquals("Corrida", exercicios.get(0).getNome());
	}

	/*
	 * @Test void testEditarExercicioPeso() { fail("Not yet implemented"); }
	 * 
	 * @Test void testEditarExercicioSemPeso() { fail("Not yet implemented"); }
	 */

}
