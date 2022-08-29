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
  private static JTextField txtNomeTreino;
  private static JList listaTreinos;

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
    btnCriarTreino.setBounds(29, 300, 200, 50);
    btnCriarTreino.setVisible(true);
    tela.getContentPane().add(this.btnCriarTreino);
    btnCriarTreino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ControladorTreino controladorTreino = new ControladorTreino();
        controladorTreino.criarTreino(txtNomeTreino.getText());
        listaTreinos.setListData(Database.getInstance().getTreinos());
        listaTreinos.repaint();
        tela.repaint();
      }
    });

    txtNomeTreino = new JTextField("nome do treino");
    txtNomeTreino.setBounds(29, 240, 200, 50);
    txtNomeTreino.setVisible(true);
    tela.getContentPane().add(this.txtNomeTreino);
    tela.repaint();

    // create a new JList with the content of the database
    listaTreinos = new JList();

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
    listaTreinos.setBounds(29, 400, 200, 200);
    listaTreinos.setVisible(true);
    tela.getContentPane().add(this.listaTreinos);

    listaTreinos.repaint();
    tela.repaint();

    btnAcessarTreino = new JButton("Acessar Treino");
    btnAcessarTreino.setBounds(29, 610, 200, 50);
    btnAcessarTreino.setVisible(true);
    tela.getContentPane().add(this.btnAcessarTreino);
    btnAcessarTreino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tela.setVisible(false);
        new TelaTreino(treinoSelecionado);
      }
    });

  }

}
