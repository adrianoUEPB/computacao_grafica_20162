package panelProcessamentoImagens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;


public class PanellDaImagem extends JPanel {

	private String caminhoDaImagem = "";
	private static final String COMENTARIO = "#";
	private static final String P2 = "P2";
	
	public int[][] matrizImagem;
	public int altura;
	public int largura;
	public static BufferedReader imagem;
	public BufferedImage imagemOriginal;
	
	public PanellDaImagem() {		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 245, 245));				
	}
	
	public void colocaImagemNoPainel(String caminhoDaImagem){
		try {
			imagem = new BufferedReader(new FileReader(caminhoDaImagem));
			geraImagem();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void geraImagem() throws Exception{
		
		String type = imagem.readLine();//Ler a primeira linha da mensagem e ignora a descricao do tipo da imagem
		
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
        int line=0;//coluna onde o pixel se localiza
        
        /*A linha onde refere-se ao valor maximo que o pixel pode ter eh ignorado*/
        linha=imagem.readLine();
        linha=imagem.readLine();
        while(linha != null ){
        	
        	pixels = linha.split(" ");
        	for(int i = 0;i<pixels.length;i++){
        		matrizImagem[line][i] = Integer.parseInt(pixels[i]);            	
        	}
        	line++;
        	linha=imagem.readLine();
        }
        
        imagemOriginal = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){
        		imagemOriginal.setRGB(j, i, corPixel(matrizImagem[i][j]));
        		repaint();
        	}
        	
        }
             
    }
	
	//Imagem da matriz
	
	public void inserirImagemNoPainelImagemMatriz(int [][] matrizEqualizada){
		try {			
			geraImagemDaMatriz(matrizEqualizada);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void geraImagemDaMatriz(int [][] matrizEqualizada) throws Exception{		 
        imagemOriginal = new BufferedImage(matrizEqualizada.length, matrizEqualizada[0].length, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i<matrizEqualizada.length; i++){
        	for(int j=0;j<matrizEqualizada[0].length;j++){
        		imagemOriginal.setRGB(j, i, corPixel(matrizEqualizada[i][j]));
        		repaint();
        	}        	
        }             
    }

	public int[][] getMatrizImagem() {
		return matrizImagem;
	}

	public void setMatrizImagem(int[][] matrizImagem) {
		this.matrizImagem = matrizImagem;
	}
	
	public BufferedImage getBufferedImage(){
		return imagemOriginal;
	}

	static int corPixel(int corP){
		Color cor = new Color(corP, corP, corP);
		return cor.getRGB();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage((Image) imagemOriginal, 0, 0, null);
	}
	
}
