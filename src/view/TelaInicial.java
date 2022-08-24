package view;

import java.awt.event.*;
import javax.swing.*;
import controlador.*;
import dados.*;

public class TelaInicial implements ActionListener {

  private static JFrame tela;
  private static JButton btnCriarTreino;
  private static ImageIcon background;
  private static JTextField txtNomeTreino;
  private static JList listaTreinos;

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
    tela.add(this.btnCriarTreino);
    btnCriarTreino.addActionListener(this);

    txtNomeTreino = new JTextField("nome do treino");
    txtNomeTreino.setBounds(29, 240, 200, 50);
    txtNomeTreino.setVisible(true);
    tela.add(this.txtNomeTreino);
    tela.repaint();

    // create a new JList with the content of the database
    listaTreinos = new JList();
    listaTreinos.setListData(Database.getInstance().getTreinos());
    listaTreinos.setBounds(29, 400, 200, 200);
    listaTreinos.setVisible(true);
    tela.add(this.listaTreinos);
    listaTreinos.repaint();
    tela.repaint();

  }

  public void actionPerformed(ActionEvent arg0) {
    ControladorTreino controladorTreino = new ControladorTreino();
    controladorTreino.criarTreino(txtNomeTreino.getText());
    listaTreinos.setListData(Database.getInstance().getTreinos());
    listaTreinos.repaint();
    tela.repaint();

  }

}
