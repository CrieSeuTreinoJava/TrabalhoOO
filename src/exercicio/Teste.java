package exercicio;

public class Teste {

	public static void main(String[] args) {
		Treino perna = new Treino("Perna");
		perna.criarNovoExercicioPeso("Cadeira Extensora", "Perna", 10, 3, 50);
		perna.criarNovoExercicioSemPeso("Agachamento", "Perna", 10, 2, 100);
		perna.criarNovoExercicioPeso("Cadeira Extensora", "Perna", 10, 3, 50);
		perna.editarExercicioPeso("Cadeira Extensora", 0, 0, 0);

		for (ExercicioPeso exercicio : perna.getExerciciosPeso()) {
			exercicio.imprimir();
		}
		for (ExercicioSemPeso exercicio : perna.getExerciciosSemPeso()) {
			exercicio.imprimir();
		}
	}

}
