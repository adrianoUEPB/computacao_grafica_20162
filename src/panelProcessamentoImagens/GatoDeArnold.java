package panelProcessamentoImagens;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import algoritmosProcessamentoImagens.ProcessamentoDeImagemGatoDeArnaldo;

public class GatoDeArnold {

	private int[][] img;
	private int[][] copyImg;
	private int[][] arnold;
	private ImagemPGM image;
	private int iteracoes;

	JLabel label;
	ImageIcon icon;


	PainelGatoDeArnold painelGatoDeArnold = new PainelGatoDeArnold();
	public GatoDeArnold(int[][] matrizDoGato) {
		this.img = matrizDoGato;
		this.arnold = matrizDoGato;
		this.image = new ImagemPGM(matrizDoGato[0].length,	matrizDoGato.length, 256, matrizDoGato);
		this.iteracoes = 0;
		this.createCopy();
		processaUmaVez();
	}

	public boolean condicaoDeContinuidade() {
		if (!this.equals(this.img, this.arnold)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean equals(int[][] matrizA, int[][] matrizB) {
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[i].length; j++) {
				if (matrizA[i][j] != matrizB[i][j])
					return false;
			}
		}
		return true;
	}

	private void createCopy() {
		this.copyImg = new int[img.length][img[0].length];
		for (int i = 0; i < copyImg.length; i++) {
			for (int j = 0; j < copyImg[i].length; j++) {
				copyImg[i][j] = img[i][j];
			}
		}
	}
	//processa apenas uma vez
	public void processaUmaVez() {
		int x = 0;
		int y = 0;
		this.iteracoes++;
		for (int i = 0; i < arnold.length; i++) {
			for (int j = 0; j < arnold[i].length; j++) {
				x = ((i + j) % img.length);
				y = ((j + 2 * i) % img[0].length);
				arnold[x][y] = copyImg[i][j];
			}
		}

		for (int i = 0; i < copyImg.length; i++) {
			for (int j = 0; j < copyImg[i].length; j++) {
				copyImg[i][j] = arnold[i][j];
			}
		}
	}

	public ImagemPGM getArnoldImage() {
		return new ImagemPGM(this.image.largura, this.image.altura,
				this.image.maxValue, this.arnold);
	}

	public int getIteracoes() {
		return this.iteracoes;
	}

	public void setIteracoes() {
		this.iteracoes = iteracoes + 1;
	}

	public void mostraGato() {

		icon = new ImageIcon(this.getArnoldImage().geraBuffer());
		label = new JLabel(icon);
		painelGatoDeArnold.panelDaImagem2.removeAll();
		painelGatoDeArnold.panelDaImagem2.add(label);
		painelGatoDeArnold.panelDaImagem2.validate();
		painelGatoDeArnold.panelDaImagem2.repaint();

		label.setBounds(0, 0, 256, 256);

	}

	public void executa() {
		
		while (this.condicaoDeContinuidade()) {

			this.processaUmaVez();
			this.icon.setImage(this.getArnoldImage().geraBuffer());
			this.label.setIcon(this.icon);

			painelGatoDeArnold.panelDaImagem2.add(label);
			painelGatoDeArnold.panelDaImagem2.validate();
			painelGatoDeArnold.panelDaImagem2.repaint();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Erro na execu��o da thread");
				e.printStackTrace();
			}
		}

	}

}