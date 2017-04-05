package algoritmos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import view.Ponto;

public class Desenhos2D {
	
	private List<Ponto> pontos;
	
	public Desenhos2D() {
		if (pontos== null)
			pontos = new ArrayList<>();
	}
	
	public List<Ponto> DDA(Ponto a, Ponto b) {
		pontos.clear();
		int xa, ya, xb, yb;
		xa = a.getX();
		ya = a.getY();
		xb = b.getX();
		yb = b.getY();
		
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
	
	
	public List<Ponto> retaPontoMedio(Ponto a, Ponto b) {
		pontos.clear();
		int xa, ya, xb, yb;
		xa = a.getX();
		ya = a.getY();
		xb = b.getX();
		yb = b.getY();
		
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
	
	public List<Ponto> circ_explicita(int x, int y, int raio) {//M�todo explicita
		pontos.clear();
		
		for (int i = -raio; i < raio; i++) {
			pontos.add(new Ponto(i, (int) Math.sqrt(raio*raio - i*i)));
			pontos.add(new Ponto(i, -1*(int) Math.sqrt(raio*raio - i*i)));
		}

		return pontos;
	}
	
	/**
	 * M�todo calcula o raio da circunf�ncia para testar se ir� desenhar a circunfer�ncia
	 * @param a
	 * @param b
	 * @return raio
	 */
	public static int pitagoras(int a, int b) {
		return (int) Math.sqrt((a*a) + (b*b));
	}
	//Simetria de 8 pontos
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
	
	//Ponto Medio
	public List<Ponto> CircunferenciaPontoMedio(int raio){
		pontos.clear();		
		int x, y, d;
		/* Valores iniciais */
		
		x = 0;
		y = raio;
		d = 1 - raio;
		
		//Setando os pixels da posicao inicial
		simetria_8(x, y);
		
		while (y > x){
			
			if (d < 0){
				/* Selecione E */
				d = d + 2 * x + 3;
				x++;
			}else{
				/* Selecione SE */
				d = d + 2 * (x - y) + 5;
				x++;
				y--;
			}
			
			//seta os pixeis atuais
			simetria_8(x, y);
		}
		
		return pontos;		
	}
	
	public List<Ponto> circ_trigonometrica(int x, int y, int raio){//M�todo trigonom�trico
		pontos.clear();
		
		for (int i = -raio; i <= raio; i++) {
			simetria_8((int) (raio*(double) Math.cos(Math.toRadians(i))), (int) (raio* (double) Math.sin(Math.toRadians(i))));
		}

		return pontos;
	}
	
	
}
