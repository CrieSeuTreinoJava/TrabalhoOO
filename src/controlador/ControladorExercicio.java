package controlador;

import java.util.ArrayList;

import dados.Database;
import exercicio.ExercicioPeso;
import exercicio.ExercicioSemPeso;
import exercicio.Treino;

public class ControladorExercicio {
  private Database database;
  
  
  public ControladorExercicio() {
	  this.database = Database.getInstance();
  }

  public void criarExercicioPeso(String treino, String nome, String musculo, int repeticao, int sets, int peso) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.criarNovoExercicioPeso(nome, musculo, repeticao, sets, peso);
  }

  public void criarExercicioSemPeso(String treino, String nome, String musculo, int repeticao, double tempo,
      double distancia) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.criarNovoExercicioSemPeso(nome, musculo, repeticao, tempo, distancia);
  }

  public void editarExercicioPeso(String treino, String nome, String musculo, int repeticao, int sets, int peso) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.editarExercicioPeso(nome, musculo, repeticao, sets, peso);
  }

  public void editarExercicioSemPeso(String treino, String nome, String musculo, int repeticao, double tempo,
      double distancia) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.editarExercicioSemPeso(nome, musculo, repeticao, tempo, distancia);
  }

  public void apagarExercicioPeso(String treino, String nome) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.apagarExercicioPeso(nome);
  }

  public void apagarExercicioSemPeso(String treino, String nome) {
    Treino treinoSelecionado = this.database.getTreino(treino);
    treinoSelecionado.apagarExercicioSemPeso(nome);
  }

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
}
