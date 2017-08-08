package panelProcessamentoImagens;

//Equiliza a imagem
public class EqualizarImagemHistograma {	
	public static int[][] equalizarImagemDoHistograma(int matrizDaImagemOriginal [][]){		
		float [][] matrizE = new float[255][6];
		int [][] matrizR = new int [matrizDaImagemOriginal.length][matrizDaImagemOriginal[0].length];
		
		//inicializando o n�vel de cinza e a frequ�ncia dos n�veis de cinza
		for (int i = 0; i < matrizE.length; i++) {
			matrizE[i][0] = 1000;
			matrizE[i][1] = 0;
		}
		
		//Inserindo os n�veis de cinza, incrementando as suas frequ�ncias de repeti��es e calculando rK (valor do pixel / 255)
		for (int i = 0; i < matrizR.length; i++) {
			for (int j = 0; j < matrizR.length; j++) {
				matrizE[matrizDaImagemOriginal[i][j]][0] = matrizDaImagemOriginal[i][j];
				matrizE[matrizDaImagemOriginal[i][j]][1] += 1;
				matrizE[matrizDaImagemOriginal[i][j]][2] = matrizDaImagemOriginal[i][j] / 255;
			}
		}
		
		matrizE = ordenarMatriz(matrizE);
		
		//calculando Pr(rk)
		int contador = 0;
		while(matrizE[contador][0] != 1000){
			
			//frequencia do pixel dividido pela quantidade de pixels
			matrizE[contador][3] = matrizE[contador][1] / (255*255);
			contador = contador + 1;
		}
		
		//calculando Sk - Soma acumulada de Pr(rk)
		contador = 0;
		while(matrizE[contador][0] != 1000){
			
			if(contador == 0){
				matrizE[contador][4] = matrizE[contador][3];
			} else {
				matrizE[contador][4] = matrizE[contador][3] + matrizE[contador - 1][4];
			}
			contador = contador + 1;
		}
		
		//calculando Round(255 * Sk)
		contador = 0;
		while(matrizE[contador][0] != 1000){
			matrizE[contador][5] = (int)Math.round(255 * matrizE[contador][4]);
			if(matrizE[contador][5] > 255){
				matrizE[contador][5] = 255;
			}
			contador = contador + 1;
		}
		
		for (int i = 0; i < matrizDaImagemOriginal.length; i++) {
			for (int j = 0; j < matrizDaImagemOriginal[0].length; j++) {
				
				int valorDoPixel = matrizDaImagemOriginal[i][j];
				int contador2 = 0;
				
				while(matrizE[contador2][0] != valorDoPixel){
					contador2 = contador2 + 1;
				}				
				matrizR[i][j] = (int)matrizE[contador2][5];				
			}			
		}
		return matrizR;
	}	
	public static float [][] ordenarMatriz(float matrizE2 [][]){
		
		boolean houveTroca = true;
		while(houveTroca == true){
			houveTroca = false;			
			for (int i = 0; i < matrizE2.length - 1; i++) {
				if(matrizE2[i][0] > matrizE2[i+1][0]){
					float Aux1;
					float Aux2;
					float Aux3;
					float Aux4;
					
					Aux1 = matrizE2[i][0];
					Aux2 = matrizE2[i][1];
					Aux3 = matrizE2[i][2];
					Aux4 = matrizE2[i][3];
					
					matrizE2[i][0] = matrizE2[i+1][0];
					matrizE2[i][1] = matrizE2[i+1][1];
					matrizE2[i][2] = matrizE2[i+1][2];
					matrizE2[i][3] = matrizE2[i+1][3];
					
					matrizE2[i+1][0] = Aux1;
					matrizE2[i+1][1] = Aux2;
					matrizE2[i+1][2] = Aux3;
					matrizE2[i+1][3] = Aux4;					
					houveTroca = true;					
				}
			}			
		}		
		return matrizE2;
	}
		/**
		 * Equalização de imagem
		 * @param matrizDaImagemOriginal
		 * @return array bi-dimensional
		 */
		public static int[][] equalizarImagem(int matrizDaImagemOriginal [][]){		
			float [][] matrizDeEqualizacao = new float[255][6];
			int [][] matrizResultado = new int [matrizDaImagemOriginal.length][matrizDaImagemOriginal[0].length];
			//inicializando o n�vel de cinza e a frequ�ncia dos n�veis de cinza
			for (int i = 0; i < matrizDeEqualizacao.length; i++) {
				matrizDeEqualizacao[i][0] = 1000;
				matrizDeEqualizacao[i][1] = 0;
			}		
			//Inserindo os n�veis de cinza, incrementando as suas frequ�ncias de repeti��es e calculando rK (valor do pixel / 255)
			for (int i = 0; i < matrizResultado.length; i++) {
				for (int j = 0; j < matrizResultado.length; j++) {
					matrizDeEqualizacao[matrizDaImagemOriginal[i][j]][0] = matrizDaImagemOriginal[i][j];
					matrizDeEqualizacao[matrizDaImagemOriginal[i][j]][1] += 1;
					matrizDeEqualizacao[matrizDaImagemOriginal[i][j]][2] = matrizDaImagemOriginal[i][j] / 255;
				}
			}	
			
			matrizDeEqualizacao = ordenarMatriz(matrizDeEqualizacao);
			
			//calculando Pr(rk)
			int contador = 0;
			while(matrizDeEqualizacao[contador][0] != 1000){
				
				//frequencia do pixel dividido pela quantidade de pixels
				matrizDeEqualizacao[contador][3] = matrizDeEqualizacao[contador][1] / (255*255);
				contador = contador + 1;
			}
			//calculando Sk - Soma acumulada de Pr(rk)
			contador = 0;
			while(matrizDeEqualizacao[contador][0] != 1000){
				
				if(contador == 0){
					matrizDeEqualizacao[contador][4] = matrizDeEqualizacao[contador][3];
				} else {
					matrizDeEqualizacao[contador][4] = matrizDeEqualizacao[contador][3] + matrizDeEqualizacao[contador - 1][4];
				}
				contador = contador + 1;
			}
			
			//calculando Round(255 * Sk)
			contador = 0;
			while(matrizDeEqualizacao[contador][0] != 1000){
				matrizDeEqualizacao[contador][5] = (int)Math.round(255 * matrizDeEqualizacao[contador][4]);
				if(matrizDeEqualizacao[contador][5] > 255){
					matrizDeEqualizacao[contador][5] = 255;
				}
				contador = contador + 1;
			}
			
			//printando a matriz original
			for (int i = 0; i < matrizDaImagemOriginal.length; i++) {
				for (int j = 0; j < matrizDaImagemOriginal.length; j++) {
					System.out.print(matrizDaImagemOriginal[i][j]+" ");
				}
				System.out.println();
			}
			
			//printando a tabela do excel
			System.out.println("\n");
			System.out.print("K\t\tNk\t\trK\t\tPr(rk)\t\t\tSk\t\tRound(255 * sk)\n");
			contador = 0;
			while(matrizDeEqualizacao[contador][0] != 1000){
				System.out.print(matrizDeEqualizacao[contador][0]+"\t\t"+matrizDeEqualizacao[contador][1]+"\t\t"+
						matrizDeEqualizacao[contador][2]+"\t\t"+matrizDeEqualizacao[contador][3]+"\t\t"+
						matrizDeEqualizacao[contador][4]+"\t\t"+matrizDeEqualizacao[contador][5]+"\t\t\n");
				contador = contador + 1;
			}			
			
			for (int i = 0; i < matrizDaImagemOriginal.length; i++) {
				for (int j = 0; j < matrizDaImagemOriginal[0].length; j++) {
					
					int valorDoPixel = matrizDaImagemOriginal[i][j];
					int contador2 = 0;
					
					while(matrizDeEqualizacao[contador2][0] != valorDoPixel){
						contador2 = contador2 + 1;
					}					
					matrizResultado[i][j] = (int)matrizDeEqualizacao[contador2][5];
					}				
			}
			return matrizResultado;
		}
		

		

}
