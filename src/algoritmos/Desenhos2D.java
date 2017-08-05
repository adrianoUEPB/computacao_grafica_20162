package algoritmos;

import java.util.ArrayList;
import java.util.List;

import model.Ponto;
import panel.PlanoCartesiano;

public class Desenhos2D {
	
	private List<Ponto> pontos;
	
	public Desenhos2D() {
		if (pontos== null)
			pontos = new ArrayList<>();
	}
	
	/**
	 * Calculo da circunferencia atraves do algoritmo DDA
	 * @param a do tipo Ponto
	 * @param b do tipo Ponto
	 * @return Lista de pontos
	 */
	public List<Ponto> DDA(Ponto a, Ponto b) {
		pontos.clear();
		int xa, ya, xb, yb;
		xa = a.getX()+ PlanoCartesiano.MEIO_X;
		ya =  PlanoCartesiano.MEIO_Y - a.getY();
		xb = b.getX() +  PlanoCartesiano.MEIO_X;
		yb =  PlanoCartesiano.MEIO_Y - b.getY();
		
		int dx = xb - xa, dy = yb - ya, steps;
		float xInc, yInc, x = xa, y = ya;
		
		if (Math.abs(dx) > Math.abs(dy)) {
			steps = Math.abs(dx);
		} else {
			steps = Math.abs(dy);
		}
		
		xInc = dx / (float) steps;
		yInc = dy / (float) steps;
		
		
		pontos.add(new Ponto((int) Math.abs(x), (int) Math.abs(y)));
		
		for (int k = 0; k < steps; k++) {
			x += xInc;
			y += yInc;
			pontos.add(new Ponto((int) Math.abs(x), (int) Math.abs(y)));
		}
		
		
		return pontos;
	}
	
	/**
	 * Calculo da reta pelo ponto medio
	 * @param a do tipo Ponto
	 * @param b do tipo Ponto
	 * @return Lista de pontos
	 */
	public List<Ponto> retaPontoMedio(Ponto a, Ponto b) {
		pontos.clear();
		int xa, ya, xb, yb;
		xa = a.getX()+ PlanoCartesiano.MEIO_X;
		ya =  PlanoCartesiano.MEIO_Y - a.getY();
		xb = b.getX() +  PlanoCartesiano.MEIO_X;
		yb =  PlanoCartesiano.MEIO_Y - b.getY();
		
		int dx = Math.abs(xb - xa), dy = Math.abs(yb - ya);
		int p = 2 * dy - dx;
		int twoDy = 2 * dy, twoDyDx = 2 * (dy - dx);
		int x, y;
		
		if (xa > xb) {
			x = xb;
			y = yb;
			xb = xa;
		} else {
			x = xa;
			y = ya;
		}
		
		pontos.add(new Ponto(x, y));
		
		while (x < xb) {
			x++;
			if (p < 0) {
				p += twoDy;
			} else {
				y++;
				p += twoDyDx;
			}
			pontos.add(new Ponto(x, y));
		}
			
		return pontos;
	}
	
	/**
	 * Calculo da circunferencia pela equacao explicita, a qual deixa a circunferencia com falhas
	 * @param x
	 * @param y
	 * @param raio
	 * @return Lista de pontos
	 */
	public List<Ponto> CircunferenciaEqExplicita(int raio) {
		pontos.clear();
		
		for (int i = -raio; i < raio; i++) {
			pontos.add(new Ponto(i, (int) Math.sqrt(raio*raio - i*i)));
			pontos.add(new Ponto(i, -1*(int) Math.sqrt(raio*raio - i*i)));
		}

		return pontos;
	}
	
	/**
	 * Calculo da circunferencia pelo ponto medio
	 * @param raio
	 * @return Lista de pontos
	 */
	public List<Ponto> CircunferenciaPontoMedio(int raio){
		pontos.clear();		
		int x, y, d;
		
		x = 0;
		y = raio;
		d = 1 - raio;
		
		simetria_8(x, y);
		
		while (y > x){
			
			if (d < 0){
				/* Seleciona E */
				d = d + 2 * x + 3;
				x++;
			}else{
				/* Seleciona SE */
				d = d + 2 * (x - y) + 5;
				x++;
				y--;
			}
			
			simetria_8(x, y);
		}
		
		return pontos;		
	}
	
	
	/**
	 * Calcula os pontos usando a simetria de 8 pontos, por�m eviando os pontos de acordo com a fun��o trigonometrica
	 * @param x
	 * @param y
	 * @param raio
	 * @return Lista de pontos
	 */
	public List<Ponto> CircunferenciaTrigonometrica(int raio){
		pontos.clear();
		
		for (int i = -raio; i <= raio; i++) {
			simetria_8((int) (raio*(double) Math.cos(Math.toRadians(i))), (int) (raio* (double) Math.sin(Math.toRadians(i))));
		}
		return pontos;
	}
	
