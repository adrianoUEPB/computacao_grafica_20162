package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algoritmos.Desenhos2D;



public class PlanoCartesiano extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3652299627184303562L;
	
	final static int ALTURA = 500;
	final static int LARGURA = 800;
	private static BufferedImage plano;
	public static List<Ponto> pontos;
	public static Ponto xy;

	
	public PlanoCartesiano() {
		
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent event) {
				
				int x = event.getPoint().x;
				int y = event.getPoint().y;
				Janela2D.label_x.setText(String.valueOf(x - 400));
				Janela2D.label_y.setText(String.valueOf(250 - y)); 
			}
			@Override
			public void mouseDragged(MouseEvent event) {
			}
		});
		
		addMouseListener(new MouseAdapter() {
			
			Ponto a = null, b = null;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setPixel(new Ponto(e.getPoint().x, e.getPoint().y));
				
				switch (Janela2D.comboBox.getSelectedIndex()) {
					case 0:
						setPixel(new Ponto(e.getPoint().x, e.getPoint().y));
						break;
				}
			}
		});
		
		
		
		plano = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_ARGB);
		setBounds(0, 0, LARGURA, ALTURA);
		zerarImagem();
		
		
		
		
		
		
	}
	
	public void calcularReta(int x1, int y1, int x2, int y2) throws NullPointerException, NumberFormatException {
		if (Janela2D.rdbtnDda.isSelected()) {
			pontos = new Desenhos2D().DDA(new Ponto(x1, y1), new Ponto(x2, y2));
		} else if(Janela2D.rdbtnPontoMdio_1.isSelected()){
			pontos = new Desenhos2D().retaPontoMedio(new Ponto(x1, y1), new Ponto(x2, y2));
		}								
				
		for (Ponto ponto : pontos)
			setPixel(ponto);
	}
	
	public void calcularCircunferencia(int raio) throws NullPointerException, NumberFormatException, Exception {
		if (raio > 250)
			throw new Exception();
		
		if (Janela2D.rdbtnEquaoExplicita.isSelected()) {
			pontos = new Desenhos2D().CircunferenciaEqExplicita(raio);
			setCircunferencia();
		} else if(Janela2D.rdbtnPontoMdio.isSelected()) {
			pontos = new Desenhos2D().CircunferenciaPontoMedio(raio);
			setCircunferencia(); 
		} else if(Janela2D.rdbtnTrigonometrica.isSelected()) {
			pontos = new Desenhos2D().CircunferenciaTrigonometrica(raio);
			setCircunferencia(); 
		}
	}
	
	/**
	 * Os parâmetros são as coordenadas dos raios em x e em y
	 * O método chama a função da ElipsePontoMedio passando os parâmetros, após receber os pontos
	 * desenha como setCircunferência
	 * @param x
	 * @param y
	 */
	public void CalcularElipse(int x, int y) {
		zerarImagem();
		pontos = new Desenhos2D().ElipsePontoMedio(x, y);
		setCircunferencia();
	}
	
	public void calcularQuadrado(int x, int y){
		zerarImagem();
		pontos = new Desenhos2D().quadrado(x, y);
		for (Ponto ponto: pontos) {
			setPixel(ponto);
		}
	}
	
	/**
	 * Limpa todo o plano carteziano, logo após recoloca as coordenadas
	 */
	public void zerarImagem() {
		
		for (int i = 0; i < LARGURA; i++)
			for (int j = 0; j < ALTURA; j++) {
				plano.setRGB(i, j, Color.WHITE.getRGB());
				repaint();
		}
		
		coordenadas();
	}
	/**
	 * Método seta os pixels no plano cartesiano, é utilizado para a elipse e para os demais algoritmos
	 * da circunferência
	 */
	private void setCircunferencia() {
		for (Ponto ponto : pontos) {
			setPixel(new Ponto(ponto.getX()+400, ponto.getY() + 250));
		}
	}
	
	
	/**
	 * Método privado sem retorno, realiza os calculos para poder setar as coordenadas
	 */
	private void coordenadas() {
		
		int meio_y = ALTURA/2;
		int meio_x = LARGURA/2;
		
		for (int i = 0; i < ALTURA; i++) {
			plano.setRGB(meio_x, i, Color.RED.getRGB());
			repaint();
		}
		
		for (int i = 0; i < LARGURA; i++) {
			plano.setRGB(i, meio_y, Color.RED.getRGB());
			repaint();
		}
		
	}
	/**
	 * Não há retorno, este método chama o metodo setRGB do BufferedImage para setar o pixel no painel
	 * @param pixel
	 */
	public void setPixel(Ponto pixel) {
		plano.setRGB(pixel.getX(), pixel.getY(), Color.BLACK.getRGB());
		repaint();
	}
	
	public List<Ponto> getPontos() {
		return pontos;
	}
	
	public BufferedImage getPlano() {
		return plano;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.create();
		g.drawImage(plano, 0, 0, null);
	}
	
}
