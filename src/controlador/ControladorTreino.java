package controlador;

import dados.Database;
import exercicio.Treino;

/**
 * 
 * Faz a relação entre a interface e a classe Treino.
 * Para realizar as operações de CRUD de treino.
 */
public class ControladorTreino {

  private Database database;

  /**
   * Construtor da classe ControladorExercicio.
   * Recebe a instância da classe Database.
   */
  public ControladorTreino() {
    this.database = Database.getInstance();
  }

  /**
   * Esse metodo valida se um treino com o nome passado como parametro ja existe.
   * caso não exista, cria um novo treino e adiciona no banco de dados.
   */
  public void criarTreino(String nome) {
    if (this.database.getTreino(nome) == null) {
      this.database.criarNovoTreino(nome);
    } else {
      System.out.println("O nome do treino já está cadastrado, utilize outro nome!");
    }
  }

  /**
   * Determina o treino a partir do nome passado como parâmetro.
   * Se o treino existir, remove o treino do banco de dados.
   */
  public void apagarTreino(String nome) {
    if (this.database.getTreino(nome) != null) {
      this.database.apagarTreino(nome);
    } else {
      System.out.println("O treino não existe!");
    }
  }

  /**
   * Determina o treino a partir do nome passado como parâmetro.
   * Se o treino existir, recebe o novo nome e atualiza o treino.
   */
  public void editarTreino(String nome, String novoNome) {
    if (this.database.getTreino(nome) != null) {
      this.database.editarTreino(nome, novoNome);
    } else {
      System.out.println("O treino não existe!");
    }
  }

  public Treino getTreino(String nome) {
    return this.database.getTreino(nome);
  }

  /**
   * Retorna uma lista com o nome de todos os treinos cadastrados.
   */
  public String[] listarTreinos() {
    this.database = Database.getInstance();
    return this.database.getTreinos();
  }

}
