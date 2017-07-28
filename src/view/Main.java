package view;
import javax.swing.DefaultComboBoxModel;

public class Main {
	public static void main(String[] args) {
		Janela2D janela2D = new Janela2D();		
		janela2D.comboBox.setModel(new DefaultComboBoxModel(new String[] {"PIXEL", "RETA", "CIRCUNFERENCIA", "ELIPSE"}));
	}
}
