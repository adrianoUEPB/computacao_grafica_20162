package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6782874347870569355L;
	
	public static Controle2D panelContent;	
	public Main() {
		init();
	}
	
	public void init() {
		setSize(1110, 520);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelContent = new Controle2D();
		add(panelContent);
	}
	
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);				
			}			
		});		
	}
}
