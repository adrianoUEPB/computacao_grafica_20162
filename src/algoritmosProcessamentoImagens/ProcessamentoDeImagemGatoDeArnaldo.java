package algoritmosProcessamentoImagens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ProcessamentoDeImagemGatoDeArnaldo extends JPanel {

	private static final long serialVersionUID = 1L;
	public BufferedImage imagemGatoDeArnold;
	//inicializando o painel
	public ProcessamentoDeImagemGatoDeArnaldo() {		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 250, 250));
	}	
	
	/**
	 * Inserindo a imagem do gato de Arnnold no Painel       
	 * @param  alturaImagem1 - a altura da imagem 1
	 * @param larguraImagem1 - a largura da imagem
	 * @param matrizImagem1 - a matriz da imagem
	 */	
	public void inserImagemNoPainelGatoDeArnold(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][]){
		try {
			geraImagemDoGatoDeArnald(alturaDaImagem1, larguraDaImagem1, matrizDaImagem1);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void geraImagemDoGatoDeArnald(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][]) throws Exception{
		        int altura = alturaDaImagem1;
        int largura = larguraDaImagem1;        
        imagemGatoDeArnold = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);      
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagemGatoDeArnold, 0, 0, null);
	}
}
