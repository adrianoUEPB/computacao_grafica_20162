package algoritmosProcessamentoImagens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ProcessamentoImagensOperacoesAritmeticas extends JPanel{
	
	public ProcessamentoImagensOperacoesAritmeticas() {		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 250, 250));
	}
	/**
	 * Inserindo a imagem no Painel do calculo da Operacao Aritmetica Adicao      
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */	
	public void inserirImagemNoPainelOperacaoAritmeticaAdicao(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][], 
			int altura_Imagem2, int largura_Imagem2, int matriz_Imagem2[][]){		
		try {
			OperacaoAritmeticaAdicao(altura_Imagem1, largura_Imagem1, matriz_Imagem1,
					altura_Imagem2, largura_Imagem2, matriz_Imagem2);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

   	/**
	 * Calculo do processamento da imagem utilizando a
	 * Operacao Aritmetica de Adicao   
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */ 
	public void OperacaoAritmeticaAdicao(int altura_Imagem1, int largura_Imagem1 ,int matriz_Imagem1[][],
			int altura_Imagem2,	int largura_Imagem2, int matriz_Imagem2[][]) throws Exception{
        int altura;
        int largura;
     /*
      * Verica a imagem com menor resolucao utiliza a menor resolucao como 
      * padrao da resolucao da imagem processada com a operacao de adicao
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
        
        for(int i = 0; i < altura; i++){
        	for(int j = 0;j < largura; j++){        		
        		//Opera��o de adicao
        		matriz[i][j] = matriz_Imagem1[i][j] + matriz_Imagem2[i][j];        		
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
	 * Inserindo a imagem no Painel do calculo da Operacao Aritmetica Subtracao      
	 * @param  alturaImagem1 - a altura da imagem 1
	 * @param larguraImagem1 - a largura da imagem 1
	 * @param matrizImagem1 - a matriz da imagem 1
	 * @param  alturaImagem1 - a altura da imagem 2
	 * @param larguraImagem1 - a largura da imagem 2
	 * @param matrizImagem1 - a matriz da imagem 2
	 */	
	public void inserirImagemNoPainelOperacaoAritmeticaSubtracao(int altura_Imagem1, int largura_Imagem1,
			int matriz_Imagem1[][], int altura_Imagem2, int largura_Imagem2, int matriz_Imagem2[][]){		
		try {
			OperacaoAritmeticaSubtracao(altura_Imagem1, largura_Imagem1, matriz_Imagem1,altura_Imagem2, 
					largura_Imagem2, matriz_Imagem2);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

   	/**
	 * Calculo do processamento da imagem utilizando a
	 * Operacao Aritmetica de Subtracao   
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */ 
	public void OperacaoAritmeticaSubtracao(int altura_Imagem1,  int largura_Imagem1, int matriz_Imagem1[][],
			int altura_Imagem2	,int largura_Imagem2, int matriz_Imagem2[][]) throws Exception{
        int altura;
        int largura;        
        /*Verifica a imagem com menor resolucao e Utiliza a menor resolucao 
         * como padrao da resolucao da imagem processada com a operacao de subtracao
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
        		//Operacao de subtracao
        		matriz[i][j] = matriz_Imagem1[i][j] - matriz_Imagem2[i][j];        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
        		if(matriz[i][j] < 0){
        			matriz[i][j] = 0;
        		}        		
        		buffer.setRGB(j, i, corPixel(matriz[i][j]));
        		repaint();
        	}
        } 
    }
	
	/**
	 * Inserindo a imagem no Painel do calculo da Operacao Aritmetica Divisao      
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */	
	public void inserirImagemNoPainelOperacaoAritmeticaDivisao(int altura_Imagem1, int largura_Imagem1,
			int matriz_Imagem1[][], int altura_Imagem2, int largura_Imagem2, int matriz_Imagem2[][]){		
		try {
			OperacaoAritmeticaDivisao(altura_Imagem1, largura_Imagem1, matriz_Imagem1,altura_Imagem2, 
					largura_Imagem2, matriz_Imagem2);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
   	
	/**
	 * Calculo do processamento da imagem utilizando a
	 * Operacao Aritmetica de Divisao   
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */ 
	public void OperacaoAritmeticaDivisao(int alturaImagem1, int larguraImagem1, int matrizImagem1[][], 
			int alturaImagem2, int larguraImagem2, int matrizImagem2[][]) throws Exception{
        int altura;
        int largura;      
        /*
         * Verificacao da imagem com menor resolucao Utiliza a menor resolucao como 
         * padrao da resolucao da imagem processada com a operacao de divisao
         */
         if(alturaImagem1 <= alturaImagem2){
        	altura = alturaImagem1;
        } else {
        	altura = alturaImagem2;
        }
        
        if(larguraImagem1 <= larguraImagem2){
        	largura = larguraImagem1;
        } else {
        	largura = larguraImagem2;
        }
        
        int matriz[][] = new int[altura][largura];       
        buffer = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i < altura; i++){
        	for(int j = 0; j < largura; j++){        		
        		//Operacao de divisao
        		if(matrizImagem2[i][j] == 0){        			
        			//Tratando a divisao por zero, por padrao soma  mais 1 no divisor
        			matrizImagem2[i][j] = matrizImagem2[i][j] + 1;
        			matriz[i][j] = (int)(matrizImagem1[i][j] / matrizImagem2[i][j]);
        		} else {
        			matriz[i][j] = (int)(matrizImagem1[i][j] / matrizImagem2[i][j]);
        		}        		
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
	 * Inserindo a imagem no Painel do calculo da Operacao Aritmetica Multiplicacao      
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */	
	public void inserirImagemNoPainelOperacaoAritmeticaMultiplicacao(int altura_Imagem1, int largura_Imagem1,
			int matriz_Imagem1[][], int altura_Imagem2, int largura_Imagem2, int matriz_Imagem2[][]){		
		try {
			OperacaoAritmeticaMultiplicacao(altura_Imagem1, largura_Imagem1, matriz_Imagem1,altura_Imagem2, 
					largura_Imagem2, matriz_Imagem2);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculo do processamento da imagem utilizando a
	 * Operacao Aritmetica de Multiplicacao   
	 * @param  altura_Imagem1 - a altura da imagem 1
	 * @param largura_Imagem1 - a largura da imagem 1
	 * @param matriz_Imagem1 - a matriz da imagem 1
	 * @param  altura_Imagem1 - a altura da imagem 2
	 * @param largura_Imagem1 - a largura da imagem 2
	 * @param matriz_Imagem1 - a matriz da imagem 2
	 */ 
	public void OperacaoAritmeticaMultiplicacao(int altura_Imagem1, int largura_Imagem1, int matriz_Imagem1[][], 
			int altura_Imagem2, int largura_Imagem2, int matriz_Imagem2[][]) throws Exception{
        int altura;
        int largura;
        
        /*
         * Verifica a imagem com a menor resolucao utilizando a menor resolucao como 
         * padrao da resolucao da imagem processada com a operacao de multiplicacao      
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
        		//Operacao de multiplicacao
        		matriz[i][j] = matriz_Imagem1[i][j] * matriz_Imagem2[i][j];        		
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
