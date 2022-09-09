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
  private static JButton btnCriarTreino;
  private static JButton btnAcessarTreino;
  // private static ImageIcon background;
  private static JTextField nomeTreinoInput;
  private static JList<String> listaTreinos;

  private String treinoSelecionado;

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

    controladorExercicio.criarExercicioPeso("Terça", "Biceps unilateral", "Bíceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Sexta", "Remada sincera", "Posterior do ombro", 12, 4, 20);
    controladorExercicio.criarExercicioSemPeso("Quarta", "Corrida", " ", 1, 30, 3);
    controladorExercicio.criarExercicioPeso("Quarta", "Agachamento", "Quadríceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Quarta", "Leg press", "Quadríceps", 10, 3, 50);
    controladorExercicio.criarExercicioPeso("Quarta", "Cadeira extensora", "Quadríceps", 10, 3, 50);
    controladorExercicio.criarExercicioSemPeso("Quarta", "polichinelo", "corpo inteiro", 20, 3, 0);

    new TelaInicial();
  }

  public TelaInicial() {
    tela = new JFrame("Tela Inicial");
    tela.setBounds(0, 0, 1280, 720);
    tela.setResizable(false);
    ImageIcon background = new ImageIcon("src/img/muzy.jpg");
    tela.setContentPane(new JLabel(background));

    tela.getContentPane().setLayout(null);
    tela.setLocationRelativeTo(null);
    tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    tela.setVisible(true);

    btnCriarTreino = new JButton("Criar treino");
    btnCriarTreino.setBounds(40, 90, 200, 30);
    btnCriarTreino.setVisible(true);
    tela.getContentPane().add(btnCriarTreino);
    btnCriarTreino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ControladorTreino controladorTreino = new ControladorTreino();
        controladorTreino.criarTreino(nomeTreinoInput.getText());
        listaTreinos.setListData(Database.getInstance().getTreinos());
        listaTreinos.repaint();
        tela.repaint();
      }
    });

    nomeTreinoInput = new JTextField("");
    nomeTreinoInput.setBounds(40, 40, 200, 30);
    nomeTreinoInput.setVisible(true);
    tela.getContentPane().add(nomeTreinoInput);
    tela.repaint();

    // create a new JList with the content of the database
    listaTreinos = new JList<String>();

    // return the selected value
    listaTreinos.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          treinoSelecionado = listaTreinos.getSelectedValue().toString();
        }
      }
    });
    // listaTreinos.addListSelectionListener(new ListSelectionListener() {
    // public void valueChanged(ListSelectionEvent e) {
    // System.out.println(listaTreinos.getSelectedValue());

    // }
    // });
    listaTreinos.setListData(Database.getInstance().getTreinos());
    listaTreinos.setBounds(40, 170, 200, 300);
    listaTreinos.setVisible(true);
    tela.getContentPane().add(listaTreinos);

    listaTreinos.repaint();
    tela.repaint();

    btnAcessarTreino = new JButton("Acessar treino");
    btnAcessarTreino.setBounds(41, 590, 200, 30);
    btnAcessarTreino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (treinoSelecionado != null) {
          tela.setVisible(false);
          new TelaTreino(treinoSelecionado);
        }
      }
    });
    btnAcessarTreino.setVisible(true);
    tela.getContentPane().add(btnAcessarTreino);

    JButton btnEditarTreino = new JButton("Editar");
    btnEditarTreino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        ControladorTreino controladorTreino = new ControladorTreino();
        controladorTreino.editarTreino(listaTreinos.getSelectedValue(), nomeTreinoInput.getText());
        listaTreinos.setListData(Database.getInstance().getTreinos());
        listaTreinos.repaint();
        tela.repaint();

      }
    });
    btnEditarTreino.setBounds(41, 540, 200, 30);
    tela.getContentPane().add(btnEditarTreino);

    JButton btnNewButton = new JButton("Apagar");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ControladorTreino controladorTreino = new ControladorTreino();
        controladorTreino.apagarTreino(listaTreinos.getSelectedValue());
        listaTreinos.setListData(Database.getInstance().getTreinos());
        listaTreinos.repaint();
        tela.repaint();
      }
    });
    btnNewButton.setBounds(41, 490, 200, 30);
    tela.getContentPane().add(btnNewButton);

    JLabel lblSelecioneUmTreino = new JLabel("Selecione um treino");
    lblSelecioneUmTreino.setBounds(40, 132, 200, 32);
    tela.getContentPane().add(lblSelecioneUmTreino);

    tela.repaint();

  }
}