	/**
	 * Algoritmo para calculo da elipse pelo ponto medio
	 * @param a
	 * @param b
	 * @return Lista de pontos
	 */
	public List<Ponto> ElipsePontoMedio(int a, int b){
		pontos.clear();
		int x = 0;
		int y = 0;
		double d1 = 0; 
		double d2 = 0;
		
		x = 0;
		y = b;
		d1 = b * b - a * a * b + a * a / 4.0;
		
		pontosElipse(x, y);
		
		while(a * a * (y - 0.5) > b * b * (x + 1)){
			
			if (d1 < 0){
				d1 = d1 + b * b * (2 * x + 3);
				x++;
			}else{
				d1 = d1 + b * b * (2 * x + 3) + a * a * (-2 * y + 2);
				x++;
				y--;
			}
			pontosElipse(x, y);
		}
		
		d2 = b * b * (x + 0.5) * (x + 0.5) + a * a * (y - 1) * (y - 1) - a * a * b * b;
		while(y > 0){
			 
			if (d2 < 0){
				d2 = d2 + b * b * (2 * x + 2) + a * a * (-2 * y + 3);
				x++;
				y--;
			}else{
				d2 = d2 + a * a * (-2 * y + 3);
				y--;
			}
			pontosElipse(x, y);
		}
		
		return pontos;		
	}
	
	/**
	 * Calculo dos pontos da elipse
	 * @param x
	 * @param y
	 */
	private void pontosElipse(int x, int y) {		
		pontos.add(new Ponto(x, y)); 
		pontos.add(new Ponto(x, -y)); 
		pontos.add(new Ponto(-x, y));
		pontos.add(new Ponto(-x, -y)); 			
	}
	
	/**
	 * Metodo calcula o raio da circunferencia a partir dos pontos recebidos
	 * @param a
	 * @param b
	 * @return raio calculado pela funcao
	 */
	public static int pitagoras(int a, int b) {
		return (int) Math.sqrt((a*a) + (b*b));
	}
	
	/**
	 * Calcula os novos pontos e adiciona na lista de pontos da classe.
	 * @param x
	 * @param y
	 */
	private void simetria_8(int x, int y){
		pontos.add(new Ponto(x, y));
		pontos.add(new Ponto(x,-y));
		pontos.add(new Ponto(-x, y));
		pontos.add(new Ponto(-x, -y));
		pontos.add(new Ponto( y,  x));
		pontos.add(new Ponto( y, -x));
		pontos.add(new Ponto(-y,  x));
		pontos.add(new Ponto(-y, -x));
	}
	
	public List<Ponto> quadrado(int x, int y) {
		
//		pontos.clear();
		
		List<Ponto> quadrado = new ArrayList<>();
		
		List<Ponto> reta_1 = this.DDA(new Ponto(0, 0), new Ponto(x, 0));
		quadrado.addAll(reta_1);
		
		List<Ponto> reta_2 = this.DDA(new Ponto(x, 0), new Ponto(x, y-1));
		quadrado.addAll(reta_2);
		
		List<Ponto> reta_3 = this.DDA(new Ponto(x, y), new Ponto(0, y));
		quadrado.addAll(reta_3);
		
		List<Ponto> reta_4 = this.DDA(new Ponto(0, y), new Ponto(0, 0));
		quadrado.addAll(reta_4);
				
		return quadrado;
	}
	
	public List<Ponto> retangulo(int x1, int y1, int x2, int y2) {
		pontos.clear();
		List<Ponto> r1 = this.DDA(new Ponto(x1, y1), new Ponto(x2, y1));
		List<Ponto> r2 = this.DDA(new Ponto(x2, y1), new Ponto(x2, y2));
		List<Ponto> r3 = this.DDA(new Ponto(2, y2+1), new Ponto(x1, y2+1));
		List<Ponto> r4 = this.DDA(new Ponto(x1, y2), new Ponto(x1, y1));		

		pontos.addAll(r1);
		pontos.addAll(r2);
		pontos.addAll(r3);
		pontos.addAll(r4);

		return pontos;
	}
	
}
