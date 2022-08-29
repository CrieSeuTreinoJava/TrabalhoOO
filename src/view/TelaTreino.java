package view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class TelaTreino {
	private static JFrame tela;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	public TelaTreino(String treino) {
		tela = new JFrame("Tela Inicial");
	    tela.setBounds(0, 0, 1280, 720);
	    tela.setResizable(false);
	    
	    tela.getContentPane().setLayout(null);
	    
	    JButton btnNewButton = new JButton("Criar Exercicio");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton.setBounds(27, 412, 173, 62);
	    tela.getContentPane().add(btnNewButton);
	    
	    textField = new JTextField();
	    textField.setBounds(27, 189, 173, 33);
	    tela.getContentPane().add(textField);
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(27, 132, 173, 33);
	    tela.getContentPane().add(textField_1);
	    textField_1.setColumns(10);
	    
	    JCheckBox chckbxNewCheckBox = new JCheckBox("Exercício sem peso");
	    chckbxNewCheckBox.setBounds(27, 374, 149, 32);
	    tela.getContentPane().add(chckbxNewCheckBox);
	    
	    textField_2 = new JTextField();
	    textField_2.setBounds(27, 74, 173, 34);
	    tela.getContentPane().add(textField_2);
	    textField_2.setColumns(10);
	    
	    JLabel lblNewLabel = new JLabel("Nome do exercício");
	    lblNewLabel.setBounds(27, 42, 149, 33);
	    tela.getContentPane().add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Músculo");
	    lblNewLabel_1.setBounds(25, 114, 96, 21);
	    tela.getContentPane().add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Repetição");
	    lblNewLabel_2.setBounds(27, 166, 45, 13);
	    tela.getContentPane().add(lblNewLabel_2);
	    
	    textField_3 = new JTextField();
	    textField_3.setBounds(27, 261, 173, 33);
	    tela.getContentPane().add(textField_3);
	    textField_3.setColumns(10);
	    
	    textField_4 = new JTextField();
	    textField_4.setBounds(27, 324, 173, 33);
	    tela.getContentPane().add(textField_4);
	    textField_4.setColumns(10);
	    
	    JLabel lblNewLabel_3 = new JLabel("Sets ou Tempo");
	    lblNewLabel_3.setBounds(27, 232, 113, 25);
	    tela.getContentPane().add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_4 = new JLabel("Peso ou Distância");
	    lblNewLabel_4.setBounds(27, 304, 134, 21);
	    tela.getContentPane().add(lblNewLabel_4);
	    
	    tela.setLocationRelativeTo(null);
	    tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tela.setVisible(true);
	}
}
