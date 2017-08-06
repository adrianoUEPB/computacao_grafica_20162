package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import panel.PlanoCartesiano;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Frame;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

public class MenuDeOp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6761863185579265491L;
	public static JLabel label_x, label_y, raio_x, raio_y, ponto_a, ponto_b, raio;
	public static JComboBox<String> comboBox;
	public static JRadioButton rdbtnDda, rdbtnPontoMdio_1, rdbtnEquaoExplicita, rdbtnPontoMdio, rdbtnTrigonometrica;
	private JTextField tf_raio, tf_raio_x, tf_raio_y, tf_altura, tf_largura, tf_x1, tf_y1, tf_x2, tf_y2;
	private JPanel panel_menu;
	private JButton btn_calc_reta, btn_calc_circ, btn_calc_elipse, btn_calc_quad;
	private PlanoCartesiano plano;
	private JTextField tf_trans_x;
	private JTextField tf_trans_y;
	private JTextField tf_trans_z;
	private JLabel label_1;
	private JTextField textField;
	private JLabel label_2;
	private JTextField textField_1;
	private JLabel label_3;
	private JTextField textField_2;
	private JLabel label_5;
	private JTextField textField_3;
	private JLabel label_6;
	private JTextField textField_4;
	private JLabel label_7;
	private JTextField textField_5;
	private JLabel label_9;
	private JTextField textField_6;
	private JLabel label_10;
	private JTextField textField_7;
	private JLabel label_11;
	private JTextField textField_8;
	private JLabel lblReflexes;
	private JRadioButton rb_rfly;
	private JRadioButton rb_rflx_y;
	private JRadioButton rb_rflxy;
	private JRadioButton rb_rflyz;
	private JRadioButton rb_rflxz, rb_rflx, rb_transl, rb_escala, rb_rotacao, rb_cis;
	private JSeparator separator_1;

	/**
	 * Create the frame.
	 */
	public MenuDeOp() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		this.initTransformacoes();
		this.initOpcoesDesenho();
		
		this.initCoordenadas();
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
	}
	
	/**
	 * Inicializa o painel de coordenadas e as labels das coordenadas
	 */
	private void initCoordenadas() {
		plano = new PlanoCartesiano();
		plano.setBounds(193, 12, 800, 500);
		getContentPane().add(plano);	
		
		JLabel lblDcx = new JLabel("DCX");
		lblDcx.setBounds(10, 32, 46, 14);
		lblDcx.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		lblDcx.setForeground(Color.WHITE);
		getContentPane().add(lblDcx);
		
		JLabel lblDcy = new JLabel("DCY");
		lblDcy.setBounds(10, 57, 46, 14);
		lblDcy.setForeground(Color.WHITE);
		lblDcy.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		getContentPane().add(lblDcy);
		
		label_x = new JLabel("0");
		label_x.setBounds(66, 32, 46, 14);
		label_x.setForeground(Color.WHITE);
		label_x.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		getContentPane().add(label_x);
		
		label_y = new JLabel("0");
		label_y.setBounds(66, 57, 46, 14);
		label_y.setForeground(Color.WHITE);
		label_y.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		getContentPane().add(label_y);
	}
	
	/**
	 * Inicializa as opções de desenho sobre o plano cartesiano
	 */
	private void initOpcoesDesenho() {		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 109, 155, 20);
		//combo box não adiciona novos itens, está estático nos 4 iniciais
		comboBox.removeAllItems();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"PIXEL", "RETA", "CIRCUNFERENCIA", "ELIPSE", "QUADRADO"}));
		getContentPane().add(comboBox);
		
		panel_menu = new JPanel();
		panel_menu.setBounds(10, 140, 171, 215);
		panel_menu.setBackground(Color.DARK_GRAY);
		panel_menu.setForeground(Color.DARK_GRAY);
		getContentPane().add(panel_menu);
		panel_menu.setLayout(null);
		

		
	
		raio_x = new JLabel("Raio X");
		raio_x.setForeground(Color.WHITE);
		raio_x.setBounds(10, 11, 46, 14);

		
		raio_y = new JLabel("Raio Y");
		raio_y.setForeground(Color.WHITE);
		raio_y.setBounds(10, 36, 46, 14);
		
		tf_raio_x = new JTextField();
		tf_raio_x.setBounds(66, 8, 30, 20);
		tf_raio_x.setColumns(10);
		
		tf_raio_y = new JTextField();
		tf_raio_y.setBounds(66, 33, 30, 20);
		tf_raio_y.setColumns(10);

		
		JLabel largura = new JLabel("Largura");
		largura.setForeground(Color.WHITE);
		largura.setBounds(10, 11, 60, 14);
		
		JLabel altura = new JLabel("Altura");
		altura.setForeground(Color.WHITE);
		altura.setBounds(10, 36, 60, 14);
		//vai até aqui a label
		
		tf_largura = new JTextField();
		tf_largura.setBounds(74, 8, 30, 20);
		tf_largura.setColumns(10);
		
		tf_altura = new JTextField();
		tf_altura.setBounds(74, 33, 30, 20);
		tf_altura.setColumns(10);
		
		rdbtnDda = new JRadioButton("DDA");
		rdbtnDda.setBackground(Color.DARK_GRAY);
		rdbtnDda.setForeground(Color.WHITE);
		rdbtnDda.setBounds(6, 7, 109, 23);
		
		rdbtnPontoMdio_1 = new JRadioButton("PONTO MEDIO");
		rdbtnPontoMdio_1.setBackground(Color.DARK_GRAY);
		rdbtnPontoMdio_1.setForeground(Color.WHITE);
		rdbtnPontoMdio_1.setBounds(6, 40, 130, 23);
		
		ponto_a = new JLabel("Ponto A");
		ponto_a.setForeground(Color.WHITE);
		ponto_a.setBounds(10, 68, 109, 23);		
		tf_x1 = new JTextField();
		tf_x1.setBounds(80, 70, 30, 20);
		tf_x1.setColumns(10);		
		tf_y1 = new JTextField();
		tf_y1.setBounds(120, 70, 30, 20);
		tf_y1.setColumns(10);
	
		ponto_b = new JLabel("Ponto B");
		ponto_b.setForeground(Color.WHITE);
		ponto_b.setBounds(10, 98, 109, 23);		
		tf_x2 = new JTextField();
		tf_x2.setBounds(80, 100, 30, 20);
		tf_x2.setColumns(10);		
		tf_y2 = new JTextField();
		tf_y2.setBounds(120, 100, 30, 20);
		tf_y2.setColumns(10); //não sei pra quê serve, tirar
		
		rdbtnEquaoExplicita = new JRadioButton("EQUACAO EXPLICITA");
		rdbtnEquaoExplicita.setForeground(Color.WHITE);
		rdbtnEquaoExplicita.setBackground(Color.DARK_GRAY);
		rdbtnEquaoExplicita.setBounds(6, 7, 180, 23);
		
		rdbtnPontoMdio = new JRadioButton("PONTO MEDIO");
		rdbtnPontoMdio.setBackground(Color.DARK_GRAY);
		rdbtnPontoMdio.setForeground(Color.WHITE);
		rdbtnPontoMdio.setBounds(6, 32, 152, 23);		
		
		rdbtnTrigonometrica = new JRadioButton("TRIGONOMETRICA");
		rdbtnTrigonometrica.setForeground(Color.WHITE);
		rdbtnTrigonometrica.setBackground(Color.DARK_GRAY);
		rdbtnTrigonometrica.setBounds(6, 57, 152, 23);
		
		raio = new JLabel("Raio");
		raio.setForeground(Color.WHITE);
		raio.setBounds(10, 90, 80, 23);		
		tf_raio = new JTextField();
		tf_raio.setBounds(50, 92, 40, 20);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnEquaoExplicita);
		group.add(rdbtnTrigonometrica);
		group.add(rdbtnPontoMdio);
		group.add(rdbtnPontoMdio_1);
		group.add(rdbtnDda);
		
		
