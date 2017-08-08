package panelProcessamentoImagens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algoritmosProcessamentoImagens.ProcessamentoImagensGraficoHistograma;


public class PainelHistograma extends JPanel {
	PanellDaImagem panelDaImagem1 = new PanellDaImagem();
	BufferedImage imagem;
	public PainelHistograma(){
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setSize(890, 608);
		setLayout(null);
		setVisible(true);
		
		// Painel inicial
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.DARK_GRAY);
		panelSuperior.setBounds(0, 0, 1024, 48);
		add(panelSuperior);
		panelSuperior.setLayout(null);

		JLabel labelFiltroMedia = new JLabel("Gr\u00E1fico Histograma");
		labelFiltroMedia.setBackground(Color.DARK_GRAY);
		labelFiltroMedia.setForeground(Color.WHITE);
		labelFiltroMedia.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 24));
		labelFiltroMedia.setBounds(10, 11, 730, 32);
		panelSuperior.add(labelFiltroMedia);
		
		panelDaImagem1 = new PanellDaImagem();
		panelDaImagem1.setBackground(Color.DARK_GRAY);
		panelDaImagem1.setBounds(10, 79, 245, 245);
		add(panelDaImagem1);
		
	
		JButton bntSelecionarImagem = new JButton("Escolher imagem");
		bntSelecionarImagem.setForeground(Color.WHITE);
		bntSelecionarImagem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent eventoDeMouse) {		

				final JFileChooser fileChooser = new JFileChooser();
				//Caminho da imagem
				fileChooser.setCurrentDirectory(new File("src/imagens/"));
				if (fileChooser.showOpenDialog(bntSelecionarImagem) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					panelDaImagem1.colocaImagemNoPainel(file.getPath());
					repaint();
					ProcessamentoImagensGraficoHistograma graficoHistograma = new ProcessamentoImagensGraficoHistograma();
					graficoHistograma.inserirImagemNoPainelImagemHistograma(file.getPath());
					add(graficoHistograma);
					graficoHistograma.setLocation(303, 79);    	
				}
			}
	
		});
		bntSelecionarImagem.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		bntSelecionarImagem.setBackground(Color.DARK_GRAY);
		bntSelecionarImagem.setBounds(10, 340, 245, 35);
		add(bntSelecionarImagem);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage((Image) imagem, 0, 0, null);
	}	
}
