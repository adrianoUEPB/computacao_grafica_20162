package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panelProcessamentoImagens.PainelEqualizarHistograma;
import panelProcessamentoImagens.PainelFiltroMedia;
import panelProcessamentoImagens.PainelFiltroMediana;
import panelProcessamentoImagens.PainelFiltroPassaAlta;
import panelProcessamentoImagens.PainelFiltroPrewitt;
import panelProcessamentoImagens.PainelFiltroRoberts;
import panelProcessamentoImagens.PainelFiltroRobertsCruzado;
import panelProcessamentoImagens.PainelFiltroSobel;
import panelProcessamentoImagens.PainelGatoDeArnold;
import panelProcessamentoImagens.PainelHistograma;
import panelProcessamentoImagens.PainelOperacaoAritmeticaAdicao;
import panelProcessamentoImagens.PainelOperacaoAritmeticaDivisao;
import panelProcessamentoImagens.PainelOperacaoAritmeticaMultiplicacao;
import panelProcessamentoImagens.PainelOperacaoAritmeticaSubtracao;
import panelProcessamentoImagens.PainelOperacaoLogicaAND;
import panelProcessamentoImagens.PainelOperadorLogicoOR;
import panelProcessamentoImagens.PainelOperadorLogicoXOR;
import panelProcessamentoImagens.PainelTransformacaoGama;
import panelProcessamentoImagens.PainelTransformacaoLogaritmica;
import panelProcessamentoImagens.PainelTransformacaoNegativa;
import panelProcessamentoImagens.PainelTransformacaoRotacao;

import java.awt.BorderLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;

