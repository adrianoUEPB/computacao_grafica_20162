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
	
	final int ALTURA = 500;
	final int LARGURA = 800;
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
					case 1:
						if (a == null) {
							a = new Ponto(e.getPoint().x, e.getPoint().y);
						} else {
							b = new Ponto(e.getPoint().x, e.getPoint().y);
							try {
								if (Janela2D.rdbtnDda.isSelected()) {
									pontos = new Desenhos2D().DDA(a, b);
								} else if(Janela2D.rdbtnPontoMdio_1.isSelected()){
									pontos = new Desenhos2D().retaPontoMedio(a, b);
								}								
								a = null;								
								for (Ponto ponto : pontos)
									setPixel(ponto);
							} catch (NullPointerException e1) {
								JOptionPane.showMessageDialog(null, "Selecione o algoritmo!");
							} 
							
						}
						break;
					case 2:
						int raio = Desenhos2D.pitagoras(e.getPoint().x - 400, e.getPoint().y - 250);						
						if (raio >= 250) {
							JOptionPane.showMessageDialog(null, "A CIRCUNFERENCIA NAO PODE SER CALCULADA!");
						} else {
							if (Janela2D.rdbtnEquaoExplicita.isSelected()) {
								pontos = new Desenhos2D().CircunferenciaEqExplicita(e.getPoint().x, e.getPoint().y, raio);
								setCircunferencia();
							} else if(Janela2D.rdbtnPontoMdio.isSelected()) {
								pontos = new Desenhos2D().CircunferenciaPontoMedio(raio);
								setCircunferencia(); 
							} else if(Janela2D.rdbtnTrigonometrica.isSelected()) {
								pontos = new Desenhos2D().CircunferenciaTrigonometrica(e.getPoint().x, e.getPoint().y, raio);
								setCircunferencia(); 
							}							
						}
						break;

				}
			}
		});
		
		
		
		plano = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_ARGB);
		setBounds(0, 0, LARGURA, ALTURA);
		zerarImagem();
		
		
		
		
		
		
	}
	
	public void CalcularElipse(int x, int y) {
		zerarImagem();
		pontos = new Desenhos2D().ElipsePontoMedio(x, y);
		setCircunferencia();
	}
	
	public void zerarImagem() {
		
		for (int i = 0; i < LARGURA; i++)
			for (int j = 0; j < ALTURA; j++) {
				plano.setRGB(i, j, Color.WHITE.getRGB());
				repaint();
		}
		
		coordenadas();
	}
	
	private void setCircunferencia() {
		for (Ponto ponto : pontos) {
			setPixel(new Ponto(ponto.getX()+400, ponto.getY() + 250));
		}
	}
	
	private void coordenadas() {
		
		int meio_y = ALTURA/2;
		int meio_x = LARGURA/2;
		
		for (int i = 0; i < ALTURA; i++) {
			plano.setRGB(meio_x, i, Color.BLACK.getRGB());
			repaint();
		}
		
		for (int i = 0; i < LARGURA; i++) {
			plano.setRGB(i, meio_y, Color.BLACK.getRGB());
			repaint();
		}
		
	}
	
	public void setPixel(Ponto pixel) {
		plano.setRGB(pixel.getX(), pixel.getY(), Color.ORANGE.getRGB());
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