/* =====================================================================================================================================
 *                                               BOTÕES
 */
		btn_calc_reta = new JButton("Calcular");
		btn_calc_reta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plano.zerarImagem();
				try {
					int x1, y1, x2, y2;
					x1 = Integer.parseInt(tf_x1.getText());
					y1 = Integer.parseInt(tf_y1.getText());
					x2 = Integer.parseInt(tf_x2.getText());
					y2 = Integer.parseInt(tf_y2.getText());
					
					plano.calcularReta(x1, y1, x2, y2);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Selecione o algoritmo!");
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Informe os valores do tipo inteiros!");
				}
			}
		});
		btn_calc_reta.setBounds(10, 140, 100, 23);
		
		/*
		 * Calcular circunferência		 * 
		 */
		btn_calc_circ = new JButton("Calcular");
		btn_calc_circ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					plano.zerarImagem();
					int raio;
					raio = Integer.parseInt(tf_raio.getText());
					plano.calcularCircunferencia(raio);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Selecione o algoritmo!");
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Informe o raio do tipo inteiro!");
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Informe o raio até 250!");
				}
			}
		});
		btn_calc_circ.setBounds(10, 130, 100, 23);
		
		/*
		 * Caluclar quadrado
		 */
		btn_calc_quad = new JButton("Calcular");
		btn_calc_quad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plano.zerarImagem();
				plano.calcularQuadrado(Integer.parseInt(tf_largura.getText()), Integer.parseInt(tf_altura.getText()));
			}
		});
		btn_calc_quad.setBounds(10, 63, 100, 23);
		
		/*
		 * Calcular elipse
		 */
		btn_calc_elipse = new JButton("Calcular");
		btn_calc_elipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plano.zerarImagem();
				plano.CalcularElipse(Integer.parseInt(tf_raio_x.getText()), Integer.parseInt(tf_raio_y.getText()));
			}
		});
		btn_calc_elipse.setBounds(10, 63, 100, 23);
		
		/*
		 *  COMENTAR
		 */
		comboBox.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().equals("PIXEL")) {
					this.limparMenu();
				} else if (e.getItem().equals("CIRCUNFERENCIA")) {
					this.limparMenu();
					panel_menu.add(rdbtnEquaoExplicita);
					panel_menu.add(rdbtnPontoMdio);
					panel_menu.add(rdbtnTrigonometrica);
					panel_menu.add(raio);
					panel_menu.add(tf_raio);
					panel_menu.add(btn_calc_circ);
					panel_menu.repaint();
				} else if (e.getItem().equals("RETA")) {
					this.limparMenu();
					panel_menu.add(rdbtnPontoMdio_1);
					panel_menu.add(rdbtnDda);
					panel_menu.add(ponto_a);
					panel_menu.add(tf_x1);
					panel_menu.add(tf_y1);
					panel_menu.add(tf_x2);
					panel_menu.add(tf_y2);
					panel_menu.add(ponto_b);
					panel_menu.add(btn_calc_reta);
					panel_menu.repaint();
				} else if (e.getItem().equals("ELIPSE")){
					this.limparMenu();
					panel_menu.add(raio_x);
					panel_menu.add(tf_raio_x);
					panel_menu.add(raio_y);
					panel_menu.add(tf_raio_y);
					panel_menu.add(btn_calc_elipse);
					panel_menu.repaint();
				} else if (e.getItem().equals("QUADRADO")) {
					this.limparMenu();
					panel_menu.add(largura);
					panel_menu.add(tf_largura);
					panel_menu.add(altura);
					panel_menu.add(tf_altura);
					panel_menu.add(btn_calc_quad);
					panel_menu.repaint();
				}
			}

			private void limparMenu() {
				plano.zerarImagem();
				panel_menu.remove(raio_x);
				panel_menu.remove(tf_raio_x);
				panel_menu.remove(raio_y);
				panel_menu.remove(tf_raio_y);
				panel_menu.remove(btn_calc_elipse);
				panel_menu.remove(altura);
				panel_menu.remove(largura);
				panel_menu.remove(tf_x1);
				panel_menu.remove(tf_y1);
				panel_menu.remove(tf_x2);
				panel_menu.remove(tf_y2);
				panel_menu.remove(ponto_a);
				panel_menu.remove(btn_calc_reta);
				panel_menu.remove(ponto_b);
				panel_menu.remove(raio);
				panel_menu.remove(tf_raio);
				panel_menu.remove(btn_calc_circ);
				panel_menu.remove(tf_altura);
				panel_menu.remove(tf_largura);				
				panel_menu.remove(btn_calc_quad);
				panel_menu.remove(rdbtnPontoMdio_1);
				panel_menu.remove(rdbtnDda);
				panel_menu.remove(rdbtnEquaoExplicita);
				panel_menu.remove(rdbtnPontoMdio);
				panel_menu.remove(rdbtnTrigonometrica);
				panel_menu.repaint();
				
			}
		});
	}
	
	private void initTransformacoes() {
		getContentPane().setLayout(null);
		JPanel panel_transformacao = new JPanel();
		panel_transformacao.setBounds(1005, 12, 349, 317);
		panel_transformacao.setBackground(Color.DARK_GRAY);
		panel_transformacao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(panel_transformacao);
		panel_transformacao.setLayout(null);
		
		JLabel lblTransformaesdE = new JLabel("TRANSFORMAÇÕES 2D e 3D");
		lblTransformaesdE.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransformaesdE.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		lblTransformaesdE.setBackground(Color.DARK_GRAY);
		lblTransformaesdE.setBounds(12, 12, 337, 36);
		lblTransformaesdE.setForeground(Color.WHITE);
		panel_transformacao.add(lblTransformaesdE);
		
		JLabel lb_x = new JLabel("X");
		lb_x.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		lb_x.setHorizontalAlignment(SwingConstants.CENTER);
		lb_x.setForeground(Color.WHITE);
		lb_x.setBounds(133, 84, 19, 14);
		panel_transformacao.add(lb_x);
		
		JLabel lb_y = new JLabel("Y");
		lb_y.setHorizontalAlignment(SwingConstants.CENTER);
		lb_y.setForeground(Color.WHITE);
		lb_y.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		lb_y.setBounds(207, 84, 19, 14);
		panel_transformacao.add(lb_y);
		
		JLabel lb_z = new JLabel("Z");
		lb_z.setHorizontalAlignment(SwingConstants.CENTER);
		lb_z.setForeground(Color.WHITE);
		lb_z.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		lb_z.setBounds(275, 85, 19, 14);
		panel_transformacao.add(lb_z);
		
		tf_trans_x = new JTextField();
		tf_trans_x.setBounds(162, 82, 35, 20);
		panel_transformacao.add(tf_trans_x);
		tf_trans_x.setColumns(10);
		
		tf_trans_y = new JTextField();
		tf_trans_y.setColumns(10);
		tf_trans_y.setBounds(230, 82, 35, 20);
		panel_transformacao.add(tf_trans_y);
		
		tf_trans_z = new JTextField();
		tf_trans_z.setColumns(10);
		tf_trans_z.setBounds(304, 82, 35, 20);
		panel_transformacao.add(tf_trans_z);
		
		label_1 = new JLabel("X");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		label_1.setBounds(133, 112, 19, 14);
		panel_transformacao.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(162, 110, 35, 20);
		panel_transformacao.add(textField);
		
		label_2 = new JLabel("Y");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(207, 112, 19, 14);
		panel_transformacao.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(230, 110, 35, 20);
		panel_transformacao.add(textField_1);
		
		label_3 = new JLabel("Z");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(275, 113, 19, 14);
		panel_transformacao.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(304, 110, 35, 20);
		panel_transformacao.add(textField_2);
		
		label_5 = new JLabel("X");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		label_5.setBounds(133, 141, 19, 14);
		panel_transformacao.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(162, 139, 35, 20);
		panel_transformacao.add(textField_3);
		
		label_6 = new JLabel("Y");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		label_6.setBounds(207, 141, 19, 14);
		panel_transformacao.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(230, 139, 35, 20);
		panel_transformacao.add(textField_4);
		
		label_7 = new JLabel("Z");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		label_7.setBounds(275, 142, 19, 14);
		panel_transformacao.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(304, 139, 35, 20);
		panel_transformacao.add(textField_5);
		
		label_9 = new JLabel("X");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		label_9.setBounds(133, 170, 19, 14);
		panel_transformacao.add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(162, 168, 35, 20);
		panel_transformacao.add(textField_6);
		
		label_10 = new JLabel("Y");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		label_10.setBounds(207, 170, 19, 14);
		panel_transformacao.add(label_10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(230, 168, 35, 20);
		panel_transformacao.add(textField_7);
		
		label_11 = new JLabel("Z");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		label_11.setBounds(275, 171, 19, 14);
		panel_transformacao.add(label_11);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(304, 168, 35, 20);
		panel_transformacao.add(textField_8);
		
		JButton jb_transf = new JButton("Calcular");
		jb_transf.setBounds(133, 273, 89, 23);
		panel_transformacao.add(jb_transf);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(5, 195, 344, 2);
		panel_transformacao.add(separator);
		
		rb_transl = new JRadioButton("Translação");
		rb_transl.setBackground(Color.DARK_GRAY);
		rb_transl.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_transl.setForeground(Color.WHITE);
		rb_transl.setBounds(12, 81, 109, 23);
		panel_transformacao.add(rb_transl);
		
		rb_escala = new JRadioButton("Escala");
		rb_escala.setForeground(Color.WHITE);
		rb_escala.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_escala.setBackground(Color.DARK_GRAY);
		rb_escala.setBounds(12, 109, 109, 23);
		panel_transformacao.add(rb_escala);
		
		rb_rotacao = new JRadioButton("Rotação");
		rb_rotacao.setForeground(Color.WHITE);
		rb_rotacao.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_rotacao.setBackground(Color.DARK_GRAY);
		rb_rotacao.setBounds(12, 166, 109, 23);
		panel_transformacao.add(rb_rotacao);
		
		rb_cis = new JRadioButton("Cisalhamento");
		rb_cis.setForeground(Color.WHITE);
		rb_cis.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_cis.setBackground(Color.DARK_GRAY);
		rb_cis.setBounds(12, 137, 115, 23);
		panel_transformacao.add(rb_cis);
		
		rb_rflx = new JRadioButton("X");
		rb_rflx.setForeground(Color.WHITE);
		rb_rflx.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_rflx.setBackground(Color.DARK_GRAY);
		rb_rflx.setBounds(12, 226, 43, 23);
		panel_transformacao.add(rb_rflx);
		
		lblReflexes = new JLabel("Reflexões");
		lblReflexes.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		lblReflexes.setForeground(Color.WHITE);
		lblReflexes.setBounds(133, 205, 73, 14);
		panel_transformacao.add(lblReflexes);
		
		rb_rfly = new JRadioButton("Y");
		rb_rfly.setForeground(Color.WHITE);
		rb_rfly.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_rfly.setBackground(Color.DARK_GRAY);
		rb_rfly.setBounds(57, 226, 43, 23);
		panel_transformacao.add(rb_rfly);
		
		rb_rflx_y = new JRadioButton("X e Y");
		rb_rflx_y.setForeground(Color.WHITE);
		rb_rflx_y.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_rflx_y.setBackground(Color.DARK_GRAY);
		rb_rflx_y.setBounds(102, 226, 64, 23);
		panel_transformacao.add(rb_rflx_y);
		
		rb_rflxy = new JRadioButton("XY");
		rb_rflxy.setForeground(Color.WHITE);
		rb_rflxy.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_rflxy.setBackground(Color.DARK_GRAY);
		rb_rflxy.setBounds(168, 226, 43, 23);
		panel_transformacao.add(rb_rflxy);
		
		rb_rflyz = new JRadioButton("YZ");
		rb_rflyz.setForeground(Color.WHITE);
		rb_rflyz.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_rflyz.setBackground(Color.DARK_GRAY);
		rb_rflyz.setBounds(213, 226, 43, 23);
		panel_transformacao.add(rb_rflyz);
		
		rb_rflxz = new JRadioButton("XZ");
		rb_rflxz.setForeground(Color.WHITE);
		rb_rflxz.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 12));
		rb_rflxz.setBackground(Color.DARK_GRAY);
		rb_rflxz.setBounds(258, 226, 43, 23);
		panel_transformacao.add(rb_rflxz);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rb_rflx);
		group.add(rb_rflx_y);
		group.add(rb_cis);
		group.add(rb_rotacao);
		group.add(rb_escala);
		group.add(rb_transl);
		group.add(rb_rfly);
		group.add(rb_rflxy);
		group.add(rb_rflyz);
		group.add(rb_rflxz);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(5, 256, 344, 2);
		panel_transformacao.add(separator_1);
	}
}
