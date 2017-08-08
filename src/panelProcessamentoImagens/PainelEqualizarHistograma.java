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
import javax.swing.border.LineBorder;

import algoritmosProcessamentoImagens.ProcessamentoImagemGraficoHistogramaMatriz;
import algoritmosProcessamentoImagens.ProcessamentoImagensGraficoHistograma;




public class PainelEqualizarHistograma extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanellDaImagem panelDaImagem1 = new PanellDaImagem();
	PanellDaImagem panelDaImagem2 = new PanellDaImagem();
	ProcessamentoImagemGraficoHistogramaMatriz graficoHistograma2 = new ProcessamentoImagemGraficoHistogramaMatriz();
	PanellDaImagem panelIEqualizadaMatriz = new PanellDaImagem();
	BufferedImage imagem;

	public PainelEqualizarHistograma(){
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setSize(901, 719);
		setLayout(null);
		setVisible(true);
		
		// Painel inicial
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.DARK_GRAY);
		panelSuperior.setBounds(0, 0, 1024, 48);
		add(panelSuperior);
		panelSuperior.setLayout(null);

		JLabel labelFiltroMedia = new JLabel("Gr\u00E1fico do Histograma Equalizado");
		labelFiltroMedia.setBackground(Color.DARK_GRAY);
		labelFiltroMedia.setForeground(Color.WHITE);
		labelFiltroMedia.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 24));
		labelFiltroMedia.setBounds(10, 11, 730, 32);
		panelSuperior.add(labelFiltroMedia);
		panelDaImagem1.setBackground(Color.DARK_GRAY);

		//PanellDaImagem panelDaImagem1 = new PanellDaImagem();
		panelDaImagem1.setSize(250, 250);
		panelDaImagem1.setForeground(Color.DARK_GRAY);
		panelDaImagem1.setBackground(Color.DARK_GRAY);
		panelDaImagem1.setLocation(21, 74);
		add(panelDaImagem1);

		PanellDaImagem panelDaImagemEqualizada = new PanellDaImagem();
		panelDaImagemEqualizada.setSize(250, 250);
		panelDaImagemEqualizada.setBackground(Color.DARK_GRAY);
		panelDaImagemEqualizada.setForeground(Color.DARK_GRAY);
		panelDaImagemEqualizada.setLocation(303, 74);
		add(panelDaImagemEqualizada);
		graficoHistograma2.setSize(250, 255);
		graficoHistograma2.setBackground(Color.DARK_GRAY);

		graficoHistograma2.setLocation(589, 74);
		graficoHistograma2.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(graficoHistograma2);
	
		JButton bntSelecionarImagem = new JButton("Escolher imagem");
		bntSelecionarImagem.setForeground(Color.WHITE);
		bntSelecionarImagem.addActionListener(new ActionListener() {
			ProcessamentoImagensGraficoHistograma graficoHistograma1 = new ProcessamentoImagensGraficoHistograma();
			ProcessamentoImagemGraficoHistogramaMatriz graficoHistograma2 = new ProcessamentoImagemGraficoHistogramaMatriz();

			public void actionPerformed(ActionEvent eventoDeMouse) {		

	
				final JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("src/imagens/"));

				// Verificacao do fileChooser
				if (fileChooser.showOpenDialog(bntSelecionarImagem) == JFileChooser.APPROVE_OPTION) {
					// Cria um file onde eh armazenada a imagem
					File file = fileChooser.getSelectedFile();
					panelDaImagem1.colocaImagemNoPainel(file.getPath());
					repaint();
					//Grafico Histograma original
					graficoHistograma1.inserirImagemNoPainelImagemHistograma(file.getPath());
					int[][] matrizOriginal = panelDaImagem1.getMatrizImagem();
					int[][] matrizEqualizada = EqualizarImagem.equalizarImagem(matrizOriginal);
					panelDaImagemEqualizada.inserirImagemNoPainelImagemMatriz(matrizEqualizada);
					//GRafico do Histograma Equalizado
					graficoHistograma2.colocaImagemNoPainel(matrizEqualizada);
					repaint();
				}
			}	
		});
		bntSelecionarImagem.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		bntSelecionarImagem.setBackground(Color.DARK_GRAY);
		bntSelecionarImagem.setBounds(21, 335, 250, 35);
		add(bntSelecionarImagem);
		
		JLabel lblImagemEqualizad = new JLabel("Imagem Equalizada");
		lblImagemEqualizad.setForeground(Color.WHITE);
		lblImagemEqualizad.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		lblImagemEqualizad.setBackground(Color.DARK_GRAY);
		lblImagemEqualizad.setBounds(303, 338, 250, 32);
		add(lblImagemEqualizad);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage((Image) imagem, 0, 0, null);
	}	
}
