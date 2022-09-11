package view;

import java.awt.event.*;
// import java.util.ArrayList;

import javax.swing.*;
import controlador.*;
import dados.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Classe que representa a tela inicial do programa, onde ficará a lista dos
 * treinos, além dos butões para adicionar, remover e editar treinos.
 * 
 */
public class TelaInicial {

  private static JFrame tela;
  private static JButton butaoCriarTreino;
  private static JButton botaoAcessarTreino;
  // private static ImageIcon background;
  private static JTextField nomeTreinoInput;
  private static ImageIcon background;
  private static JList<String> listaTreinos;
  private static JButton botaoDeletar;
  private static JButton botaoEditarTreino;
  private JLabel SelecioneUmTreino;
  private JScrollPane scroll;

  private String treinoSelecionado;
  private ControladorTreino controladorTreino = new ControladorTreino();
  private final JButton botaoPesquisar = new JButton("Pesquisar");

  /**
   * Construtor da classe TelaInicial. Inicializa todos os componentes da tela
   * telaInicial.
   */
  public static void main(String[] args) {
    ControladorTreino controladorTreino = new ControladorTreino();
    ControladorExercicio controladorExercicio = new ControladorExercicio();

    // Criar um treino
    controladorTreino.criarTreino("Quarta");
    controladorTreino.criarTreino("Terça");
    controladorTreino.criarTreino("Sabado");
    controladorTreino.criarTreino("Sexta");
    for (int i = 1; i < 30; i++) {
      controladorTreino.criarTreino("treino" + i);
      for (int j = 1; j < 15; j++) {
        controladorExercicio.criarExercicioPeso("treino" + i, "exercicio" + j, "PEITO", j, j, j);
        controladorExercicio.criarExercicioSemPeso("treino" + i, "exercicio" + j, "cardio", j, j, j);
      }
    }

    controladorExercicio.criarExercicioPeso("Terça", "Biceps unilateral", "Bíceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Sexta", "Remada sincera", "Posterior do ombro", 12, 4, 20);
    controladorExercicio.criarExercicioSemPeso("Quarta", "Corrida", " ", 1, 30, 3);
    controladorExercicio.criarExercicioPeso("Quarta", "Agachamento", "Quadríceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Quarta", "Leg press", "Quadríceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Quarta", "Cadeira extensora", "Quadríceps", 10, 3, 50);
    controladorExercicio.criarExercicioSemPeso("Quarta", "polichinelo", "corpo inteiro", 20, 3, 0);
    controladorExercicio.criarExercicioSemPeso("Quarta", "polichinelo", "corpo inteiro", 20, 3, 0);

    new TelaInicial();
  }

  public TelaInicial() {
    tela = new JFrame("Tela Inicial");
    background = new ImageIcon("src/img/muzy.jpg");
    tela.setContentPane(new JLabel(background));
    tela.setBounds(0, 0, 1280, 720);
    tela.setResizable(false);

    tela.getContentPane().setLayout(null);
    tela.setLocationRelativeTo(null);
    tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    tela.setVisible(true);

    butaoCriarTreino = new JButton("Criar treino");
    butaoCriarTreino.setBounds(40, 90, 200, 30);
    butaoCriarTreino.setVisible(true);
    tela.getContentPane().add(butaoCriarTreino);
    butaoCriarTreino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (nomeTreinoInput.getText().compareTo("") == 0) {
          JOptionPane.showMessageDialog(null, "O campo de Treino está vazio!");
        } else {
          ControladorTreino controladorTreino = new ControladorTreino();
          boolean foiCriado = controladorTreino.criarTreino(nomeTreinoInput.getText());
          if (!foiCriado) {
            JOptionPane.showMessageDialog(null, "Esse nome de Treino já existe!");
          } else {
            listaTreinos.setListData(Database.getInstance().getTreinos());
            listaTreinos.repaint();
            tela.repaint();
          }
        }

      }
    });

    nomeTreinoInput = new JTextField("");
    nomeTreinoInput.setBounds(40, 40, 200, 30);
    nomeTreinoInput.setVisible(true);
    tela.getContentPane().add(nomeTreinoInput);
    tela.repaint();

    listaTreinos = new JList<String>();

    listaTreinos.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          treinoSelecionado = listaTreinos.getSelectedValue().toString();
        }
      }
    });

    listaTreinos.setListData(Database.getInstance().getTreinos());
    listaTreinos.setBounds(40, 170, 200, 300);

    scroll = new JScrollPane(listaTreinos);
    scroll.setBounds(40, 170, 200, 250);
    tela.getContentPane().add(scroll);

    listaTreinos.repaint();
    tela.repaint();

    botaoAcessarTreino = new JButton("Acessar treino");
    botaoAcessarTreino.setBounds(40, 590, 200, 30);
    botaoAcessarTreino.setVisible(true);
    botaoAcessarTreino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (controladorTreino.getTreino(treinoSelecionado) != null) {
          tela.setVisible(false);
          new TelaTreino(treinoSelecionado);
        } else {
          JOptionPane.showMessageDialog(null, "Selecione um treino para acessar!");
        }
      }
    });
    tela.getContentPane().add(botaoAcessarTreino);

    botaoEditarTreino = new JButton("Editar");
    botaoEditarTreino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (listaTreinos.getSelectedValue() == null) {
          JOptionPane.showMessageDialog(null, "Selecione um treino para editar!");
        } else {
          ControladorTreino controladorTreino = new ControladorTreino();
          controladorTreino.editarTreino(listaTreinos.getSelectedValue(), nomeTreinoInput.getText());
          listaTreinos.setListData(Database.getInstance().getTreinos());
          listaTreinos.repaint();
          tela.repaint();
        }

      }
    });

    botaoEditarTreino.setBounds(40, 540, 200, 30);
    tela.getContentPane().add(botaoEditarTreino);

    botaoDeletar = new JButton("Apagar");
    botaoDeletar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (listaTreinos.getSelectedValue() == null) {
          JOptionPane.showMessageDialog(null, "Selecione um treino para apagar!");
        } else {
          ControladorTreino controladorTreino = new ControladorTreino();
          controladorTreino.apagarTreino(listaTreinos.getSelectedValue());
          listaTreinos.setListData(Database.getInstance().getTreinos());
          listaTreinos.repaint();
          tela.repaint();
        }
      }
    });

    botaoDeletar.setBounds(40, 490, 200, 30);
    tela.getContentPane().add(botaoDeletar);

    SelecioneUmTreino = new JLabel("Selecione um treino");
    SelecioneUmTreino.setBounds(40, 132, 200, 32);
    tela.getContentPane().add(SelecioneUmTreino);

    botaoPesquisar.setBounds(40, 440, 200, 30);
    botaoPesquisar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (nomeTreinoInput.getText().compareTo("") == 0) {
          JOptionPane.showMessageDialog(null, "Escreva o treino que quer acessar!");
        }

        else if (controladorTreino.getTreino(nomeTreinoInput.getText()) == null) {
          JOptionPane.showMessageDialog(null, "Treino não encontrado!");
        } else {
          tela.setVisible(false);
          new TelaTreino(nomeTreinoInput.getText());
        }
      }
    });
    tela.getContentPane().add(botaoPesquisar);

    tela.repaint();

  }
}