public class ProcessamentoDeImagens extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5848864567173905324L;
	PainelFiltroMedia painelFiltroMedia = new PainelFiltroMedia(); 
	PainelFiltroMediana painelFiltroMediana =  new PainelFiltroMediana();
	PainelFiltroPassaAlta painelFiltroPassaAlta = new PainelFiltroPassaAlta();
	PainelFiltroPrewitt painelFiltroPrewitt = new PainelFiltroPrewitt();
	PainelFiltroRoberts painelFiltroRoberts = new PainelFiltroRoberts();
	PainelFiltroRobertsCruzado painelFiltroRobertsCruzado = new PainelFiltroRobertsCruzado();
	PainelFiltroSobel painelFiltroSobel = new PainelFiltroSobel();
	PainelOperacaoAritmeticaAdicao painelOperacaoAritmeticaAdicao = new PainelOperacaoAritmeticaAdicao();
	PainelOperacaoAritmeticaDivisao painelOperacaoAritmeticaDivisao = new PainelOperacaoAritmeticaDivisao();
	PainelOperacaoAritmeticaSubtracao painelOperacaoAritmeticaSubtracao = new PainelOperacaoAritmeticaSubtracao();
	PainelOperacaoAritmeticaMultiplicacao painelOperacaoAritmeticaMltiplicacao = new PainelOperacaoAritmeticaMultiplicacao();
	PainelOperacaoLogicaAND painelOperacaoLogicaAND = new PainelOperacaoLogicaAND();
	PainelOperadorLogicoOR painelOperadorLogicoOR =  new PainelOperadorLogicoOR();
	PainelOperadorLogicoXOR painelOperadorLogicoXOR = new PainelOperadorLogicoXOR();
	PainelTransformacaoGama painelTransformacaoGama = new PainelTransformacaoGama();
	PainelTransformacaoNegativa painelTransformacaoNegativa = new PainelTransformacaoNegativa();
	PainelTransformacaoLogaritmica painelTransformacaoLogaritmica = new PainelTransformacaoLogaritmica();
		
	public ProcessamentoDeImagens() {
		
		Font fonte = new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 102, 194, 618);
		getContentPane().add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnMedia = new JButton("Filtro Média");
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelFiltroMedia.setVisible(true);
				painelFiltroMedia.setBounds(10,10,1000,1000);
				panel.add(painelFiltroMedia);
				panel.repaint();
				
			}
		});

		PainelHistograma painelHistograma = new PainelHistograma();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.DARK_GRAY);
		menuBar.setBackground(Color.DARK_GRAY);
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFiltros = new JMenu("Filtros");
		mnFiltros.setFont(fonte);
		menuBar.add(mnFiltros);
		
		JMenuItem mntmMdia = new JMenuItem("Média");
		mntmMdia.setFont(fonte);
		mntmMdia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelFiltroMedia.setVisible(true);
				painelFiltroMedia.setBounds(10,10,1000,1000);
				panel.add(painelFiltroMedia);
				panel.repaint();
			}
		});
		mnFiltros.add(mntmMdia);
		
		JMenuItem mntmMediana = new JMenuItem("Mediana");
		mntmMediana.setFont(fonte);
		mntmMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelFiltroMediana.setVisible(true);
				painelFiltroMediana.setBounds(10,10,1000,1000);
				panel.add(painelFiltroMediana);
				panel.repaint();
			}
		});
		mnFiltros.add(mntmMediana);
		
		JMenuItem mntmPassaAlta = new JMenuItem("Passa Alta");
		mntmPassaAlta.setFont(fonte);
		mntmPassaAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelFiltroPassaAlta.setVisible(true);
				painelFiltroPassaAlta.setBounds(10,10,1000,1000);
				panel.add(painelFiltroPassaAlta);
				panel.repaint();
			}
		});
		mnFiltros.add(mntmPassaAlta);
		
		JMenuItem mntmPrewitt = new JMenuItem("Prewitt");
		mntmPrewitt.setFont(fonte);
		mntmPrewitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelFiltroPrewitt.setVisible(true);
				painelFiltroPrewitt.setBounds(10,10,1000,1000);
				panel.add(painelFiltroPrewitt);
				panel.repaint();
			}
		});
		mnFiltros.add(mntmPrewitt);
		
		JMenuItem mntmRoberts = new JMenuItem("Roberts");
		mntmRoberts.setFont(fonte);
		mntmRoberts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelFiltroRoberts.setVisible(true);
				painelFiltroRoberts.setBounds(10,10,1000,1000);
				panel.add(painelFiltroRoberts);
				panel.repaint();
			}
		});
		mnFiltros.add(mntmRoberts);
		
		JMenuItem mntmSobel = new JMenuItem("Sobel");
		mntmSobel.setFont(fonte);
		mntmSobel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelFiltroSobel.setVisible(true);
				painelFiltroSobel.setBounds(10,10,1000,1000);
				panel.add(painelFiltroSobel);
				panel.repaint();
			}
		});
		
		JMenuItem mntmRobertsCruzado = new JMenuItem("Roberts Cruzado");
		mntmRobertsCruzado.setFont(fonte);
		mntmRobertsCruzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelFiltroRobertsCruzado.setVisible(true);
				painelFiltroRobertsCruzado.setBounds(10,10,1000,1000);
				panel.add(painelFiltroRobertsCruzado);
				panel.repaint();

			}
		});
		mntmRobertsCruzado.setFont(fonte);
		
				mnFiltros.add(mntmRobertsCruzado);
		mnFiltros.add(mntmSobel);
		
		JMenu mnOperadoresAritmticos = new JMenu("Operadores Aritméticos");
		mnOperadoresAritmticos.setFont(fonte);

		menuBar.add(mnOperadoresAritmticos);
		
		JMenuItem mntmAdio = new JMenuItem("Adição");
		mntmAdio.setFont(fonte);

		mntmAdio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelOperacaoAritmeticaAdicao.setVisible(true);
				painelOperacaoAritmeticaAdicao.setBounds(10,10,1000,1000);
				panel.add(painelOperacaoAritmeticaAdicao);
				panel.repaint();
			}
		});
		mnOperadoresAritmticos.add(mntmAdio);
		
		JMenuItem mntmSubtrao = new JMenuItem("Subtração");
		mntmSubtrao.setFont(fonte);
		mntmSubtrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelOperacaoAritmeticaSubtracao.setVisible(true);
				painelOperacaoAritmeticaSubtracao.setBounds(10,10,1000,1000);
				panel.add(painelOperacaoAritmeticaSubtracao);
				panel.repaint();
			}
		});
		mnOperadoresAritmticos.add(mntmSubtrao);
		
		JMenuItem mntmMultiplicao = new JMenuItem("Multiplicação");
		mntmMultiplicao.setFont(fonte);
		mntmMultiplicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelOperacaoAritmeticaDivisao.setVisible(true);
				painelOperacaoAritmeticaDivisao.setBounds(10,10,1000,1000);
				panel.add(painelOperacaoAritmeticaDivisao);
				panel.repaint();
			}
		});
		mnOperadoresAritmticos.add(mntmMultiplicao);
		
		JMenuItem mntmDiviso = new JMenuItem("Divisão");
		mntmDiviso.setFont(fonte);
		mntmDiviso.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelOperacaoAritmeticaDivisao.setVisible(true);
				painelOperacaoAritmeticaDivisao.setBounds(10,10,1000,1000);
				panel.add(painelOperacaoAritmeticaDivisao);
				panel.repaint();				
			}
		});
		mnOperadoresAritmticos.add(mntmDiviso);
		
		JMenu mnOperadoresLgicos = new JMenu("Operadores Lógicos");
		mnOperadoresLgicos.setFont(fonte);
		menuBar.add(mnOperadoresLgicos);
		
		JMenuItem mntmAnd = new JMenuItem("AND");
		mntmAnd.setFont(fonte);
		mntmAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelOperacaoLogicaAND.setVisible(true);
				painelOperacaoLogicaAND.setBounds(10,10,1000,1000);
				panel.add(painelOperacaoLogicaAND);
				panel.repaint();
			}
		});
		
		mnOperadoresLgicos.add(mntmAnd);
		
		JMenuItem mntmOr = new JMenuItem("OR");
		mntmOr.setFont(fonte);
		mntmOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelOperadorLogicoOR.setVisible(true);
				painelOperadorLogicoOR.setBounds(10,10,1000,1000);
				panel.add(painelOperadorLogicoOR);
				panel.repaint();
			}
		});
		mnOperadoresLgicos.add(mntmOr);
		
		JMenuItem mntmXor = new JMenuItem("XOR");
		mntmXor.setFont(fonte);
		mntmXor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelOperadorLogicoXOR.setVisible(true);
				painelOperadorLogicoXOR.setBounds(10,10,1000,1000);
				panel.add(painelOperadorLogicoXOR);
				panel.repaint();
			}
		});
		mnOperadoresLgicos.add(mntmXor);
		
		JMenu mnHistograma = new JMenu("Histograma");
		mnHistograma.setFont(fonte);
		menuBar.add(mnHistograma);
		
		PainelEqualizarHistograma painelEqualizarHistograma = new PainelEqualizarHistograma();
		JMenuItem mntmEqualizar = new JMenuItem("Equalizar");
		mntmEqualizar.setFont(fonte);
		mntmEqualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelEqualizarHistograma.setVisible(true);
				painelEqualizarHistograma.setBounds(10,10,1000,1000);
				panel.add(painelEqualizarHistograma);
				panel.repaint();
			}
		});
		JMenuItem mntmHitograma = new JMenuItem("Hitograma");
		mntmHitograma.setFont(fonte);
		mntmHitograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelHistograma.setVisible(true);
				painelHistograma.setBounds(10,10,1000,1000);
				panel.add(painelHistograma);
				panel.repaint();
			}
		});
		mnHistograma.add(mntmHitograma);
		mnHistograma.add(mntmEqualizar);
		
		JMenu mnTransformaes = new JMenu("Transformações");
		mnTransformaes.setFont(fonte);
		menuBar.add(mnTransformaes);
		
		JMenuItem mntmGama = new JMenuItem("Gama");
		mntmGama.setFont(fonte);
		mntmGama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				painelTransformacaoGama.setVisible(true);
				painelTransformacaoGama.setBounds(10,10,1000,1000);
				panel.add(painelTransformacaoGama);
				panel.repaint();
			}
		});
		mnTransformaes.add(mntmGama);
		mntmGama.setFont(fonte);

		JMenuItem mntmLogaritmico = new JMenuItem("Logaritmico");
		mntmLogaritmico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelTransformacaoLogaritmica.setVisible(true);
				painelTransformacaoLogaritmica.setBounds(10,10,1000,1000);
				panel.add(painelTransformacaoLogaritmica);
				panel.repaint();
			}
		});
		mntmLogaritmico.setFont(fonte);
		mnTransformaes.add(mntmLogaritmico);
		
		JMenuItem mntmNegativo = new JMenuItem("Negativo");
		mntmNegativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelTransformacaoNegativa.setVisible(true);
				painelTransformacaoNegativa.setBounds(10,10,1000,1000);
				panel.add(painelTransformacaoNegativa);
				panel.repaint();
			}
		});
		mntmNegativo.setFont(fonte);
		mnTransformaes.add(mntmNegativo);
		PainelTransformacaoRotacao painelTransformacaoRotacao = new PainelTransformacaoRotacao();
		JMenuItem mntmRotao = new JMenuItem("Rotação");
		mntmRotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelTransformacaoRotacao.setVisible(true);
				painelTransformacaoRotacao.setBounds(10,10,1000,1000);
				panel.add(painelTransformacaoRotacao);
				panel.repaint();
			}
		});
		mntmRotao.setFont(fonte);
		mnTransformaes.add(mntmRotao);
		PainelGatoDeArnold painelGatoDeArnold = new PainelGatoDeArnold();

		JMenu mnGatoDeArnald = new JMenu("Gato de Arnald");
		mnGatoDeArnald.setFont(fonte);
		menuBar.add(mnGatoDeArnald);
		
		JMenuItem mntmGatoDeArnaldo = new JMenuItem("Gato de Arnald");
		mntmGatoDeArnaldo.setFont(fonte);
		mntmGatoDeArnaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				painelGatoDeArnold.setVisible(true);
				painelGatoDeArnold.setBounds(10,10,1000,1000);				
				panel.add(painelGatoDeArnold);
				panel.repaint();
				
			}
		});
		mnGatoDeArnald.add(mntmGatoDeArnaldo);
		setSize(971,660);
		
	}
}
