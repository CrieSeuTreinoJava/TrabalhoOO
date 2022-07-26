package view;

import javax.swing.*;

import controlador.ControladorExercicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe que representa a tela de treino, onde ficará a lista dos exercícios
 * com peso e sem peso além dos botões para adicionar, editar e remover
 * exercícios
 * 
 */
public class TelaTreino {
	private static JFrame tela;
	private static ImageIcon background;

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
	private static JLabel tabelaTituloPeso;
	private static JTable tabela2;
	private static JLabel tabelaTituloSemPeso;

	private JLabel texto2;
	private JLabel textoExercicio;

	/**
	 * Construtor da classe TelaTreino. Inicializa todos os componentes da tela
	 * TelaTreino.
	 */

	public TelaTreino(String treino) {
		ControladorExercicio controladorExercicio = new ControladorExercicio();

		tela = new JFrame("Tela Inicial");
		tela.setBounds(0, 0, 1280, 720);
		tela.setResizable(false);
		background = new ImageIcon("src/img/imagem52.jpg");
		tela.setContentPane(new JLabel(background));

		tela.getContentPane().setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);

		String[] colunas = { "Exercício", "Músculo", "Repetição", "Set", "Peso" };
		String[] colunas2 = { "Exercício", "Músculo", "Repetição", "Tempo", "Distância" };

		tela.getContentPane().setLayout(null);

