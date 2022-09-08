package exercicio;

import java.util.ArrayList;

/**
 * Treino é uma classe que representa um treino de um usuário, armazenando os
 * exercícios.
 * Esta classe possui os atributos nome,
 * exerciciosPeso(uma lista de exercicio com peso) e
 * exerciciosSemPeso(uma lista de exercicio sem peso).
 */
public class Treino {

	private String nome;

	private ArrayList<ExercicioPeso> exerciciosPeso;
	private ArrayList<ExercicioSemPeso> exerciciosSemPeso;

	/**
	 * Instância um objeto Treino com o nome passado como parâmetro.
	 * Além disso, inicializa as listas de exerciciosPeso e exerciciosSemPeso.
	 */
	public Treino(String nome) {
		this.nome = nome;
		this.exerciciosPeso = new ArrayList<ExercicioPeso>();
		this.exerciciosSemPeso = new ArrayList<ExercicioSemPeso>();
	}

	/**
	 * Este método válida se um exercicio com peso já existe no treino baseado no
	 * parametro
	 * nome.
	 * Caso não exista, adiciona o exercicio à lista exerciciosPeso.
	 * 
	 * @throws Exceção caso o exercicio já exista no treino.
	 */
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

	/**
	 * Este método válida se um exercicio sem peso já existe no treino baseado no
	 * parametro
	 * nome.
	 * Caso não exista, adiciona o exercicio à lista exerciciosSemPeso.
	 * 
	 * @throws Exceção caso o exercicio já exista no treino.
	 */
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

	/**
	 * Esse método serve para editar os atributos de um exercicio com peso.
	 * ele determina o exercicio a ser editado baseado no nome passado como
	 * parâmetro.
	 */
	public ExercicioPeso editarExercicioPeso(String nome, String musculo, int repeticao, int sets, int peso) {
		// editar exercicio escolhendo por nome do exercicio com peso
		for (ExercicioPeso exercicio : this.exerciciosPeso) {
			if (exercicio.getNome().equals(nome)) {
				exercicio.setMusculo(musculo);
				exercicio.setRepeticao(repeticao);
				exercicio.setSets(sets);
				exercicio.setPeso(peso);
				return exercicio;
			}
		}
		return null;
	}

	/**
	 * Esse método serve para editar os atributos de um exercicio sem peso.
	 * ele determina o exercicio a ser editado baseado no nome passado como
	 * parâmetro.
	 */
	public ExercicioSemPeso editarExercicioSemPeso(String nome, String musculo, int repeticao, double tempo, double distancia) {
		// editar exercicio escolhendo por nome do exercicio sem peso
		for (ExercicioSemPeso exercicio : this.exerciciosSemPeso) {
			if (exercicio.getNome().equals(nome)) {
				exercicio.setMusculo(musculo);
				exercicio.setRepeticao(repeticao);
				exercicio.setTempo(tempo);
				exercicio.setDistancia(distancia);
			return exercicio;
			}
		}
		return null;
	}

	/**
	 * Esse método serve para remover um exercicio com peso.
	 * ele determina o exercicio a ser removido baseado no nome passado como
	 * parâmetro.
	 * 
	 * @return true caso o exercicio seja removido com sucesso.
	 * @return false caso o exercicio não seja removido.
	 */
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

	/**
	 * Esse método serve para remover um exercicio sem peso.
	 * ele determina o exercicio a ser removido baseado no nome passado como
	 * parâmetro.
	 * 
	 * @return true caso o exercicio seja removido com sucesso.
	 * @return false caso o exercicio não seja removido.
	 */
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

	public ArrayList<ExercicioPeso> getExerciciosPeso() {
		return exerciciosPeso;
	}

	public ArrayList<ExercicioSemPeso> getExerciciosSemPeso() {
		return exerciciosSemPeso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setExerciciosPeso(ArrayList<ExercicioPeso> exerciciosPeso) {
		this.exerciciosPeso = exerciciosPeso;
	}

	public void setExerciciosSemPeso(ArrayList<ExercicioSemPeso> exerciciosSemPeso) {
		this.exerciciosSemPeso = exerciciosSemPeso;
	}

}
