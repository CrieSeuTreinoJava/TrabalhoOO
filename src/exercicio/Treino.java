package exercicio;

import java.util.ArrayList;

public class Treino {

	private String nome;

	private ArrayList<ExercicioPeso> exerciciosPeso;
	private ArrayList<ExercicioSemPeso> exerciciosSemPeso;

	public Treino(String nome) {
		this.nome = nome;
		this.exerciciosPeso = new ArrayList<ExercicioPeso>();
		this.exerciciosSemPeso = new ArrayList<ExercicioSemPeso>();
	}

	public void criarNovoExercicioPeso(String nome, String musculo, int repeticao, int sets, int peso) {
		// validar se o exercicio ja existe
		boolean foiCriado = false;
		for (Exercicio exercicio : exerciciosPeso) {
			if (exercicio.getNome().equals(nome)) {
				foiCriado = true;
			}
		}
		if (foiCriado == false) {
			ExercicioPeso exercicio = new ExercicioPeso(nome, musculo, repeticao, sets, peso);
			exerciciosPeso.add(exercicio);
		} else {
			System.out.println("O nome deste exercicio já está cadastrado, utilize outro nome!");
		}
	}

	public void criarNovoExercicioSemPeso(String nome, String musculo, int repeticao, double tempo, double distancia) {
		boolean foiCriado = false;
		for (Exercicio exercicio : exerciciosSemPeso) {
			if (exercicio.getNome().equals(nome)) {
				foiCriado = true;
			}
		}
		if (foiCriado == false) {
			ExercicioSemPeso exercicio = new ExercicioSemPeso(nome, musculo, repeticao, tempo, distancia);
			exerciciosSemPeso.add(exercicio);
		} else {
			System.out.println("O nome deste exercicio já está cadastrado, utilize outro nome!");
		}
	}

	public void editarExercicioPeso(String nome, int repeticao, int sets, int peso) {
		// editar exercicio escolhendo por nome do exercicio com peso
		for (ExercicioPeso exercicio : this.exerciciosPeso) {
			if (exercicio.getNome().equals(nome)) {
				exercicio.setRepeticao(repeticao);
				exercicio.setSets(sets);
				exercicio.setPeso(peso);
			}
		}
	}

	public void editarExercicioSemPeso(int repeticao, double tempo, double distancia) {
		// editar exercicio escolhendo por nome do exercicio sem peso
		for (ExercicioSemPeso exercicio : this.exerciciosSemPeso) {
			if (exercicio.getNome().equals(nome)) {
				exercicio.setRepeticao(repeticao);
				exercicio.setTempo(tempo);
				exercicio.setDistancia(distancia);
			}
		}
	}

	public boolean apagarExercicioPeso(String nome) {
		// apagar exercicio escolhendo por nome do exercicio
		for (Exercicio exercicio : this.exerciciosPeso) {
			if (exercicio.getNome().equals(nome)) {
				this.exerciciosPeso.remove(exercicio);
				return true;
			}
		}
		return false;
	}

	public boolean apagarExercicioSemPeso(String nome) {
		// apagar exercicio escolhendo por nome do exercicio
		for (Exercicio exercicio : this.exerciciosSemPeso) {
			if (exercicio.getNome().equals(nome)) {
				this.exerciciosSemPeso.remove(exercicio);
				return true;
			}
		}
		return false;
	}

	// return exercicios;
	public ArrayList<ExercicioPeso> getExerciciosPeso() {
		return exerciciosPeso;
	}

	public ArrayList<ExercicioSemPeso> getExerciciosSemPeso() {
		return exerciciosSemPeso;
	}
}
