package algoritmosProcessamentoImagens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ProcessamentoImagensOperadoresLogicos extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProcessamentoImagensOperadoresLogicos() {		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 250, 250));
	}
	/**
	 * Inserindo a imagem no Painel do calculo da Operacao Aritmetica Logica AND      
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */	
	public void inserirImagemNoPainelOperadorLogicoAND(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][], 
			int altura_Imagem2, int largura_Imagem2, int matriz_Imagem2[][]){		
		try {
			OperadorLogicoAND(altura_Imagem1, largura_Imagem1, matriz_Imagem1, altura_Imagem2, largura_Imagem2, 
					matriz_Imagem2);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
   	/**
	 * Processamento da imagem utilizando a
	 * Operacao Logico AND   
	 * @param altura_Imagem1
	 * @param largura_Imagem1
	 * @param matriz_Imagem1
	 * @param altura_Imagem2
	 * @param largura_Imagem2
	 * @param matriz_Imagem2
	 */ 
	public void OperadorLogicoAND(int altura_Imagem1, int largura_Imagem1,int matriz_Imagem1[][],  int altura_Imagem2,   
			int largura_Imagem2, int matriz_Imagem2[][]) throws Exception{
        int altura;
        int largura;
        /*       
         * Verifica a imagem com menor resolucao e utiliza a menor resolucao como 
         * padrao da resolucao da imagem processada com a Operador logico AND
         */
        if(altura_Imagem1 <= altura_Imagem2){
        	altura = altura_Imagem1;
        } else {
        	altura = altura_Imagem2;
        }
        
        if(largura_Imagem1 <= largura_Imagem2){
        	largura = largura_Imagem1;
        } else {
        	largura = largura_Imagem2;
        }
        
        int matriz[][] = new int[altura][largura];       
        buffer = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){        		
        		//operador logico AND
        		matriz[i][j] = (matriz_Imagem1[i][j] & matriz_Imagem2[i][j]);        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
        		if(matriz[i][j] > 255){
        			matriz[i][j] = 255;
        		}
        		
        		buffer.setRGB(j, i, corPixel(matriz[i][j]));
        		repaint();
        	}
        } 
    }
	/**
	 * Inserindo a imagem no Painel do calculo da Operacao Aritmetica Logica OR     
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */	
	public void inserirImagemNoPainelOperadorLogicoOR(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][], 
			int altura_Imagem2, int largura_Imagem2, int matriz_Imagem2[][]){		
		try {
			OperacaoLogicaOR(altura_Imagem1, largura_Imagem1, matriz_Imagem1, altura_Imagem2, largura_Imagem2, 
					matriz_Imagem2);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Processamento da imagem utilizando a
	 * Operacao Logico OR   
	 * @param altura_Imagem1
	 * @param largura_Imagem1
	 * @param matriz_Imagem1
	 * @param altura_Imagem2
	 * @param largura_Imagem2
	 * @param matriz_Imagem2
	 */ 
	public void OperacaoLogicaOR(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][], int altura_Imagem2, 
			int largura_Imagem2, int matriz_Imagem2[][]) throws Exception{
        int altura;
        int largura;

        /*
         * Verifica a imagem com menor resolucao e utiliza a menor resolucao como  
         * padrao da resolucao da imagem processada com a Operador logico or
         */
        if(altura_Imagem1 <= altura_Imagem2){
        	altura = altura_Imagem1;
        } else {
        	altura = altura_Imagem2;
        }        
        if(largura_Imagem1 <= largura_Imagem2){
        	largura = largura_Imagem1;
        } else {
        	largura = largura_Imagem2;
        }
        
        int matriz[][] = new int[altura][largura];       
        buffer = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){
        		
        		//operador logico OR
        		matriz[i][j] = (matriz_Imagem1[i][j] | matriz_Imagem2[i][j]);
        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
        		if(matriz[i][j] > 255){
        			matriz[i][j] = 255;
        		}
        		
        		buffer.setRGB(j, i, corPixel(matriz[i][j]));
        		repaint();
        	}
        } 
    }
	
	/**
	 * Inserindo a imagem no Painel do calculo da Operacao Aritmetica Logica OR     
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */	
	public void inserirImagemNoPainelOperadorLogicoXOR(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][], 
			int altura_Imagem2, int largura_Imagem2, int matriz_Imagem2[][]){		
		try {
			OperacaoLogicaXOR(altura_Imagem1, largura_Imagem1, matriz_Imagem1, altura_Imagem2, largura_Imagem2, 
					matriz_Imagem2);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
  	/**
	 * Processamento da imagem utilizando a
	 * Operacao Logico XOR   
	 * @param altura_Imagem1
	 * @param largura_Imagem1
	 * @param matriz_Imagem1
	 * @param altura_Imagem2
	 * @param largura_Imagem2
	 * @param matriz_Imagem2
	 */ 
	public void OperacaoLogicaXOR(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][], int altura_Imagem2, 
			int largura_Imagem2, int matriz_Imagem2[][]) throws Exception{
        int altura;
        int largura;
        
        /*
         * Verifica a imagem com menor resolucao e utiliza a menor resolucao como 
         * padrao da resolucao da imagem processada com a Operador logico XOR
         */
        if(altura_Imagem1 <= altura_Imagem2){
        	altura = altura_Imagem1;
        } else {
        	altura = altura_Imagem2;
        }
        
        if(largura_Imagem1 <= largura_Imagem2){
        	largura = largura_Imagem1;
        } else {
        	largura = largura_Imagem2;
        }
        
        int matriz[][] = new int[altura][largura];       
        buffer = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){        		
        		//operacao de XOR
        		matriz[i][j] = (matriz_Imagem1[i][j] ^ matriz_Imagem2[i][j]);
        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
        		if(matriz[i][j] > 255){
        			matriz[i][j] = 255;
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