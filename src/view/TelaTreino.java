package view;

import javax.swing.*;

import controlador.ControladorExercicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaTreino {
	private static JFrame tela;

	private static JTextField caixaTextoRep;
	private static JTextField caixaTextoMusculo;
	private static JTextField caixaTextoExercicio;
	private static JTextField caixaTextoSetTempo;
	private static JTextField caixaTextoPesoDist;

	private static JButton criarExercicio;
	private static JButton editar;
	private static JButton excluir;
	private static JButton voltar;

	// checkbox para selecionar se é um exercicio com peso ou sem peso
	private static JCheckBox tipoExercicio;

	private static JLabel texto1;
	private static JLabel textoMusculo;
	private static JLabel textoRep;
	private static JLabel textoSetTempo;
	private static JLabel textoPesoDist;
	private static JLabel nomeDoTreino;

	private static JScrollPane scroll;
	private static JScrollPane scroll2;

	private static JTable tabela;
	private static JTable tabela2;

	private JLabel texto2;
	private JLabel textoExercicio;

	public TelaTreino(String treino) {
		ControladorExercicio controladorExercicio = new ControladorExercicio();

		String[] colunas = { "Exercício", "Músculo", "Repetição", "Set",
				"Peso" };
		String[] colunas2 = { "Exercício", "Músculo", "Repetição", "Tempo",
				"Distância" };

		tela = new JFrame("Tela Inicial");
		tela.setBounds(0, 0, 1280, 720);
		tela.setResizable(false);

		tela.getContentPane().setLayout(null);

		criarExercicio = new JButton("Criar");
		criarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorExercicio controladorExercicio = new ControladorExercicio();
				if (!tipoExercicio.isSelected()) {
					// System.out.println("Exercicio com peso");
					controladorExercicio.criarExercicioPeso(treino,
							caixaTextoExercicio.getText(), caixaTextoMusculo.getText(),
							Integer.parseInt(caixaTextoRep.getText()),
							Integer.parseInt(caixaTextoSetTempo.getText()),
							Integer.parseInt(caixaTextoPesoDist.getText()));
					String[][] dadosPeso = new String[controladorExercicio.getExerciciosPeso(treino).size()][5];
					for (int i = 0; i < controladorExercicio.getExerciciosPeso(treino).size(); i++) {
						dadosPeso[i][0] = controladorExercicio.getExerciciosPeso(treino).get(i).getNome();
						dadosPeso[i][1] = controladorExercicio.getExerciciosPeso(treino).get(i).getMusculo();
						dadosPeso[i][2] = Integer.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getRepeticao());
						dadosPeso[i][3] = Integer.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getSets());
						dadosPeso[i][4] = Integer.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getPeso());
					}
					tabela = new JTable(dadosPeso, colunas);
					scroll.setViewportView(tabela);

				} else {
					// System.out.println("Exercicio sem peso");
					controladorExercicio.criarExercicioSemPeso(treino,
							caixaTextoExercicio.getText(), caixaTextoMusculo.getText(),
							Integer.parseInt(caixaTextoRep.getText()),
							Integer.parseInt(caixaTextoSetTempo.getText()),
							Integer.parseInt(caixaTextoPesoDist.getText()));

					String[][] dadosSemPeso = new String[controladorExercicio.getExerciciosSemPeso(treino).size()][5];
					for (int i = 0; i < controladorExercicio.getExerciciosSemPeso(treino).size(); i++) {
						dadosSemPeso[i][0] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getNome();
						dadosSemPeso[i][1] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getMusculo();
						dadosSemPeso[i][2] = Integer
								.toString(controladorExercicio.getExerciciosSemPeso(treino).get(i).getRepeticao());
						dadosSemPeso[i][3] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getTempo() + "";
						dadosSemPeso[i][4] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getDistancia() + "";
					}
					tabela2 = new JTable(dadosSemPeso, colunas2);
					scroll2.setViewportView(tabela2);
				}
			}
		});
		criarExercicio.setBounds(50, 490, 200, 30);
		tela.getContentPane().add(criarExercicio);

		caixaTextoRep = new JTextField();
		caixaTextoRep.setBounds(50, 250, 200, 33);
		tela.getContentPane().add(caixaTextoRep);
		caixaTextoRep.setColumns(10);

		caixaTextoMusculo = new JTextField();
		caixaTextoMusculo.setBounds(50, 190, 200, 30);
		tela.getContentPane().add(caixaTextoMusculo);
		caixaTextoMusculo.setColumns(10);

		tipoExercicio = new JCheckBox("Exercício sem peso");
		tipoExercicio.setBounds(50, 430, 200, 30);
		tela.getContentPane().add(tipoExercicio);

		caixaTextoExercicio = new JTextField();
		caixaTextoExercicio.setBounds(50, 130, 200, 30);
		tela.getContentPane().add(caixaTextoExercicio);
		caixaTextoExercicio.setColumns(10);

		texto1 = new JLabel("Crie seu exercício:");
		texto1.setBounds(50, 40, 200, 30);
		tela.getContentPane().add(texto1);

		textoMusculo = new JLabel("Músculo");
		textoMusculo.setBounds(50, 160, 200, 30);
		tela.getContentPane().add(textoMusculo);

		textoRep = new JLabel("Repetição");
		textoRep.setBounds(50, 220, 200, 30);
		tela.getContentPane().add(textoRep);

		caixaTextoSetTempo = new JTextField();
		caixaTextoSetTempo.setBounds(50, 310, 200, 30);
		tela.getContentPane().add(caixaTextoSetTempo);
		caixaTextoSetTempo.setColumns(10);

		caixaTextoPesoDist = new JTextField();
		caixaTextoPesoDist.setBounds(50, 370, 200, 30);
		tela.getContentPane().add(caixaTextoPesoDist);
		caixaTextoPesoDist.setColumns(10);

		textoSetTempo = new JLabel("Sets ou Tempo(min)");
		textoSetTempo.setBounds(50, 280, 200, 25);
		tela.getContentPane().add(textoSetTempo);

		textoPesoDist = new JLabel("Peso(kg) ou Distância(km)");
		textoPesoDist.setBounds(50, 340, 200, 21);
		tela.getContentPane().add(textoPesoDist);

		editar = new JButton("Editar");
		editar.setBounds(50, 550, 200, 30);
		tela.getContentPane().add(editar);

		excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		excluir.setBounds(900, 490, 200, 30);
		tela.getContentPane().add(excluir);

		scroll = new JScrollPane();
		scroll.setBounds(500, 40, 300, 430);
		tela.getContentPane().add(scroll);

		scroll2 = new JScrollPane();
		scroll2.setBounds(800, 40, 300, 430);
		tela.getContentPane().add(scroll2);

		String[][] dadosPeso = new String[controladorExercicio.getExerciciosPeso(treino).size()][5];
		String[][] dadosSemPeso = new String[controladorExercicio.getExerciciosSemPeso(treino).size()][5];

		for (int i = 0; i < controladorExercicio.getExerciciosPeso(treino).size(); i++) {
			dadosPeso[i][0] = controladorExercicio.getExerciciosPeso(treino).get(i).getNome();
			dadosPeso[i][1] = controladorExercicio.getExerciciosPeso(treino).get(i).getMusculo();
			dadosPeso[i][2] = Integer.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getRepeticao());
			dadosPeso[i][3] = Integer.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getSets());
			dadosPeso[i][4] = Integer.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getPeso());
		}

		for (int i = 0; i < controladorExercicio.getExerciciosSemPeso(treino).size(); i++) {
			dadosSemPeso[i][0] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getNome();
			dadosSemPeso[i][1] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getMusculo();
			dadosSemPeso[i][2] = Integer.toString(controladorExercicio.getExerciciosSemPeso(treino).get(i).getRepeticao());
			dadosSemPeso[i][3] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getTempo() + "";
			dadosSemPeso[i][4] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getDistancia() + "";
		}

		tabela = new JTable(dadosPeso, colunas);
		scroll.setViewportView(tabela);

		tabela2 = new JTable(dadosSemPeso, colunas2);
		scroll2.setViewportView(tabela2);

		nomeDoTreino = new JLabel(treino);
		nomeDoTreino.setBounds(290, 69, 200, 30);
		tela.getContentPane().add(nomeDoTreino);

		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setVisible(false);
				new TelaInicial();
			}
		});
		voltar.setBounds(1130, 40, 100, 30);
		tela.getContentPane().add(voltar);

		texto2 = new JLabel("Você está aceesando o Treino:");
		texto2.setBounds(290, 40, 200, 30);
		tela.getContentPane().add(texto2);

		textoExercicio = new JLabel("Nome do Exercício");
		textoExercicio.setBounds(50, 100, 200, 30);
		tela.getContentPane().add(textoExercicio);

		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
	}
}
