package controlador;

import java.util.ArrayList;

import dados.Database;
import exercicio.ExercicioPeso;
import exercicio.ExercicioSemPeso;
import exercicio.Treino;

/**
 * 
 * Faz a relação entre a interface e as classes de exercicios.
 * Para realizar as operações de CRUD de exercício.
 */
public class ControladorExercicio {
  private Database database;

  /**
   * Construtor da classe ControladorExercicio.
   * Recebe a instância da classe Database.
   */
  public ControladorExercicio() {
    this.database = Database.getInstance();
  }

  /**
   * Determina o treino a partir do nome passado como parâmetro.
   * cria um novo exercício com peso e adiciona no treino.
   */
  public void criarExercicioPeso(String treino, String nome, String musculo, int repeticao, int sets, int peso) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.criarNovoExercicioPeso(nome, musculo, repeticao, sets, peso);
  }

  /**
   * Determina o treino a partir do nome passado como parâmetro.
   * cria um novo exercício sem peso e adiciona no treino.
   */
  public void criarExercicioSemPeso(String treino, String nome, String musculo, int repeticao, double tempo,
      double distancia) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.criarNovoExercicioSemPeso(nome, musculo, repeticao, tempo, distancia);
  }

  /**
   * Determina o treino a partir do nome passado como parâmetro.
   * recebe os atributos modificados do exercício com peso e atuliza o exercício.
   */
  public void editarExercicioPeso(String treino, String nome, String musculo, int repeticao, int sets, int peso) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.editarExercicioPeso(nome, musculo, repeticao, sets, peso);
  }

  /**
   * /**
   * Determina o treino a partir do nome passado como parâmetro.
   * recebe os atributos modificados do exercício sem peso e atuliza o exercício.
   */
  public void editarExercicioSemPeso(String treino, String nome, String musculo, int repeticao, double tempo,
      double distancia) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.editarExercicioSemPeso(nome, musculo, repeticao, tempo, distancia);
  }

  /**
   * Determina o treino e o exercicio a partir dos atributos e paga o exercicio
   * com peso.
   */
  public void apagarExercicioPeso(String treino, String nome) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.apagarExercicioPeso(nome);
  }

  /**
   * Determina o treino e o exercicio a partir dos atributos e paga o exercicio
   * sem peso.
   */
  public void apagarExercicioSemPeso(String treino, String nome) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.apagarExercicioSemPeso(nome);
  }

  /**
   * recebe como atributo o nome treino e retorna a lista de exercicios
   * 
   * @deprecated
   */
  public ArrayList<String> listarExercicios(String treino) {
    Treino treinoSelecionado = this.database.getTreino(treino);

    ArrayList<String> exercicios = new ArrayList<String>();

    for (ExercicioPeso exercicioPeso : treinoSelecionado.getExerciciosPeso()) {
      exercicios.add(exercicioPeso.getNome());
    }
    for (ExercicioSemPeso exercicioSemPeso : treinoSelecionado.getExerciciosSemPeso()) {
      exercicios.add(exercicioSemPeso.getNome());
    }
    return exercicios;
  }

  /**
   * recebe como atributo o nome treino e retorna a lista de exercicios com peso
   */
  public ArrayList<ExercicioPeso> getExerciciosPeso(String treino) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    return treinoSelecionado.getExerciciosPeso();
  }

  /**
   * recebe como atributo o nome treino e retorna a lista de exercicios sem peso
   */
  public ArrayList<ExercicioSemPeso> getExerciciosSemPeso(String treino) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    return treinoSelecionado.getExerciciosSemPeso();
  }

}
