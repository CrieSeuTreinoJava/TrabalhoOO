package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controlador.ControladorExercicio;
import controlador.ControladorTreino;
import exercicio.ExercicioSemPeso;

public class TesteControladorExercicioSemPeso {
	ControladorExercicio controladorExercicio = new ControladorExercicio();
	ControladorTreino controladorTreino = new ControladorTreino();
	
	@Test
	void testCriarExercicioSemPeso() {
		controladorTreino.criarTreino("Quarta");
		ArrayList<ExercicioSemPeso> exercicios = controladorExercicio.criarExercicioSemPeso("Quarta", "Corrida", "Coracao",
				1, 30, 5);
		System.out.println(exercicios.get(0).getNome());
		assertEquals("Corrida", exercicios.get(0).getNome());
	}
	

	@Test
	void testEditarExercicioSemPeso() {
		controladorTreino.criarTreino("Sexta");
		controladorExercicio.criarExercicioSemPeso("Sexta", "Corridona", "Coracao", 1, 30, 5);
		ExercicioSemPeso exercicioEditado = controladorExercicio.editarExercicioSemPeso("Sexta", "Corridona",
				"coracao sofredor", 1, 60, 10);
		assertEquals("coracao sofredor", exercicioEditado.getMusculo());

	}
}
