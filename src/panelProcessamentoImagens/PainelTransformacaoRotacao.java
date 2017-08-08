package panelProcessamentoImagens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import algoritmosProcessamentoImagens.*;

public class PainelTransformacaoRotacao extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanellDaImagem panelDaImagem1 = new PanellDaImagem();
	public static ProcessamentoImagensTransformacaoGammaLogaritmoNegativo panelDaImagem2 = new ProcessamentoImagensTransformacaoGammaLogaritmoNegativo();
	public PainelTransformacaoRotacao(){
		setBackground(Color.DARK_GRAY);
		setSize(890, 545);
		setLayout(null);
		setVisible(true);
		
		// Painel inicial
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.DARK_GRAY);
		panelSuperior.setBounds(0, 0, 1024, 48);
		add(panelSuperior);
		panelSuperior.setLayout(null);

		JLabel labelFiltroMedia = new JLabel("Transforma��o Rota��o");
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
					JOptionPane.showMessageDialog(null, "N�o foi possivel carregar a imagem.");  				        
				}    				
			}
	
		});
		botaoSelecionarImagem.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		botaoSelecionarImagem.setBackground(Color.DARK_GRAY);
		botaoSelecionarImagem.setBounds(10, 340, 245, 35);
		add(botaoSelecionarImagem);
		
		JLabel labelGamma = new JLabel("Rota��o");
		labelGamma.setForeground(Color.WHITE);
		labelGamma.setBackground(Color.WHITE);
		labelGamma.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		labelGamma.setBounds(574, 79, 194, 35);
		add(labelGamma);
		
		
		JComboBox<String> comboBoxRotacao = new JComboBox<String>();
		comboBoxRotacao.setModel(new DefaultComboBoxModel<String>(new String[] {"", "90", "120", "180"}));
		comboBoxRotacao.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));

		comboBoxRotacao.setBounds(574, 115, 174, 41);
		add(comboBoxRotacao);
		

		JButton bntGama = new JButton("Transforma��o Rota��o");
		bntGama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse){	
				TransformacaoRotacao transformacaoRotacao = new TransformacaoRotacao();

			if(comboBoxRotacao.getSelectedItem() != null && panelDaImagem1 != null ){
				try {
					transformacaoRotacao.rotacao(255, 255, panelDaImagem1.matrizImagem, 
							Integer.valueOf((String) comboBoxRotacao.getSelectedItem()));
						
				} catch (Exception e) {
					e.printStackTrace();
				}				
			
			}
				
			}
	
		});
		bntGama.setForeground(Color.WHITE);
		bntGama.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		bntGama.setBackground(Color.DARK_GRAY);
		bntGama.setBounds(292, 339, 245, 35);
		add(bntGama);

	}
}
