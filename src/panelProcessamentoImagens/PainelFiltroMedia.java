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

public class PainelFiltroMedia extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanellDaImagem panelDaImagem1 = new PanellDaImagem();
	ProcessamentoImagensFiltros panelDaImagem2 = new ProcessamentoImagensFiltros();
	
	public PainelFiltroMedia(){
		setBackground(Color.DARK_GRAY);
		setSize(890, 526);
		setLayout(null);
		setVisible(true);	
		
		Font fonte = new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18);
		Font fonte1 = new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 24);


		// Painel inicial
		JPanel panelSuperior = new JPanel();
		panelSuperior.setForeground(Color.DARK_GRAY);
		panelSuperior.setBackground(Color.DARK_GRAY);
		panelSuperior.setBounds(0, 0, 1024, 48);
		add(panelSuperior);
		panelSuperior.setLayout(null);
		// Corpo do sistema
		JLabel labelFiltroMedia = new JLabel("Filtros M\u00E9dia");
		labelFiltroMedia.setBackground(Color.WHITE);
		labelFiltroMedia.setForeground(Color.WHITE);
		labelFiltroMedia.setFont(fonte1);
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
		botaoSelecionarImagem.setFont(fonte);
		botaoSelecionarImagem.setBackground(Color.DARK_GRAY);
		botaoSelecionarImagem.setBounds(10, 340, 245, 35);
		add(botaoSelecionarImagem);
		
		JButton botaoMedia = new JButton("Filtro M\u00E9dia");
		botaoMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse){			
				panelDaImagem2.InserirImagemNoPainelMedia(panelDaImagem1.altura, panelDaImagem1.largura
						, panelDaImagem1.matrizImagem);				
			}
		});
		botaoMedia.setForeground(Color.WHITE);
		botaoMedia.setFont(fonte);
		botaoMedia.setBackground(Color.DARK_GRAY);
		botaoMedia.setBounds(292, 339, 245, 35);
		add(botaoMedia);

	}
}
