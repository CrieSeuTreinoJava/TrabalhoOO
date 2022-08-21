package controlador;

import java.util.ArrayList;

import dados.Database;
import exercicio.Treino;

public class ControladorTreino {

  private Database database;

  public void criarTreino(String nome) {
    this.database = Database.getInstance();
    if (this.database.getTreino(nome) == null) {
      this.database.criarNovoTreino(nome);
    } else {
      System.out.println("O nome do treino já está cadastrado, utilize outro nome!");
    }
  }

  public void apagarTreino(String nome) {
    this.database = Database.getInstance();
    if (this.database.getTreino(nome) != null) {
      this.database.apagarTreino(nome);
    } else {
      System.out.println("O treino não existe!");
    }
  }

  public void editarTreino(String nome, String novoNome) {
    this.database = Database.getInstance();
    if (this.database.getTreino(nome) != null) {
      this.database.editarTreino(nome, novoNome);
    } else {
      System.out.println("O treino não existe!");
    }
  }

  public ArrayList<Treino> listarTreinos() {
    this.database = Database.getInstance();
    return this.database.getTreinos();
  }

}
