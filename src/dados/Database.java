package dados;

import java.util.ArrayList;

import exercicio.Treino;

/**
 * Classe responsável por armazenar os Treinos, e por consequencia os
 * Exercicios.
 */
public class Database {

  ArrayList<Treino> treinos;
  private static Database instance;

  /**
   * Construtor da classe Database.
   * Inicializa o ArrayList de Treinos.
   */
  private Database() {
    this.treinos = new ArrayList<Treino>();
  }

  /**
   * Esse método verifica se já existe uma instância da classe Database.
   * se existir, retorna a instância.
   * Caso não exista, cria uma nova instância.
   * Assim, garante que só haverá uma instância da classe Database.
   * 
   * @return o própio objeto Database.
   */
  public static Database getInstance() {
    if (instance == null) {
      instance = new Database();
    }
    return instance;
  }

  /**
   * Esse método instância um treino e adiciona na lista de treinos.
   */
  public void criarNovoTreino(String nome) {
    Treino treino = new Treino(nome);
    treinos.add(treino);
  }

  /**
   * Para cada treino na lista de treinos, verifica se o nome do treino é igual ao
   * nome passado como parâmetro.
   * 
   * @return o treino com o nome passado como parâmetro caso exista.
   * @return null caso não exista.
   */
  public Treino getTreino(String nome) {
    for (Treino treino : treinos) {
      if (treino.getNome().equals(nome)) {
        return treino;
      }
    }
    return null;
  }

  /**
   * cria um Array de Strings com o tamanho da lista de treinos.
   * Para cada treino na lista de treinos, adiciona o nome do treino no Array.
   * 
   * @return o Array de Strings com os nomes dos treinos.
   */
  public String[] getTreinos() {
    String[] treinos = new String[this.treinos.size()];
    for (int i = 0; i < this.treinos.size(); i++) {
      treinos[i] = this.treinos.get(i).getNome();
    }
    return treinos;
  }

  /**
   * Determina o treino baseado no nome passado como parâmetro.
   * Renomeia o treino com o novo nome passado como parâmetro.
   */
  public void editarTreino(String nome, String novoNome) {
    Treino treino = getTreino(nome);
    treino.setNome(novoNome);
  }

  /**
   * Determina o treino baseado no nome passado como parâmetro.
   * Remove o treino da lista de treinos.
   */
  public void apagarTreino(String nome) {
    Treino treino = getTreino(nome);

    treinos.remove(treino);

  }

}
