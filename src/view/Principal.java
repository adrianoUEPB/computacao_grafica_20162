package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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



public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6761863185579265491L;
	public static JLabel label_x, label_y;
	public static JComboBox<String> comboBox;
	public static JRadioButton rdbtnDda, rdbtnPontoMdio_1, rdbtnEquaoExplicita, rdbtnPontoMdio, rdbtnTrigonometrica;
	private JTextField tf_raio_x, tf_raio_y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Principal();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
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
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"PIXEL", "RETA", "CIRCUNFERENCIA", "ELIPSE"}));
		comboBox.setBounds(10, 109, 155, 20);
		getContentPane().add(comboBox);
		
		JPanel panel_circunferencia = new JPanel();
		panel_circunferencia.setBackground(Color.DARK_GRAY);
		panel_circunferencia.setForeground(Color.DARK_GRAY);
		panel_circunferencia.setBounds(10, 140, 180, 97);
		getContentPane().add(panel_circunferencia);
		panel_circunferencia.setLayout(null);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plano.zerarImagem();
				plano.CalcularElipse(Integer.parseInt(tf_raio_x.getText()), Integer.parseInt(tf_raio_y.getText()));
			}
		});
		btnCalcular.setBounds(10, 63, 89, 23);
		
		JLabel raio_x = new JLabel("Raio X");
		raio_x.setForeground(Color.WHITE);
		raio_x.setBounds(10, 11, 46, 14);

		
		JLabel raio_y = new JLabel("Raio Y");
		raio_y.setForeground(Color.WHITE);
		raio_y.setBounds(10, 36, 46, 14);

		
		tf_raio_x = new JTextField();
		tf_raio_x.setBounds(66, 8, 86, 20);
		tf_raio_x.setColumns(10);
		
		tf_raio_y = new JTextField();
		tf_raio_y.setBounds(66, 33, 86, 20);
		tf_raio_y.setColumns(10);
		
		rdbtnDda = new JRadioButton("DDA");
		rdbtnDda.setBackground(Color.DARK_GRAY);
		rdbtnDda.setForeground(Color.WHITE);
		rdbtnDda.setBounds(6, 7, 109, 23);
		
		rdbtnPontoMdio_1 = new JRadioButton("PONTO MEDIO");
		rdbtnPontoMdio_1.setBackground(Color.DARK_GRAY);
		rdbtnPontoMdio_1.setForeground(Color.WHITE);
		rdbtnPontoMdio_1.setBounds(6, 32, 109, 23);
		
		rdbtnEquaoExplicita = new JRadioButton("EQUACAO EXPLICITA");
		rdbtnEquaoExplicita.setForeground(Color.WHITE);
		rdbtnEquaoExplicita.setBackground(Color.DARK_GRAY);
		rdbtnEquaoExplicita.setBounds(6, 7, 152, 23);
		
		rdbtnPontoMdio = new JRadioButton("PONTO MEDIO");
		rdbtnPontoMdio.setBackground(Color.DARK_GRAY);
		rdbtnPontoMdio.setForeground(Color.WHITE);
		rdbtnPontoMdio.setBounds(6, 32, 152, 23);
		
		
		rdbtnTrigonometrica = new JRadioButton("TRIGONOMETRICA");
		rdbtnTrigonometrica.setForeground(Color.WHITE);
		rdbtnTrigonometrica.setBackground(Color.DARK_GRAY);
		rdbtnTrigonometrica.setBounds(6, 57, 152, 23);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnEquaoExplicita);
		group.add(rdbtnTrigonometrica);
		group.add(rdbtnPontoMdio);
		group.add(rdbtnPontoMdio_1);
		group.add(rdbtnDda);

		comboBox.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().equals("PIXEL")) {
					plano.zerarImagem();
					panel_circunferencia.remove(raio_x);
					panel_circunferencia.remove(tf_raio_x);
					panel_circunferencia.remove(raio_y);
					panel_circunferencia.remove(tf_raio_y);
					panel_circunferencia.remove(btnCalcular);
					panel_circunferencia.remove(rdbtnPontoMdio_1);
					panel_circunferencia.remove(rdbtnDda);
					panel_circunferencia.remove(rdbtnEquaoExplicita);
					panel_circunferencia.remove(rdbtnPontoMdio);
					panel_circunferencia.remove(rdbtnTrigonometrica);					
					panel_circunferencia.repaint();
				} else if (e.getItem().equals("CIRCUNFERENCIA")) {
					plano.zerarImagem();
					panel_circunferencia.add(rdbtnEquaoExplicita);
					panel_circunferencia.add(rdbtnPontoMdio);
					panel_circunferencia.add(rdbtnTrigonometrica);
					panel_circunferencia.remove(raio_x);
					panel_circunferencia.remove(tf_raio_x);
					panel_circunferencia.remove(raio_y);
					panel_circunferencia.remove(btnCalcular);
					panel_circunferencia.remove(tf_raio_y);
					panel_circunferencia.remove(rdbtnPontoMdio_1);
					panel_circunferencia.remove(rdbtnDda);			
					panel_circunferencia.repaint();
				} else if (e.getItem().equals("RETA")) {
					plano.zerarImagem();
					panel_circunferencia.remove(raio_x);
					panel_circunferencia.remove(tf_raio_x);
					panel_circunferencia.remove(raio_y);
					panel_circunferencia.remove(tf_raio_y);
					panel_circunferencia.remove(btnCalcular);
					panel_circunferencia.remove(rdbtnEquaoExplicita);
					panel_circunferencia.remove(rdbtnPontoMdio);
					panel_circunferencia.remove(rdbtnTrigonometrica);
					panel_circunferencia.add(rdbtnPontoMdio_1);
					panel_circunferencia.add(rdbtnDda);
					panel_circunferencia.repaint();
				} else if (e.getItem().equals("ELIPSE")){
					plano.zerarImagem();
					panel_circunferencia.add(raio_x);
					panel_circunferencia.add(tf_raio_x);
					panel_circunferencia.add(raio_y);
					panel_circunferencia.add(tf_raio_y);
					panel_circunferencia.add(btnCalcular);
					panel_circunferencia.remove(rdbtnEquaoExplicita);
					panel_circunferencia.remove(rdbtnPontoMdio);
					panel_circunferencia.remove(rdbtnTrigonometrica);
					panel_circunferencia.remove(rdbtnPontoMdio_1);
					panel_circunferencia.remove(rdbtnDda);
					panel_circunferencia.repaint();
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.DARK_GRAY);
		setSize(1109, 551);
		setVisible(true);
		
	}
}
