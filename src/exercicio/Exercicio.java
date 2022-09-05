package exercicio;

/**
 * Classe abstrata, possui os atributos e métodos comuns a todos os exercícios.
 * 
 */
public abstract class Exercicio {

	private String nome;

	private String musculo;

	private int repeticao;

	/**
	 * Construtor da classe Exercicio.
	 * Atribui valores para os atributos nome, musculo e repeticao de um exercicio.
	 * 
	 * @params nome, musculo, repeticao
	 */
	public Exercicio(String nome, String musculo, int repeticao) {
		this.nome = nome;
		this.musculo = musculo;
		this.repeticao = repeticao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMusculo() {
		return musculo;
	}

	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}

	public int getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(int repeticao) {
		this.repeticao = repeticao;
	}

}