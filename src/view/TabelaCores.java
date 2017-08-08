package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class TabelaCores extends JFrame {
	private JTable table;
	
	public TabelaCores() {
		getContentPane().setBackground(Color.DARK_GRAY);
		
		setTitle("Computação Gráfica: Tabela de cores");
		setResizable(false);
		setSize(684, 688);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		String[][] modelo = new String[36][6];
		int x = 000000, count = 0;
		String[] num = new String[6];
		String par1 = "00", par2 = "00", par3 = "00";
		
		for (int i = 0; i < 6; i++){
			par1 = Integer.toHexString(x+(i*51));
			if (par1.length() == 1)
				par1 = par1 + "0";
			
			for (int j = 0; j < 6; j++){
				par2 = Integer.toHexString(x+(j*51));
				if (par2.length() == 1)
					par2 = par2 + "0";

				for (int k = 0; k < 6; k++){
					par3 = Integer.toHexString(x+(k*51));
					if (par3.length() == 1)
						par3 = par3 + "0";
					
					num[k] = "#" + par1 + "" + par2 + "" + par3;
				}

				modelo[count] = num.clone();
				count++;
			}
		}
		
		JLabel labelTabela = new JLabel("Tabela de Cores");
		labelTabela.setForeground(Color.WHITE);
		labelTabela.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		labelTabela.setHorizontalAlignment(SwingConstants.CENTER);
		labelTabela.setBounds(10, 11, 664, 32);
		getContentPane().add(labelTabela);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBounds(10, 54, 658, 599);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		table.setGridColor(Color.BLACK);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(modelo,
			new String[] {
				"1", "2", "3", "4", "5", "6"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.setDefaultRenderer(Object.class, new MeuModelo());
		
	}
	
	public class MeuModelo extends DefaultTableCellRenderer {

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        Color c = Color.WHITE;
	        Object text = table.getValueAt(row, column);
	        if (text != null)
	        	c = Color.decode("" + text);
	        label.setBackground(c);
	        return label;
	    }
	}

	public static void main(String[] args) {

	}
}
