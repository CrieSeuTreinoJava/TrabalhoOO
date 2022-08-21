package dados;

import java.util.ArrayList;

import exercicio.Treino;



public class Database {

  ArrayList<Treino> treinos;
  private static Database instance;

  private Database() {
    this.treinos = new ArrayList<Treino>();
  }

  public static Database getInstance() {
    if (instance == null) {
      instance = new Database();
    }
    return instance;
  }

  public void criarNovoTreino(String nome) {
    Treino treino = new Treino(nome);
    treinos.add(treino);
  }

  public Treino getTreino(String nome) {
    for (Treino treino : treinos) {
      if (treino.getNome().equals(nome)) {
        return treino;
      }
    }
    return null;
  }

  public ArrayList<Treino> getTreinos() {
    return treinos;
  }

  public void editarTreino(String nome, String novoNome) {
    Treino treino = getTreino(nome);

    treino.setNome(novoNome);

  }

  public void apagarTreino(String nome) {
    Treino treino = getTreino(nome);

    treinos.remove(treino);

  }

}
