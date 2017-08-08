package algoritmosProcessamentoImagens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



public class ProcessamentoImagensGraficoHistograma extends JPanel{
	
	private static final String COMENTARIO = "#";
	private static final String P2 = "P2";	
	public int[][] matrizImagem;
	public int altura;
	public int largura;
	public static BufferedReader imagem;
	private static BufferedImage imagemOriginal;
	
	public ProcessamentoImagensGraficoHistograma() {
		setBackground(Color.DARK_GRAY);		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 250, 250));
				
	}
	/**
	 * Inserindo a imagem no Painel com Grafico do histograma      
	 * @param  caminho - caminho da Imgem

	 */		
	public void inserirImagemNoPainelImagemHistograma(String caminho){
		try {
			imagem = new BufferedReader(new FileReader(caminho));			
			gerarImagemHistograma();			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Gerando  a imgem do histograma
	public void gerarImagemHistograma() throws Exception{
		
		String type = imagem.readLine();		
		if (type == null || !type.equals(P2)) {
            throw new Exception("Formato invalido - Tipo P2 requerido");
        }		
        String linha = null;
        
        do {
            linha = imagem.readLine();
        } while (linha != null && linha.startsWith(COMENTARIO));
        
        String[] dimensao = linha.split(" ");
        altura  = Integer.parseInt(dimensao[0]);
        largura = Integer.parseInt(dimensao[1]);    
        matrizImagem = new int[altura][largura];
       
        String [] pixels;
        int[] frequencia = new int[255];        
        int linha1 = 0;
        int quantidade = 0;
        
        /*A linha onde refere-se ao valor maximo que o pixel pode ter eh ignorado*/
        linha=imagem.readLine();
        linha=imagem.readLine();
        while(linha != null ) {        	
        	pixels = linha.split(" ");
        	for(int i = 0;i<pixels.length;i++){
        		matrizImagem[linha1][i] = Integer.parseInt(pixels[i]);
        		frequencia[Integer.parseInt(pixels[i])]++;
        		quantidade++;
        	}
        	linha1++;
        	linha=imagem.readLine();
        }        
        setImagemOriginal(new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB));        
        //Coloca todos do buffered image na cor branca
        for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				getImagemOriginal().setRGB(i, j, Color.WHITE.getRGB());
			}
		}
        
        //Procura o o valor RGB com maior frequencia entre 0 e 255
        int maior = 0;
        for (int i = 0; i < frequencia.length; i++) {
			if (maior < frequencia[i]) {
				maior = frequencia[i];
			}
		}
        
        //Plota as frequencias dos valores RGB na vertical
        for (int i = 0; i < largura-1; i++) {
        	int funcao = (100*frequencia[i])/maior;
			for (int j = 0; j < funcao; j++) {
				try {
					getImagemOriginal().setRGB(i, altura -1 - j, Color.RED.getRGB());
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
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage((Image) getImagemOriginal(), 0, 0, null);
	}

	public BufferedImage getImagemOriginal() {
		return imagemOriginal;
	}

	public static void setImagemOriginal(BufferedImage imagemOriginal) {
		ProcessamentoImagensGraficoHistograma.imagemOriginal = imagemOriginal;
	}
	

	
}
