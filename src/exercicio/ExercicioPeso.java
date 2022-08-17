package exercicio;

public class ExercicioPeso extends Exercicio {

	private int sets;

	private int peso;

	public ExercicioPeso(String nome, String musculo, int repeticao, int parametroSets, int parametroPeso) {
		super(nome, musculo, repeticao);
		sets = parametroSets;
		peso = parametroPeso;

	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void imprimir() {
		System.out.println("Nome: " + getNome());
		System.out.println("Musculo: " + getMusculo());
		System.out.println("Repeticao: " + getRepeticao());
		System.out.println("Sets: " + getSets());
		System.out.println("Peso: " + getPeso());
	}
}
