package view;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelCircunferencia extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1852731672499692271L;
	
	public static JRadioButton eq_explicita, trigonometrica, ponto_medio;
	public static  ButtonGroup grupo;
	
	public PanelCircunferencia() {
		setBounds(10, 100, 200,100);
		eq_explicita = new JRadioButton("Equação Explicita");
		eq_explicita.setBounds(0, 100, 150, 15);
		trigonometrica = new JRadioButton("Trigonometrica");
		trigonometrica.setBounds(0, 115, 150, 15);
		ponto_medio = new JRadioButton("Ponto Médio");
		ponto_medio.setBounds(0, 130, 150, 15);
					
		grupo = new ButtonGroup();
		grupo.add(eq_explicita);
		grupo.add(trigonometrica);
		grupo.add(ponto_medio);
		
		
		
		add(eq_explicita);
		add(trigonometrica);
		add(ponto_medio);
	}
}
