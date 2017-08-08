package algoritmosProcessamentoImagens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ProcessamentoImagensFiltros extends JPanel {		
	
	public ProcessamentoImagensFiltros() {		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 245, 245));
	}
	/**
	 * Inserindo a imagem no Painel do calculo do Filtro da Media      
	 * @param  alturaImagem1 - a altura da imagem 1
	 * @param larguraImagem1 - a largura da imagem
	 * @param matrizImagem1 - a matriz da imagem
	 */	
	public void InserirImagemNoPainelMedia(int alturaImagem1, int larguraImagem1, int matrizImagem1[][]){
		try {
			FiltroMedia(alturaImagem1, larguraImagem1, matrizImagem1);	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Calculo do processamento da imagem com o Filtro da Media      
	 * @param  alturaI da imagem
	 * @param larguraI da imagem
	 * @param matrizI da imagem
	 */	
	public void FiltroMedia(int alturaI, int larguraI, int matrizI[][]) throws Exception{

		//BufferedImage Media;
		int normalizar = 0;    
        int a = alturaI;
        int l = larguraI;            
        int matriz[][] = new int[a][l];       
        buffer = new BufferedImage(a, l, BufferedImage.TYPE_INT_RGB);
        //determinando o coeficiente de normaliza��o atraves da soma dos pixels
        for(int i = 0; i < a; i++){
        	for(int j = 0; j < l; j++){        		
        		normalizar = normalizar + matrizI[i][j];
        	}
        }        

        for(int i = 0; i < a; i++){
        	for(int j = 0; j < l; j++){        		
        		//soma dos pixeis da vizinhan�a
        		int soma = 0;        		
        		//Os IFs s�o o tratamento de exce��o para o limite das bordas da matriz
        		soma = soma + matrizI[i][j];
        		if ((i - 1) >= 0) {
        			soma = soma + matrizI[i - 1][j] / normalizar;
        		}
        		if ((i + 1) < l) {
        			soma = soma + matrizI[i + 1][j] / normalizar;
        		}
        		if ((j - 1) >= 0) {
        			soma = soma + matrizI[i][j - 1] / normalizar;
        		}
        		if ((j + 1) < a) {
        			soma = soma + matrizI[i][j + 1] / normalizar;
        		}
        		if (((i - 1) >= 0) && ((j - 1) >= 0)) {
        			soma = soma + matrizI[i - 1][j - 1] / normalizar;
        		}
        		if (((i + 1) < l) && ((j - 1) >= 0)) {
        			soma = soma + matrizI[i + 1][j - 1] / normalizar;
        		}
        		if (((i - 1) >= 0) && ((j + 1) < a)) {
        			soma = soma + matrizI[i - 1][j + 1] / normalizar;
        		}
        		if (((i + 1) < l
        				
        				) && ((j + 1) < a)) {
        			soma =  soma + matrizI[i + 1][j + 1] / normalizar;
        		}
        		
        		//adiciona a soma dos valores RGB da vizinhan�a na posi��o central
        		matriz[i][j] = Math.round(soma);
        		
        		//verificacao do valor do pixel caso o mesmo ultrapasse o valor de 255 (valor maximo)
        		if(matriz[i][j] > 255){
        			matriz[i][j] = 255;
        		}        		
        		//adiciona o valor do RGB do pixel central no buffered image
        		buffer.setRGB(j, i, corPixel(matriz[i][j]));
        		repaint();
        	}
        } 
    }
	
	/**
	 * Inserindo a imagem no Painel do calculo do Filtro da Mediana      
	 * @param  alturaImagem1 - a altura da imagem 1
	 * @param larguraImagem1 - a largura da imagem
	 * @param matrizImagem1 - a matriz da imagem
	 */	
	public void InserirImagemNoPainelMediana(int alturaImagem1, int larguraImagem1, int matrizImagem1[][]){
		try {
			FiltroMediana(alturaImagem1, larguraImagem1, matrizImagem1);	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculo do processamento da imagem como o Filtro da Mediana      
	 * @param  alturaI da imagem
	 * @param larguraI da imagem
	 * @param matrizI da imagem
	 */

	public void FiltroMediana(int alturaI, int larguraI, int matrizI[][]) throws Exception{
        int a = alturaI;
        int l = larguraI;
        
        
        int matriz[][] = new int[a][l];       
        buffer = new BufferedImage(a, l, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i < a; i++){
        	for(int j = 0;j < l;j++){        		
        		//Cria��o de um vetor para armazenar os valores dos pixels da vizinhan�a
        		int[] v = new int[9];
    		    
        		v[0] += matrizI[i][j];
        		if ((i - 1) >= 0) {
        			v[1] = v[1] + matrizI[i-1][j];
        		}
        		if ((i + 1) < l) {
        			v[2] = v[2] + matrizI[i + 1][j];
        		}
        		if ((j - 1) >= 0) {
        			v[3] = v[3] + matrizI[i][j - 1];
        		}
        		if ((j + 1) < a) {
        			v[4] = v[4] + matrizI[i][j + 1];
        		}
        		if (((i - 1) >= 0) && ((j - 1) >= 0)) {
        			v[5] = v[5] + matrizI[i - 1][j - 1];
        		}
        		if (((i + 1) < a && ((j - 1) >= 0))) {
        			v[6] += v[6] +matrizI[i + 1][j - 1];
        		}
        		if (((i - 1) >= 0) && ((j + 1) < a)) {
        			v[7] = v[7] + matrizI[i - 1][j + 1];
        		}
        		if (((i + 1) < a) && ((j + 1) < a)) {
        			v[8] = v[8] + matrizI[i + 1][j + 1];
        		}
        		
        		//Ordenando o vetor para selecionar a Mediana
        		Quicksort(v, 0, 8);
        		
        		//Pegando o valor que esta na posi��o que representa a mediana no vetor
        		matriz[i][j] = v[4];
        		
        		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
        		if(matriz[i][j] > 255){
        			matriz[i][j] = 255;
        		}        		
        		//Adiciona o valor do pixel no buffered 
        		buffer.setRGB(j, i, corPixel(matriz[i][j]));
        		repaint();
        	}
        } 
    }
	
	/**
	 * Metodo de ordena��o Quicksort - esta sendo usado no Filtro da Mediana
	 * @param vetor 
	 * @param ini 
	 * @param fim
	 */
	private static void Quicksort(int[] vetor, int ini, int fim) {
		int n;
		if (ini < fim) {
			n = particionarQuicksort(vetor, ini, fim);
			Quicksort(vetor, ini, n - 1);
			Quicksort(vetor, n + 1, fim);
		}
	}
	
	/**
	 *  Particionamento de Quicksort
	 */	 
	private static int particionarQuicksort(int[] v, int inicio, int fim) {
		int aux;
		int c = v[inicio];
		int i = inicio + 1, j = fim;
		
		while (i <= j) {
			if (v[i] <= c)
				++i;
			else if (c < v[j])
				--j;
			else {
				aux = v[i];
				v[i] = v[j];
				v[j] = aux;
				++i;
				--j;
			}
		}

		aux = v[inicio];
		v[inicio] = v[j];
		v[j] = aux;
		return j;
	}	
	
	/**
	 * Inserindo a imagem no Painel do calculo do Filtro da Passa Alta      
	 * @param  alturaImagem1 - a altura da imagem 1
	 * @param larguraImagem1 - a largura da imagem
	 * @param matrizImagem1 - a matriz da imagem
	 */	
	public void InserirImagemNoPainelPassaAlta(int alturaImagem1, int larguraImagem1, int matrizImagem1[][]){
		try {
			FiltroPassaAlta(alturaImagem1, larguraImagem1, matrizImagem1);	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Calculo do processamento da imagem com o Filtro Passa Alta      
	 * @param  alturaI da imagem
	 * @param larguraI da imagem
	 * @param matrizI da imagem
	 */
	public void FiltroPassaAlta(int alturaI, int larguraI, int matrizI[][]) throws Exception{
			
        int a = alturaI;
        int l = larguraI;
        int matriz[][] = new int[a][l];       

        buffer = new BufferedImage(a, l, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i < a; i++){
        	for(int j = 0; j < l; j++){        		
        		//variavel para salvar a soma dos pixels da vizinhan�a
        		int soma = 0;        		
        		//Multiplica o pixel central por 8
        		soma = soma + (8*matrizI[i][j]);
        		
        		//Para os demais pixels, multiplica por -1
        		if ((i - 1) >= 0) {
        			soma = soma + (-1*matrizI[i - 1][j]);
        		}
        		if ((i + 1) < l) {
        			soma = soma + (-1*matrizI[i + 1][j]);
        		}
        		if ((j - 1) >= 0) {
        			soma = soma + (-1*matrizI[i][j - 1]);
        		}
        		if ((j + 1) < a) {
        			soma = soma + (-1*matrizI[i][j + 1]);
        		}
        		if (((i - 1) >= 0) && ((j - 1) >= 0)) {
        			soma = soma + (-1*matrizI[i - 1][j - 1]);
        		}
        		if (((i + 1) < l) && ((j - 1) >= 0)) {
        			soma = soma + ( -1*matrizI[i + 1][j - 1]);
        		}
        		if (((i - 1) >= 0) && ((j + 1) < a)) {
        			soma = soma + (-1*matrizI[i - 1][j + 1]);
        		}
        		if (((i + 1) < l) && ((j + 1) < a)) {
        			soma = soma + (-1*matrizI[i + 1][j + 1]);
        		}
        		
        		//na posi��o atual, pega o resultado da soma e divide por 9 e � inserido na posi��o [i][j] da matriz
        		matriz[i][j] = (int)(soma/9);
        		
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
	 * Inserindo a imagem no Painel do calculo do Filtro da Prewitt      
	 * @param  alturaImagem1 - a altura da imagem 1
	 * @param larguraImagem1 - a largura da imagem
	 * @param matrizImagem1 - a matriz da imagem
	 */	
	public void InserirImagemNoPainelPrewitt(int alturaImagem1, int larguraImagem1, int matrizImagem1[][]){
		try {
			FiltroPrewitt(alturaImagem1, larguraImagem1, matrizImagem1);
	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculo do processamento da imagem com o Filtro Prewitt      
	 * @param  alturaI da imagem
	 * @param larguraI da imagem
	 * @param matrizI da imagem
	 */
	public void FiltroPrewitt(int alturaI, int larguraI, int matrizI[][]) throws Exception{
   		int a = alturaI;
        int l = larguraI;            
        int matriz[][] = new int[a][l];       
        buffer = new BufferedImage(a, l, BufferedImage.TYPE_INT_RGB);
            
        for(int i = 0; i < a; i++){
          	for(int j = 0; j < l;j++){
          		//aproximacoes em X e Y
            	int aproxX = 0;
            	int aproxY = 0;

            	if (((i - 1) >= 0) && ((j + 1) < a)) {
            		aproxX += matrizI[i - 1][j + 1];
            		aproxY -= matrizI[i - 1][j + 1];
            	}            		
            	if ((j + 1) < a) {
            		aproxX += matrizI[i][j + 1];
            	}            		
            	if (((i + 1) < l) && ((j + 1) < a)) {
            		aproxX += matrizI[i + 1][j + 1];
            		aproxY += matrizI[i + 1][j + 1];
            	}            		
            	if (((i - 1) >= 0) && ((j - 1) >= 0)) {
            		aproxX -= matrizI[i - 1][j - 1];
            		aproxY -= matrizI[i - 1][j - 1];
            	}            		
            	if ((j - 1) >= 0) {
            		aproxX -= matrizI[i][j - 1];
            	}            		
            	if (((i + 1) < l) && ((j - 1) >= 0)){
            		aproxX -= matrizI[i + 1][j - 1];
            		aproxY += matrizI[i + 1][j - 1];
            	}            		
            	if ((i + 1) < l){
            		aproxY += matrizI[i + 1][j];
            	}            		
            	if ((i - 1) >= 0){
            		aproxY -= matrizI[i - 1][j];
            	}            		
            	//O modulo da soma das aproxima��es em X e Y
            	int m = Math.abs(aproxX) + Math.abs(aproxY);
            	matriz[i][j] = m;            	
            	//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
            	if(matriz[i][j] > 255){
            		matriz[i][j] = 255;            	}            	
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
	 * Inserindo a imagem no Painel do calculo do Filtro da Roberts      
	 * @param  alturaImagem1 - a altura da imagem 1
	 * @param larguraImagem1 - a largura da imagem
	 * @param matrizImagem1 - a matriz da imagem
	 */	
	public void InserirImagemNoPainelRoberts(int alturaImagem1, int larguraImagem1, int matrizImagem1[][]){
		try {
			FiltroRoberts(alturaImagem1, larguraImagem1, matrizImagem1);	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculo do processamento da imagem com o Filtro Roberts      
	 * @param  alturaI da imagem
	 * @param larguraI da imagem
	 * @param matrizI da imagem
	 */   	
   	public void FiltroRoberts(int alturaI, int larguraI, int matrizI[][]) throws Exception{
        int a = alturaI;
        int l = larguraI;
        int matriz[][] = new int[a][l];       
        buffer = new BufferedImage(a, l, BufferedImage.TYPE_INT_RGB);
            
        for(int i = 0; i < a; i++){
           	for(int j = 0;j < l; j++){
           	//Aproxima��es em X e Y
        	int aproxX = 0;
        	int aproxY = 0;

      		if ((j + 1) < a){
      			aproxY = matrizI[i][j] - matrizI[i][j + 1];
         	}else{
            	aproxY = matrizI[i][j];
            }
       		if ((i + 1) < a){
       			aproxX = matrizI[i][j] - matrizI[i + 1][j];
           		}else {
         			aproxX = matrizI[i][j];
           		}
            		
      		//Modulo da soma das Aproxima��es
       		int m = Math.abs(aproxX) + Math.abs(aproxY);           		
      		//Adiciona o novo valor na matriz
       		matriz[i][j] = m;
       		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor maximo de 255
       		if(matriz[i][j] > 255){
       			matriz[i][j] = 255;
       		}
       		//Verifica o valor do pixel para ver se o mesmo ultrapassou o valor minimo de 0
       		if(matriz[i][j] < 0){
            	matriz[i][j] = 0;            }
            		
            //Coloca o valor do pixel no buffered image
            buffer.setRGB(j, i, corPixel(matriz[i][j]));
            repaint();
            }
        } 
   }
   	
	
	/**
	 * Inserindo a imagem no Painel do calculo do Filtro da Roberts Cruzado    
	 * @param  alturaImagem1 - a altura da imagem 1
	 * @param larguraImagem1 - a largura da imagem
	 * @param matrizImagem1 - a matriz da imagem
	 */	
	public void InserirImagemNoPainelRobertsCruzado(int alturaImagem1, int larguraImagem1, int matrizImagem1[][]){
		try {
			FiltroRobertsCruzado(alturaImagem1, larguraImagem1, matrizImagem1);	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

   	/**
	 * Calculo do processamento da imagem com o Filtro Roberts Cruzado    
	 * @param  alturaI da imagem
	 * @param larguraI da imagem
	 * @param matrizI da imagem
	 */ 
	public void FiltroRobertsCruzado(int alturaI, int larguraI, int matizI[][]) throws Exception{
	    int a = alturaI;
	    int l = larguraI;	    
	    int matriz[][] = new int[a][l];       
	    buffer = new BufferedImage(a, l, BufferedImage.TYPE_INT_RGB);
	    
	    for(int i = 0; i < a; i++){
	    	for(int j = 0;j < l;j++){            		
	    		//Aproximacoes em X e Y
	    		int aproxX = 0;
	    		int aproxY = 0;
	
	    		if (((j + 1) < a) && ((i + 1) < a)) {
	    			aproxY = matizI[i][j] - matizI[i + 1][j + 1];
	    		} else {
	    			aproxY = matizI[i][j];
	    		}
	    		
	    		if ((i + 1) < l){
	    			aproxX += matizI[i + 1][j];
	    		}
	    		if ((j + 1) < a){
	    			aproxX += - matizI[i][j + 1];
	    		}	    		
	    		//Modulo da soma das Aproxima��es em x e y
	    		int m = Math.abs(aproxY) + Math.abs(aproxX);	    		
	    		//Adicionando o valor do pixel na matriz
	    		matriz[i][j] = m;	    		
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
	 * Inserindo a imagem no Painel do calculo do Filtro da Sobel      
	 * @param  alturaImagem1 - a altura da imagem 1
	 * @param larguraImagem1 - a largura da imagem
	 * @param matrizImagem1 - a matriz da imagem
	 */	
	public void InserirImagemNoPainelSobel(int alturaImagem1, int larguraImagem1, int matrizImagem1[][]){
		try {
			FiltroSobel(alturaImagem1, larguraImagem1, matrizImagem1);	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Calculo do processamento da imagem com o Filtro Roberts Sobel   
	 * @param  alturaI da imagem
	 * @param larguraI da imagem
	 * @param matrizI da imagem
	 */ 
	public void FiltroSobel(int alturaI, int larguraI, int matrizI[][]) throws Exception{
	    int a = alturaI;
	    int l = larguraI;	    
	    int matriz[][] = new int[a][l];       
	    buffer = new BufferedImage(a, l, BufferedImage.TYPE_INT_RGB);
	    
	    for(int i = 0; i < a; i++){
	    	for(int j = 0 ;j < l; j++){	    		
	    		int fatA = 0;
	    		int fatB = 0;
	    		int fatC = 0;
	    		int fatD = 0;
	    		if ((i - 1) >= 0) {
	    			fatD += 2*matrizI[i - 1][j];
	    		}
	    		if ((i + 1) < l) {
	    			fatC += 2*matrizI[i + 1][j];
	    		}
	    		if ((j - 1) >= 0) {
	    			fatB += 2*matrizI[i][j - 1];
	    		}
	    		if ((j + 1) < a) {
	    			fatA += 2*matrizI[i][j + 1];
	    		}
	    		if (((i - 1) >= 0) && ((j - 1) >= 0)) {
	    			fatB += matrizI[i - 1][j - 1];
	    			fatD += matrizI[i - 1][j - 1];
	    		}
	    		if (((i + 1) < l) && ((j - 1) >= 0)) {
	    			fatB += matrizI[i + 1][j - 1];
	    			fatC += matrizI[i + 1][j - 1];
	    		}
	    		if (((i - 1) >= 0) && ((j + 1) < a)) {
	    			fatA += matrizI[i - 1][j + 1];
	    			fatD += matrizI[i - 1][j + 1];
	    		}
	    		if (((i + 1) < l) && ((j + 1) < a)) {
	    			fatA += matrizI[i + 1][j + 1];
	    			fatC += matrizI[i + 1][j + 1];;
	    		}
	
	    		int aux1 = fatA - fatB;
	    		int aux2 = fatC - fatD;
	    		int m = Math.abs(aux1) + Math.abs(aux2);
	    		
	    		//Adicionando o valor do pixel a matriz
	    		matriz[i][j] = m;	    		
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
