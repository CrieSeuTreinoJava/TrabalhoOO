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
   */
  public ControladorTreino() {
    this.database = Database.getInstance();
  }

  /**
   * Esse metodo valida se um treino com o nome passado como parametro ja existe.
   * caso não exista, cria um novo treino e adiciona no banco de dados.
   */
  public boolean criarTreino(String nome) {
    if (this.database.getTreino(nome) == null) {
      this.database.criarNovoTreino(nome);
      return true;
    } else {
      System.out.println("O nome do treino já está cadastrado, utilize outro nome!");
      return false;
    }
  }

  /**
   * Determina o treino a partir do nome passado como parâmetro.
   * Se o treino existir, remove o treino do banco de dados.
   */
  public boolean apagarTreino(String nome) {
    if (this.database.getTreino(nome) != null) {
      this.database.apagarTreino(nome);
      return true;
    } else {
      System.out.println("O treino não existe!");
      return false;
    }
  }

  /**
   * Determina o treino a partir do nome passado como parâmetro.
   * Se o treino existir, recebe o novo nome e atualiza o treino.
   */
  public Treino editarTreino(String nome, String novoNome) {
    if (this.database.getTreino(nome) != null) {
      if (this.database.getTreino(novoNome) == null) {
        this.database.editarTreino(nome, novoNome);
        return this.database.getTreino(novoNome);
      } else {
        System.out.println("O nome do treino já está cadastrado, utilize outro nome!");
        return null;
      }

    } else {
      System.out.println("O treino não existe!");
      return null;
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
