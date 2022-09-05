package exercicio;

/**
 * ExercicioSemPeso é uma classe que extende a classe Exercicio,
 * é uma classe que serve de modelo para exercicios sem peso.
 * Esta classe possui os atributos tempo e distância.
 */
public class ExercicioSemPeso extends Exercicio {

	private double tempo;

	private double distancia;

	/**
	 * Construtor da classe ExercicioSemPeso.
	 * Atribui valores para os atributos nome, musculo, repeticao, tempo e distancia
	 * de um
	 * exercicio.
	 * Para atribuir os valores: nome, musculo e repeticao, utiliza o construtor da
	 * classe pai Exercicio.
	 */
	public ExercicioSemPeso(String nome, String musculo, int repeticao, double parametroTempo,
			double parametroDistancia) {
		super(nome, musculo, repeticao);
		tempo = parametroTempo;
		distancia = parametroDistancia;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	/**
	 * @deprecated
	 *             Método imprimir imprime os atributos de um exercicio.
	 */
	public void imprimir() {
		System.out.println("Nome: " + getNome());
		System.out.println("Musculo: " + getMusculo());
		System.out.println("Repeticao: " + getRepeticao());
		System.out.println("Tempo: " + getTempo());
		System.out.println("Distancia: " + getDistancia());
	}
}
