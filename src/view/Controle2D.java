package view;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Controle2D extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5080474631482001415L;
	
	public static PlanoCartesiano cartesiano;
	public static JComboBox<String> cb;
	public static JLabel label;
	public static JPanel circunferencia;

	
	public Controle2D() {
		cartesiano = new PlanoCartesiano();
		
		setBackground(Color.DARK_GRAY);	
		setBounds(0, 0, 1100, 500);
		setLayout(null);

		cartesiano.setBounds(cartesiano.POS_X, cartesiano.POS_Y, cartesiano.LARGURA, cartesiano.ALTURA);

		add(cartesiano);
		label = new JLabel("ASDFASDFADS");
		label.setForeground(Color.WHITE);
		label.setBounds(10, -30, 100, 100);		

		
		cb = new JComboBox<String>();
		String[] lista_cb = {"DDA", "Circunferencia"};
				
		for (int i = 0; i < lista_cb.length; i++)
			cb.addItem(lista_cb[i]);
		
		cb.setBounds(10, 40, 100, 20);
		add(cb);
		
		cb.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange() == ItemEvent.SELECTED) {					
					
					if (cb.getSelectedIndex() == 1) {
						add(new PanelCircunferencia());
					}
				}
				
				
			}
		});
		
		add(label);	
	}
}


