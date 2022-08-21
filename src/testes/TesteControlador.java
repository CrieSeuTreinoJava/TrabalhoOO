package testes;

import java.util.ArrayList;

import controlador.ControladorExercicio;
import controlador.ControladorTreino;
import exercicio.Treino;

public class TesteControlador {
  public static void main(String[] args) {
    ControladorTreino controladorTreino = new ControladorTreino();
    ControladorExercicio controladorExercicio = new ControladorExercicio();

    // Criar um treino
    controladorTreino.criarTreino("Perna");
    controladorTreino.criarTreino("Braço");
    controladorTreino.criarTreino("Cardio");
    controladorTreino.criarTreino("Costas");
    // Editar treino
    controladorTreino.editarTreino("Braço", "Bracinho");
    // Apagar treino
    controladorTreino.apagarTreino("Perna");

    // -----------------------------------------------------------------------------------------------------------------------------

    // Criar exercicios
    controladorExercicio.criarExercicioPeso("Bracinho", "Biceps unilateral", "Bíceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Costas", "Remada sincera", "Posterior do ombro", 12, 4, 20);
    // Editar exercicio
    controladorExercicio.editarExercicioPeso("Bracinho", "Biceps unilateral", "Bíceps", 10, 3, 50);
    // Apagar exercicio
    // controladorExercicio.apagarExercicioPeso("Costas", "Remada sincera");

    // -----------------------------------------------------------------------------------------------------------------------------

    // Listar treinos
    // ArrayList<Treino> treinos = controladorTreino.listarTreinos();
    // for (Treino treino : treinos) {
    // System.out.println(treino.getNome());
    // }

    // Listar exercicios
    ArrayList<String> exercicios = controladorExercicio.listarExercicios("Costas");
    for (String exercicio : exercicios) {
      System.out.println(exercicio);
    }
  }
}