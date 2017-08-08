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
import javax.swing.JTextField;

import algoritmosProcessamentoImagens.*;

public class PainelTransformacaoLogaritmica extends JPanel {
	PanellDaImagem panelDaImagem1 = new PanellDaImagem();
	ProcessamentoImagensTransformacaoGammaLogaritmoNegativo panelDaImagem2 = new ProcessamentoImagensTransformacaoGammaLogaritmoNegativo();
	JTextField TxtConstante;
	public PainelTransformacaoLogaritmica(){
		setSize(890, 489);
		setLayout(null);
		setVisible(true);
		
		// Painel inicial
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.DARK_GRAY);
		panelSuperior.setBounds(0, 0, 1024, 48);
		add(panelSuperior);
		panelSuperior.setLayout(null);

		JLabel labelFiltroMedia = new JLabel("Transforma\u00E7\u00E3o Logaritmica");
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
		
		JButton botaoSelecionarImagem = new JButton("Escolher imagem");
		botaoSelecionarImagem.setForeground(Color.WHITE);
		botaoSelecionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {				
				try{  					
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File ("src/imagens"));					
					//Verificacao do fileChooser
					if (fileChooser.showOpenDialog(botaoSelecionarImagem) == JFileChooser.APPROVE_OPTION) {						
						//Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();						
						panelDaImagem1.colocaImagemNoPainel(file.getPath());			
						repaint();
					}					
				}catch(Exception erro){  				        
					JOptionPane.showMessageDialog(null, "Não foi possivel carregar a imagem.");  				        
				}    				
			}
	
		});
		botaoSelecionarImagem.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		botaoSelecionarImagem.setBackground(Color.DARK_GRAY);
		botaoSelecionarImagem.setBounds(10, 340, 245, 35);
		add(botaoSelecionarImagem);
		
		TxtConstante = new JTextField();
		TxtConstante.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		TxtConstante.setBounds(574, 125, 182, 46);
		add(TxtConstante);
		TxtConstante.setColumns(10);
		
		JLabel labelGamma = new JLabel("Constante:");
		labelGamma.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		labelGamma.setBounds(574, 79, 194, 35);
		add(labelGamma);
		

		JButton bntGama = new JButton("Transformação Logaritmica");
		bntGama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse){	
				TxtConstante.setText(TxtConstante.getText().replace(",", "."));
				float constante = Float.parseFloat(TxtConstante.getText());
				
				panelDaImagem2.inserirImagemNoPainelTransformcaoLogaritmo(panelDaImagem1.altura,
						panelDaImagem1.largura, panelDaImagem1.matrizImagem, constante);						
			}
		});
		bntGama.setForeground(Color.WHITE);
		bntGama.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		bntGama.setBackground(Color.DARK_GRAY);
		bntGama.setBounds(292, 339, 245, 35);
		add(bntGama);

	}
}
