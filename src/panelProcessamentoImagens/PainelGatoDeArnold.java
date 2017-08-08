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

public class PainelGatoDeArnold extends JPanel {
	PanellDaImagem panelDaImagem1 = new PanellDaImagem();
	public static ProcessamentoDeImagemGatoDeArnaldo panelDaImagem2 = new ProcessamentoDeImagemGatoDeArnaldo();
	
	public PainelGatoDeArnold(){
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setSize(890, 624);
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

		JLabel labelFiltroMedia = new JLabel("Gato De Arnold");
		labelFiltroMedia.setBackground(Color.DARK_GRAY);
		labelFiltroMedia.setForeground(Color.WHITE);
		labelFiltroMedia.setFont(fonte1);
		labelFiltroMedia.setBounds(10, 11, 730, 32);
		panelSuperior.add(labelFiltroMedia);
		
		//panelDaImagem1 = new PanellDaImagem();
//		panelDaImagem1.setBackground(Color.DARK_GRAY);
//		panelDaImagem1.setBounds(10, 79, 245, 245);
//		add(panelDaImagem1);
//		panelDaImagem2.setForeground(Color.DARK_GRAY);
//		panelDaImagem2.setBackground(Color.DARK_GRAY);
//		
//		panelDaImagem2.setBounds(292, 79, 245, 245);
//		panelDaImagem2.setVisible(true);
//		add(panelDaImagem2);
		
	

		panelDaImagem1 = new PanellDaImagem();
		panelDaImagem1.setBackground(Color.DARK_GRAY);
		panelDaImagem1.setBounds(10, 84, 245, 245);
		add(panelDaImagem1);
		panelDaImagem2.setForeground(Color.DARK_GRAY);
		panelDaImagem2.setBackground(Color.DARK_GRAY);

		panelDaImagem2.setBounds(287, 84, 250, 250);
		panelDaImagem2.setVisible(true);
		add(panelDaImagem2);
		
		JButton botaoSelecionarImagem = new JButton("Escolher imagem");
		botaoSelecionarImagem.setForeground(Color.WHITE);
		botaoSelecionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {				
			try {

//					// Instanciacao de fileChooser e alteracao do diretorio para
					final JFileChooser fileChooser = new JFileChooser();
					// Indo atras da imagem
				fileChooser.setCurrentDirectory(new File("src/imagens"));
					// Verificacao do fileChooser
					if (fileChooser.showOpenDialog(botaoSelecionarImagem) == JFileChooser.APPROVE_OPTION) {
						// Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();
						panelDaImagem1.colocaImagemNoPainel(file.getPath());
						repaint();
					}

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null,
							"Não foi possivel carregar a imagem.");
				} 				
			}
		});
		botaoSelecionarImagem.setFont(fonte);
		botaoSelecionarImagem.setBackground(Color.DARK_GRAY);
		botaoSelecionarImagem.setBounds(10, 340, 245, 35);
		add(botaoSelecionarImagem);
		
	JButton botaoMedia = new JButton("Gato de Arnold");
		botaoMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse){	
				Thread minhaThread = new Thread() {
					public void run() {
						for (int i = 0; i < 256; i++) {
							GatoDeArnold gatoDeArnold = new GatoDeArnold(
									panelDaImagem1.matrizImagem);
							gatoDeArnold.mostraGato();
							gatoDeArnold.executa();
							repaint();
							try {
								sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
				}
				};
				minhaThread.start();		
			}
		});
		botaoMedia.setForeground(Color.WHITE);
		botaoMedia.setFont(fonte);
		botaoMedia.setBackground(Color.DARK_GRAY);
		botaoMedia.setBounds(287, 339, 245, 35);
		add(botaoMedia);

	}
}
