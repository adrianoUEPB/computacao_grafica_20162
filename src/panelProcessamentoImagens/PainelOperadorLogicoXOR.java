package panelProcessamentoImagens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algoritmosProcessamentoImagens.*;

public class PainelOperadorLogicoXOR extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanellDaImagem panelDaImagem1 = new PanellDaImagem();
	PanellDaImagem panelDaImagem2 = new PanellDaImagem();
	ProcessamentoImagensOperadoresLogicos panelDaImagem3 = new ProcessamentoImagensOperadoresLogicos();

	public PainelOperadorLogicoXOR(){
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setSize(890, 648);
		setLayout(null);
		setVisible(true);
		
		// Painel Superior
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.DARK_GRAY);
		panelSuperior.setBounds(0, 0, 890, 48);
		add(panelSuperior);
		panelSuperior.setLayout(null);


		JLabel labelFiltroMedia = new JLabel("Opera��o L�gica XOR");
		labelFiltroMedia.setBackground(Color.DARK_GRAY);
		labelFiltroMedia.setForeground(Color.WHITE);
		labelFiltroMedia.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 24));
		labelFiltroMedia.setBounds(10, 11, 730, 32);
		panelSuperior.add(labelFiltroMedia);
		
		panelDaImagem1 = new PanellDaImagem();
		panelDaImagem1.setBackground(Color.DARK_GRAY);
		panelDaImagem1.setBounds(10, 79, 245, 245);
		add(panelDaImagem1);
		
		panelDaImagem2.setBackground(Color.DARK_GRAY);		
		panelDaImagem2.setBounds(292, 79, 245, 245);
		panelDaImagem2.setVisible(true);
		add(panelDaImagem2);
		
		panelDaImagem3.setBackground(Color.DARK_GRAY);
		panelDaImagem3.setBounds(578, 79, 245, 245);
		add(panelDaImagem3);

		JButton bntSelecionarImagem1 = new JButton("Escolher imagem");
		bntSelecionarImagem1.setForeground(Color.WHITE);
		bntSelecionarImagem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {				
				try{  					
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File ("src/imagens"));					
					//Verificacao do fileChooser
					if (fileChooser.showOpenDialog(bntSelecionarImagem1) == JFileChooser.APPROVE_OPTION) {						
						//Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();						
						panelDaImagem1.colocaImagemNoPainel(file.getPath());			
						repaint();
					}					
				}catch(Exception erro){  				        
					JOptionPane.showMessageDialog(null, "N�o foi possivel carregar a imagem.");  				        
				}    				
			}
		});
		bntSelecionarImagem1.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		bntSelecionarImagem1.setBackground(Color.DARK_GRAY);
		bntSelecionarImagem1.setBounds(10, 340, 245, 35);
		add(bntSelecionarImagem1);
		
		JButton bntSelecionarImagem2 = new JButton("Escolher imagem");
		bntSelecionarImagem2.setForeground(Color.WHITE);
		bntSelecionarImagem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {				
				try{  					
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File ("src/imagens"));					
					//Verificacao do fileChooser
					if (fileChooser.showOpenDialog(bntSelecionarImagem2) == JFileChooser.APPROVE_OPTION) {						
						//Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();						
						panelDaImagem2.colocaImagemNoPainel(file.getPath());			
						repaint();
					}					
				}catch(Exception erro){  				        
					JOptionPane.showMessageDialog(null, "N�o foi possivel carregar a imagem.");  				        
				}    				
			}
		});
		bntSelecionarImagem2.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		bntSelecionarImagem2.setBackground(Color.DARK_GRAY);
		bntSelecionarImagem2.setBounds(292, 339, 245, 35);
		add(bntSelecionarImagem2);
		
		
		JButton bntXOR = new JButton("XOR");
		bntXOR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse){	
				panelDaImagem3.inserirImagemNoPainelOperadorLogicoXOR(panelDaImagem1.altura,	panelDaImagem1.largura,	
						panelDaImagem1.matrizImagem,panelDaImagem2.altura, panelDaImagem2.largura, panelDaImagem2.matrizImagem);				
			}
		});
		bntXOR.setForeground(Color.WHITE);
		bntXOR.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		bntXOR.setBackground(Color.DARK_GRAY);
		bntXOR.setBounds(578, 340, 245, 35);
		add(bntXOR);

	}
}