		criarExercicio = new JButton("Criar");
		// quando o butão for clicado, cria um novo exercicio caso os campos estejam preenchidos corretamente
		criarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (caixaTextoExercicio.getText().trim().compareTo("") == 0 ||
						caixaTextoMusculo.getText().trim().compareTo("") == 0 ||
						caixaTextoRep.getText().trim().compareTo("") == 0 ||
						caixaTextoSetTempo.getText().trim().compareTo("") == 0 ||
						caixaTextoSetTempo.getText().trim().compareTo("") == 0) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					try {
						int numRep = Integer.parseInt(caixaTextoRep.getText());
						Double numSetTempo = Double.parseDouble(caixaTextoSetTempo.getText());
						Double numPesoDist = Double.parseDouble(caixaTextoPesoDist.getText());
						ControladorExercicio controladorExercicio = new ControladorExercicio();
						if (!tipoExercicio.isSelected()) {
							controladorExercicio.criarExercicioPeso(treino, caixaTextoExercicio.getText(),
									caixaTextoMusculo.getText(), numRep,
									numSetTempo.intValue(),
									numPesoDist.intValue());
							String[][] dadosPeso = new String[controladorExercicio.getExerciciosPeso(treino).size()][5];
							for (int i = 0; i < controladorExercicio.getExerciciosPeso(treino).size(); i++) {
								dadosPeso[i][0] = controladorExercicio.getExerciciosPeso(treino).get(i).getNome();
								dadosPeso[i][1] = controladorExercicio.getExerciciosPeso(treino).get(i).getMusculo();
								dadosPeso[i][2] = Integer
										.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getRepeticao());
								dadosPeso[i][3] = Integer
										.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getSets());
								dadosPeso[i][4] = Integer
										.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getPeso());
							}
							tabela = new JTable(dadosPeso, colunas);
							scroll.setViewportView(tabela);

						} else {
							controladorExercicio.criarExercicioSemPeso(treino, caixaTextoExercicio.getText(),
									caixaTextoMusculo.getText(), numRep,
									numSetTempo,
									numPesoDist);

							String[][] dadosSemPeso = new String[controladorExercicio.getExerciciosSemPeso(treino).size()][5];
							for (int i = 0; i < controladorExercicio.getExerciciosSemPeso(treino).size(); i++) {
								dadosSemPeso[i][0] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getNome();
								dadosSemPeso[i][1] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getMusculo();
								dadosSemPeso[i][2] = Integer
										.toString(controladorExercicio.getExerciciosSemPeso(treino).get(i).getRepeticao());
								dadosSemPeso[i][3] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getTempo() + "";
								dadosSemPeso[i][4] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getDistancia()
										+ "";
							}
							tabela2 = new JTable(dadosSemPeso, colunas2);
							scroll2.setViewportView(tabela2);
						}
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Insira somente numeros nos campos 3, 4 e 5!");
						return;
					}

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
		texto1.setBounds(50, 69, 200, 30);
		tela.getContentPane().add(texto1);

		textoMusculo = new JLabel("2. Músculo");
		textoMusculo.setBounds(50, 160, 200, 30);
		tela.getContentPane().add(textoMusculo);

		textoRep = new JLabel("3. Repetição");
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

		textoSetTempo = new JLabel("4. Sets ou Tempo(min)");
		textoSetTempo.setBounds(50, 280, 200, 25);
		tela.getContentPane().add(textoSetTempo);

		textoPesoDist = new JLabel("5. Peso(kg) ou Distância(km)");
		textoPesoDist.setBounds(50, 340, 200, 21);
		tela.getContentPane().add(textoPesoDist);

		editar = new JButton("Editar");
				// quando o butão for clicado, edita o exercicio e atualiza a tabela
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorExercicio controladorExercicio = new ControladorExercicio();
				if (!tipoExercicio.isSelected()) {
					controladorExercicio.editarExercicioPeso(treino, caixaTextoExercicio.getText(),
							caixaTextoMusculo.getText(), Integer.parseInt(caixaTextoRep.getText()),
							Integer.parseInt(caixaTextoSetTempo.getText()),
							Integer.parseInt(caixaTextoPesoDist.getText()));
					String[][] dadosPeso = new String[controladorExercicio.getExerciciosPeso(treino).size()][5];
					for (int i = 0; i < controladorExercicio.getExerciciosPeso(treino).size(); i++) {
						dadosPeso[i][0] = controladorExercicio.getExerciciosPeso(treino).get(i).getNome();
						dadosPeso[i][1] = controladorExercicio.getExerciciosPeso(treino).get(i).getMusculo();
						dadosPeso[i][2] = Integer
								.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getRepeticao());
						dadosPeso[i][3] = Integer
								.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getSets());
						dadosPeso[i][4] = Integer
								.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getPeso());
					}
					tabela = new JTable(dadosPeso, colunas);
					scroll.setViewportView(tabela);

				} else {
					controladorExercicio.editarExercicioSemPeso(treino, caixaTextoExercicio.getText(),
							caixaTextoMusculo.getText(), Integer.parseInt(caixaTextoRep.getText()),
							Integer.parseInt(caixaTextoSetTempo.getText()),
							Integer.parseInt(caixaTextoPesoDist.getText()));

					String[][] dadosSemPeso = new String[controladorExercicio.getExerciciosSemPeso(treino).size()][5];
					for (int i = 0; i < controladorExercicio.getExerciciosSemPeso(treino).size(); i++) {
						dadosSemPeso[i][0] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getNome();
						dadosSemPeso[i][1] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getMusculo();
						dadosSemPeso[i][2] = Integer
								.toString(controladorExercicio.getExerciciosSemPeso(treino).get(i).getRepeticao());
						dadosSemPeso[i][3] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getTempo() + "";
						dadosSemPeso[i][4] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getDistancia()
								+ "";
					}
					tabela2 = new JTable(dadosSemPeso, colunas2);
					scroll2.setViewportView(tabela2);
				}
			}
		});
		editar.setBounds(50, 550, 200, 30);
		tela.getContentPane().add(editar);

		excluir = new JButton("Excluir");
				// quando o butão for clicado, exclui o exercicio
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabela.getSelectedRow() != -1) {
					controladorExercicio.apagarExercicioPeso(treino,
							tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
					String[][] dadosPeso = new String[controladorExercicio.getExerciciosPeso(treino).size()][5];
					for (int i = 0; i < controladorExercicio.getExerciciosPeso(treino).size(); i++) {
						dadosPeso[i][0] = controladorExercicio.getExerciciosPeso(treino).get(i).getNome();
						dadosPeso[i][1] = controladorExercicio.getExerciciosPeso(treino).get(i).getMusculo();
						dadosPeso[i][2] = Integer
								.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getRepeticao());
						dadosPeso[i][3] = Integer
								.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getSets());
						dadosPeso[i][4] = Integer
								.toString(controladorExercicio.getExerciciosPeso(treino).get(i).getPeso());
					}
					tabela = new JTable(dadosPeso, colunas);
					scroll.setViewportView(tabela);
				} else if (tabela2.getSelectedRow() != -1) {
					controladorExercicio.apagarExercicioSemPeso(treino,
							tabela2.getValueAt(tabela2.getSelectedRow(), 0).toString());
					String[][] dadosSemPeso = new String[controladorExercicio.getExerciciosSemPeso(treino).size()][5];
					for (int i = 0; i < controladorExercicio.getExerciciosSemPeso(treino).size(); i++) {
						dadosSemPeso[i][0] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getNome();
						dadosSemPeso[i][1] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getMusculo();
						dadosSemPeso[i][2] = Integer
								.toString(controladorExercicio.getExerciciosSemPeso(treino).get(i).getRepeticao());
						dadosSemPeso[i][3] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getTempo() + "";
						dadosSemPeso[i][4] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getDistancia()
								+ "";
					}
					tabela2 = new JTable(dadosSemPeso, colunas2);
					scroll2.setViewportView(tabela2);
				}
			}
		});
		excluir.setBounds(1020, 542, 200, 30);
		tela.getContentPane().add(excluir);

		scroll = new JScrollPane();
		scroll.setBounds(540, 130, 340, 200);
		tela.getContentPane().add(scroll);

		scroll2 = new JScrollPane();
		scroll2.setBounds(880, 130, 340, 200);
		tela.getContentPane().add(scroll2);

		// carrega os dados da tabela
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
			dadosSemPeso[i][2] = Integer
					.toString(controladorExercicio.getExerciciosSemPeso(treino).get(i).getRepeticao());
			dadosSemPeso[i][3] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getTempo() + "";
			dadosSemPeso[i][4] = controladorExercicio.getExerciciosSemPeso(treino).get(i).getDistancia() + "";
		}

		tabela = new JTable(dadosPeso, colunas);
		scroll.setViewportView(tabela);

		tabela2 = new JTable(dadosSemPeso, colunas2);
		scroll2.setViewportView(tabela2);

		nomeDoTreino = new JLabel(treino);
		nomeDoTreino.setBounds(590, 56, 120, 21);
		tela.getContentPane().add(nomeDoTreino);

		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setVisible(false);
				new TelaInicial();
			}
		});
		voltar.setBounds(1120, 20, 100, 30);
		tela.getContentPane().add(voltar);

		texto2 = new JLabel("Você está acessando o Treino:");
		texto2.setBounds(530, 20, 230, 30);
		tela.getContentPane().add(texto2);

		textoExercicio = new JLabel("1. Nome do Exercício");
		textoExercicio.setBounds(50, 100, 200, 30);
		tela.getContentPane().add(textoExercicio);

		tabelaTituloPeso = new JLabel("Com peso");
		tabelaTituloPeso.setBounds(805, 90, 80, 13);
		tela.getContentPane().add(tabelaTituloPeso);

		tabelaTituloSemPeso = new JLabel("Sem peso");
		tabelaTituloSemPeso.setBounds(1140, 90, 80, 13);
		tela.getContentPane().add(tabelaTituloSemPeso);

		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
	}
}
