package panelProcessamentoImagens;


public class EqualizarImagem {//Classe da equalização de imagen
	
	
	public static int[][] equalizarImagem(int matrizDaImagemOriginal [][]){		
		
		float [][] matrizDeEqualizacao = new float[255][6];
		int [][] matrizResultado = new int [matrizDaImagemOriginal.length][matrizDaImagemOriginal[0].length];
		
		//inicializa níveis de frequência de cinza
		for (int i = 0; i < matrizDeEqualizacao.length; i++) {
			matrizDeEqualizacao[i][0] = 1000;
			matrizDeEqualizacao[i][1] = 0;
		}
		
		//Inserindo os níveis de cinza, incrementando as suas frequências de repetições e calculando rK (valor do pixel / 255)
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
	
	public static float [][] ordenarMatriz(float matrizDeEqualizacao [][]){
		
		boolean houveTroca = true;
		while(houveTroca == true){
			houveTroca = false;
			
			for (int i = 0; i < matrizDeEqualizacao.length - 1; i++) {
				if(matrizDeEqualizacao[i][0] > matrizDeEqualizacao[i+1][0]){
					float variavelAuxiliar0, variavelAuxiliar1, variavelAuxiliar2, variavelAuxiliar3;
					
					variavelAuxiliar0 = matrizDeEqualizacao[i][0];
					variavelAuxiliar1 = matrizDeEqualizacao[i][1];
					variavelAuxiliar2 = matrizDeEqualizacao[i][2];
					variavelAuxiliar3 = matrizDeEqualizacao[i][3];
					
					matrizDeEqualizacao[i][0] = matrizDeEqualizacao[i+1][0];
					matrizDeEqualizacao[i][1] = matrizDeEqualizacao[i+1][1];
					matrizDeEqualizacao[i][2] = matrizDeEqualizacao[i+1][2];
					matrizDeEqualizacao[i][3] = matrizDeEqualizacao[i+1][3];
					
					matrizDeEqualizacao[i+1][0] = variavelAuxiliar0;
					matrizDeEqualizacao[i+1][1] = variavelAuxiliar1;
					matrizDeEqualizacao[i+1][2] = variavelAuxiliar2;
					matrizDeEqualizacao[i+1][3] = variavelAuxiliar3;
					
					houveTroca = true;
				}
			}
		}
		
		return matrizDeEqualizacao;
	}
}
