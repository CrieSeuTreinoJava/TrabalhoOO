package view;

import java.awt.event.*;
import javax.swing.*;
import controlador.*;
import dados.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TelaInicial {

  private static JFrame tela;
  private static JButton btnCriarTreino;
  private static JButton btnAcessarTreino;
  private static ImageIcon background;
  private static JTextField nomeTreinoInput;
  private static JList<String> listaTreinos;

  private String treinoSelecionado;

  public TelaInicial() {
    tela = new JFrame("Tela Inicial");
    tela.setBounds(0, 0, 1280, 720);
    tela.setResizable(false);
    background = new ImageIcon("src/img/muzy.jpg");
    tela.setContentPane(new JLabel(background));

    tela.getContentPane().setLayout(null);
    tela.setLocationRelativeTo(null);
    tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    tela.setVisible(true);

    btnCriarTreino = new JButton("Criar Treino");
    btnCriarTreino.setBounds(41, 106, 200, 30);
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
    nomeTreinoInput.setBounds(41, 51, 200, 30);
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
    listaTreinos.setBounds(41, 170, 200, 300);
    listaTreinos.setVisible(true);
    tela.getContentPane().add(listaTreinos);

    listaTreinos.repaint();
    tela.repaint();

    btnAcessarTreino = new JButton("Acessar Treino");
    btnAcessarTreino.setBounds(41, 618, 200, 30);
    btnAcessarTreino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tela.setVisible(false);
        new TelaTreino(treinoSelecionado);
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
    btnEditarTreino.setBounds(40, 579, 201, 30);
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
    btnNewButton.setBounds(41, 548, 200, 21);
    tela.getContentPane().add(btnNewButton);

    tela.repaint();

  }
}
