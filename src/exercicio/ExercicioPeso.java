package exercicio;

/**
 * ExercicioPeso é uma classe que extende a classe Exercicio,
 * é uma classe que serve de modelo para exercicios com peso.
 * Esta classe possui os atributos peso e sets.
 */
public class ExercicioPeso extends Exercicio {

	private int sets;

	private int peso;

	/**
	 * Construtor da classe ExercicioPeso.
	 * Atribui valores para os atributos nome, musculo, repeticao, sets e peso de um
	 * exercicio.
	 * Para atribuir os valores: nome, musculo e repeticao, utiliza o construtor da
	 * classe pai Exercicio.
	 */
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

	/**
	 * @deprecated
	 *             Método imprimir imprime os atributos de um exercicio.
	 */
	public void imprimir() {
		System.out.println("Nome: " + getNome());
		System.out.println("Musculo: " + getMusculo());
		System.out.println("Repeticao: " + getRepeticao());
		System.out.println("Sets: " + getSets());
		System.out.println("Peso: " + getPeso());
	}
}
