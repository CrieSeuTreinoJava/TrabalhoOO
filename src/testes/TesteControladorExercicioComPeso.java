package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import controlador.ControladorExercicio;
import controlador.ControladorTreino;
import exercicio.ExercicioPeso;
import exercicio.ExercicioSemPeso;

class TesteControladorExercicioComPeso {
	ControladorExercicio controladorExercicio = new ControladorExercicio();
	ControladorTreino controladorTreino = new ControladorTreino();

	@Test
	void testCriarExercicioPeso() {
		controladorTreino.criarTreino("Terca");
		ArrayList<ExercicioPeso> exercicios = controladorExercicio.criarExercicioPeso("Terca", "Biceps uni lateral",
				"biceps", 12, 12, 12);
		System.out.println(exercicios.get(0).getNome());
		assertEquals("Biceps uni lateral", exercicios.get(0).getNome());
	}

	@Test
	void testEditarExercicioPeso() {
		controladorTreino.criarTreino("Quinta");
		controladorExercicio.criarExercicioPeso("Quinta", "Agachamento com Peso", "Coracao", 1, 30, 5);
		ExercicioPeso exercicioEditado = controladorExercicio.editarExercicioPeso("Quinta", "Agachamento com Peso",
				"gluteo", 15, 3, 30);
		assertEquals("gluteo", exercicioEditado.getMusculo());

	}

}
