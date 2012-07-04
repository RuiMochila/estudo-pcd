package graphic.user;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Botoes {
	private JFrame janela = new JFrame("Eventos");
	private JButton bot�o_OK = new JButton("OK");
	private JButton bot�o_Cancel = new JButton("Cancel");
	private SentinelaParaAc��es sentinela = new SentinelaParaAc��es();

	
	//Uma das formas de programar a sentinela. Classe Interna.
	//Assim a mesma sentinala serve para v�rios bot�es, apesar de n ser boa pr�tica.
	//Ver como se declara de forma an�nima.
	private class SentinelaParaAc��es implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton bot�o = (JButton) e.getSource();
			if (bot�o == bot�o_OK) {
				System.out.println("Carregou no bot�o OK");
			} else {
				System.out.println("Carregou no bot�o Cancel");
			}
			//Ou um switch se forem v�rios
		}
	}
	
	
	public Botoes() {
		//Explicar porque est� aqui dentro e n�o no main
		Container contentor = janela.getContentPane();
		contentor.setLayout(new FlowLayout());

		contentor.add(bot�o_OK);
		contentor.add(bot�o_Cancel);

		// Regista sentinelas:
		bot�o_OK.addActionListener(sentinela);
		bot�o_Cancel.addActionListener(sentinela);

		janela.setSize(100, 100);
		janela.setLocation(200, 100);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void mostra() {
		janela.setVisible(true);
	}

	
	public static void main(String[] argumentos) {
		Botoes b = new Botoes();
		b.mostra();
	}

	/*
	 * Extra:
	 * Adiciona um novo bot�o chamado Stop.
	 * Este bot�o quando � carregado bloqueia os outros bot�es at� que volte a ser primido.
	 * 
	 * Fazer uma nova classe "Botoes2" igual a esta, com sentinelas an�nimas, para praticar.
	 * Exercicios assitido xD
	 * 
	 * Brincar com outros componentes. Como a JList e ListSelectionListener. 
	 * S� se for necess�rio.
	 */
	
}
