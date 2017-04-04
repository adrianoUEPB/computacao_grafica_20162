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
	
	public List<Ponto> circ_explicita(int x, int y, int raio) {//M�todo explicita
		pontos.clear();
		
		for (int i = -raio; i < raio; i++) {
			pontos.add(new Ponto(i, (int) Math.sqrt(raio*raio - i*i)));
			pontos.add(new Ponto(i, -1*(int) Math.sqrt(raio*raio - i*i)));
		}

		return pontos;
	}
	
	public static int pitagoras(int a, int b) {
		return (int) Math.sqrt((a*a) + (b*b));
	}
	
	
}
