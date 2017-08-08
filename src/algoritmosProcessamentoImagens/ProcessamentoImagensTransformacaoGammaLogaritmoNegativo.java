package algoritmosProcessamentoImagens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ProcessamentoImagensTransformacaoGammaLogaritmoNegativo extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProcessamentoImagensTransformacaoGammaLogaritmoNegativo() {		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 255, 255));				
	}	
	
	/**
	 * Inserindo a imagem no Painel do calculo da Transformaa��o Gama   
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  Gama - Valor de gama
	 * @param valor
	 */	

	public void inserirImagemNoPainelTransformacaoGamma(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][],
			float Gamma, float valor){		
		try {
			TransformacaoGamma(alturaDaImagem1, larguraDaImagem1, matrizDaImagem1, Gamma, valor);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Calculo do processamento da imagem utilizando a
	 * Transformacao Gamma   
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param Gama - valor de gama
	 * @param valor
	 */
	public void TransformacaoGamma(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][],
			float Gamma, float valor) throws Exception{
        int altura = altura_Imagem1;
        int largura = largura_Imagem1;
        
        int matriz[][] = new int[altura][largura];       
        buffer = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i < altura; i++){
        	for(int j = 0;j < largura; j++){        		
        		matriz[i][j] = (int)(valor * (Math.pow(matriz_Imagem1[i][j], Gamma)));
        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
        		if(matriz[i][j] > 255){
        			matriz[i][j] = 255;
        		}
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor minimo de 0
        		if(matriz[i][j] < 0){
        			matriz[i][j] = 0;
        		}        		
        		buffer.setRGB(j, i, corPixel(matriz[i][j]));
        		repaint();
        	}
        } 
    }
	
	/**
	 * Inserindo a imagem no Painel do calculo da transforma��o Logaritmica  
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  Gama - Valor de gama
	 */	

	public void inserirImagemNoPainelTransformcaoLogaritmo(int alturaDaImagem1, int larguraDaImagem1, 
			int matrizDaImagem1[][],
			float constante){		
		try {
			TransformcaoLogaritmo(alturaDaImagem1, larguraDaImagem1, matrizDaImagem1, constante);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Calculo do processamento da imagem utilizando a
	 * Transformacao Logaritmico   
	 * @param altura_Imagem1
	 * @param largura_Imagem1
	 * @param matriz_Imagem1
	 * @param constante
	 */	
	public void TransformcaoLogaritmo(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][],
			float constante) throws Exception{
        int altura = altura_Imagem1;
        int largura = largura_Imagem1;
        
        int matriz[][] = new int[altura][largura];       
        buffer = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){        		
        		matriz[i][j] = (int)(constante * (Math.log(matriz_Imagem1[i][j] + 1)));
        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
        		if(matriz[i][j] > 255){
        			matriz[i][j] = 255;
        		}
        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor minimo de 0
        		if(matriz[i][j] < 0){
        			matriz[i][j] = 0;
        		}        		
        		buffer.setRGB(j, i, corPixel(matriz[i][j]));
        		repaint();
        	}
        } 
    }	

	
	/**
	 * Inserindo a imagem no Painel do calculo da transforma��o Logaritmica  
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  Gama - Valor de gama
	 */	

	public void inserirImagemNotransformacaoNegativa(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][]){		
		try {
			transformacaoNegativa(alturaDaImagem1, larguraDaImagem1, matrizDaImagem1);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculo do processamento da imagem utilizando a
	 * Transformacao Negativo 
	 * @param altura_Imagem1
	 * @param largura_Imagem1
	 * @param matriz_Imagem1
	 */		
	public void transformacaoNegativa(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][]) throws Exception{
        int altura = altura_Imagem1;
        int largura = largura_Imagem1;        
        int matriz[][] = new int[altura][largura];       
        buffer = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){        		
        		matriz[i][j] = 255 - matriz_Imagem1[i][j];        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
        		if(matriz[i][j] > 255){
        			matriz[i][j] = 255;
        		}        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor minimo de 0
        		if(matriz[i][j] < 0){
        			matriz[i][j] = 0;
        		}        		
        		buffer.setRGB(j, i, corPixel(matriz[i][j]));
        		repaint();
        	}
        } 
    }

	static int corPixel(int corP){
		Color cor = new Color(corP, corP, corP);
		return cor.getRGB();
	}
	public BufferedImage buffer;
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
	}

}
