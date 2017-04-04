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
	final int POS_X = 300;
	final int POS_Y = 10;
	private static BufferedImage plano;
	public static List<Ponto> pontos;
	public static Ponto xy;

	
	public PlanoCartesiano() {
		
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent event) {
				
				int x = event.getPoint().x;
				int y = event.getPoint().y;
//				xy = new Ponto(x, y);
				Controle2D.label.setText(String.valueOf((x - 400) + " " + (250 - y)));
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
				
				switch (Controle2D.cb.getSelectedIndex()) {
					case 0:
						if (a == null) {
							a = new Ponto(e.getPoint().x, e.getPoint().y);
						} else {
							b = new Ponto(e.getPoint().x, e.getPoint().y);
							pontos = new Desenhos2D().DDA(a, b);
//							pontos = new Desenhos2D().circ_explicita(0, 0, 200);
//							setCircunferencia();
							a = null;
							for (Ponto ponto : pontos) {
								setPixel(ponto);
							}
						}
						break;
					case 1:
						int raio = Desenhos2D.pitagoras(e.getPoint().x - 400, e.getPoint().y - 250);						
						if (raio >= 250) {
							JOptionPane.showMessageDialog(null, "Circunferência não pode ser calculada!");
						} else {
							pontos = new Desenhos2D().circ_explicita(e.getPoint().x, e.getPoint().y, raio);
							setCircunferencia();
						}
						break;
				}
			}
		});
		
		
		
		plano = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_ARGB);
		setBounds(0, 0, LARGURA, ALTURA);
		zerarImagem();
		
		
		
		
		
		
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
	
	public void coordenadas() {
		
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
