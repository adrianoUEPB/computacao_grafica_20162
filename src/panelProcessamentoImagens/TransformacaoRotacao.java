package panelProcessamentoImagens;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class TransformacaoRotacao {
	BufferedImage rotacao;

	public static void rotate(BufferedImage originalImage) throws Exception {

		BufferedImage bufferImg = originalImage;
		BufferedImage bufferImgOut = new BufferedImage(bufferImg.getWidth(),
				bufferImg.getHeight(), bufferImg.getType());

		for (int x = 0; x < bufferImg.getWidth(); x++) {
			for (int y = 0; y < bufferImg.getHeight(); y++) {
				int px = bufferImg.getRGB(x, y);
				int destY = bufferImg.getWidth() - x - 1; 
															
				bufferImgOut.setRGB(y, destY, px);
			}
		}

		PainelTransformacaoRotacao.panelDaImagem2.buffer = bufferImgOut;
		PainelTransformacaoRotacao.panelDaImagem2.repaint();
	}

	public void rotacao(int largura, int altura, int[][] matrizImagem,
			int angulo) {

		BufferedImage imagem_auxiliar = new BufferedImage(altura, largura,
				BufferedImage.TYPE_INT_RGB);
		rotacao = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);

		int matriz_auxiliar[][] = new int[altura][largura];

		switch (angulo) {
		case 30:
			matriz_auxiliar = rotacionarMatrizHorario(matrizImagem);
			break;
		case 60:
			matriz_auxiliar = rotacionarMatrizHorario(matrizImagem);

			break;
		case 90:
			matriz_auxiliar = rotacionarMatrizHorario(matrizImagem);
			break;
		case 120:
			matriz_auxiliar = rotacionarMatrizHorario(matrizImagem);
			matriz_auxiliar = rotacionarMatrizHorario(matriz_auxiliar);
			break;
		case 180:
			matriz_auxiliar = rotacionarMatrizHorario(matrizImagem);
			matriz_auxiliar = rotacionarMatrizHorario(matriz_auxiliar);
			matriz_auxiliar = rotacionarMatrizHorario(matriz_auxiliar);
			break;
		default:
			break;
		}

		for (int x = 0; x < imagem_auxiliar.getHeight(); x++) {
			for (int y = 0; y < imagem_auxiliar.getWidth(); y++) {
				try {
					rotacao.setRGB(y, x, corPixel(matriz_auxiliar[x][y]));
				} catch (Exception e) {

				}
			}

		}
		PainelTransformacaoRotacao.panelDaImagem2.buffer = rotacao;
		PainelTransformacaoRotacao.panelDaImagem2.repaint();
	}

	public static int[][] rotacionarMatrizHorario(int[][] matriz) {
		int largura = matriz.length;
		int altura = matriz[0].length;
		int[][] ret = new int[altura][largura];
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				try {
					ret[i][j] = matriz[largura - j - 1][i];
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}

	static int corPixel(int corRGB) {
		Color cor = new Color(corRGB, corRGB, corRGB);
		return cor.getRGB();
	}

	public int mod(int a, int b) {
		return a % b;
	}
	
	public int[][] rotateMatrixRight(int[][] matrix)
	{
	    /* W and H are already swapped */
	    int w = matrix.length;
	    int h = matrix[0].length;
	    int[][] ret = new int[h][w];
	    for (int i = 0; i < h; ++i) {
	        for (int j = 0; j < w; ++j) {
	            ret[i][j] = matrix[w - j - 1][i];
	        }
	    }
	    return ret;
	}


	public int[][] rotateMatrixLeft(int[][] matrix)
	{
	    /* W and H are already swapped */
	    int w = matrix.length;
	    int h = matrix[0].length;   
	    int[][] ret = new int[h][w];
	    for (int i = 0; i < h; ++i) {
	        for (int j = 0; j < w; ++j) {
	            ret[i][j] = matrix[j][h - i - 1];
	        }
	    }
	    return ret;
	}
	
	
	public void rotacao (BufferedImage img, int degree) {
		
		int[][] matrixRotated = new int[256][256];
       
        double cosTheta = Math.cos(Math.toRadians(degree));
        double sinTheta = Math.sin(Math.toRadians(degree));

        for (int x = 0; x < 255; x++)
        {
            for (int y = 0; y < 255; y++)
            {
                int hwidth = 255 / 2;
                int hheight = 255/ 2;

                int xt = x - hwidth;
                int yt = y - hheight;

                int xs = Integer.valueOf((int)(cosTheta * xt - sinTheta * yt) + hwidth); 

                int ys = Integer.valueOf((int) (sinTheta * xt + cosTheta * yt) + hheight);
                

                if (xs >= 0 && xs <= 255 && ys >= 0 && ys <= 255)
                {
                    try {
                    	matrixRotated[xs][ys] = img.getRGB(x, y);
					} catch (Exception e) {
						// TODO: handle exception
					}
                }
            }
        }
        rotacao = new BufferedImage(255, 255, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < matrixRotated[0].length; i++) {
			for (int j = 0; j < matrixRotated.length; j++) {
				try {
					rotacao.setRGB(i, j, corPixel(matrixRotated[i][j]));					
				} catch(Exception e) {
					
				}
			}
		}
		PainelTransformacaoRotacao.panelDaImagem2.buffer = rotacao;
		PainelTransformacaoRotacao.panelDaImagem2.repaint();
	}

}
