package exercicio;

public class ExercicioSemPeso extends Exercicio {

	private double tempo;

	private double distancia;

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

	public void imprimir() {
		System.out.println("Nome: " + getNome());
		System.out.println("Musculo: " + getMusculo());
		System.out.println("Repeticao: " + getRepeticao());
		System.out.println("Tempo: " + getTempo());
		System.out.println("Distancia: " + getDistancia());
	}
}
