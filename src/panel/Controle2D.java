package panel;

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
	public static JRadioButton eq_explicita, trigonometrica, ponto_medio;
	public static  ButtonGroup grupo;

	
	public Controle2D() {
		cartesiano = new PlanoCartesiano();
		
		setBackground(Color.DARK_GRAY);	
		setBounds(0, 0, 1100, 500);
		setLayout(null);

		
		add(cartesiano);

	}
}


