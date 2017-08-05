package view;

import java.awt.Color;
import java.awt.EventQueue;

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

import algoritmos.Desenhos2D;

import javax.swing.JButton;



public class Janela2D extends JFrame {

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

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new Janela2D();					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Janela2D() {
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		PlanoCartesiano plano = new PlanoCartesiano();
		plano.setBounds(283, 11, 800, 500);
		getContentPane().add(plano);	
		
		JLabel lblDcx = new JLabel("DCX");
		lblDcx.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		lblDcx.setForeground(Color.WHITE);
		lblDcx.setBounds(10, 32, 46, 14);
		getContentPane().add(lblDcx);
		
		JLabel lblDcy = new JLabel("DCY");
		lblDcy.setForeground(Color.WHITE);
		lblDcy.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		lblDcy.setBounds(10, 57, 46, 14);
		getContentPane().add(lblDcy);
		
		label_x = new JLabel("0");
		label_x.setForeground(Color.WHITE);
		label_x.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		label_x.setBounds(66, 32, 46, 14);
		getContentPane().add(label_x);
		
		label_y = new JLabel("0");
		label_y.setForeground(Color.WHITE);
		label_y.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		label_y.setBounds(66, 57, 46, 14);
		getContentPane().add(label_y);
		
		comboBox = new JComboBox<String>();
		//combo box não adiciona novos itens, está estático nos 4 iniciais
		comboBox.removeAllItems();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PIXEL", "RETA", "CIRCUNFERENCIA", "ELIPSE", "QUADRADO"}));
		comboBox.setBounds(10, 109, 155, 20);
		getContentPane().add(comboBox);
		
		panel_menu = new JPanel();
		panel_menu.setBackground(Color.DARK_GRAY);
		panel_menu.setForeground(Color.DARK_GRAY);
		panel_menu.setBounds(10, 140, 261, 215);
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
		
		
		/*
		 * Seção botões
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.DARK_GRAY);
		setSize(1109, 551);
		setVisible(true);
		
	}
}
