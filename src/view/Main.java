package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 216);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnOperaesd = new JButton("Operações 2D e 3D");
		btnOperaesd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Operacoes2D_3D();
			}
		});
		btnOperaesd.setBounds(30, 34, 222, 23);
		contentPane.add(btnOperaesd);
		
		JButton btnProcessamentoDeImagens = new JButton("Processamento de Imagens");
		btnProcessamentoDeImagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProcessamentoDeImagens().setVisible(true);
			}
		});
		btnProcessamentoDeImagens.setBounds(30, 75, 222, 23);
		contentPane.add(btnProcessamentoDeImagens);
		
		JButton btnTabelaDeCores = new JButton("Tabela de Cores");
		btnTabelaDeCores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TabelaCores();
			}
		});
		btnTabelaDeCores.setBounds(30, 119, 222, 23);
		contentPane.add(btnTabelaDeCores);
	}
}
