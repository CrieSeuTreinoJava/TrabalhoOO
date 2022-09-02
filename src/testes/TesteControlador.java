package testes;

import java.util.ArrayList;

import controlador.ControladorExercicio;
import controlador.ControladorTreino;
import view.TelaInicial;

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
    controladorExercicio.criarExercicioPeso("Bracinho", "Bicepawds unilateral", "Bíceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Bracinho", "Bicwadeps unilateral", "Bíceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Bracinho", "Biceawsadps unilateral", "Bíceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Bracinho", "Biceweps unilateral", "Bíceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Bracinho", "Biceaawddps unilateral", "Bíceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Costas", "Remada sincera", "Posterior do ombro", 12, 4, 20);
    // Editar exercicio

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
    new TelaInicial();
  }
}