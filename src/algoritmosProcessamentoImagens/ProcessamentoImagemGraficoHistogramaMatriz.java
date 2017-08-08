package algoritmosProcessamentoImagens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

public class ProcessamentoImagemGraficoHistogramaMatriz extends JPanel {

	private static final String COMENTARIO = "#";
	private static final String P2 = "P2";	
	public int altura;
	public int largura;
	private static BufferedImage imagemO;
	
	public ProcessamentoImagemGraficoHistogramaMatriz() {		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 255, 255));				
	}	
	
	/**
	 * Inserindo a imagem no Painel do Histograma Equalizado      
	 * @param matrizEqualizada - a matriz da imagem da imagem eequalizada
	 */	
	public void colocaImagemNoPainel(int [][] matrizEqualizada){
		try {
			
			geraImagemGraficoHistograma(matrizEqualizada);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Algoritmo que Gera a imagem do grafico de Arnold      
	 * @param matrizEqualizada - a matriz da imagem equalizada
	 */	
	
	public void geraImagemGraficoHistograma(int [][] matrizEqualizada) throws Exception{
		
		//Le o n�mero de linhas e colunas
        //linha possuir� a resolucao da imagem ex: 256 256
       
        altura  = matrizEqualizada.length;
        largura = matrizEqualizada[0].length;    
      
        int[] freq = new int[256];        
        for (int i = 0; i < freq.length; i++) {
        	freq[i] = 0;
		}
        
        for (int i = 0; i < matrizEqualizada.length; i++) {
        	for (int j = 0; j < matrizEqualizada[0].length; j++) {
				freq[matrizEqualizada[i][j]] += 1;
			}
			
		}
        setimagemO(new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB));        
        //coloca todos os pixels do buffered image na core branca
        for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				getimagemO().setRGB(i, j, Color.WHITE.getRGB());
			}
		}
        
      //Procura o o valor RGB com maior frequencia entre 0 e 255
        int maior = 0;
        for (int i = 0; i < freq.length; i++) {
			if (maior < freq[i]) {
				maior = freq[i];
			}
		}
        
      //plota as frequencias dos valores RGB na vertical
        for (int i = 0; i < largura - 1; i++) {
        	int funcao = (100 * freq[i])/maior;
			for (int j = 0; j < funcao; j++) {
				try {
					getimagemO().setRGB(i, altura -1 - j, Color.RED.getRGB());
				} catch (Exception e) {
					System.out.print("ERRO ");
				}				
			}
		}         
    }
	
	static int corPixel(int corP){
		Color cor = new Color(corP, corP, corP);
		return cor.getRGB();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage((Image) getimagemO(), 0, 0, null);
	}

	public BufferedImage getimagemO() {
		return imagemO;
	}
	
	public static void setimagemO(BufferedImage imagemO) {
		ProcessamentoImagemGraficoHistogramaMatriz.imagemO = imagemO;
	}
	
	
}
