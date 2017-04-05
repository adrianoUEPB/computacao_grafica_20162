package algoritmos;

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
	
	public List<Ponto> circ_explicita(int x, int y, int raio) {//Mï¿½todo explicita
		pontos.clear();
		
		for (int i = -raio; i < raio; i++) {
			pontos.add(new Ponto(i, (int) Math.sqrt(raio*raio - i*i)));
			pontos.add(new Ponto(i, -1*(int) Math.sqrt(raio*raio - i*i)));
		}

		return pontos;
	}
	
	/**
	 * Método calcula o raio da circunfência para testar se irá desenhar a circunferência
	 * @param a
	 * @param b
	 * @return raio
	 */
	public static int pitagoras(int a, int b) {
		return (int) Math.sqrt((a*a) + (b*b));
	}
	
	
}
